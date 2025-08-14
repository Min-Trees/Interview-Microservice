# Interview Microservice Dev Environment

## Docker Compose
```
docker compose build
docker compose up -d
docker compose ps
```

## Quick checks
```
curl -s http://localhost:8080/actuator/health
# open the following in your browser
# http://localhost:8761
# http://localhost:8888/gateway/default
# http://localhost:9411
# http://localhost:8025
# http://localhost:9001
```

* Gateway: http://localhost:8080
* Eureka: http://localhost:8761
* Config: http://localhost:8888
* Zipkin: http://localhost:9411
* MinIO console: http://localhost:9001
* MailHog: http://localhost:8025

## Run without Docker
On Linux/macOS:
```
./scripts/run-all-local.sh
```

On Windows PowerShell:
```
./scripts/run-all-local.ps1
```
