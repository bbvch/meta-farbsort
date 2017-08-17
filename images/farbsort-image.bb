include recipes-core/images/core-image-minimal.bb

LICENSE = "MIT"

IMAGE_INSTALL += " \
   pru-farbsort \
   farbsort-websocket \
   omapdrm-pvr \
   dropbear \
   i2c-tools \
   kernel-modules \
   fontconfig freetype pulseaudio dbus taglib zlib \
   alsa-lib alsa-tools \
   qtbase \
"

#  sqlite3 \
#   packagegroup-qt5-toolchain-target \   
#   qtmultimedia-dev \   
#   qtmultimedia-mkspecs \
#   ti-cgt-pru-native \
#   ti-sgx-ddk-km \
#    dropbear \
#    i2c-tools \
#    kernel-modules \
#    qtbase-fonts \
#    qtbase-plugins \
#    qtdeclarative \
#    qtdeclarative-plugins \
#    qtdeclarative-tools \
#    qtdeclarative-qmlplugins \
#    qtmultimedia \
#    qtmultimedia-plugins \
#    qtmultimedia-qmlplugins \
#    qtlocation \
#    qtlocation-plugins \
#    qtlocation-qmlplugins \
#    qtsvg \
#    qtsvg-plugins \
#    qtsensors \
#    qtsensors-plugins \
#    qtsensors-qmlplugins \
#    qtimageformats-plugins \
#    qtsystems \
#    qtsystems-tools \
#    qtsystems-qmlplugins \
#    qtscript \
#    qt3d \
#    qt3d-qmlplugins \
#    qt3d-tools \
#    qtconnectivity \
#    qtconnectivity-qmlplugins \
#    qtserialport \
#    cinematicexperience \
#    qt5-opengles2-test \
#    fontconfig freetype pulseaudio dbus taglib zlib \
#    alsa-lib alsa-tools \
#    gcc g++ libgcc libgcc-dev libstdc++ libstdc++-dev libstdc++-staticdev \
#    "
