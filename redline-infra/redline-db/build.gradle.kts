plugins {
    id("redline-base")
    id("redline-jpa")
}
dependencies{
    implementation(project(":redline-infra:redline-commons"))
    implementation(project(":redline-core:redline-user"))
    api(libs.spring.data.jpa)
}