plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.maven.publish)
}

dependencies {
    testImplementation(libs.junit)
    testImplementation(libs.junit.params)
}

kotlin {
    jvmToolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
