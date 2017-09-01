FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Set-qpa-to-eglfs.patch"
SRC_URI += " file://0002-eglfs_kms_egldevice-fix-include-path-mismatch-for-dr.patch"
