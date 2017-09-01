SUMMARY = "The pru firmware for the farbsort showcase"
SECTION = "base"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=783b7e40cdfb4a1344d15b1f7081af66"

SRCREV = "${AUTOREV}"
SRC_URI = " git://github.com/bbvch/farbsort-websocket.git;protocol=http"

SRC_URI[md5sum] = "0688ddb5c56f6467631ed9d0f59028b9"

COMPATIBLE_MACHINE = "ti33x|ti43x|beaglebone"
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS_${PN}  += "python-tornado"
RDEPENDS_${PN} += "python-tornado bash"

S = "${WORKDIR}/git"

#Disable auto config
do_configure () {
}

#Disable auto build
do_compile () {
}

do_install () {

	install -d ${D}/root/farbsort-websocket
        install -D ${S}/farbsort.html ${D}/root/farbsort-websocket
	cp -r ${S}/farbsort/* ${D}/root/farbsort-websocket/

        install -d ${D}/etc/systemd/system/
	install -D ${S}/farbsort-websocket.service ${D}/etc/systemd/system/
	install -d ${D}/root/farbsort-websocket/tests
	cp -r ${S}/test* ${D}/root/farbsort-websocket/tests
}

FILES_${PN} += "/root/farbsort-websocket/*"
FILES_${PN} += "/etc/systemd/system/farbsort-websocket.service"
