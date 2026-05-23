# FinTrack API — Contexto del Proyecto para OpenCode

> Este archivo es leído automáticamente por todos los agentes de OpenCode.
> Proporciona contexto del proyecto, convenciones y estado del aprendizaje.

## 🌐 Idioma

**Todas las respuestas deben ser en castellano.** El estudiante y el mentor se comunican en español. Código, nombres de clases, métodos y variables se mantienen en inglés (convención estándar de la industria).

---

## Proyecto

**FinTrack** es una API REST de gestión financiera personal construida como proyecto
incremental de aprendizaje en el plan Spring Boot (transición NestJS → Spring Boot).

### Stack técnico

| Tecnología | Versión | Equivalente NestJS |
|------------|---------|-------------------|
| Java | 21 (LTS) | TypeScript 5.x |
| Spring Boot | 3.x | NestJS 10.x |
| PostgreSQL | 16 | PostgreSQL (igual) |
| Flyway | 10.x | TypeORM migrations |
| Spring Security + JWT | 6.x | Passport + JWT |
| WebClient | (reactivo) | Axios / Fetch |
| JUnit 5 + Testcontainers | — | Jest + testcontainers-node |
| Maven | 3.x | npm/pnpm |
| Docker Compose | — | Docker Compose (igual) |

### Estructura del proyecto

```
fintrack/
├── src/
│   ├── main/
│   │   ├── java/com/fintrack/
│   │   │   ├── FinTrackApplication.java
│   │   │   ├── config/          # Spring @Configuration beans
│   │   │   ├── controller/      # @RestController (equiv. NestJS controllers)
│   │   │   ├── service/         # @Service (equiv. NestJS @Injectable providers)
│   │   │   ├── repository/      # @Repository / JpaRepository interfaces
│   │   │   ├── entity/          # @Entity JPA (equiv. TypeORM entities)
│   │   │   ├── dto/             # Records / clases DTO (equiv. NestJS DTOs)
│   │   │   ├── exception/       # @ControllerAdvice global error handler
│   │   │   └── security/        # JWT filter, SecurityConfig
│   │   └── resources/
│   │       ├── application.yml       # Config principal
│   │       ├── application-dev.yml   # Config dev (equiv. .env.development)
│   │       ├── application-prod.yml  # Config prod
│   │       └── db/migration/         # Flyway: V1__init.sql, V2__...sql
│   └── test/
│       ├── java/com/fintrack/
│       │   ├── unit/            # Tests sin Spring context
│       │   ├── integration/     # @WebMvcTest, @DataJpaTest
│       │   └── e2e/             # Testcontainers + full context
│       └── resources/
│           └── application-test.yml
├── docker-compose.yml           # PostgreSQL local + (M9) Prometheus/Grafana
├── pom.xml
└── AGENTS.md                    ← este archivo
```

---

## Convenciones del proyecto

### Nombrado

- Clases: `PascalCase` — `AccountService`, `TransactionController`
- Variables/métodos: `camelCase` — `findByUserId`, `createAccount`
- Constantes: `UPPER_SNAKE_CASE` — `MAX_RETRIES`
- Paquetes: `lowercase` — `com.fintrack.service`
- Tablas BD: `snake_case` — `bank_accounts`, `transactions`
- Migrations Flyway: `V{n}__{descripcion_snake}.sql` — `V1__create_users_table.sql`

### Inyección de dependencias

```java
// ✅ SIEMPRE constructor injection
@Service
public class AccountService {
    private final AccountRepository repo;
    public AccountService(AccountRepository repo) { this.repo = repo; }
}

// ❌ NUNCA field injection
@Autowired
private AccountRepository repo;
```

### DTOs

Usar Java Records para DTOs (inmutables, sin boilerplate):
```java
public record CreateAccountRequest(String name, String currency, BigDecimal initialBalance) {}
public record AccountResponse(Long id, String name, String currency, BigDecimal balance) {}
```

Los DTOs van en `dto/`, las entidades en `entity/`. **Nunca exponer entidades directamente en controllers.**

### Manejo de errores

Global en `exception/GlobalExceptionHandler.java` con `@ControllerAdvice`.
Usar excepciones de dominio propias: `AccountNotFoundException`, `InsufficientFundsException`.

### Transactions

`@Transactional` en la capa de servicio, no en controllers ni repositories.


---

## Módulos y sprints del plan (13 semanas)

| # | Módulo | Semanas | Sprint |
|---|--------|---------|--------|
| 0 | Java Essentials para TypeScript Devs | 1 | Setup del proyecto |
| 1 | Spring Core & Boot | 1.5 | Estructura base FinTrack |
| 2 | REST API con Spring MVC | 1.5 | Endpoints de Cuentas |
| 3 | Spring Data JPA + PostgreSQL | 2 | Persistencia completa |
| 4 | Flyway — Migraciones de BD | 0.5 | Schema versionado |
| 5 | Spring Security + JWT + OAuth2 | 2 | Autenticación completa |
| 6 | OpenAPI / Swagger | 0.5 | Documentación viva |
| 7 | Integración con APIs externas | 1 | Conversión de divisas |
| 8 | Testing completo | 2 | Suite de tests |
| 9 | Production-Ready | 1 | Deploy-ready |

---

## Criterios de code review por módulo

| Módulo | Qué revisar siempre |
|--------|---------------------|
| M1–2 | Constructor injection; DTOs ≠ Entidades; ResponseEntity correcto |
| M3 | Sin N+1; @Transactional en servicio; sin `ddl-auto: create` |
| M4 | V{n}\_\_{desc}.sql; sin modificar migrations existentes |
| M5 | BCrypt en passwords; @PreAuthorize; JWT no en sesión |
| M6 | @Schema en DTOs; seguridad documentada en Swagger |
| M7 | Timeout configurado; circuit breaker; errores internos no expuestos |
| M8 | Unit sin Spring; @WebMvcTest para controllers; Testcontainers para BD |
| M9 | Sin secrets en código; health check propio; logs estructurados |

---

## Equivalencias rápidas NestJS → Spring

| NestJS | Spring |
|--------|--------|
| `@Module({ providers })` | `@Configuration` + `@Bean` |
| `@Injectable()` | `@Service`, `@Component`, `@Repository` |
| `@Controller()` | `@RestController` |
| `@Get()`, `@Post()` | `@GetMapping()`, `@PostMapping()` |
| `@Body()` | `@RequestBody` |
| `@Param()` | `@PathVariable` |
| `@Query()` | `@RequestParam` |
| `@UseGuards(JwtGuard)` | `@PreAuthorize("isAuthenticated()")` |
| `@UsePipes(ValidationPipe)` | `@Valid` en parámetro del método |
| `app.useGlobalFilters(...)` | `@ControllerAdvice` |
| `ConfigService.get('KEY')` | `@Value("${key}")` o `@ConfigurationProperties` |
| `.env` | `application.yml` + Spring Profiles |
| `process.env.NODE_ENV` | `-Dspring.profiles.active=dev` |
| TypeORM Entity | JPA `@Entity` + `@Table` |
| TypeORM Repository | `JpaRepository<Entity, ID>` |
| TypeORM migrations | Flyway `V{n}__desc.sql` |
