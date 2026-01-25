# BlueArcade API [![](https://jitpack.io/v/BluevaDevelopment/BlueArcadeAPI.svg)](https://jitpack.io/#BluevaDevelopment/BlueArcadeAPI)

BlueArcade API is the public module development kit for BlueArcade 3. It provides
stable interfaces and data contracts so external minigame modules can integrate
with the BlueArcade runtime without depending on core internals.

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
        <version>3.0.0</version>
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
    compileOnly("com.github.BluevaDevelopment:BlueArcadeAPI:3.0.0")
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
