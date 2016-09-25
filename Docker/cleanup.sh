#!/usr/bin/env bash

for i in $(docker service list | grep $1 | awk '{ print $2 }'); do
  docker service rm $i
done

exit 0
