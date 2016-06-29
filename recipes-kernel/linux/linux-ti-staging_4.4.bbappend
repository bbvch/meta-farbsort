FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE += "|beaglebone"

deltask compileconfigs

SRC_URI += " \
	file://farbsort_defconfig \
	file://0001-simple-logger-service-for-rpmsg.patch \
"

kernel_do_compile_prepend() {
	cp ${WORKDIR}/farbsort_defconfig ${S}/arch/arm/configs/
	oe_runmake farbsort_defconfig
}

