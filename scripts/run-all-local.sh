#!/usr/bin/env bash
set -e
trap "kill 0" EXIT

mvn -q -pl config-service spring-boot:run -Dspring-boot.run.profiles=local &
mvn -q -pl discovery-service spring-boot:run -Dspring-boot.run.profiles=local &
mvn -q -pl gateway spring-boot:run -Dspring-boot.run.profiles=local &
mvn -q -pl user-service spring-boot:run -Dspring-boot.run.profiles=local &
mvn -q -pl question-service spring-boot:run -Dspring-boot.run.profiles=local &
mvn -q -pl exam-service spring-boot:run -Dspring-boot.run.profiles=local &
mvn -q -pl career-service spring-boot:run -Dspring-boot.run.profiles=local &
mvn -q -pl news-service spring-boot:run -Dspring-boot.run.profiles=local &
uvicorn nlp-service.app:app --host 0.0.0.0 --port 7000 --reload &

wait
