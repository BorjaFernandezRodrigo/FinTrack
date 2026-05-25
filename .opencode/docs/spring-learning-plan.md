# 🍃 Spring Boot: Plan de Aprendizaje para Desarrolladores Senior

## Ruta de transición NestJS → Spring Boot

> **Para el estudiante:** Tienes 10 años de experiencia y dominas NestJS/Node/Angular. Este plan NO te enseña a programar — te enseña cómo Java y Spring resuelven los mismos problemas que ya resuelves en Node. Cada módulo tiene una columna *"En NestJS lo harías así..."* para que el aprendizaje sea inmediato.

---

## 📊 Visión General del Plan

| Módulo | Tema | Duración | Proyecto |
|--------|------|----------|---------|
| 0 | Java Essentials para TypeScript Devs | 1 semana | Setup del proyecto |
| 1 | Spring Core & Boot | 1.5 semanas | Estructura base FinTrack |
| 2 | REST API con Spring MVC | 1.5 semanas | Endpoints de Cuentas |
| 3 | Spring Data JPA + PostgreSQL | 2 semanas | Persistencia completa |
| 4 | Flyway — Migraciones de BD | 0.5 semanas | Schema versionado |
| 5 | Spring Security + JWT + OAuth2 | 2 semanas | Autenticación completa |
| 6 | OpenAPI / Swagger | 0.5 semanas | Documentación viva |
| 7 | Integración con APIs externas | 1 semana | Conversión de divisas |
| 8 | Testing completo | 2 semanas | Suite de tests |
| 9 | Production-Ready (Actuator, Cache, Async) | 1 semana | Deploy-ready |

**Duración total estimada:** ~13 semanas (con dedicación de 2-3h/día)

---

## 🏗️ El Proyecto: FinTrack API

Una API REST de gestión financiera personal con:

- Gestión de usuarios con autenticación JWT
- Cuentas bancarias y transacciones
- Categorías y presupuestos
- Conversión de divisas en tiempo real (API externa)
- Documentación OpenAPI completa
- Suite de tests unitarios, de integración y E2E

**Stack técnico:**

- Java 21 (LTS)
- Spring Boot 3.x
- PostgreSQL
- Flyway
- Spring Security + JWT
- WebClient (HTTP reactivo)
- JUnit 5 + Testcontainers
- Docker Compose

---

## 📦 Módulo 0 — Java Essentials para TypeScript Developers

### Objetivo

Transición mental TypeScript → Java. No es aprender Java desde cero, es mapear lo que ya sabes.

### 🔄 Tabla de equivalencias clave

| TypeScript/Node | Java |
|-----------------|------|
| `interface` | `interface` o `record` |
| `type` con campos | `class` o `record` |
| `async/await` + Promise | `CompletableFuture` o Reactive |
| `?.` optional chaining | `Optional<T>` |
| `Array.map/filter/reduce` | `Stream.map/filter/reduce` |
| `npm install` | Maven `pom.xml` o Gradle `build.gradle` |
| `package.json scripts` | `mvn` / `gradle` commands |
| `tsconfig.json` | configurado en Maven/Gradle |
| `node_modules` | `~/.m2/repository` |
| `jest` | JUnit 5 + Mockito |
| `interface + class implements` | `interface + class implements` (igual!) |

### Conceptos críticos de Java a dominar

**Generics** — Son como TypeScript generics pero más estrictos en tiempo de compilación

```java
// TypeScript
function identity<T>(arg: T): T { return arg; }

// Java
public <T> T identity(T arg) { return arg; }
```

**Streams API** — Como Array.prototype methods en JS pero lazy y componibles

```java
List<Integer> result = numbers.stream()
    .filter(n -> n > 5)
    .map(n -> n * 2)
    .collect(Collectors.toList());
```

**Optional** — Como el optional chaining de TypeScript pero explícito

```java
Optional<User> user = userRepo.findById(id);
user.ifPresent(u -> System.out.println(u.getName()));
String name = user.map(User::getName).orElse("Unknown");
```

**Records** (Java 16+) — Como interfaces de TypeScript con data

```java
// TypeScript: type UserDTO = { name: string; email: string }
public record UserDTO(String name, String email) {}
```

**Lambdas y Method References** — Como arrow functions

```java
// TypeScript: users.forEach(u => console.log(u))
users.forEach(u -> System.out.println(u));
users.forEach(System.out::println); // method reference
```

### Recursos

**Documentación oficial:**

- [Java 21 Language Spec — What's new](https://openjdk.org/projects/jdk/21/)
- [Java Streams Documentation](https://docs.oracle.com/en/java/api/java.base/java/util/stream/Stream.html)
- [Records (JEP 395)](https://openjdk.org/jeps/395)

**Artículos / Reading:**

- [Java for JavaScript developers — Baeldung](https://www.baeldung.com/java-for-javascript-developers) *(excelente comparativa directa)*
- [Modern Java features overview — Baeldung](https://www.baeldung.com/java-8-new-features)
- [Optional in Java — Baeldung](https://www.baeldung.com/java-optional)
- [Java Streams — Baeldung](https://www.baeldung.com/java-8-streams)

**Videos:**

- [Java for JavaScript Developers — Amigoscode (YouTube, 1h)](https://www.youtube.com/watch?v=GoXwIVyNvX0)
- [Modern Java (Records, Sealed Classes, Pattern Matching) — Marco Codes](https://www.youtube.com/c/MarcoCodesJava)
- [Java 21 Virtual Threads & Modern Features — JetBrains](https://www.youtube.com/watch?v=UVoGE0wpVBM)

**Herramientas:**

- Instalar: [SDKMAN](https://sdkman.io/) — equivalente a `nvm` para Java
- IDE: [IntelliJ IDEA Community](https://www.jetbrains.com/idea/) — obligatorio, el VS Code de Java

### 🔨 Proyecto — Sprint 0: Setup

- Instalar Java 21 con SDKMAN
- Configurar IntelliJ IDEA con plugins: Spring Boot, Lombok, SonarLint
- Crear el repositorio Git de FinTrack
- Iniciar el sistema de katas diarias (ver `docs/katas.md`) — 2 ejercicios/día como refuerzo continuo durante todo el plan. Los bloques 1-10 cubren: Records, Generics, Streams, Optional, Lambdas, Interfaces, Collectors, Enums/Sellados, BigDecimal, y Excepciones.

> 🏋️ **Sistema de katas continuas**: En lugar de concentrar todos los ejercicios en M0, cada módulo incluye ejercicios diarios de refuerzo (~2/día). Esto mantiene fresca la sintaxis de Java mientras avanzas con Spring. Los bloques están en `docs/katas.md` y cada sprint del proyecto incluye sugerencias de kata alineadas con el tema del módulo.

---

## 📦 Módulo 1 — Spring Core & Spring Boot

### Objetivo

Entender el corazón de Spring: IoC Container, Dependency Injection, y cómo Boot autoconfigura todo. Mapear esto con el Module system de NestJS.

### 🔄 NestJS → Spring

| NestJS | Spring |
|--------|--------|
| `@Module({ providers: [] })` | `@Configuration` + `@Bean` |
| `@Injectable()` | `@Service`, `@Component`, `@Repository` |
| `NestFactory.create(AppModule)` | `SpringApplication.run()` |
| `app.module.ts` | Autoconfiguración de Spring Boot |
| `providers: [MyService]` | Detección automática por `@ComponentScan` |
| `.env` + ConfigService | `application.properties` / `application.yml` |
| `process.env.NODE_ENV` | Spring Profiles (`@Profile("dev")`) |
| Constructor injection | Constructor injection (mismo patrón!) |

### Conceptos clave

**IoC Container** — El contenedor gestiona el ciclo de vida de los beans

```java
// NestJS: @Injectable() class MyService {}
// Spring:
@Service
public class AccountService {
    private final AccountRepository repo;
    
    // Constructor injection — Spring resuelve automáticamente
    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }
}
```

**Spring Boot Auto-configuration** — No hay que configurar casi nada. Boot detecta las dependencias en el classpath y configura automáticamente. Si tienes `spring-boot-starter-data-jpa` en tu `pom.xml`, ya tienes JPA configurado.

**application.yml** — El `config.ts` de Spring

```yaml
spring:
  profiles:
    active: dev
  datasource:
    url: jdbc:postgresql://localhost:5432/fintrack
    username: ${DB_USER}
    password: ${DB_PASSWORD}
  
server:
  port: 8080

app:
  jwt:
    secret: ${JWT_SECRET}
    expiration: 86400000
```

**Profiles** — Como `NODE_ENV`

```java
@Configuration
@Profile("dev")
public class DevConfig {
    @Bean
    public DataSource devDataSource() { ... }
}
```

**Bean Scopes** — Singleton por defecto (como los providers de NestJS)

- `@Scope("singleton")` — Una instancia (default)
- `@Scope("prototype")` — Nueva instancia cada vez
- `@Scope("request")` — Una por request HTTP

### Recursos

**Documentación oficial:**

- [Spring Framework Core — IoC Container](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)
- [Spring Boot Reference — Auto-configuration](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using.auto-configuration)
- [Spring Initializr](https://start.spring.io/) — El `nest new` de Spring

**Artículos:**

- [Spring IoC Container — Baeldung](https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring)
- [Spring Boot Auto-configuration — Baeldung](https://www.baeldung.com/spring-boot-auto-configuration)
- [Spring Profiles — Baeldung](https://www.baeldung.com/spring-profiles)
- [Spring application.yml config — Baeldung](https://www.baeldung.com/spring-yaml)

**Videos:**

- [Spring Boot 3 Full Course — Amigoscode (YouTube, 3h)](https://www.youtube.com/watch?v=9SGDpanrc8U)
- [Spring Core Deep Dive — Dan Vega (YouTube)](https://www.youtube.com/@DanVega)
- [Spring Boot Crash Course — Marco Codes (YouTube)](https://www.youtube.com/watch?v=UgX5lgv4uVM)

**Cursos completos:**

- [Spring & Hibernate for Beginners — Udemy Chad Darby](https://www.udemy.com/course/spring-hibernate-tutorial/) *(Ignorar secciones básicas, ir a Spring Boot 3)*
- [Master Spring Boot 3 with JPA — Udemy](https://www.udemy.com/course/spring-boot-tutorial-for-beginners/)

### 🔨 Proyecto — Sprint 1: Estructura base

- Crear proyecto con Spring Initializr (Web, Lombok, DevTools, Actuator)
- Estructura de paquetes: `domain`, `application`, `infrastructure`, `api`
- Primer `@Service`, `@Component` con inyección por constructor
- Configuración de profiles (`dev`, `test`, `prod`) con `application.yml`
- Health check endpoint con Actuator
- 🏋️ Kata diario: crear beans con scopes singleton/prototype/request y verificar su comportamiento con logs

---

## 📦 Módulo 2 — REST API con Spring MVC

### Objetivo

Construir APIs REST robustas con validación, manejo de errores y buenas prácticas. Es el equivalente directo de los Controllers de NestJS.

### 🔄 NestJS → Spring MVC

| NestJS | Spring MVC |
|--------|------------|
| `@Controller('/accounts')` | `@RestController @RequestMapping("/accounts")` |
| `@Get(':id')` | `@GetMapping("/{id}")` |
| `@Post()` | `@PostMapping` |
| `@Put(':id')` | `@PutMapping("/{id}")` |
| `@Delete(':id')` | `@DeleteMapping("/{id}")` |
| `@Body()` | `@RequestBody` |
| `@Param('id')` | `@PathVariable Long id` |
| `@Query('page')` | `@RequestParam int page` |
| `@Headers()` | `@RequestHeader` |
| DTO class-validator | Bean Validation (`@Valid`, `@NotNull`, `@Email`) |
| `ExceptionFilter` | `@ControllerAdvice` + `@ExceptionHandler` |
| `HttpException` | Custom exceptions + ProblemDetail (RFC 9457) |
| Interceptor (logging) | `HandlerInterceptor` |
| Pipe (transform) | `@InitBinder` o `Converter<S,T>` |

### Ejemplo de Controller completo

```java
@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor   // Lombok: genera constructor para campos final
@Validated
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<Page<AccountResponse>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(accountService.findAll(PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AccountResponse> create(@Valid @RequestBody CreateAccountRequest request) {
        AccountResponse created = accountService.create(request);
        URI location = URI.create("/api/v1/accounts/" + created.id());
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateAccountRequest request) {
        return ResponseEntity.ok(accountService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        accountService.delete(id);
    }
}
```

### Validación con Bean Validation

```java
// DTO con validaciones — como class-validator de NestJS
public record CreateAccountRequest(
    @NotBlank(message = "Name is required")
    String name,
    
    @NotNull
    @Positive(message = "Initial balance must be positive")
    BigDecimal initialBalance,
    
    @NotNull
    AccountType type,
    
    @Pattern(regexp = "[A-Z]{3}", message = "Currency must be 3 uppercase letters")
    String currency
) {}
```

### Manejo global de errores — equivalente al ExceptionFilter de NestJS

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    // Spring Boot 3.x — RFC 9457 ProblemDetail
    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handleNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problem.setTitle("Resource Not Found");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problem.setTitle("Validation Failed");
        problem.setProperty("errors", errors);
        return problem;
    }
}
```

### Recursos

**Documentación oficial:**

- [Spring MVC — Spring Reference](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc)
- [Bean Validation — Jakarta EE](https://beanvalidation.org/2.0/spec/)
- [ProblemDetail RFC 9457](https://www.rfc-editor.org/rfc/rfc9457)

**Artículos:**

- [REST with Spring Tutorial — Baeldung](https://www.baeldung.com/rest-with-spring-series)
- [Bean Validation — Baeldung](https://www.baeldung.com/javax-validation)
- [Error Handling for REST with Spring — Baeldung](https://www.baeldung.com/exception-handling-for-rest-with-spring)
- [ProblemDetail in Spring Boot 3 — Baeldung](https://www.baeldung.com/spring-boot-problem-json)
- [Spring ResponseEntity — Baeldung](https://www.baeldung.com/spring-response-entity)

**Videos:**

- [Building REST APIs with Spring Boot — Amigoscode](https://www.youtube.com/watch?v=9SGDpanrc8U)
- [Spring Boot REST API Best Practices — Dan Vega](https://www.youtube.com/watch?v=Nv2DERaMx-4)
- [Exception Handling in Spring Boot — Teddy Smith (YouTube)](https://www.youtube.com/watch?v=PzK4ZXa2Tbc)

### 🔨 Proyecto — Sprint 2: Endpoints CRUD

- CRUD completo de `Account` y `Transaction`
- DTOs con validación (request y response separados)
- GlobalExceptionHandler con ProblemDetail
- Paginación en listados
- Tests básicos con `MockMvc` (solo smoke tests, profundizaremos en Módulo 8)
- 🏋️ Kata diario: implementar un `@ControllerAdvice` que maneje 5 tipos de excepción con mensajes personalizados

---

## 📦 Módulo 3 — Spring Data JPA + PostgreSQL

### Objetivo

ORM completo con Hibernate. Equivalente a TypeORM/Prisma pero con el poder de JPA estándar.

### 🔄 TypeORM/Prisma → JPA

| TypeORM/Prisma | JPA/Spring Data |
|----------------|-----------------|
| `@Entity()` | `@Entity` |
| `@Column()` | `@Column` |
| `@PrimaryGeneratedColumn()` | `@Id @GeneratedValue` |
| `@OneToMany(() => T)` | `@OneToMany(mappedBy="account")` |
| `Repository<Entity>` | `JpaRepository<Entity, Long>` |
| `repo.findOne({ where: {} })` | `repo.findById(id)` |
| Custom query methods | Derived query methods |
| `@Query()` raw SQL | `@Query("JPQL...")` |
| QueryBuilder | JPQL / Criteria API / Specifications |
| `find({ relations: ['x'] })` | `@EntityGraph` / `JOIN FETCH` |
| `createQueryRunner()` | `@Transactional` |

### Entidad JPA con Auditoría

```java
@Entity
@Table(name = "accounts")
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
```

### Repository con queries avanzadas

```java
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Derived query method — Spring genera el SQL automáticamente
    List<Account> findByUserIdAndType(Long userId, AccountType type);
    
    // JPQL personalizado
    @Query("SELECT a FROM Account a WHERE a.user.id = :userId AND a.balance > :minBalance")
    List<Account> findByUserWithMinBalance(@Param("userId") Long userId, 
                                           @Param("minBalance") BigDecimal minBalance);
    
    // Native SQL
    @Query(value = "SELECT * FROM accounts WHERE user_id = :userId ORDER BY balance DESC LIMIT :limit", 
           nativeQuery = true)
    List<Account> findTopByUser(@Param("userId") Long userId, @Param("limit") int limit);
    
    // Projection — solo los campos que necesitas
    @Query("SELECT new com.fintrack.dto.AccountSummary(a.id, a.name, a.balance) FROM Account a WHERE a.user.id = :userId")
    List<AccountSummary> findSummariesByUser(@Param("userId") Long userId);
    
    // Paginación
    Page<Account> findByUserId(Long userId, Pageable pageable);
    
    // Exists check
    boolean existsByNameAndUserId(String name, Long userId);
}
```

### Transacciones — @Transactional

```java
@Service
@RequiredArgsConstructor
public class TransactionService {

    private final AccountRepository accountRepo;
    private final TransactionRepository transactionRepo;

    // Propagación REQUIRED por defecto — crea o usa transacción existente
    @Transactional
    public Transaction transfer(Long fromId, Long toId, BigDecimal amount) {
        Account from = accountRepo.findById(fromId)
            .orElseThrow(() -> new ResourceNotFoundException("Account", fromId));
        Account to = accountRepo.findById(toId)
            .orElseThrow(() -> new ResourceNotFoundException("Account", toId));
        
        if (from.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException(fromId, amount);
        }
        
        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));
        
        // Guardado implícito por dirty checking de JPA
        return transactionRepo.save(new Transaction(from, to, amount));
    }
    
    // Solo lectura — optimización de Hibernate
    @Transactional(readOnly = true)
    public Page<Transaction> findByAccount(Long accountId, Pageable pageable) {
        return transactionRepo.findByAccountId(accountId, pageable);
    }
}
```

### N+1 Problem — El gotcha más común

```java
// ❌ MAL — N+1 queries (como en TypeORM sin eager loading)
@Query("SELECT a FROM Account a WHERE a.user.id = :userId")
List<Account> findByUser(Long userId);
// Luego acceder a transactions hace una query por cuenta

// ✅ BIEN — JOIN FETCH
@Query("SELECT a FROM Account a LEFT JOIN FETCH a.transactions WHERE a.user.id = :userId")
List<Account> findByUserWithTransactions(@Param("userId") Long userId);

// ✅ BIEN — @EntityGraph (declarativo)
@EntityGraph(attributePaths = {"transactions", "user"})
List<Account> findByUserId(Long userId);
```

### Recursos

**Documentación oficial:**

- [Spring Data JPA Reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Hibernate ORM User Guide](https://docs.jboss.org/hibernate/orm/6.4/userguide/html_single/)
- [JPA 3.1 Specification](https://jakarta.ee/specifications/persistence/3.1/)

**Artículos:**

- [Spring Data JPA Tutorial — Baeldung](https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa)
- [JPA Entity Relationships — Baeldung](https://www.baeldung.com/jpa-many-to-many)
- [Spring @Transactional — Baeldung](https://www.baeldung.com/transaction-configuration-with-jpa-and-spring)
- [JPA N+1 Problem — Baeldung](https://www.baeldung.com/hibernate-common-performance-problems-in-logs)
- [Spring Data Specifications — Baeldung](https://www.baeldung.com/rest-api-search-language-spring-data-specifications)
- [Hibernate Query Tuning — Vlad Mihalcea (el experto mundial en Hibernate)](https://vladmihalcea.com/tutorials/hibernate/)

**Videos:**

- [Spring Data JPA Full Tutorial — Amigoscode](https://www.youtube.com/watch?v=8SGI_XS5OPw)
- [JPA & Hibernate Masterclass — Marco Codes (YouTube)](https://www.youtube.com/watch?v=W9-BL5OAPUQ)
- [Hibernate Performance Gotchas — Vlad Mihalcea (YouTube)](https://www.youtube.com/c/VladMihalcea)

**Libro recomendado:**

- *High-Performance Java Persistence* — Vlad Mihalcea (PDF disponible en su web) — el mejor libro sobre JPA/Hibernate

### 🔨 Proyecto — Sprint 3: Persistencia

- Entidades: `User`, `Account`, `Transaction`, `Category`, `Budget`
- Relationships: ManyToOne, OneToMany con lazy loading correcto
- Custom queries con JPQL y native SQL
- Paginación y sorting en todos los listados
- Auditoría automática (`@CreatedDate`, `@LastModifiedDate`)
- Docker Compose con PostgreSQL
- 🏋️ Kata diario: escribir 3 derived query methods en un repository y verificar el SQL generado por Hibernate en los logs

---

## 📦 Módulo 4 — Flyway: Migraciones de Base de Datos

### Objetivo

Versionar el schema de la base de datos. Equivalente a TypeORM migrations pero más robusto.

### 🔄 TypeORM migrations → Flyway

| TypeORM | Flyway |
|---------|--------|
| `migration:generate` | Scripts SQL escritos a mano |
| `migration:run` | Automático al arrancar la app |
| `migration:revert` | No hay rollback automático (por diseño) |
| `migrations/` folder | `resources/db/migration/` |
| Timestamp en nombre | `V{version}__{description}.sql` |
| `typeorm_migrations` table | `flyway_schema_history` table |

### Convención de nombres

```
V1__create_users_table.sql
V2__create_accounts_table.sql
V3__create_transactions_table.sql
V4__add_category_to_transactions.sql
V5__create_budgets_table.sql
R__create_views.sql          # Repeatable migrations (vistas, stored procs)
U2__undo_accounts_table.sql  # Undo migration (Flyway Teams)
```

### Ejemplo de migración

```sql
-- V3__create_transactions_table.sql
CREATE TABLE transactions (
    id          BIGSERIAL PRIMARY KEY,
    account_id  BIGINT        NOT NULL REFERENCES accounts(id),
    amount      NUMERIC(19,4) NOT NULL,
    type        VARCHAR(20)   NOT NULL CHECK (type IN ('CREDIT', 'DEBIT', 'TRANSFER')),
    description VARCHAR(255),
    category_id BIGINT        REFERENCES categories(id),
    occurred_at TIMESTAMPTZ   NOT NULL DEFAULT NOW(),
    created_at  TIMESTAMPTZ   NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMPTZ   NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_transactions_account_id ON transactions(account_id);
CREATE INDEX idx_transactions_occurred_at ON transactions(occurred_at DESC);
CREATE INDEX idx_transactions_category_id ON transactions(category_id);
```

### Configuración

```yaml
spring:
  flyway:
    enabled: true
    locations: classpath:db/migration
    baseline-on-migrate: true    # Para DBs existentes
    validate-on-migrate: true    # Verifica checksums
    out-of-order: false          # No permite V3 después de V5
    
  # CRÍTICO: Deshabilitar DDL auto de Hibernate cuando usas Flyway
  jpa:
    hibernate:
      ddl-auto: validate         # Solo valida, no crea/modifica
```

### Test migrations

```java
@SpringBootTest
@TestPropertySource(properties = {
    "spring.flyway.locations=classpath:db/migration,classpath:db/testdata"
})
class FlywayMigrationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void allMigrationsApplySuccessfully() {
        Integer count = jdbcTemplate.queryForObject(
            "SELECT COUNT(*) FROM flyway_schema_history WHERE success = true", 
            Integer.class
        );
        assertThat(count).isGreaterThan(0);
    }
}
```

### Recursos

**Documentación oficial:**

- [Flyway Documentation](https://documentation.red-gate.com/flyway)
- [Spring Boot Flyway Integration](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto.data-initialization.migration-tool.flyway)

**Artículos:**

- [Flyway with Spring Boot — Baeldung](https://www.baeldung.com/database-migrations-with-flyway)
- [Flyway Best Practices — Baeldung](https://www.baeldung.com/flyway-migrations)
- [Testing Flyway Migrations — Baeldung](https://www.baeldung.com/database-migration-tool-comparison)

**Videos:**

- [Flyway Tutorial — Amigoscode (YouTube)](https://www.youtube.com/watch?v=1cHlyDN3CKE)
- [Database Migrations with Flyway — Dan Vega](https://www.youtube.com/watch?v=YjMgQnVJuHU)

### 🔨 Proyecto — Sprint 4: Schema versionado

- Mover toda la DDL a migrations de Flyway (eliminar `ddl-auto: create`)
- Crear migraciones para todas las entidades
- Migración con datos seed para testing
- Validar que la app arranca desde cero con las migrations
- 🏋️ Kata diario: escribir una migration que añada columna con valor por defecto y otra repeatable para recrear una vista

---

## 📦 Módulo 5 — Spring Security + JWT + OAuth2

### Objetivo

Segurizar la API con autenticación JWT stateless y autorización basada en roles. El módulo más complejo del plan.

### 🔄 NestJS Passport → Spring Security

| NestJS + Passport | Spring Security |
|-------------------|-----------------|
| `AuthGuard('jwt')` | `SecurityFilterChain` con `JwtAuthenticationFilter` |
| `PassportStrategy(Strategy)` | `JwtAuthenticationConverter` |
| `@Roles('admin')` + RolesGuard | `@PreAuthorize("hasRole('ADMIN')")` |
| `@Public()` | `.requestMatchers("/auth/**").permitAll()` |
| `JwtService.sign()` | `JwtEncoder` (Nimbus JOSE) |
| `JwtService.verify()` | `JwtDecoder` |
| `@CurrentUser()` decorator | `@AuthenticationPrincipal` |
| `AuthModule` imports | `SecurityConfig` |

### Arquitectura de seguridad

```
Request → JwtAuthenticationFilter → SecurityContext → Controller
              ↓
         Verifica JWT
              ↓
         Carga UserDetails
              ↓
         Pone en SecurityContextHolder
```

### Configuración de Spring Security 6

```java
@Configuration
@EnableWebSecurity
@EnableMethodSecurity    // Habilita @PreAuthorize
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/auth/**").permitAll()
                .requestMatchers("/actuator/health").permitAll()
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/public/**").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .exceptionHandling(ex -> ex
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .accessDeniedHandler(new HttpStatusAccessDeniedHandler(HttpStatus.FORBIDDEN))
            )
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) 
            throws Exception {
        return config.getAuthenticationManager();
    }
}
```

### JWT Filter

```java
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                     HttpServletResponse response, 
                                     FilterChain filterChain) throws ServletException, IOException {
        
        final String authHeader = request.getHeader("Authorization");
        
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        
        final String jwt = authHeader.substring(7);
        final String userEmail = jwtService.extractUsername(jwt);
        
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
            
            if (jwtService.isTokenValid(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = 
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        
        filterChain.doFilter(request, response);
    }
}
```

### Autorización basada en roles y método

```java
@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")   // Protege toda la clase
public class AdminController {

    @GetMapping("/users")
    // Hereda @PreAuthorize del controlador
    public List<UserResponse> getAllUsers() { ... }
    
    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN') and #id != authentication.principal.id")
    public void deleteUser(@PathVariable Long id) { ... }
}

// En cualquier @Service también funciona
@Service
public class AccountService {
    
    @PreAuthorize("@accountSecurity.isOwner(#accountId, authentication)")
    public AccountResponse findById(Long accountId) { ... }
}
```

### Recursos

**Documentación oficial:**

- [Spring Security Reference 6.x](https://docs.spring.io/spring-security/reference/)
- [Spring Security Architecture](https://spring.io/guides/topicals/spring-security-architecture)
- [Spring Security OAuth2 Resource Server](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/index.html)

**Artículos:**

- [Spring Security JWT — Baeldung](https://www.baeldung.com/spring-security-oauth-jwt)
- [Spring Boot 3 + JWT — Baeldung](https://www.baeldung.com/spring-boot-jwt-authentication)
- [Method Security — Baeldung](https://www.baeldung.com/spring-security-method-security)
- [Spring Security Filters — Baeldung](https://www.baeldung.com/spring-security-registered-filters)
- [OAuth2 with Spring Boot 3 — Baeldung](https://www.baeldung.com/spring-security-oauth)

**Videos:**

- [Spring Boot 3 + Spring Security 6 + JWT — Amigoscode (YouTube, muy completo)](https://www.youtube.com/watch?v=KxqlJblhzfI)
- [Spring Security 6 Deep Dive — Dan Vega (YouTube)](https://www.youtube.com/watch?v=us0VjFiHogo)
- [Spring Security Tutorial Series — Marco Codes](https://www.youtube.com/watch?v=b9O9NI-RJ3o)

### 🔨 Proyecto — Sprint 5: Autenticación completa

- Registro y login con JWT (access + refresh token)
- Refresh token endpoint
- `@PreAuthorize` en todos los endpoints (users solo ven sus datos)
- Roles: `USER`, `ADMIN`
- Endpoint `/auth/me` que devuelve el usuario autenticado
- Hash de contraseñas con BCrypt
- 🏋️ Kata diario: escribir expresiones `@PreAuthorize` con SpEL (`hasRole`, `hasAuthority`, `@beanSecurity.method`)

---

## 📦 Módulo 6 — OpenAPI 3 con Springdoc

### Objetivo

Documentación automática de la API con OpenAPI 3. Equivalente a `@nestjs/swagger`.

### 🔄 NestJS Swagger → Springdoc

| NestJS `@nestjs/swagger` | Springdoc OpenAPI |
|--------------------------|-------------------|
| `@ApiOperation()` | `@Operation(summary = "...")` |
| `@ApiResponse()` | `@ApiResponse(responseCode = "200")` |
| `@ApiBody()` | Automático desde `@RequestBody` |
| `@ApiProperty()` | `@Schema(description = "...")` |
| `@ApiBearerAuth()` | `@SecurityRequirement(name = "bearerAuth")` |
| `@ApiTags('accounts')` | `@Tag(name = "Accounts")` |
| `DocumentBuilder` | `@OpenAPIDefinition` |

### Configuración

```java
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI finTrackOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("FinTrack API")
                .description("Personal Finance Management API")
                .version("1.0.0")
                .contact(new Contact().name("Team").email("team@fintrack.io"))
                .license(new License().name("MIT")))
            .externalDocs(new ExternalDocumentation()
                .description("GitHub Repository")
                .url("https://github.com/fintrack/api"))
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            .components(new Components()
                .addSecuritySchemes("bearerAuth", new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")
                    .description("JWT token de autenticación")));
    }
}
```

### Anotaciones en controllers y DTOs

```java
@Tag(name = "Accounts", description = "Account management operations")
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Operation(
        summary = "Create a new account",
        description = "Creates a new financial account for the authenticated user"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Account created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request data",
            content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PostMapping
    public ResponseEntity<AccountResponse> create(@Valid @RequestBody CreateAccountRequest request) { ... }
}

// DTO con documentación
public record CreateAccountRequest(
    @Schema(description = "Account display name", example = "My Savings Account", minLength = 1, maxLength = 100)
    @NotBlank String name,
    
    @Schema(description = "Initial balance", example = "1000.00", minimum = "0")
    @NotNull @PositiveOrZero BigDecimal initialBalance,
    
    @Schema(description = "ISO 4217 currency code", example = "EUR")
    @Pattern(regexp = "[A-Z]{3}") String currency
) {}
```

### application.yml para Springdoc

```yaml
springdoc:
  api-docs:
    path: /v3/api-docs
  swagger-ui:
    path: /swagger-ui.html
    operations-sorter: method
    tags-sorter: alpha
    display-request-duration: true
  show-actuator: false
```

### Recursos

**Documentación oficial:**

- [Springdoc OpenAPI Documentation](https://springdoc.org/)
- [OpenAPI 3.0 Specification](https://swagger.io/specification/)

**Artículos:**

- [Setting Up Swagger 3 with Spring Boot — Baeldung](https://www.baeldung.com/spring-rest-openapi-documentation)
- [Springdoc with Spring Security — Baeldung](https://www.baeldung.com/spring-rest-docs-vs-openapi)

**Videos:**

- [OpenAPI with Spring Boot 3 — Amigoscode](https://www.youtube.com/watch?v=2o_3hjUPAfQ)
- [Springdoc Tutorial — Dan Vega](https://www.youtube.com/watch?v=iaVBleTf88U)

### 🔨 Proyecto — Sprint 6: Documentación viva

- Documentar todos los controllers con `@Operation` y `@ApiResponse`
- Documentar todos los DTOs con `@Schema`
- Configurar autenticación JWT en Swagger UI
- Exportar el `openapi.json` y validarlo en [editor.swagger.io](https://editor.swagger.io)
- 🏋️ Kata diario: documentar un DTO con `@Schema` anidado (objetos dentro de objetos) y verificar la salida en Swagger UI

---

## 📦 Módulo 7 — Integración con APIs Externas

### Objetivo

Consumir APIs externas de forma resiliente. Equivalente a `HttpService` de NestJS + Axios.

### 🔄 Axios/HttpService → WebClient

| NestJS + Axios | Spring WebClient |
|----------------|------------------|
| `HttpService.get(url)` | `webClient.get().uri(url)` |
| `.pipe(map(...))` | `.bodyToMono(T.class)` |
| `HttpService.post(url, body)` | `webClient.post().bodyValue(body)` |
| Axios interceptors | `ExchangeFilterFunction` |
| `catchError` | `.onErrorMap()` |
| `retry()` RxJS | `Retry` de Resilience4j |
| `@nestjs/axios` config | `WebClient.Builder` Bean |

### WebClient configurado

```java
@Configuration
public class WebClientConfig {

    @Bean
    public WebClient exchangeRateClient(
            @Value("${app.exchange-rate.base-url}") String baseUrl,
            @Value("${app.exchange-rate.api-key}") String apiKey) {
        
        return WebClient.builder()
            .baseUrl(baseUrl)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader("X-API-KEY", apiKey)
            .filter(logRequest())
            .filter(logResponse())
            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(1024 * 1024))
            .build();
    }
    
    private ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(request -> {
            log.debug("Request: {} {}", request.method(), request.url());
            return Mono.just(request);
        });
    }
}
```

### Service con Resilience4j

```java
@Service
@RequiredArgsConstructor
@Slf4j
public class ExchangeRateService {

    private final WebClient exchangeRateClient;

    // Circuit Breaker + Retry + Cache
    @CircuitBreaker(name = "exchangeRateService", fallbackMethod = "getCachedRate")
    @Retry(name = "exchangeRateService")
    @Cacheable(value = "exchangeRates", key = "#from + '_' + #to")
    public Mono<BigDecimal> getRate(String from, String to) {
        return exchangeRateClient.get()
            .uri("/latest?base={from}&symbols={to}", from, to)
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError, 
                response -> Mono.error(new ExchangeRateException("Invalid currency: " + from + "/" + to)))
            .onStatus(HttpStatusCode::is5xxServerError, 
                response -> Mono.error(new ExchangeRateException("Exchange rate service unavailable")))
            .bodyToMono(ExchangeRateResponse.class)
            .map(response -> response.rates().get(to));
    }
    
    // Fallback cuando el circuit breaker está abierto
    public Mono<BigDecimal> getCachedRate(String from, String to, Throwable t) {
        log.warn("Circuit breaker open for exchange rates: {}", t.getMessage());
        return Mono.just(getLastKnownRate(from, to));
    }
}
```

### Recursos

**Documentación oficial:**

- [Spring WebClient](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-client)
- [Resilience4j Documentation](https://resilience4j.readme.io/docs/getting-started)

**Artículos:**

- [Spring WebClient vs RestTemplate — Baeldung](https://www.baeldung.com/spring-webclient-resttemplate)
- [WebClient Tutorial — Baeldung](https://www.baeldung.com/spring-5-webclient)
- [Resilience4j with Spring Boot — Baeldung](https://www.baeldung.com/spring-boot-resilience4j)
- [Circuit Breaker Pattern — Baeldung](https://www.baeldung.com/resilience4j)

**Videos:**

- [Spring WebClient Tutorial — Amigoscode](https://www.youtube.com/watch?v=F3uJyeAyv5g)
- [Resilience4j Crash Course — Marco Codes](https://www.youtube.com/watch?v=x7oCa1kpBMU)

### 🔨 Proyecto — Sprint 7: Integración de divisas

- Integrar API de tipos de cambio (ExchangeRate-API.com — free tier)
- Conversión de transacciones a moneda base del usuario
- Circuit breaker con Resilience4j
- Cache de tipos de cambio con Spring Cache + Caffeine
- Tests con WireMock para mockear la API externa
- 🏋️ Kata diario: configurar un `Retry` con backoff exponencial en Resilience4j y probarlo con fallos simulados

---

## 📦 Módulo 8 — Testing Completo

### Objetivo

Suite de tests completa: unitarios, de integración y E2E. Es el módulo donde Spring brilla frente a Node.

### 🔄 Jest/Supertest → JUnit 5/MockMvc/Testcontainers

| NestJS Testing | Spring Testing |
|----------------|----------------|
| `jest.fn()` | `Mockito.mock()` |
| `jest.spyOn()` | `Mockito.spy()` |
| `jest.mock('module')` | `@MockBean` |
| `supertest(app)` | `MockMvc` |
| `@nestjs/testing TestingModule` | `@WebMvcTest` / `@SpringBootTest` |
| `describe/it/expect` | `@Test` + AssertJ |
| `beforeEach/afterEach` | `@BeforeEach/@AfterEach` |
| Docker in tests | Testcontainers |
| Test doubles | Mockito verify, ArgumentCaptor |

### Tests unitarios con Mockito

```java
@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;
    
    @Mock
    private UserService userService;
    
    @InjectMocks
    private AccountService accountService;

    @Test
    void createAccount_shouldSaveAndReturnAccount() {
        // Given
        Long userId = 1L;
        CreateAccountRequest request = new CreateAccountRequest("Savings", BigDecimal.TEN, "EUR", AccountType.SAVINGS);
        User user = new User(userId, "john@example.com");
        Account savedAccount = new Account(1L, "Savings", BigDecimal.TEN, AccountType.SAVINGS, user);
        
        given(userService.findById(userId)).willReturn(user);
        given(accountRepository.save(any(Account.class))).willReturn(savedAccount);
        
        // When
        AccountResponse result = accountService.create(userId, request);
        
        // Then
        assertThat(result.name()).isEqualTo("Savings");
        assertThat(result.balance()).isEqualByComparingTo(BigDecimal.TEN);
        
        // Verify interactions
        then(accountRepository).should(times(1)).save(any(Account.class));
        then(userService).should().findById(userId);
    }
    
    @Test
    void findById_whenNotFound_shouldThrowException() {
        given(accountRepository.findById(99L)).willReturn(Optional.empty());
        
        assertThatThrownBy(() -> accountService.findById(99L))
            .isInstanceOf(ResourceNotFoundException.class)
            .hasMessageContaining("Account")
            .hasMessageContaining("99");
    }
}
```

### Tests de integración con @WebMvcTest

```java
@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @MockBean
    private AccountService accountService;
    
    @MockBean
    private JwtService jwtService;      // Necesario por Spring Security
    
    @MockBean
    private UserDetailsService userDetailsService;

    @Test
    @WithMockUser(username = "user@test.com", roles = "USER")
    void createAccount_withValidRequest_shouldReturn201() throws Exception {
        // Given
        CreateAccountRequest request = new CreateAccountRequest("Savings", BigDecimal.TEN, "EUR", AccountType.SAVINGS);
        AccountResponse response = new AccountResponse(1L, "Savings", BigDecimal.TEN, "EUR", AccountType.SAVINGS);
        
        given(accountService.create(any(), any())).willReturn(response);
        
        // When/Then
        mockMvc.perform(post("/api/v1/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Savings"))
            .andExpect(jsonPath("$.balance").value(10))
            .andDo(print());
    }
    
    @Test
    void createAccount_withoutAuth_shouldReturn401() throws Exception {
        mockMvc.perform(post("/api/v1/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
            .andExpect(status().isUnauthorized());
    }
    
    @Test
    @WithMockUser
    void createAccount_withInvalidData_shouldReturn422() throws Exception {
        CreateAccountRequest invalid = new CreateAccountRequest("", null, "INVALID", null);
        
        mockMvc.perform(post("/api/v1/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalid)))
            .andExpect(status().isUnprocessableEntity())
            .andExpect(jsonPath("$.errors.name").exists())
            .andExpect(jsonPath("$.errors.initialBalance").exists());
    }
}
```

### Tests de integración con Testcontainers + base de datos real

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class AccountIntegrationTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private UserRepository userRepository;

    private String authToken;

    @BeforeEach
    void setUp() {
        accountRepository.deleteAll();
        authToken = authenticateAndGetToken("user@test.com", "password");
    }

    @Test
    void fullAccountLifecycle() {
        // Create
        CreateAccountRequest createReq = new CreateAccountRequest("Savings", new BigDecimal("1000"), "EUR", AccountType.SAVINGS);
        ResponseEntity<AccountResponse> createResp = restTemplate.exchange(
            "/api/v1/accounts", HttpMethod.POST,
            withAuth(createReq), AccountResponse.class
        );
        assertThat(createResp.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Long accountId = createResp.getBody().id();
        
        // Read
        ResponseEntity<AccountResponse> getResp = restTemplate.exchange(
            "/api/v1/accounts/" + accountId, HttpMethod.GET,
            withAuth(null), AccountResponse.class
        );
        assertThat(getResp.getBody().name()).isEqualTo("Savings");
        
        // Update
        // ...
        
        // Delete
        // ...
        
        // Verify persistence
        assertThat(accountRepository.findById(accountId)).isEmpty();
    }
}
```

### Recursos

**Documentación oficial:**

- [Spring Boot Testing Reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#testing)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Mockito Documentation](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
- [Testcontainers for Java](https://testcontainers.com/guides/getting-started-with-testcontainers-for-java/)
- [AssertJ Documentation](https://assertj.github.io/doc/)

**Artículos:**

- [Testing in Spring Boot — Baeldung Guide](https://www.baeldung.com/spring-boot-testing)
- [MockMvc Tutorial — Baeldung](https://www.baeldung.com/integration-testing-in-spring)
- [Testcontainers with Spring Boot — Baeldung](https://www.baeldung.com/spring-boot-testcontainers-integration-test)
- [Mockito Tutorial — Baeldung](https://www.baeldung.com/mockito-series)
- [Spring Security Testing — Baeldung](https://www.baeldung.com/spring-security-integration-tests)

**Videos:**

- [Spring Boot Testing — Amigoscode (YouTube)](https://www.youtube.com/watch?v=jqwZthuBmZY)
- [Testcontainers Tutorial — Marco Codes (YouTube)](https://www.youtube.com/watch?v=erp-7MCK5BU)
- [Testing Spring Boot Apps — Dan Vega (YouTube)](https://www.youtube.com/watch?v=Ym0LFAnBnXI)

### 🔨 Proyecto — Sprint 8: Suite de tests

- Tests unitarios para todos los Services (>80% cobertura)
- Tests de integración con MockMvc para todos los Controllers
- Tests E2E con Testcontainers para los flujos críticos
- WireMock para el servicio de divisas
- Configurar JaCoCo para reporte de cobertura
- Pipeline CI mínimo (GitHub Actions)
- 🏋️ Kata diario: escribir un test parametrizado (`@ParameterizedTest`) con `@CsvSource`, `@ValueSource` y `@MethodSource`

---

## 📦 Módulo 9 — Production-Ready

### Objetivo

Preparar la API para producción: observabilidad, performance, y operaciones.

### Temas clave

**Spring Actuator — Observabilidad**

```yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
  endpoint:
    health:
      show-details: when-authorized
  metrics:
    export:
      prometheus:
        enabled: true
```

**Logging estructurado con SLF4J + Logback**

```java
@Slf4j   // Lombok genera: private static final Logger log = LoggerFactory.getLogger(...)
@Service
public class AccountService {
    
    public AccountResponse create(Long userId, CreateAccountRequest request) {
        log.info("Creating account for user={} name={}", userId, request.name());
        try {
            Account account = accountRepository.save(toEntity(request, userId));
            log.info("Account created id={} user={}", account.getId(), userId);
            return toResponse(account);
        } catch (Exception e) {
            log.error("Failed to create account for user={}", userId, e);
            throw e;
        }
    }
}
```

**Caching con Caffeine**

```java
@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager manager = new CaffeineCacheManager();
        manager.setCaffeine(Caffeine.newBuilder()
            .expireAfterWrite(Duration.ofMinutes(10))
            .maximumSize(1000)
            .recordStats());
        return manager;
    }
}
```

**Async con @Async**

```java
@Service
@EnableAsync
public class NotificationService {

    @Async
    public CompletableFuture<Void> sendTransactionNotification(Transaction tx) {
        // No bloquea el hilo del request
        emailService.sendEmail(tx.getUser().getEmail(), buildEmailContent(tx));
        return CompletableFuture.completedFuture(null);
    }
}
```

**Docker Compose para producción**

```yaml
services:
  app:
    image: fintrack-api:latest
    ports: ["8080:8080"]
    environment:
      SPRING_PROFILES_ACTIVE: prod
      DB_URL: jdbc:postgresql://db:5432/fintrack
      DB_USER: ${DB_USER}
      DB_PASSWORD: ${DB_PASSWORD}
      JWT_SECRET: ${JWT_SECRET}
    depends_on:
      db:
        condition: service_healthy
    
  db:
    image: postgres:16-alpine
    environment:
      POSTGRES_DB: fintrack
      POSTGRES_USER: ${DB_USER}
      POSTGRES_PASSWORD: ${DB_PASSWORD}
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U ${DB_USER}"]
      interval: 5s
      timeout: 5s
      retries: 5
    volumes:
      - pgdata:/var/lib/postgresql/data
```

### Recursos

**Artículos:**

- [Spring Boot Actuator — Baeldung](https://www.baeldung.com/spring-boot-actuators)
- [Spring Boot Caching — Baeldung](https://www.baeldung.com/spring-cache-tutorial)
- [Spring @Async — Baeldung](https://www.baeldung.com/spring-async)
- [Logback with Spring Boot — Baeldung](https://www.baeldung.com/spring-boot-logging)
- [Spring Boot Docker — Spring Guides](https://spring.io/guides/topicals/spring-boot-docker)

**Videos:**

- [Spring Boot Actuator — Amigoscode](https://www.youtube.com/watch?v=ojhEnUQvMQs)
- [Dockerizing Spring Boot — TechWorld with Nana](https://www.youtube.com/watch?v=EFMDfHXAlNw)

### 🔨 Proyecto — Sprint 9: Deploy-ready

- Actuator con health check personalizado (DB + API externa)
- Métricas Prometheus + Grafana (Docker Compose)
- Dockerfile multi-stage optimizado
- Variables de entorno documentadas
- README completo con setup guide
- Postman collection exportada
- 🏋️ Kata diario: crear un health check customizado que verifique DB y una API externa, expuesto vía Actuator

---

## 📚 Recursos Adicionales Recomendados

### Libros

- *Spring in Action, 6th Edition* — Craig Walls *(el libro de referencia)*
- *Effective Java, 3rd Edition* — Joshua Bloch *(Java idiomático)*
- *High-Performance Java Persistence* — Vlad Mihalcea *(JPA avanzado)*
- *Spring Security in Action* — Laurentiu Spilca *(Security en profundidad)*

### Blogs y comunidades

- [Baeldung.com](https://www.baeldung.com) — La biblia de Spring
- [Vlad Mihalcea's Blog](https://vladmihalcea.com) — Experto en Hibernate
- [Dan Vega's Blog](https://www.danvega.dev) — Spring developer advocate de VMware
- [Spring Blog](https://spring.io/blog)
- [r/java](https://www.reddit.com/r/java/) — Comunidad Java
- [Stack Overflow — spring tag](https://stackoverflow.com/questions/tagged/spring-boot)

### YouTube Channels imprescindibles

- [Amigoscode](https://www.youtube.com/@amigoscode) — Tutoriales Spring completos
- [Marco Codes](https://www.youtube.com/@MarcoCodes) — Spring moderno y profundo
- [Dan Vega](https://www.youtube.com/@DanVega) — Spring developer advocate
- [Teddy Smith](https://www.youtube.com/@TeddySmithDev) — Spring Boot práctico

### Herramientas del día a día

- [start.spring.io](https://start.spring.io) — Generador de proyectos
- [Baeldung REST API](https://api.github.com) — Para probar endpoints
- [HTTPie](https://httpie.io) — Mejor que curl para APIs
- [TablePlus](https://tableplus.com) — GUI para PostgreSQL (como DBeaver pero más moderno)
- [Testcontainers Desktop](https://testcontainers.com/desktop/) — Para visualizar containers de test

---

## ⏱️ Timeline sugerida

```
Semana 1     : Módulo 0 — Java Essentials
Semana 2-3   : Módulo 1 y 2 — Spring Core + REST API
Semana 4-5   : Módulo 3 — Spring Data JPA
Semana 6     : Módulo 4 — Flyway
Semana 7-8   : Módulo 5 — Spring Security
Semana 9     : Módulo 6 y 7 — OpenAPI + APIs externas
Semana 10-11 : Módulo 8 — Testing
Semana 12-13 : Módulo 9 — Production-Ready + Entrega final
```

> **Tip para seniors:** Si ya tienes experiencia con conceptos como DI, middleware, y ORM en TypeScript, puedes acelerar los módulos 1-3 y dedicar más tiempo a los módulos 5 (Security) y 8 (Testing), donde Spring tiene diferencias significativas con el ecosistema Node.
