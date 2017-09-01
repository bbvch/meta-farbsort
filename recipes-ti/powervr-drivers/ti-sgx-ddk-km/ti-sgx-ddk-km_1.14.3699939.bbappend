SUMMARY = "Add beaglebone to the compatible machines"
COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15|beaglebone"

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-srvkm-env-linux-Check-whether-Soc-supports-SGX.patch"

