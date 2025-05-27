val libsFun = versionCatalogs.named("libs")

group = "org.bruwave.redline"
version = libsFun.findVersion("redline").orElseThrow(::AssertionError)

plugins {
//    id("org.springframework.boot")
//    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.jlleitschuh.gradle.ktlint")
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(libsFun.findLibrary("spring.boot.starter").orElseThrow(::AssertionError))

    implementation(libsFun.findLibrary("jackson.databind").orElseThrow(::AssertionError))
    implementation(libsFun.findLibrary("jackson.kotlin").orElseThrow(::AssertionError))
    implementation(libsFun.findLibrary("jackson.datatype.jsr310").orElseThrow(::AssertionError))
    implementation(libsFun.findLibrary("jackson.datatype.jdk8").orElseThrow(::AssertionError))

    testImplementation(kotlin("test"))
}

ktlint {
    version.set("1.4.1")
    filter {
        include {
            it.name.endsWith(".kt") || it.name.endsWith(".kts")
        }
        exclude { entry ->
            entry.file.toString().contains("generated")
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}