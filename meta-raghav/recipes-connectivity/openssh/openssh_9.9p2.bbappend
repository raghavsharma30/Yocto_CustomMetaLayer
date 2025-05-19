do_configure:append() {
    # Remove the sshd -t check from Makefile to prevent build failure
    sed -i '/sshd -t -f/d' ${S}/Makefile
}
