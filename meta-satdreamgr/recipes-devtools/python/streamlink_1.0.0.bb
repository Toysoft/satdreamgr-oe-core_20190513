SUMMARY = "CLI for extracting streams from various websites to a video player of your choosing"
DESCRIPTION = "Streamlink is a command-line utility that pipes video streams from various services into a video player, such as VLC."
HOMEPAGE = "https://streamlink.github.io/"
SECTION = "devel/python"
LICENSE = "BSD"
PACKAGE_ARCH = "all"

LIC_FILES_CHKSUM = "file://LICENSE;md5=67e73aa1a18a474a727af66319626ed4"

inherit setuptools

RDEPENDS_${PN} = "python \
	python-argparse \
	python-backports-shutil-which \
	python-ctypes \
	python-futures \
	python-iso3166 \
	python-iso639 \
	python-isodate \
	python-misc \
	python-pkgutil \
	python-pycrypto \
	python-requests \
	python-shell \
	python-singledispatch \
	python-subprocess \
	python-websocket-client \
	"

SRC_URI = "git://github.com/streamlink/streamlink.git;protocol=git"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git/"

inherit gitpkgv

PV = "1.0.0+git${SRCPV}"
PKGV = "1.0.0+git${GITPKGV}"
PR = "r0"

do_install_append() {
	rm -rf ${D}${bindir}
	rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/streamlink_cli
}

PACKAGES = "${PN}-src ${PN}"

FILES_${PN} = " \
	${libdir}/${PYTHON_DIR}/site-packages/streamlink/*.pyo \
	${libdir}/${PYTHON_DIR}/site-packages/streamlink/*/*.pyo \
	${libdir}/${PYTHON_DIR}/site-packages/streamlink/*/*/*.pyo \
	"

FILES_${PN}-src = " \
	${libdir}/${PYTHON_DIR}/site-packages/streamlink-*.egg-info/* \
	${libdir}/${PYTHON_DIR}/site-packages/streamlink/*.py \
	${libdir}/${PYTHON_DIR}/site-packages/streamlink/*/*.py \
	${libdir}/${PYTHON_DIR}/site-packages/streamlink/*/*/*.py \
	"
