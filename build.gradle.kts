plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.10.2")
}

tasks.test {
    useTestNG()
}