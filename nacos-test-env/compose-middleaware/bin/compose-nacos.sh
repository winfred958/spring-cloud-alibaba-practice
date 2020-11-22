#!/bin/bash

HOME_PATH=$(
  cd "$(dirname "$0")"
  cd ..
  pwd
)

cd "${HOME_PATH}/compose"

docker-compose -f mysql-redis-elasticsearch.yaml up -d
