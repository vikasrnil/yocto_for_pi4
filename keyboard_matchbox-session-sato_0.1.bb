SUMMARY = "Minimal Matchbox session to launch CAN Viewer (Qt app) directly"
HOMEPAGE = "http://www.matchbox-project.org/"
LICENSE = "GPL-2.0-or-later"

SECTION = "x11"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit features_check
REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = ""

do_install() {
    install -d ${D}${sysconfdir}/matchbox
    cat << 'EOF' > ${D}${sysconfdir}/matchbox/session
#!/bin/sh
# Custom Matchbox session with CAN Viewer

# Start gconf daemon
gconfd-2 &

# Start window manager
matchbox-window-manager -use_titlebar no -use_cursor no &

# Start keyboard docked at bottom
matchbox-keyboard --docked &

# Set background cursor
xsetroot -cursor_name left_ptr

# Give everything a moment
sleep 2

# Launch your Qt app
exec /usr/bin/version1


EOF
    chmod +x ${D}${sysconfdir}/matchbox/session
}

FILES:${PN} += "${sysconfdir}/matchbox/session"

RDEPENDS:${PN} = "matchbox-session formfactor xsetroot version1 matchbox-keyboard gconf"

