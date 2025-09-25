package com.example.cli.commands;

import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
@CommandLine.Command(
        name = "sprong",
        mixinStandardHelpOptions = true,
        version = "sprong 0.0.1",
        description = "Spring Boot + Picocli demo CLI",
        subcommands = {
                HelloCommand.class,
                RepeatCommand.class,
                FileInfoCommand.class
        }
)
public class RootCommand implements Runnable {

    @Override
    public void run() {
        CommandLine.usage(this, System.out);
    }
}
