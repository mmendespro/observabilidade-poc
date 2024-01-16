#!/bin/bash

# stop container
docker stop service-organization

# remove container
docker rm service-organization

# remove container image
docker rmi poc/service-organization:latest

# build app and docker image
mvn clean install

# run docker image with no export port cause they are accessible by geteway-service
#docker run -id --network=localnet --name service-organization -p 8082:8082 poc/service-organization