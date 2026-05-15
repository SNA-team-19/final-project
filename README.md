# Redis-Based Session Management for Java Web Application on Kubernetes

## Backend

Spring Boot application responsible for user authentication and session management.

### Current backend status

- [x] Spring Boot project initialized
- [x] Maven project configured
- [x] Spring Security dependency added
- [x] Application starts locally on port 8080
- [x] Custom home page
- [x] Custom home page controller added
- [x] Thymeleaf template for home page added
- [x] Login configuration
- [x] Protected dashboard page
- [x] Session counter
- [x] Redis-based session storage
- [x] Session ID display on dashboard

### Implemented backend endpoints

| Endpoint | Description | Access |
|---------|-------------|--------|
| `/` | Home page | Public |
| `/login` | Default Spring Security login page | Public |
| `/dashboard` | Protected dashboard page with Redis-backed session counter | Authenticated users only |
| `/logout` | Logout handled by Spring Security | Authenticated users only |

### Test credentials

```text
username: admin
password: password
```

### Local Redis run

```bash
docker run -d --name session-redis -p 6379:6379 redis:7
```

If the container already exists:

```bash
docker start session-redis
```

Check Redis sessions:

```bash
docker exec -it session-redis redis-cli
keys *
```

Expected keys:

```text
spring:session:sessions:...
spring:session:expirations:...
spring:session:index:...
```

### Local application run

```bash
mvn spring-boot:run
```

### Application URL

```text
http://localhost:8080
```

At the current stage, the application has a public home page, default Spring Security login, a protected dashboard page, and Redis-backed session storage.