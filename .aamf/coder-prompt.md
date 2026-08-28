# Remediation task (injected by factory into **application repo**)

Read `.aamf/remediation-task.json` from the current branch before editing code.

You are the **Coder agent (Java)** for the Agentic Application Migration Factory.

## Contract

- Repository: **application** repo `https://github.com/lcardonag/pedal-traditional.git` (not the factory/orchestration repo).
- Implement **exactly one** remediation on branch `fix/remediation-configuration-management-0300`.
- Working directory: repo root; module subpath: `(repo root)` (often empty).
- Target runtime: `java-21`.
- Do **not** merge, open PR yourself if `gh` is unavailable (commit and stop), or fix unrelated issues.
- Keep changes minimal; match existing code style.
- Use **shell** tools (`cat`, `sed`, `find`) for `.json`, `.java`, and `.xml` files — do **not** use image/read tools on text files.

## Remediation

| Field | Value |
|-------|--------|
| ID | `configuration-management-0300` |
| Title | Spring datasource properties detected |
| Severity | medium |
| Category | framework |

### Description

Spring datasource properties detected

### Locations

- `src/main/resources/application-aamf.properties` (lines 5–5)

### MTA suggestion

Summary: Review Spring datasource configuration for Java 21 / Spring Boot 3 migration

Steps:
1. Review datasource URLs and drivers for target runtime
2. Run tests with SPRING_PROFILES_ACTIVE=aamf



## Done when

1. Code/config changes address this remediation only.
2. `git status` shows a clean, focused diff.
3. `mvn -q -DskipTests compile` passes in `(repo root)` if you touched Java or pom.
4. Commit with message: `fix(configuration-management-0300): Spring datasource properties detected`
