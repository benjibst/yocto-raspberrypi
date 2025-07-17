SUMMARY = "Install all files recursively to a directory"
LICENSE = "CLOSED"
SRC_URI = "	file://www/"

S = "${WORKDIR}"
DEST_DIR = "/www"

do_install() {
    install -d ${D}${DEST_DIR}
    cp -r ${S}/www/* ${D}${DEST_DIR}
}

FILES:${PN} += "${DEST_DIR}"
