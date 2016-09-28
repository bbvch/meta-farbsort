FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE += "|beaglebone"

deltask compileconfigs

BRANCH = "farbsort"

SRCREV = "9a965386facf8f21e9d5f13ae3be0e0e368390c0"

KERNEL_GIT_URI = "git://github.com/ppoile/linux-farbsort.git"

SRC_URI += " \
	file://farbsort_defconfig \
"

kernel_do_compile_prepend() {
	# remove .config from source tree
	rm -f ${S}/.config*
	# install farbsort_defconfig into build directory
	mkdir -p arch/arm/configs/
	cp ${WORKDIR}/farbsort_defconfig arch/arm/configs/
	# configure
	oe_runmake farbsort_defconfig
}

