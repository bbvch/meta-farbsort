include recipes-core/images/core-image-minimal.bb

LICENSE = "MIT"

IMAGE_INSTALL += " \
   pru-farbsort \
   farbsort-websocket \
   farbsort-gui \
   ti-sgx-ddk-km \
   omapdrm-pvr \
   dropbear \
   i2c-tools \
   kernel-modules \
   fontconfig freetype pulseaudio dbus taglib zlib \
   alsa-lib alsa-tools \
"

#  sqlite3 \
#   packagegroup-qt5-toolchain-target \   
#    cinematicexperience \
#    qt5-opengles2-test \
