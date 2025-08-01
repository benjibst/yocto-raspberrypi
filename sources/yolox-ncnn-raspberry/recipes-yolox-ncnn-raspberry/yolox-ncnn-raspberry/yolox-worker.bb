SUMMARY = "install python worker service"
LICENSE = "CLOSED"

SRC_URI = "\
	file://yolox-ncnn-raspberry/worker.service\
	"
inherit systemd
SYSTEMD_SERVICE:${PN} = "worker.service"


do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/yolox-ncnn-raspberry/worker.service ${D}${systemd_system_unitdir}/worker.service
}
FILES:${PN} += "${systemd_system_unitdir}/worker.service"

