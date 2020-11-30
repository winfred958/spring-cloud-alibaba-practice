#!/bin/bash

HOME_PATH=$(
  cd "$(dirname "$0")"
  cd ..
  pwd
)

cd "${HOME_PATH}/compose"

docker-compose -f nacos-standalone-mysql-5.7.yaml start
