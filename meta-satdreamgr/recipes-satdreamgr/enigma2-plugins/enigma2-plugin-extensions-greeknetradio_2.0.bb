DESCRIPTION = "GreekNetRadio"
SUMMARY = "Greek web radios"
SECTION = "multimedia"
MAINTAINER = "SatDreamGR"
HOMEPAGE = "http://satdreamgr.com"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://setup.py;md5=5d6dbd47e15611970ab1e4286f0acd22"

RDEPENDS_${PN} = "python-core"

PR = "r3"

S="${WORKDIR}/git"

SRC_URI = "git://github.com/satdreamgr/GreekNetRadio;protocol=git"

SRCREV = "264ad40f36a0a451651a229d506c7213be1fa85f"

inherit distutils-openplugins

do_install_append() {
  chmod 755 ${D}${libdir}/enigma2/python/Plugins/Extensions/GreekNetRadio/*.sh
}

PACKAGES =+ "${PN}-src"

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/GreekNetRadio/*"
FILES_${PN}-src = "${libdir}/enigma2/python/Plugins/Extensions/GreekNetRadio/*.py \
	${libdir}/enigma2/python/Plugins/enigma2_plugin_extensions_greeknetradio-1.0-py2.7.egg-info \
	${libdir}/python2.7/* \
	"

