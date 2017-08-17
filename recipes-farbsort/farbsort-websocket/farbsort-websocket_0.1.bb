SUMMARY = "The pru firmware for the farbsort showcase"
SECTION = "base"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=783b7e40cdfb4a1344d15b1f7081af66"

SRCREV = "${AUTOREV}"
SRC_URI = " git://github.com/bbvch/farbsort-websocket.git;protocol=http"

SRC_URI[md5sum] = "0688ddb5c56f6467631ed9d0f59028b9"

DEPENDS = "python-tornado"

S = "${WORKDIR}/git"

do_configure () {
}

do_compile () {
}

do_install () {
        install -d ${D}/etc/systemd/system/
	install -D ${S}/farbsort-websocket.service ${D}/etc/systemd/system/
}
