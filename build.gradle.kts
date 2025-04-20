/**
 * 项目构建配置文件
 * 使用 Kotlin DSL 语法
 */

// 插件配置 - 使用 Version Catalog 从 libs.versions.toml 引用插件
plugins {
    alias(libs.plugins.kotlin.jvm)          // Kotlin JVM 插件
    alias(libs.plugins.kotlin.spring)        // Kotlin Spring 插件，提供 Spring 框架支持
    alias(libs.plugins.spring.boot)          // Spring Boot 插件
    alias(libs.plugins.spring.dependency.management)  // Spring 依赖管理插件
    alias(libs.plugins.kotlin.jpa)           // Kotlin JPA 插件，提供 JPA 支持
    alias(libs.plugins.groovy) // groovy插件，支持识别到groovy代码
}

// 方法1：使用 ext 块集中管理版本号
// 可以在构建脚本中通过 ${ext["key"]} 访问
ext {
    set("kotlinVersion", "1.9.25")           // Kotlin 版本
    set("springBootVersion", "3.4.3")        // Spring Boot 版本
    set("mysqlVersion", "8.0.19")            // MySQL 连接器版本
    set("hibernateVersion", "6.4.2.Final")   // Hibernate 版本
    set("jacksonVersion", "2.15.2")          // Jackson 版本
}

// 方法2：使用 Kotlin val 变量定义版本
// 可以直接在构建脚本中通过 $variableName 访问
val hibernateVersion = "6.4.2.Final"         // Hibernate 版本
val jacksonVersion = "2.15.2"                // Jackson 版本

// 项目基本信息
group = "com.xhh"                            // 组织/公司标识符
version = "0.0.1-SNAPSHOT"                   // 项目版本号

// Java 工具链配置
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)  // 指定使用 Java 17
    }
}

// 仓库配置 - 指定从哪里下载依赖
repositories {
    
    maven {
        url = uri("https://maven.aliyun.com/repository/spring/")
    }
    maven {
        url = uri("https://maven.aliyun.com/repository/public/")
    }
    
    mavenCentral()                           // 使用 Maven 中央仓库
}

// 依赖配置 - 使用 Version Catalog 从 libs.versions.toml 引用依赖
dependencies {
    // 核心依赖
    implementation(libs.bundles.spring)  {// Spring 相关依赖包（web, data-jpa）
        // 移除tomcat，使用undertow
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    // 数据库相关
    implementation(libs.mysql.connector)     // MySQL 数据库连接器
    
    implementation(libs.kotlin.reflect)
    
    // 测试依赖
    testImplementation(libs.bundles.testing) // 测试相关依赖包
    
    // groovy 依赖
    implementation(libs.groovy)
}

// Kotlin 编译器配置
kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")  // 启用 JSR-305 注解的严格模式
    }
}

// JPA 实体类配置 - 自动为标注的类生成无参构造函数和开放类
allOpen {
    annotation("jakarta.persistence.Entity")         // 对所有 @Entity 注解的类开放
    annotation("jakarta.persistence.MappedSuperclass") // 对所有 @MappedSuperclass 注解的类开放
    annotation("jakarta.persistence.Embeddable")     // 对所有 @Embeddable 注解的类开放
}

sourceSets {
    main {
        kotlin {
            srcDirs("src/main/kotlin")      // 添加 Kotlin 源代码目录
        }
        
        java {
            srcDirs("src/main/java")
        }
        
        groovy{
            srcDirs("src/main/groovy")
        }
        
        resources {
            srcDirs("src/main/resources")   // 添加资源文件目录
        }
    }
}

// 测试任务配置
tasks.withType<Test> {
    useJUnitPlatform()                      // 使用 JUnit 5 平台运行测试
}
tasks.withType<Copy> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}