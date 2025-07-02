plugins {
    alias(libs.plugins.jvm) // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    alias(libs.plugins.springboot)
    alias(libs.plugins.springbootManagement)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.palantir)
}

group = "org.agrfesta.movies"
version = "0.1.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.0")
    implementation(libs.ktor.core)
    implementation(libs.ktor.okhttp)
    implementation(libs.ktor.content.negotiation)
    implementation(libs.ktor.jackson)
    implementation(libs.arrow.core)

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
        exclude(module = "junit-vintage-engine")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation(libs.kotest.assertions.core)
    testImplementation(libs.kotest.assertions.arrow)
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("io.rest-assured:rest-assured")
    testImplementation("io.mockk:mockk:1.13.10")
    testImplementation("com.ninja-squad:springmockk:4.0.2")
    testImplementation(libs.ktor.client.mock)
}

docker {
    name = "agrfesta/imdb-web-scraper:${version}"
    uri("agrfesta/imdb-web-scraper:${version}")
    tag("name", "imdb-web-scraper")
    buildArgs(mapOf("name" to "imdb-web-scraper"))
    copySpec.from("build").into("build")
    pull(true)
    setDockerfile(file("Dockerfile"))
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
