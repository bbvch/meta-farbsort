include recipes-core/images/core-image-minimal.bb

LICENSE = "MIT"

IMAGE_INSTALL += " \
   pru-farbsort \
   farbsort-websocket \
   farbsort-gui \
   dropbear \
   i2c-tools \
   kernel-modules \
   fontconfig freetype pulseaudio dbus taglib zlib \
   alsa-lib alsa-tools \
   mksd \
   elo-single-touch \
   qt5-opengles2-test \
   opkg \
   opkg-utils \
   strace \
   binutils \
"

IMAGE_INSTALL += "\
    packagegroup-mb-qt5 \
    "

IMAGE_FEATURES += "package-management"

do_deploy_append() {
   sudo ${TOPDIR}/mkBeagleImage.sh ${TOPDIR}/bbb.img ${TOPDIR}  farbsort-image-beaglebone.tar.gz 4294967296

}


#   packagegroup-qt5-toolchain-target
#   cinematicexperience
#   qt5-opengles2-test 

