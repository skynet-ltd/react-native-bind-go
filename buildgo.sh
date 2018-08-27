#!/bin/bash

if [ -z "$1" ]; then
    echo "please provide module name in argument, example ./build greeting"
    exit 1
fi

gomobile bind -x -v -target=android -o $1/$1.aar TestGo/$1

cp -r $1 android/$1