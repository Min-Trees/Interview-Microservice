# Interview Microservice Dev Environment

## Docker Compose
```
docker compose build
docker compose up -d
docker compose ps
```

The stack reads database and infrastructure settings from a `.env` file. A sample is provided:

```
POSTGRES_HOST=mainline.proxy.rlwy.net
POSTGRES_PORT=55240
POSTGRES_DB=railway
POSTGRES_USER=postgres
POSTGRES_PASSWORD=imDbpNYRkmRSNrIUlpLFfSKGTKAmxovg
POSTGRES_SSLMODE=require
KAFKA_BROKER=kafka:9092
EUREKA_URI=http://eureka:8761/eureka
CONFIG_URI=http://config:8888
USER_SCHEMA=user_svc
QUESTION_SCHEMA=question_svc
EXAM_SCHEMA=exam_svc
CAREER_SCHEMA=career_svc
NEWS_SCHEMA=news_svc
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
