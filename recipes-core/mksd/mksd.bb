SUMMARY = "Copy mksd.sh script to image deployment area"
SECTION = "devel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/uEnv.txt;md5=a8aeec068a182697e8843a1acfe7540f"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://uEnv.txt"

#This package doesn't have any files for the rootfs in it, option needed to create an empty 
# package so when the rootfs image is made it finds the mksd_xxx.deb package and doesn't complain
FILES_${PN} = ""
ALLOW_EMPTY_${PN} = "1"


# Copy script to the deploy area with u-boot, uImage, and rootfs
do_deploy () {
   install -d ${DEPLOY_DIR_IMAGE}
   install -m 0744 ${THISDIR}/files/mkBeagleImage.sh ${TOPDIR}
   install -m 0644 ${THISDIR}/files/uEnv.txt ${DEPLOY_DIR_IMAGE}
}
addtask deploy after do_install
