SUMMARY = "developer tools for FarbSort"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = "\
  bash \
  binutils \
  bzip2 \
  cppunit \
  devmem2 \
  e2fsprogs \
  e2fsprogs-mke2fs \
  ethtool \
  evtest \
  file \
  gdb \
  gdbserver \
  gmock \
  gtest \
  htop \
  i2c-tools \
  iputils \
  libudev \
  mtd-utils \
  openssh-sftp \
  openssh-sftp-server \
  perf \
  procps \
  farbsort-gui \
  screen \
  strace \
  sysstat \
  tar \
  time \
  usbutils \
  wget \
"

