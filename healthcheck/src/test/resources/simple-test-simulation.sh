#!/bin/bash

uuid=$(uuidgen)

list=SUBMITTED,ASSIGNED,WORKING,COMPLETED,FAILED,REJECTED,ABORTED,PAUSED,INTERACTION_REQUIRED
while true
do
  for status in ${list//,/ }
  do

     # shellcheck disable=SC2016
     echo $(curl -X POST -d "{\"applicationUUID\": \"${uuid}\", \"status\": \"${status}\"}" -H "Content-Type: application/json" localhost:8080/info)
     sleep 2

  done
done
