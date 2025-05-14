FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    echo "[Service]" > ${D}${systemd_system_unitdir}/sshd.service.d/override.conf
    echo "ExecStart=" >> ${D}${systemd_system_unitdir}/sshd.service.d/override.conf
    echo "ExecStart=/usr/sbin/sshd -D -e" >> ${D}${systemd_system_unitdir}/sshd.service.d/override.conf
}

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "sshd.service"
