SUMMARY = "The pru firmware for the farbsort showcase"
SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYRIGHTS;md5=d41d8cd98f00b204e9800998ecf8427e"

SRCREV = "${AUTOREV}"
SRC_URI = " \
	git://github.com/bbvch/pru-farbsort.git \
	file://0001-pru_virtio_ring-make-it-compile.patch \
"


do_patch() {
}

do_compile () {
#        ${CC} ${WORKDIR}/skeleton_test.c -o ${WORKDIR}/skeleton-test
}

do_install () {
#        install -d ${D}${sysconfdir}/init.d
#        cat ${WORKDIR}/skeleton | \
#          sed -e 's,/etc,${sysconfdir},g' \
#              -e 's,/usr/sbin,${sbindir},g' \
#              -e 's,/var,${localstatedir},g' \
#              -e 's,/usr/bin,${bindir},g' \
#              -e 's,/usr,${prefix},g' > ${D}${sysconfdir}/init.d/skeleton
#        chmod a+x ${D}${sysconfdir}/init.d/skeleton
#
#        install -d ${D}${sbindir}
#        install -m 0755 ${WORKDIR}/skeleton-test ${D}${sbindir}/
}

DEPENDS = "ti-cgt-pru-native"
RDEPENDS_${PN} = "ti-cgt-pru"

#CONFFILES_${PN} += "${sysconfdir}/init.d/skeleton"
