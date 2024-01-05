dependencies {
    implementation(project(":subprojects:domain"))
    api("org.springframework.data:spring-data-jdbc")
    runtimeOnly(libs.mysql.connector.java)
}
