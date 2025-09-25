package com.example.cli.commands;

import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
@CommandLine.Command(name = "hello", description = "Print a friendly greeting")
public class HelloCommand implements Runnable {

    @CommandLine.Option(names = {"-n", "--name"}, description = "Who should be greeted", defaultValue = "World")
    private String name;

    @Override
    public void run() {
        System.out.printf("Hello, %s!%n", name);
    }
}
