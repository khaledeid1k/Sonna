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

rootProject.name = "Sonna"
include(":app")
include(":Presentation:ui")
include(":Presentation:viewmodels")
include(":data:remote")
include(":data:local")
include(":data:repo")
include(":domain:models")
include(":domain:usecase")
