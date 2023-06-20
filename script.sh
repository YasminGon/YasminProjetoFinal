#!/bin/bash
while true
do
    if ! mysql -u root -e "CREATE DATABASE applicationdb" &> /dev/null
        then
            	sleep 1
        else
            	break
    fi
done