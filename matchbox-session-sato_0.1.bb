SUMMARY = "Minimal Matchbox session to launch CAN Viewer (Qt app) directly"
HOMEPAGE = "http://www.matchbox-project.org/"
LICENSE = "GPL-2.0-or-later"

SECTION = "x11"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit features_check
REQUIRED_DISTRO_FEATURES = "x11"

# No external files needed — session script is created inline
SRC_URI = ""

do_install() {
    install -d ${D}${sysconfdir}/matchbox
    cat << 'EOF' > ${D}${sysconfdir}/matchbox/session
#!/bin/sh
# Custom Matchbox session — runs only CAN Viewer app (Qt GUI)
# No desktop, no panels, no terminal flicker.

# Set background cursor (optional)
xsetroot -cursor_name left_ptr

# Give X a short moment to settle
sleep 1

# Run your Qt app (must be installed at /usr/bin/canviewer3)
exec /usr/bin/canviewer3
EOF
    chmod +x ${D}${sysconfdir}/matchbox/session
}

FILES:${PN} += "${sysconfdir}/matchbox/session"

RDEPENDS:${PN} = "matchbox-session formfactor xsetroot canviewer3"
