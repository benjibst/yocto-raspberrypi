DESCRIPTION = "generate SWU image"
SECTION = ""
LICENSE = "CLOSED"
inherit swupdate
SRC_URI = " \
    file://sw-description \
    "

IMAGE_DEPENDS = "core-image-full-cmdline"

SWUPDATE_IMAGES = "core-image-full-cmdline"

SWUPDATE_IMAGES_FSTYPES[core-image-full-cmdline] = ".rootfs.ext4.gz"

