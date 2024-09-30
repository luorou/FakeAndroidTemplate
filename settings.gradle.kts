pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://maven.aliyun.com/nexus/content/groups/public/") }
        maven { url = uri("https://maven.aliyun.com/repository/public/") }
        maven { url = uri("https://maven.aliyun.com/repository/google/") }
        maven { url = uri("https://maven.aliyun.com/repository/jcenter/") }
        maven { url = uri("https://maven.aliyun.com/repository/central/") }
        maven { url = uri("https://maven.fabric.io/public") }
        maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { url = uri("https://plugins.gradle.org/m2/com/gradle") }
        maven { url = uri("https://maven.aliyun.com/nexus/content/repositories/releases") }
        maven { url = uri("https://dl.google.com/dl/android/maven2/") }
        maven { url = uri("https://developer.huawei.com/repo/") }
        maven { url = uri("https://s3.amazonaws.com/fabric-artifacts/public") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
        maven { url = uri("https://repo1.maven.org/maven2/") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://maven.aliyun.com/nexus/content/groups/public/") }
        maven { url = uri("https://maven.aliyun.com/repository/public/") }
        maven { url = uri("https://maven.aliyun.com/repository/google/") }
        maven { url = uri("https://maven.aliyun.com/repository/jcenter/") }
        maven { url = uri("https://maven.aliyun.com/repository/central/") }
        maven { url = uri("https://maven.fabric.io/public") }
        maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { url = uri("https://plugins.gradle.org/m2/com/gradle") }
        maven { url = uri("https://maven.aliyun.com/nexus/content/repositories/releases") }
        maven { url = uri("https://dl.google.com/dl/android/maven2/") }
        maven { url = uri("https://developer.huawei.com/repo/") }
        maven { url = uri("https://s3.amazonaws.com/fabric-artifacts/public") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
        maven { url = uri("https://repo1.maven.org/maven2/") }
    }
}

rootProject.name = "FakeAndroidTemplate"
include(":app")
//--------------------------------------------------------------------------------------------------
include(":core:global")
include(":core:network")
//--------------------------------------------------------------------------------------------------
include(":shared:mvi")
//--------------------------------------------------------------------------------------------------
include(":feature:index")
include(":feature:index-port")
include(":feature:login")
include(":feature:login-port")
include(":core:environment")
include(":shared:store")
