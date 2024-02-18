# Ktor + Exposed Perf Testing

## Getting Started

1. Clone the repo.
2. In the root directory execute `./gradlew run`
3. By default, the server will start on port `8080`. See below [Routes](#routes) section for more information.

### Libraries used:

- [Ktor](https://github.com/ktorio/ktor) - Kotlin async web framework
- [Netty](https://github.com/netty/netty) - Async web server
- [Kotlin Serialization](https://github.com/Kotlin/kotlinx.serialization) - JSON serialization/deserialization
- [Exposed](https://github.com/JetBrains/Exposed) - Kotlin SQL framework
- [H2](https://github.com/h2database/h2database) - Embeddable database
- [HikariCP](https://github.com/brettwooldridge/HikariCP) - High performance JDBC connection pooling
- [Flyway](https://flywaydb.org/) - Database migrations
- [JUnit 5](https://junit.org/junit5/), [AssertJ](http://joel-costigliola.github.io/assertj/)
  and [Rest Assured](http://rest-assured.io/) for testing
- [Kover](https://github.com/Kotlin/kotlinx-kover) for code coverage, publishing
  to [Codecov](https://about.codecov.io/) through GitHub Actions