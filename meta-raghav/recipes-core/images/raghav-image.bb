SUMMARY = "A custom image named raghav-image"
DESCRIPTION = "A minimal custom image with SSH, nano, htop, network tools, and a custom script"

LICENSE = "MIT"
inherit core-image extrausers

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
    wifi-config \
    linux-firmware \
    networkmanager \
    networkmanager-nmcli \
    shadow \
"

# Image features (keywords)
IMAGE_FEATURES:append = " ssh-server-openssh allow-empty-password"

# Add root to netdev group using extrausers
EXTRA_USERS_PARAMS = "\
    groupadd netdev; \
    usermod -a -G netdev root; \
"

IMAGE_LINGUAS = "en-us"
