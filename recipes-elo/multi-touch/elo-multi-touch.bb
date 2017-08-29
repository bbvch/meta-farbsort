SUMMARY = "Recipe for the ELO multi touchscreen driver for the accustic PCAP chip"
SECTION = "base"
LICENSE = "commercial"
LIC_FILES_CHKSUM = "file://bin-mt-usb/Elo_OEM_&_EU_LA.txt;md5=49dde7f5e36e9533da31f4b60006f26a"

SRC_URI = "http://media.elotouch.com/DriverDownload/drivers/SW602516_Elo_Linux_MT_USB_Driver_v2.3.0_armv7l.tgz;subdir=${PN}-${PV}"

SRC_URI[md5sum] = "e3963f7f0956858ce4a115a2fc12a922"
SRC_URI[sha256sum] = "9a6a050ffe692499c903b8a43baf91c7032e66957e16a819c9d0515dfdc07f02"

#S = "${WORKDIR}/bbexample-${PV}"

#do_unpack() {}
