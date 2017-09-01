COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15|k2g|beaglebone"

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI += "file://0002-pru_virtio_ring-make-it-compile.patch"

do_install_append() {
    install -d ${STAGING_INCDIR_NATIVE}/pru-icss
    install -d ${STAGING_LIBDIR_NATIVE}/pru-icss
    cp -ar ${S}/include/* ${STAGING_INCDIR_NATIVE}/pru-icss/    
    cp  ${S}/lib/rpmsg_lib* ${STAGING_LIBDIR_NATIVE}/pru-icss/ 
}
