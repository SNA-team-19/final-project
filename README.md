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
to be added later
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

### 1. Start Redis container

```bash
docker run -d --name session-redis -p 6379:6379 redis:7
```

If container already exists:

```bash
docker start session-redis
```

### 2. Run Spring Boot application

```bash
mvn spring-boot:run
```

Application available at:

```text
http://localhost:8080
```

### 3. Check Redis session data

Open Redis CLI:

```bash
docker exec -it session-redis redis-cli
```

Run:

```bash
keys *
```

Expected keys:

```text
spring:session:sessions:...
spring:session:expirations:...
spring:session:index:...
```

---

## Docker Build

Build Docker image:

```bash
docker build -t session-app .
```

Run container:

```bash
docker run -p 8080:8080 session-app
```

---

## Kubernetes Deployment

### 1. Start Minikube

```bash
minikube start
```

### 2. Use Minikube Docker daemon

```bash
eval $(minikube docker-env)
docker build -t session-app .
```

### 3. Deploy Redis

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

### 5. Access application using port-forward

```bash
kubectl port-forward service/session-app-service 8080:80
```

Application available at:

```text
http://localhost:8080
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
- [ ] Health probes
- [ ] NGINX Ingress

---

## Authors

System and Network Administration Group Project: Anastasia Kalashnikova, Daria Komzolova, Kristina Ushakova
