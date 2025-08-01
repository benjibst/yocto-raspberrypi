# Dockerfile
FROM debian:bookworm

RUN apt-get update && apt-get upgrade -y && apt-get install -y \
    protobuf-compiler tmux locales build-essential chrpath cpio debianutils diffstat file gawk gcc git iputils-ping libacl1 liblz4-tool locales python3 python3-git python3-jinja2 python3-pexpect python3-pip python3-subunit socat texinfo unzip wget xz-utils zstd \
    && apt-get clean

RUN echo "en_US.UTF-8 UTF-8" > /etc/locale.gen && \
    locale-gen
ENV LANG=en_US.UTF-8  
ENV LANGUAGE=en_US:en  
ENV LC_ALL=en_US.UTF-8 

RUN useradd -m yocto -s /bin/bash && \
    echo "yocto ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers

USER yocto
WORKDIR /home/yocto

RUN mkdir -p /home/yocto/rpi_yocto

CMD ["bash"]
