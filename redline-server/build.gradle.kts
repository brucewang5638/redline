plugins {
    id("redline-base")
    id("org.springframework.boot")
}

dependencies {
    implementation(project(":redline-usecase"))
    implementation(project(":redline-protal:redline-protal-web"))
}
