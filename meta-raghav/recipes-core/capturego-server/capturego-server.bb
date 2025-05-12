SUMMARY = "Multiplayer CaptureGo server"
LICENSE = "CLOSED"
SRC_URI = "file://server-1.0.0.tar.gz"

# Look for the tarball in this custom path
FILESEXTRAPATHS:prepend := "/home/raghav/my_sources:"

S = "${WORKDIR}/server-1.0.0"

# Use CXX for C++ code
do_compile() {
    ${CXX} ${CXXFLAGS} server_main.cpp server.cpp network.cpp game.cpp -o server ${LDFLAGS}
}


do_install() {
    install -d ${D}${bindir}
    install -m 0755 server ${D}${bindir}/server
}

