SUMMARY = "Wi-Fi setup script for automatic connection"
DESCRIPTION = "Installs a Wi-Fi setup script to configure and connect to Wi-Fi at boot"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "file://wifi-setup.sh"

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/wifi-setup.sh ${D}${sysconfdir}/init.d/wifi-setup.sh
}

FILES:${PN} += "${sysconfdir}/init.d/wifi-setup.sh"
