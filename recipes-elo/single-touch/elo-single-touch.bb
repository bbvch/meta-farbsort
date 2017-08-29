SUMMARY = "Recipe for the ELO single touchscreen driver for the accustic PCAP chip"
SECTION = "base"
LICENSE = "commercial"
LIC_FILES_CHKSUM = "file://bin-usb/Elo_OEM_&_EU_LA.txt;md5=49dde7f5e36e9533da31f4b60006f26a"

SRCREV = "${AUTOREV}"
SRC_URI = "http://media.elotouch.com/DriverDownload/drivers/SW602480_Elo_Linux_ST_USB_Driver_v4.3.1_armv7l.tgz;subdir=${PN}-${PV}"

SRC_URI[md5sum]    = "b82829b04cedbfc2920e56829106fdaa"
SRC_URI[sha256sum] = "4a8185cb45ccdb6f23edc17e996c10e459626ac6f5bae2ddd20935b672dae8de"

# xorg Motif libusb
#DEPENDS = libusb x11 libXm 

do_compile() {
}

do_install() {
  install -d ${D}/etc/opt/elo-usb
  install -m 644 ${S}/bin-usb/99-elotouch.rules ${D}/etc/udev/rules.d
}
