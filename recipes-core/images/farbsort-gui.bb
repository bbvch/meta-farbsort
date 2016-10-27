#
# builds the farbsort gui application
#

DESCRIPTION = "farbsort showcase app"
SECTION = "tools"

DEPENDS = "\
  qtbase \
  qtbase-native \
  qtdeclarative \
  qtmultimedia \
  qtlocation \
  qtsvg \
  qtsensors \
  qtsystems \
  qtscript \
  qtquick1 \
  qt3d \
  qtconnectivity \
  qtserialport \
"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=783b7e40cdfb4a1344d15b1f7081af66"

#FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# use taged
#SRC_URI = "https://github.com/goerks/farbsort-gui/archive/${PV}.tar.gz"
#SRC_URI[md5sum] = "669c7a8439ae0ec6add893c4674a4d48"

# use revision
S = "${WORKDIR}/git"
SRC_URI = "git://github.com/goerks/farbsort-gui.git;protocol=git;rev=5eaacbf1988d3fe44de0eecd31ce22c43a36240f"
#SRC_URI[md5sum] = "669c7a8439ae0ec6add893c4674a4d48"

inherit qmake5

do_install() {
	export INSTALL_ROOT=${D}
	make install
}

