plugins {
    kotlin("jvm") version "1.9.22"
    application
}

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

val starterClass: String = "MainKt"

application {
    mainClass.set(starterClass)
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation("com.github.WilliamAHartman:Jamepad:1.4.0")
}

tasks.register("buildJar", Jar::class.java) {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    manifest {
        attributes("Main-Class" to starterClass)
    }

    from(configurations.runtimeClasspath.get()
        .onEach { println("add from dependencies: ${it.name}") }
        .map { if (it.isDirectory) it else zipTree(it) })

    val sourcesMain = sourceSets.main.get()
    sourcesMain.allSource.forEach { println("add from sources: ${it.name}") }
    from(sourcesMain.output)
}
