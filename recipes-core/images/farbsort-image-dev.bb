LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL = " \
  packagegroup-core-boot \
  packagegroup-core-ssh-openssh \
  packagegroup-farbsort-common \
  packagegroup-farbsort-dev \
  \
"

IMAGE_FEATURES += " \
  package-management \
  debug-tweaks \
"

