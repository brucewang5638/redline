val libsFun = versionCatalogs.named("libs")

plugins {
    kotlin("jvm")
    kotlin("plugin.jpa")
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(libsFun.findLibrary("spring-boot-starter-data-jpa").orElseThrow(::AssertionError))
    implementation(libsFun.findLibrary("spring-boot-starter-validation").orElseThrow(::AssertionError))
}