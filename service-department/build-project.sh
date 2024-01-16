#!/bin/bash

# stop container
docker stop service-department

# remove container
docker rm service-department

# remove container image
docker rmi poc/service-department:latest

# build app and docker image
mvn clean install

# run docker image with no export port cause they are accessible by geteway-service
#docker run -id --network=localnet --name service-department -p 8081:8081 poc/service-department