import gradle.kotlin.dsl.accessors._2ae1f5f4c3028690945a5ad212af1642.implementation

val libsFun = versionCatalogs.named("libs")

plugins {
    kotlin("plugin.jpa")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libsFun.findLibrary("spring-boot-starter-data-jpa").orElseThrow(::AssertionError))
}
