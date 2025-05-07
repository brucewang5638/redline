plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "redline"

// 基础设施层
include("redline-infra:redline-db")
findProject(":redline-infra:redline-db")?.name = "redline-db"

// 领域核心层
include("redline-core:redline-user")
findProject(":redline-core:redline-user")?.name = "redline-user"

// 服务层
include("redline-usecase")
include("redline-usecase:redline-usecase-user")
findProject(":redline-usecase:redline-usecase-user")?.name = "redline-usecase-user"

// 接入层
include("redline-protal:redline-protal-web")
findProject(":redline-protal:redline-protal-web")?.name = "redline-protal-web"

// 辅助工具层
include("redline-tools:redline-monitor")
findProject(":redline-tools:redline-monitor")?.name = "redline-monitor"

// 应用服务启动层
include("redline-server")

// 页面
include("redline-webapp")
