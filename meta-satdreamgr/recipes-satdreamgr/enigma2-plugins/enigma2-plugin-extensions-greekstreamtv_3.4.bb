DESCRIPTION = "GreekStreamTV"
SUMMARY = "Watch live stream TV from Greece"
SECTION = "multimedia"
MAINTAINER = "SatDreamGR"
HOMEPAGE = "http://satdreamgr.com"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://setup.py;md5=5bd6abbe16b24378e2f2a38aea9768d2"

RDEPENDS_${PN} = "livestreamer \
	python-requests \
	rtmpdump \
	"

PR = "r2"

S="${WORKDIR}/git"

SRC_URI = " \
	git://github.com/athoik/GreekStreamTV;protocol=git \
	file://0001-Satdreamgr-Changes.patch \
	"

SRCREV = "d5817a2f332a838ef5f5311c664a081664221610"

inherit distutils-openplugins

do_install_append() {
  chmod 755 ${D}${libdir}/enigma2/python/Plugins/Extensions/GreekStreamTV/*.sh
}

PACKAGES =+ "${PN}-src"

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/GreekStreamTV/*"
FILES_${PN}-src = "${libdir}/enigma2/python/Plugins/Extensions/GreekStreamTV/*.py \
	${libdir}/enigma2/python/Plugins/enigma2_plugin_extensions_greekstreamtv-3.2-py2.7.egg-info \
	${libdir}/python2.7/* \
	"

