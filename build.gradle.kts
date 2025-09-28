group = "cn.crabapples"
version = "1.0.0"
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
plugins {
    java
    id("org.springframework.boot") version "2.5.5"
    id("io.spring.dependency-management") version "1.1.4"
    id("maven-publish")

}
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "cn.crabapples"
            artifactId = "learn-spring-cloud"
            version = "1.0.0"
            from(components["java"])
        }
    }
}
configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(fileTree("libs"))
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    runtimeOnly("mysql:mysql-connector-java:8.0.23")
}
tasks.withType<Test> {
    useJUnitPlatform()
}
