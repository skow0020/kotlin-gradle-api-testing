
plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM.
    id("org.jetbrains.kotlin.jvm").version("1.3.31")

    // Apply the application plugin to add support for building a CLI application.
    application
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    implementation("org.apache.httpcomponents:httpclient:4.5.9")
    implementation("org.apache.commons:commons-lang3:3.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7")
}

application {
    // Define the main class for the application
    mainClassName = "kotlin.gradle.api.AppKt"
}
