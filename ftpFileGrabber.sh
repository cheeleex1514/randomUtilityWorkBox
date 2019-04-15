#!/bin/sh

# Must include credentials within single quotes below
# At the end of this file call the transfer_file function and file desired

HOST=''
USER=''
PASSWD=''
DATE=`date +%Y%m%d`
TIME="$(date +%H)00"
DIRECTORY=`pwd`

function transfer_file() {
    echo Connecting to $HOST
    ftp -in $HOST <<EOF
    quote USER $USER
    quote PASS $PASSWD

    bin
    lcd $DIRECTORY
    cd On2/char

    ls $1 $1.txt
    mget $1
    bye    
EOF
}

function process_files(){
    gunzip *.gz

    for FILENAME in *.xml; do
        mv $FILENAME ./processedFiles/"${TIME}"/"${TIME}_${FILENAME}"
    done
}

# Execute
mkdir -p processedFiles 
mkdir -p processedFiles/"${TIME}"

echo "Current time: ${TIME}"

# HOW EXECUTE: 
# transfer_file some_random_file_*${DATE}*.xml.gz
