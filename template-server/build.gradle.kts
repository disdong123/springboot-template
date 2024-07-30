plugins {
    idea
}

dependencies {
    implementation(project(":template-domain"))
    implementation(project(":template-common"))
    implementation(libs.spring.boot.starter.web)

    testImplementation(project(path = ":template-domain", configuration = "testJarConfig"))
    testImplementation(libs.embedded.redis)
    testRuntimeOnly(libs.h2.database)
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

sourceSets {
    create("integrationTest") {
        kotlin.srcDir(file("src/test-integration/kotlin"))
        resources.srcDir(file("src/test-integration/resources"))
        compileClasspath += sourceSets.main.get().output + sourceSets.test.get().output
        runtimeClasspath += sourceSets.main.get().output + sourceSets.test.get().output
    }
}

val integrationTest = task<Test>("integrationTest") {
    description = "Run integration tests"
    group = "verification"

    classpath = sourceSets["integrationTest"].runtimeClasspath
    testClassesDirs = sourceSets["integrationTest"].output.classesDirs

    shouldRunAfter(tasks.test)
}

val integrationTestImplementation: Configuration by configurations.getting {
    extendsFrom(configurations.testCompileOnly.get(), configurations.testImplementation.get(), configurations.testRuntimeOnly.get(), configurations.testApi.get())
}

tasks.check { dependsOn(integrationTest) }

idea.module {
    testSources.from(project.sourceSets.getByName("integrationTest").kotlin.srcDirs)
    testResources.from(project.sourceSets.getByName("integrationTest").resources.srcDirs)
}
