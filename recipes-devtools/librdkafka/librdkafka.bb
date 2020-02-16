DESCRIPTION = "Library for deploying kafka client into ZCU104"
SECTION = "network protocol"
HOMEPAGE = "https://github.com/edenhill/librdkafka"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9fce0f49e0cfcf27ee7fec6c059e0146"

SRCREV = "c8fd8e682bb79e756920176b34051f18e7c8c006"
BRANCH = "master"
SRC_URI = "git://github.com/edenhill/librdkafka.git;protocol=https;branch=${BRANCH}"

S = "${WORKDIR}/git"

DEPENDS = "zlib gnutls make cmake"

inherit cmake pkgconfig

EXTRA_OECMAKE = " \
        -Dlibrdkafka_ZLIB_PROVIDER=package \
        -Dlibrdkafka_INSTALL=ON \
        -DCMAKE_CROSSCOMPILING=ON \
        -DBUILD_SHARED_LIBS=ON \
        -Dlibrdkafka_INSTALL_LIBDIR=${baselib} \
        "

PACKAGE_BEFORE_PN += "${PN}-tools"
FILES_${PN}-tools = "${bindir}"
FILES_${PN}-dev += "${bindir}"
