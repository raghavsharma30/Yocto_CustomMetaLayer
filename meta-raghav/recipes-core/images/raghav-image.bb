SUMMARY = "A custom image named raghav-image"
DESCRIPTION = "A minimal custom image with SSH, nano, htop, network tools, and a custom script"

LICENSE = "MIT"
inherit core-image

# Actual packages to install
IMAGE_INSTALL:append = " \
    nano \
    htop \
    net-tools \
    systemd \
    hello-world \
    capturego-server \
    openssh \
    openssh-sftp-server \
    wpa-supplicant \
    connman \
    wifi-config \
"

# Image features (keywords)
IMAGE_FEATURES:append = " ssh-server-openssh allow-empty-password"

IMAGE_LINGUAS = "en-us"
