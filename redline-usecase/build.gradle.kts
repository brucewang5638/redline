plugins {
    id("redline-base")
}

dependencies {
    api(project("redline-usecase-commons"))
    api(project("redline-usecase-user"))
    implementation(libs.postgresql)
    implementation(libs.spring.boot.starter.data.jpa)
}
