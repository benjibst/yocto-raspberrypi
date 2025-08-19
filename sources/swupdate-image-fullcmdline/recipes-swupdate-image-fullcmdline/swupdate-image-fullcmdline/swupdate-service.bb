SUMMARY = "Install files to "
LICENSE = "CLOSED"
SRC_URI = "	file://swupdate-websrvargs.sh"

S = "${WORKDIR}"
DEST_DIR = "/etc/swupdate/conf.d"

do_install() {
    install -d ${D}${DEST_DIR}
    cp  ${S}/swupdate-websrvargs.sh ${D}${DEST_DIR}
}

FILES:${PN} += "${DEST_DIR}"
