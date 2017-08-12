SUMMARY = "The pru firmware for the farbsort showcase"
SECTION = "base"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=d41d8cd98f00b204e9800998ecf8427e"

SRCREV = "${AUTOREV}"
SRC_URI = " git://github.com/bbvch/farbsort-websocket.git;protocol=http"

SRC_URI[md5sum] = "0688ddb5c56f6467631ed9d0f59028b9"

DEPENDS = "python tornado"

S = "${WORKDIR}/git"

do_patch() {
}

do_install () {
}
