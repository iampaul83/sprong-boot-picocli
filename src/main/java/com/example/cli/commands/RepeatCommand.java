package com.example.cli.commands;

import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
@CommandLine.Command(name = "repeat", description = "Repeat a message multiple times")
public class RepeatCommand implements Runnable {

    @CommandLine.Option(names = {"-c", "--count"}, description = "Number of repetitions", defaultValue = "1")
    private int count;

    @CommandLine.Parameters(paramLabel = "MESSAGE", description = "Message to repeat")
    private String message;

    @Override
    public void run() {
        if (count < 1) {
            throw new CommandLine.ParameterException(new CommandLine(this),
                    "Count must be greater than zero");
        }

        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }
}
