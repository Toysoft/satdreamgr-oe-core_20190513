INSANE_SKIP_${PN} += "file-rdeps"
INSANE_SKIP_${PN}-plugins += "file-rdeps"

# Qt packages are machine specific
#QT_PACKAGES_ARCH = "${MACHINE_ARCH}"
PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGECONFIG_remove_hd51 = "directfb"
