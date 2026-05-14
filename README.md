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
- [ ] Login configuration
- [ ] Protected dashboard page
- [ ] Session counter
- [ ] Redis-based session storage

### Implemented backend endpoints

| Endpoint | Description | Access |
|---------|-------------|--------|
| `/` | Home page | Currently protected by default Spring Security |

### Local run

```bash
mvn spring-boot:run
```

### Application URL

```text
http://localhost:8080
```

At the current stage, Spring Security protects all routes, so the default login page is shown before accessing the home page.