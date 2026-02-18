FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

do_install:append() {
    # Remove the default interfaces file
    rm -f ${D}${sysconfdir}/network/interfaces
    # Or replace with your own clean version
    install -m 0644 ${WORKDIR}/interfaces ${D}${sysconfdir}/network/interfaces
}

