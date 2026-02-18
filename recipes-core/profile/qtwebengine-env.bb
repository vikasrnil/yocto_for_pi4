SUMMARY = "Set QTWEBENGINE_DISABLE_SANDBOX globally"
LICENSE = "CLOSED"

SRC_URI = "file://qtwebengine.sh"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/etc/profile.d
    install -m 0755 ${WORKDIR}/qtwebengine.sh ${D}/etc/profile.d/qtwebengine.sh
}

FILES:${PN} += "/etc/profile.d/qtwebengine.sh"

