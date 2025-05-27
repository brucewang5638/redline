plugins {
    id("redline-base")
    alias(libs.plugins.openapi.generator)
}

dependencies {
    api(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.swagger.annotations)
    implementation(libs.swagger.core)
//    implementation(libs.springdoc.openapi.ui)
//    implementation(libs.springdoc.openapi.webmvc.ui)
    implementation(project(":redline-usecase"))
}

openApiGenerate {
    generatorName.set("kotlin-spring")

    inputSpec = "$projectDir/src/main/resources/static/openapi.yaml"
    outputDir =
        layout.buildDirectory
            .dir("generated/openapi")
            .get()
            .asFile.absolutePath
    apiPackage = "org.bruwave.redline.portal.web.api"
    invokerPackage = "org.bruwave.redline.portal.web.invoker"
    modelPackage = "org.bruwave.redline.portal.web.model"
    configOptions.set(
        mapOf(
            "dateLibrary" to "java8", // 使用 Java8 日期类型
            "interfaceOnly" to "true", // 仅生成接口
            "useSpringBoot3" to "true", // 适配 Spring Boot 3.x
            "openApiNullable" to "false", // 关闭 nullable 避免 Jackson 冲突
            "serializationLibrary" to "jackson", // 明确序列化库
        ),
    )
    globalProperties.set(
        mapOf(
            "modelDocs" to "false",
        ),
    )
//    skipValidateSpec = true
//    logToStderr = true
//    generateAliasAsModel = false
//    enablePostProcessFile = false
    modelNameSuffix = "VO"
    cleanupOutput.set(true)
}

tasks.compileKotlin {
    dependsOn(tasks.openApiGenerate)
    sourceSets["main"].kotlin.srcDir(projectDir.resolve("build/generated/openapi/src/main/kotlin").absolutePath)
}

tasks.runKtlintCheckOverMainSourceSet {
    dependsOn(tasks.openApiGenerate)
}
ktlint {
    filter {
        exclude { entry ->
            entry.file.toString().contains("generated")
        }
    }
}
