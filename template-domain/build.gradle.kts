dependencies {
    implementation(project(":template-common"))
    implementation(project(":template-infrastructure:jpa"))
    implementation(project(":template-infrastructure:redis"))
}

val testJar by tasks.registering(Jar::class) {
    archiveBaseName.set("test-${archiveBaseName.get()}")
    from(sourceSets.test.get().output)
    println(sourceSets.test.get().output)
}

configurations {
    create("testJarConfig")
}

testJar.get().dependsOn(tasks.testClasses)

artifacts {
    add("testJarConfig", testJar)
}
