#!/bin/bash

# Check for root privileges
if [[ $EUID -ne 0 ]]; then
   echo "This script must be run as root (try using sudo)" 
   exit 1
fi

# Check arguments
if [[ $# -ne 2 ]]; then
    echo "Usage: $0 /dev/sdX /path/to/image.wic"
    exit 1
fi

SDCARD="$1"
IMAGE="$2"

# Validate SD card path
if [[ ! -b "$SDCARD" ]]; then
    echo "Error: '$SDCARD' is not a valid block device."
    exit 1
fi

# Validate image file
if [[ ! -f "$IMAGE" ]]; then
    echo "Error: '$IMAGE' does not exist."
    exit 1
fi

echo "Unmounting partitions on $SDCARD..."
for part in $(lsblk -ln -o NAME "$SDCARD" | tail -n +2); do
    umount "/dev/$part" 2>/dev/null || echo "Warning: Could not unmount /dev/$part"
done

echo "Flashing image using bmaptool..."
bmaptool copy "$IMAGE" "$SDCARD"

echo "Done."
