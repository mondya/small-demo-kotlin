# Repository Guidelines

## Project Structure & Module Organization
这是一个单模块 Kotlin Spring Boot 项目。应用入口在 `src/main/kotlin/com/xhh/smalldemokotlin/SmallDemoKotlinApplication.kt`。业务代码按职责拆分到 `controller`、`service`、`repository`、`domain`、`config`、`module` 包下；例如 `controller/CustomerController.kt` 与 `domain/CustomerEntity.kt` 分别承载接口层和实体层。配置文件位于 `src/main/resources/`，默认环境使用 `application.yml`，生产环境使用 `application-prod.yml`。测试代码统一放在 `src/test/kotlin/`。

## Build, Test, and Development Commands
常用命令基于 Gradle Wrapper：

```bash
./gradlew bootRun
./gradlew test
./gradlew clean build
```

`bootRun` 用于本地启动服务，`test` 运行 JUnit 测试，`clean build` 执行完整构建。除非用户明确要求，代理或贡献者不要主动运行构建、测试、打包、部署命令。提交文档或小改动时，优先说明未执行验证。

## Coding Style & Naming Conventions
使用 Kotlin 官方风格，缩进为 4 个空格。类名使用 PascalCase，例如 `CustomerService`；方法和属性使用 camelCase，例如 `findFirstById`；控制器、服务、仓储、实体分别使用 `*Controller`、`*Service`、`*Repository`、`*Entity` 后缀。REST 路径保持复数资源命名，例如 `/api/customers`。优先保持包名 `com.xhh.smalldemokotlin.*` 下的现有分层，不要随意引入跨层耦合。

## Testing Guidelines
当前测试基于 Spring Boot Test 和 JUnit 5，项目也存在旧的 `org.junit.Test` 用法；新增测试应统一优先使用 JUnit 5。测试类命名建议使用 `*Tests` 或 `*Test`，并与被测对象对应，例如 `CustomerServiceTests`。涉及 Spring 上下文时使用 `@SpringBootTest`，纯逻辑优先写轻量单元测试，避免无必要地加载完整容器。

## Commit & Pull Request Guidelines
现有提交历史以简短英文短语为主，例如 `add prod`、`add prod +docker file`、`kotlin 一些小改动`。后续提交建议继续保持单行、聚焦单一变更，可采用 `add xxx`、`fix xxx`、`refactor xxx` 风格。PR 应说明变更目的、影响范围、配置变更点；若修改接口或配置，附上示例请求、关键 YAML 片段或截图。

## Security & Configuration Tips
仓库中的 `application*.yml` 含数据库与 Redis 连接信息。新增配置时优先使用环境变量或外部化配置，不要把真实密码、IP、令牌直接提交到仓库。修改 `Dockerfile`、生产配置或数据源参数时，应在 PR 中明确标注风险和回滚方式。
