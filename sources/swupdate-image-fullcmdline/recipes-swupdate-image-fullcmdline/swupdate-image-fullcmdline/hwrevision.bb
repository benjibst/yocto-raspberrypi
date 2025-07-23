SUMMARY = "Install hwrevision"
LICENSE = "CLOSED"
SRC_URI = "	file://hwrevision"

S = "${WORKDIR}"
DEST_DIR = "/etc/"

do_install() {
    install -d ${D}${DEST_DIR}
    cp -r ${S}/hwrevision ${D}${DEST_DIR}
}

