docker run -it \
 	-v $(pwd)/sources:/home/yocto/rpi_yocto/sources	\
	-v $(pwd)/build:/home/yocto/rpi_yocto/build \
	-v $SSH_AUTH_SOCK:/ssh-agent \
	-e SSH_AUTH_SOCK=/ssh-agent \
	rpi_yocto_build \
	/bin/bash -c "cd rpi_yocto; source sources/poky/oe-init-build-env; /bin/bash"
