FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-add-pru-icss-native-deployment.patch;patchdir=${THISDIR}/../.."
SRC_URI += "file://0002-pru_virtio_ring-make-it-compile.patch"
