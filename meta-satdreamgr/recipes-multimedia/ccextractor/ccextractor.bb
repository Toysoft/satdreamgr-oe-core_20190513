SUMMARY = "Fast closed captions extractor for MPEG and H264 files"
DESCRIPTION = "CCExtractor is a tool used to produce subtitles for TV recordings from almost anywhere in the world."
MAINTAINER = "https://www.ccextractor.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../LICENSE.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit gitpkgv

PV = "0.87+git${SRCPV}"
PKGV = "0.87+git${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/ccextractor/ccextractor.git;protocol=http"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git/linux"

DEPENDS = "virtual/libiconv"

inherit autotools-brokensep pkgconfig gettext

do_configure_prepend() {
	./pre-build.sh
}

CPPFLAGS_append = " -DPNG_ARM_NEON_OPT=0"
INSANE_SKIP_${PN} = "already-stripped"
