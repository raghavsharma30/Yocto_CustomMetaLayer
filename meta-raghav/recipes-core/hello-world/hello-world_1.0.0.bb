SUMMARY = "Simple Hello World application"
DESCRIPTION = "A very simple Hello World application written in C++"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://hello-world.cpp;md5=fa547e143baeaa17f23f69139dfc29cc"

SRC_URI = "file://hello-world-1.0.0.tar.gz"

S = "${WORKDIR}/hello-world-1.0.0"

do_compile() {
    # Ensure the use of proper LDFLAGS and CXXFLAGS
    ${CXX} ${CXXFLAGS} hello-world.cpp ${LDFLAGS} -o hello-world
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 hello-world ${D}${bindir}
}
