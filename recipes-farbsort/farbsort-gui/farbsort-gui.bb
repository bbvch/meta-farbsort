#
# builds the farbsort gui application
#

DESCRIPTION = "farbsort showcase app"
SECTION = "tools"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=783b7e40cdfb4a1344d15b1f7081af66"

SRC_URI = "git://github.com/goerks/farbsort-gui.git;protocol=git;rev=5eaacbf1988d3fe44de0eecd31ce22c43a36240f"
#SRC_URI[md5sum] = "669c7a8439ae0ec6add893c4674a4d48"

inherit qmake5

FILES_${PN} += "${bindir}/farbsort-gui"


DEPENDS += "\
  qtbase \
  qtbase-fonts \
  qtbase-plugins
  qtdeclarative \
  qtmultimedia \
  qtlocation \
  qtsvg \
  qtsensors \
  qtsystems \
  qtconnectivity \
  qtserialport \
  qtdeclarative-qmlplugins \
  qtmultimedia-plugins \
  qtmultimedia-qmlplugins \
  qtquickcontrols2 \
  qtwebsockets \
  qttranslations \
"

# use revision
S = "${WORKDIR}/git"

do_install() {
  install -d ${D}${bindir}
  install -m 0755 ${WORKDIR}/build/farbsort-gui ${D}${bindir}
}

