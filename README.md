# Spring Boot + Picocli CLI

This project demonstrates how to build a command line application powered by Spring Boot and [Picocli](https://picocli.info/).

## Getting started

```bash
./mvnw spring-boot:run -- hello --name Alice
```

Or build the application first and run the packaged jar:

```bash
./mvnw package
java -jar target/sprong-boot-picocli-0.0.1-SNAPSHOT.jar repeat --count 3 "Hello"
```

## Available commands

- `hello` – prints a friendly greeting. Use `-n/--name` to customize the recipient.
- `repeat` – repeats a given message a configurable number of times.
- `file-info` – prints file metadata such as size and timestamps.

You can explore the help output by running:

```bash
java -jar target/sprong-boot-picocli-0.0.1-SNAPSHOT.jar --help
java -jar target/sprong-boot-picocli-0.0.1-SNAPSHOT.jar file-info --help
```

Each command is implemented as a Spring component, so you can inject other beans or services using Spring's dependency injection capabilities.
