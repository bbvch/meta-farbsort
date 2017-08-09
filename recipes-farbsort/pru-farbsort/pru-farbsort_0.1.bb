SUMMARY = "The pru firmware for the farbsort showcase"
SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/COPYRIGHTS;md5=d41d8cd98f00b204e9800998ecf8427e"

SRCREV = "${AUTOREV}"
SRC_URI = " git://github.com/bbvch/pru-farbsort.git;protocol=http"

SRC_URI[md5sum] = "0688ddb5c56f6467631ed9d0f59028b9"
SRC_URI[sha256sum] = "38b4e2fb7c970647bb612d3e0f69bf4f8808b883d32e15e05008c2883657c0bb"

require recipes-ti/includes/ti-paths.inc

COMPATIBLE_MACHINE = "ti33x|ti43x"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES_prepend = " \
    ${PN}-fw \
"

RDEPENDS_${PN}_append = " \
    ${PN}-fw \
"

DEPENDS = "ti-cgt-pru-native pru-icss"

S = "${WORKDIR}/git"

export PRU_CGT           = "${TI_CGT_PRU_INSTALL_DIR}"
export PRU_ICSS_INC_PATH = "${STAGING_INCDIR_NATIVE}/pru-icss"
export PRU_ICSS_LIB_PATH = "${STAGING_LIBDIR_NATIVE}/pru-icss"

do_patch() {
}

do_compile_prepend () {
        export CCTOOL_PREFIX="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}"
}

do_compile () {
        make -f ${WORKDIR}/git/Makefile.pru
}


do_install () {
	install -d ${D}/lib/firmware
	install -m 0644 ${S}/bin/* ${D}/lib/firmware
}

FILES_${PN}-fw = "/lib/firmware/am335x-pru0-fw"
ALLOW_EMPTY_${PN} = "1"


# This installs PRU firmware, so skip "arch" QA check
INSANE_SKIP_${PN}-fw = "arch"

