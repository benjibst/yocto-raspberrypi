DESCRIPTION = "Example recipe generating SWU image"
SECTION = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
inherit swupdate
SRC_URI = " \
    file://sw-description \
    "

IMAGE_DEPENDS = "core-image-full-cmdline"

SWUPDATE_IMAGES = "core-image-full-cmdline"

SWUPDATE_IMAGES_FSTYPES[core-image-full-cmdline] = ".rootfs.ext4.gz"

