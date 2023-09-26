plugins {
    java
    id("org.springframework.boot") version "2.7.12"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "com.ads"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_13

repositories {
    mavenCentral()
}

dependencies {
    //core
    implementation("org.springframework.boot:spring-boot-starter-web")

    //lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    //db
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.liquibase:liquibase-core")
    implementation("org.liquibase:liquibase-core:4.21.1")
    runtimeOnly("org.postgresql:postgresql")

    //mapper
    implementation("org.mapstruct:mapstruct-jdk8:1.3.0.Final")
    annotationProcessor("org.mapstruct:mapstruct-jdk8:1.3.0.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.3.0.Final")

    //validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    //unit test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.spockframework:spock-core:2.4-M1-groovy-4.0")

    //random object
    implementation("io.github.benas:random-beans:3.9.0")


    //security
    implementation("org.springframework.boot:spring-boot-starter-security")
    testImplementation("org.springframework.security:spring-security-test")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
