SUMMARY = "The pru firmware for the farbsort showcase"
SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/COPYRIGHTS;md5=d41d8cd98f00b204e9800998ecf8427e"

SRCREV = "${AUTOREV}"
SRC_URI = " git://github.com/bbvch/pru-farbsort.git;protocol=http"

SRC_URI[md5sum] = "0688ddb5c56f6467631ed9d0f59028b9"
SRC_URI[sha256sum] = "38b4e2fb7c970647bb612d3e0f69bf4f8808b883d32e15e05008c2883657c0bb"

require recipes-ti/includes/ti-paths.inc

PACKAGES_prepend = " \
    ${PN}-halt \
    ${PN}-rpmsg-echo \
"

RDEPENDS_${PN}_append = " \
    ${PN}-halt \
    ${PN}-rpmsg-echo \
"

DEPENDS = "ti-cgt-pru-native pru-icss"

S = "${WORKDIR}/git"

export PRU_CGT = "${TI_CGT_PRU_INSTALL_DIR}"
export PRU_LIB = "${TOPDIR}/tmp/work/beaglebone-poky-linux-gnueabi/pru-icss/${PV}-${PR}/git}"

do_patch() {
}

do_compile_prepend () {
        export CCTOOL_PREFIX="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}"
}

do_compile () {
        make -f ${WORKDIR}/git/Makefile.pru
}


do_install () {

}
