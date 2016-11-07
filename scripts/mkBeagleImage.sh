#! /bin/bash

if [ $# -ne 4 ]; then
	echo "Usage: $0 <Image File> <YoctoBuildBaseDir> <rootfs-file-name.tar.gz> <disksize in bytes>"
	exit 1;
fi

if [ ! -x `which kpartx` ]; then
	echo "install kpartx using: apt-get install kpartx"
	exit 1
fi

OUTFILENAME=$1
BASEDIR=$2
IMAGENAME=$3
SIZE=$4

#OUTFILENAME=BBV-GuiShowcase.img
#BASEDIR=/home/reinhard/yocto/mybuilds/beagleboard-core-image-bbv
#IMAGENAME=core-image-bbv-beagleboard.tar.gz
#SIZE=3904897024

IMAGEDIR=${BASEDIR}/tmp/deploy/images/beaglebone
DRIVE=${BASEDIR}/${OUTFILENAME}

rm ${DRIVE}*

cd ${BASEDIR}

dd if=/dev/zero of=$DRIVE bs=1024 count=0 seek=$[${SIZE}/1024]

#SIZE=`fdisk -l $DRIVE | grep Disk | awk '{print $5}'`

CYLINDERS=`echo $SIZE/255/63/512 | bc`

echo DISK SIZE - $SIZE bytes - CYLINDERS - ${CYLINDERS}

sfdisk -D -H 255 -S 63 -C $CYLINDERS ${OUTFILENAME} << EOF
,9,0x0C,*
10,185,,-
196,,,-
EOF


kpartx -l $DRIVE > kpartx.tmp
cat kpartx.tmp

LOOPNAME=`cat kpartx.tmp | grep "loop deleted" |  awk 'BEGIN { FS = "/" } ; {print $NF}'`

rm kpartx.tmp

kpartx -a -v $DRIVE

mkdir -p ${BASEDIR}/mnt/boot
mkdir -p ${BASEDIR}/mnt/rootfs
mkdir -p ${BASEDIR}/mnt/START_HERE

LOOPDRIVE=/dev/mapper/${LOOPNAME}

echo "LOOPNAME - ${LOOPNAME} - LOOPDRIVE - ${LOOPDRIVE}"

mkfs.vfat -F 32 -n "boot" ${LOOPDRIVE}p1
mkfs.ext3 -L "rootfs" ${LOOPDRIVE}p2
mkfs.ext3 -L "START_HERE" ${LOOPDRIVE}p3

mount ${LOOPDRIVE}p1 ${BASEDIR}/mnt/boot
mount ${LOOPDRIVE}p2 ${BASEDIR}/mnt/rootfs
mount ${LOOPDRIVE}p3 ${BASEDIR}/mnt/START_HERE

cp ${IMAGEDIR}/MLO ${BASEDIR}/mnt/boot/MLO
cp ${IMAGEDIR}/u-boot.img ${BASEDIR}/mnt/boot/u-boot.img
cp ${IMAGEDIR}/zImage ${BASEDIR}/mnt/boot/zImage
cp ${BASEDIR}/uEnv.txt ${BASEDIR}/mnt/boot/uEnv.txt

tar xvf ${IMAGEDIR}/${IMAGENAME} -C ${BASEDIR}/mnt/rootfs/

if [ -d "${BASEDIR}/Videos" ]; then
	cp ${BASEDIR}/Videos/* ${BASEDIR}/mnt/START_HERE
fi

sync

umount ${LOOPDRIVE}p1
umount ${LOOPDRIVE}p2
umount ${LOOPDRIVE}p3

kpartx -d $DRIVE

rm -rf ${BASEDIR}/mnt

cd ${BASEDIR}
tar -czf ${DRIVE}.tar.gz ${OUTFILENAME}
