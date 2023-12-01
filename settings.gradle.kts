pluginManagement {
    repositories {
        google()
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

rootProject.name = "PayTestTask"
include(":app")
include(":cloudService")
include(":tokenStorage")
include(":core")
include(":feature:login")
include(":feature:payments")
include(":navigation")
