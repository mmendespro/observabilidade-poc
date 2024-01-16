#!/bin/bash

# stop container
docker stop service-employee

# remove container
docker rm service-employee

# remove container image
docker rmi poc/service-employee:latest

# build app and docker image
mvn clean install

# run docker image with no export port cause they are accessible by geteway-service
#docker run -id --network=localnet --name service-employee -p 8080:8080 poc/service-employee