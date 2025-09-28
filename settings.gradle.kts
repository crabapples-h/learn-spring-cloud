rootProject.name = "learn-spring-cloud"
dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://maven.aliyun.com/repository/public")
        }
        mavenLocal()
        mavenCentral()
        println("repositories")
    }
}
pluginManagement {
    repositories {
        maven {
            url = uri("https://maven.aliyun.com/repository/public")
        }
        mavenLocal()
        mavenCentral()
    }
}
