SUMMARY = "The pru firmware for the farbsort showcase"
SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/COPYRIGHTS;md5=d41d8cd98f00b204e9800998ecf8427e"

SRCREV = "${AUTOREV}"
SRC_URI = " \
	git://github.com/bbvch/pru-farbsort.git \
	file://0001-pru_virtio_ring-make-it-compile.patch \
"

SRC_URI[md5sum] = "0688ddb5c56f6467631ed9d0f59028b9"
SRC_URI[sha256sum] = "38b4e2fb7c970647bb612d3e0f69bf4f8808b883d32e15e05008c2883657c0bb"

do_patch() {
}

do_compile() {
	make -f ${WORKDIR}/git/Makefile.pru
}

do_install() {

}

DEPENDS = "ti-cgt-pru-native"
RDEPENDS_${PN} = "ti-cgt-pru"

#CONFFILES_${PN} += "${sysconfdir}/init.d/skeleton"
