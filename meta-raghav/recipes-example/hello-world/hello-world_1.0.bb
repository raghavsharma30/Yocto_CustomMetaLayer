DESCRIPTION = "A simple hello-world program"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello-world-1.0/"

S = "${WORKDIR}/hello-world-1.0"

do_compile() {
    ${CC} ${CFLAGS} -o hello-world ${S}/hello-world.c
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 hello-world ${D}${bindir}
}
