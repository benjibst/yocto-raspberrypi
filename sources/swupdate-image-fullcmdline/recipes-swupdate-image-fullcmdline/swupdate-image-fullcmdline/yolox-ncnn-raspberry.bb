SUMMARY = "Fetch and build yolox-ncnn-raspberry"
LICENSE = "CLOSED"

SRC_URI = "ssh://git@gitlab.ewo.com:2222/connexx-dev/software/yolox-ncnn-raspberry.git;branch=main;protocol=ssh"

S = "${WORKDIR}/yoloxsrc"
YOLOX_BASE="/root/yolox-ncnn-raspberry"
inherit cmake

do_configure:prepend() {
    tar -xzvf precompiled_libs.tar.gz
}

do_compile:prepend() {

}

do_install:append() {
    echo "Running custom install step..."
    install -d ${D}${YOLOX_BASE}
	install -d ${D}${YOLOX_BASE}/site
    cp -r ${S}/site/* ${D}${YOLOX_BASE}/site
	install -d ${D}${YOLOX_BASE}/build
	install -d ${D}${YOLOX_BASE}/build/model_in
	install -d ${D}${YOLOX_BASE}/build/model_out
	install -m 0755 ${S}/build/yoloX ${D}${YOLOX_BASE}/build/yoloX
    install -m 0755 ${S}/yoloxN.bin ${D}${YOLOX_BASE}/yoloxN.bin
    install -m 0755 ${S}/yoloxN.param ${D}${YOLOX_BASE}/yoloxN.param
    install -m 0755 ${S}/worker.py ${D}${YOLOX_BASE}/worker.py
    install -d ${D}${sysconfdir}/nginx
    install -m 0755 ${S}/nginx.conf ${D}${sysconfdir}/nginx/nginx.conf
}

