#
# Copyright (C) 2007-2008 OpenedHand Ltd.
#

SUMMARY = "Sato desktop"
DESCRIPTION = "Packagegroups provide a convenient mechanism of bundling a collection of packages."
HOMEPAGE = "https://www.yoctoproject.org/"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup features_check
REQUIRED_DISTRO_FEATURES = "x11"

PACKAGES = "${PN} ${PN}-base"

RDEPENDS:${PN} = "\
    ${PN}-base \
    "

SUMMARY:${PN}-base = "Sato desktop - base packages"
RDEPENDS:${PN}-base = "\
    canviewer3 \
    matchbox-session-sato \
    matchbox-keyboard \
    matchbox-keyboard-applet \
    matchbox-keyboard-im \
    matchbox-config-gtk \
    xcursor-transparent-theme \
    sato-icon-theme \
    settings-daemon \
    shutdown-desktop \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '', 'udev-extraconf', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio-server pulseaudio-client-conf-sato pulseaudio-misc', '', d)} \
    "

FILEMANAGER ?= "pcmanfm"

WEB ?= ""
#WEB = "epiphany"

GSTEXAMPLES ?= "gst-examples"
GSTEXAMPLES:riscv64 = ""
