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
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
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
