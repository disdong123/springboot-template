dependencies {
    implementation(project(":subprojects:domain"))
    implementation(project(":subprojects:jpa"))
    implementation(project(":subprojects:common"))
    implementation(libs.spring.boot.starter.web)
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
