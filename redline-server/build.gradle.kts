plugins {
    id("redline-base")
}

dependencies {
    implementation(project(":redline-usecase"))
    implementation(project(":redline-protal:redline-protal-web"))
//    implementation(libs.spring.boot.starter.web)
}
