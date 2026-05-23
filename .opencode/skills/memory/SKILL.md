---
name: memory
description: Gestión de memoria persistente en `.opencode/memory/` para no repetir análisis entre sesiones.
---

# Skill: memory — Gestión de memoria persistente

Mantienes una memoria persistente en `.opencode/memory/` para que tanto tú como otros agentes no tengan que redescubrir información en futuras sesiones. Solo almacenas hallazgos de alto valor. Cada entrada debe responder a: **"¿Le ahorraría esto a otro agente (o a mí mismo) tener que redescubrirlo?"**. Si la respuesta es no, no lo almacenes.

## Cuándo guardar memoria

- **Decisiones arquitectónicas** que tomaste durante la sesión y su justificación (por qué X sobre Y, trade-offs considerados, contexto que motivó la decisión).
- **Patrones no obvios** que descubriste en el código y que no están documentados en los archivos de contexto del proyecto (AGENTS.md, README, docs/).
- **Restricciones ocultas** del entorno, dependencias, versiones, o configuraciones que afectan a tareas futuras y no son evidentes.
- **Configuraciones sensibles o no documentadas** necesarias para que el proyecto funcione (sin incluir secretos ni credenciales reales).
- **Lecciones aprendidas** tras depurar un problema complejo cuya causa raíz no era obvia.
- **Preferencias explícitas del usuario** que afectan a cómo debe trabajar el agente (estilo de código, convenciones no estándar, herramientas preferidas).

## Cómo guardar memoria

Crea o modifica un archivo en `.opencode/memory/`. Elige o crea una categoría según el dominio conceptual del hallazgo, **sin atarte a tecnologías concretas**:

| Archivo | Dominio (agnóstico al stack) |
|---------|------|
| `arquitectura.md` | Decisiones estructurales, patrones de diseño, organización de módulos/capas |
| `infraestructura.md` | Contenedores, orquestación, redes, CI/CD, entornos, cloud |
| `api-y-servicios.md` | Endpoints, middleware, autenticación, comunicación entre servicios |
| `datos-y-persistencia.md` | Modelos, migraciones, queries, caching, integridad de datos |
| `frontend-ui.md` | Componentes, estado, rutas, rendering, accesibilidad (si aplica) |
| `testing.md` | Estrategias de test, fixtures, mocks, herramientas, datos de prueba |
| `workflow.md` | Convenciones de branching, commits, revisión de código, despliegue |
| `dependencias.md` | Conflictos de versiones, vulnerabilidades, licencias, alternativas |

Si ninguna encaja, crea una nueva con un nombre descriptivo y en minúsculas. No fuerces un hallazgo dentro de una categoría que no le corresponde.

Cada entrada usa este formato:

```markdown
## YYYY-MM-DD — Título descriptivo

**Contexto**: breve descripción de cuándo y por qué se descubrió

**Hallazgo**: qué se aprendió o qué decisión se tomó

**Relevancia futura**: por qué debe saberlo otro agente
```

## Lo que NUNCA guardas en memoria

- Información trivial o redundante con los archivos de contexto del proyecto (AGENTS.md, README, docs/)
- Detalles de implementación de una tarea puntual ya resuelta
- Código completo — solo la esencia del hallazgo, patrones, o referencias a archivos concretos
- Secretos, tokens, contraseñas, claves de API reales
- Opiniones no verificadas o suposiciones sin confirmar
