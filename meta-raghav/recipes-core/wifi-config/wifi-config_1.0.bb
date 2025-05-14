SUMMARY = "WiFi auto-setup script"
DESCRIPTION = "Installs a systemd service and wpa_supplicant.conf for automatic WiFi connection"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://wpa_supplicant.conf \
           file://wifi-autoconnect.service"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

inherit systemd

RDEPENDS:${PN} += "wpa-supplicant rfkill"

do_install() {
    # Install wpa_supplicant config
    install -d ${D}${sysconfdir}
    install -m 0644 ${S}/wpa_supplicant.conf ${D}${sysconfdir}/wpa_supplicant.conf.wifi-config

    # Install systemd service
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/wifi-autoconnect.service ${D}${systemd_system_unitdir}/
}

pkg_postinst_ontarget:${PN} () {
#!/bin/sh
echo "Overwriting default wpa_supplicant.conf with custom one"
/bin/cp /etc/wpa_supplicant.conf.wifi-config /etc/wpa_supplicant.conf
/bin/systemctl enable wifi-autoconnect.service
}

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "wifi-autoconnect.service"

FILES:${PN} += "/etc/wpa_supplicant.conf.wifi-config ${systemd_system_unitdir}/wifi-autoconnect.service"
INSANE_SKIP:${PN} += "installed-vs-shipped"
