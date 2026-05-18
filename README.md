# Redis-Based Session Management for Java Web Application on Kubernetes

## Project Overview

This project demonstrates session management for a Java web application using Redis as an external session store and Kubernetes for deployment orchestration.

The main goal is to show that user sessions remain persistent even if an application pod is restarted or replaced.

## Technologies Used

- Java 17
- Spring Boot
- Spring Security
- Thymeleaf
- Redis
- Docker
- Kubernetes (Minikube)
- Maven

---

## Application Features

- Public home page
- User authentication with Spring Security
- Protected dashboard page
- Redis-backed HTTP sessions
- Session counter stored in Redis
- Session ID display
- Kubernetes deployment with multiple application replicas

---


## Project Structure

```text
redis-session-k8s-project/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│
├── k8s/
│   ├── redis/
│   │   ├── redis-deployment.yaml
│   │   └── redis-service.yaml
│   │
│   └── app/
│       ├── app-deployment.yaml
│       └── app-service.yaml
│
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## Implemented backend endpoints

| Endpoint | Description | Access |
|---------|-------------|--------|
| `/` | Home page | Public |
| `/login` | Default Spring Security login page | Public |
| `/dashboard` | Protected dashboard page with Redis-backed session counter | Authenticated users only |
| `/logout` | Logout handled by Spring Security | Authenticated users only |

## Test credentials

```text
username: admin
password: password
```

---

## Running Locally

### 1. Build docker containers

```bash
docker compose up --build
```

Application available at:

```text
http://localhost:8080
```

---

## Kubernetes Deployment

### 1. Start Minikube

```bash
minikube start
minikube image load session-app
```

### 2. Deploy Redis

```bash
kubectl apply -f k8s/redis/
```

Check:

```bash
kubectl get pods
kubectl get svc
```

### 4. Deploy application

```bash
kubectl apply -f k8s/app/
```

Check:

```bash
kubectl get pods
kubectl get svc
```

---

## Health Checks

Spring Boot Actuator is used for Kubernetes health monitoring.

Available endpoints:

```text
/actuator/health
/actuator/health/liveness
/actuator/health/readiness
```

These endpoints are used by Kubernetes liveness and readiness probes.

### Health check test

Open:

```text
http://session.local/actuator/health
```

Expected response:

```json
{"status":"UP"}
```

---

## Testing Session Persistence

### Test flow

1. Open application
2. Login using demo credentials
3. Open dashboard
4. Refresh page several times and observe visit counter increase

Example:

```text
Visits: 1
Visits: 2
Visits: 3
```

---

### Simulate pod failure

Get pods:

```bash
kubectl get pods
```

Delete one application pod:

```bash
kubectl delete pod <pod-name>
```

Kubernetes automatically creates a new pod.

Refresh browser.

Expected result:
- session remains active
- dashboard still accessible
- visit counter preserved

This confirms that session data is stored in Redis instead of application memory.

---

## Current Project Status

- [x] Spring Boot application
- [x] Authentication
- [x] Dashboard
- [x] Redis session storage
- [x] Docker containerization
- [x] Redis deployment in Kubernetes
- [x] Application deployment in Kubernetes
- [x] Kubernetes Service configuration
- [x] Health probes

---

## Authors

System and Network Administration Group Project: Anastasia Kalashnikova, Daria Komzolova, Kristina Ushakova
