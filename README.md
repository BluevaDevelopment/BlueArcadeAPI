# BlueArcade API [![](https://jitpack.io/v/BluevaDevelopment/BlueArcadeAPI.svg)](https://jitpack.io/#BluevaDevelopment/BlueArcadeAPI)
The official developer toolkit for BlueArcade 3. It provides the core interfaces and data contracts needed to build minigame modules that integrate seamlessly with the BlueArcade runtime on both Minecraft (Spigot) and Hytale.

## Original Example Projects
BlueArcade provides a full set of original example projects that demonstrate how to build complete minigames and microgames using the API.

These projects are real production modules, available both as open-source repositories and as downloadable modules from the Blueva Store.

👉 **[View all example projects](EXAMPLE_PROJECTS.md)**

## Installation
Add the repository and dependency to your build tool.

### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.BluevaDevelopment</groupId>
        <artifactId>BlueArcadeAPI</artifactId>
        <version>3.0.0-2</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

### Gradle (Kotlin DSL)
```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.BluevaDevelopment:BlueArcadeAPI:3.0.0-2")
}
```

## Documentation
Full documentation available at: https://docs.blueva.net/

## Javadocs

API reference documentation: https://blueva.net/docs/arcade/api
You can also generate Javadocs locally by running:
```bash
mvn -f BlueArcade-API/pom.xml javadoc:javadoc
```
