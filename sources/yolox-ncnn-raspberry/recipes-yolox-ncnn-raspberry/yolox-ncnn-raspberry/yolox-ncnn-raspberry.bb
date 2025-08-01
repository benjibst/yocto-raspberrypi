SUMMARY = "Fetch and build yolox-ncnn-raspberry"
LICENSE = "CLOSED"

SRC_URI = "\
	file://yolox-ncnn-raspberry\
	"
S = "${WORKDIR}/yolox-ncnn-raspberry"
B = "${WORKDIR}/yolox-ncnn-raspberry/build"
YOLOX_BASE="/root/yolox-ncnn-raspberry"
DEPENDS += "protobuf protobuf-native"
RDEPENDS:${PN} += "python3-core"
inherit cmake

do_configure:prepend() {
    tar -xzvf ${S}/precompiled_libs.tar.gz -C ${S}
    ${STAGING_BINDIR_NATIVE}/protoc \
        --proto_path=${S} \
        --cpp_out=${S}/src \
        ${S}/detection_vector.proto
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
	install -m 0755 ${B}/yoloX ${D}${YOLOX_BASE}/build/yoloX
    install -m 0755 ${S}/yoloxN.bin ${D}${YOLOX_BASE}/yoloxN.bin
    install -m 0755 ${S}/yoloxN.param ${D}${YOLOX_BASE}/yoloxN.param
    install -m 0755 ${S}/worker.py ${D}${YOLOX_BASE}/worker.py
    install -m 0755 ${S}/nginx.conf ${D}${YOLOX_BASE}/nginx.conf
}
FILES:${PN} += "${YOLOX_BASE}"
