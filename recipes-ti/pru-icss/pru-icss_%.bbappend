COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15|k2g|beaglebone"

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI += "file://0002-pru_virtio_ring-make-it-compile.patch"

do_install_append() {
    install -d ${D}/usr/include/pru-icss
    install -d ${D}/usr/lib/pru-icss

    install -m 0644 ${S}/include/*.h ${D}/usr/include/pru-icss
    install -m 0644 ${S}/include/am335x/*.h ${D}/usr/include/pru-icss
    install -m 0644 ${S}/lib/rpmsg_lib* ${D}/usr/lib/pru-icss
}

