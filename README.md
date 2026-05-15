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
- [ ] Redis-based session storage

### Implemented backend endpoints

| Endpoint | Description | Access |
|---------|-------------|--------|
| `/` | Home page | Public |
| `/login` | Default Spring Security login page | Public |
| `/dashboard` | Protected dashboard page with session counter | Authenticated users only |
| `/logout` | Logout handled by Spring Security | Authenticated users only |

### Test credentials

```text
username: admin
password: password
```

### Local run

```bash
mvn spring-boot:run
```

### Application URL

```text
http://localhost:8080
```

At the current stage, the application has a public home page, default Spring Security login, and a protected dashboard page with a session-based visit counter.