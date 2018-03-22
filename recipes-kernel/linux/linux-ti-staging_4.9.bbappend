FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.9:"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.9/ti33x:"

LINUX_VERSION = "4.9"
LINUX_VERSION_EXTENSION = "-ti-bbv"

SRC_URI += "file://defconfig \
    file://0001-dts-Revoke-Beaglebone-i2c2-cape-definitions.patch \
    file://0002-dts-Add-custom-dts-files.patch \
    "

KERNEL_DEVICETREE_beaglebone-mb-board = "am335x-boneblack.dtb \
    bbb-hdmi.dtb \
    bbb-nohdmi.dtb \
    "

KERNEL_DEFAULT_DEVICETREE ?= "bbb-hdmi.dtb"

do_default_dtb_symlink() {
    ln -sf ${KERNEL_DEFAULT_DEVICETREE} ${D}/${KERNEL_IMAGEDEST}/devicetree.dtb
}

do_install[postfuncs] += "do_default_dtb_symlink"

#kernel_do_compile_prepend() {
#    # remove .config from source tree
#    rm -f ${S}/.config*
#    # install farbsort_defconfig into build directory
#    mkdir -p arch/arm/configs/
#    cp ${WORKDIR}/farbsort_defconfig arch/arm/configs/
#    # configure
#    oe_runmake farbsort_defconfig
#}
