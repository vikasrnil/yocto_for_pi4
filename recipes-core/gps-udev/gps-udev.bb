SUMMARY = "Udev rules for GPS device"
DESCRIPTION = "Installs custom udev rules for GPS serial device"
LICENSE = "CLOSED"

SRC_URI += "file://99-gps.rules"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/99-gps.rules ${D}${sysconfdir}/udev/rules.d/
}

FILES:${PN} += "${sysconfdir}/udev/rules.d/99-gps.rules"

