package com.example.cli.config;

import com.example.cli.commands.RootCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import picocli.CommandLine;
import picocli.spring.PicocliSpringFactory;

@Configuration
public class PicocliConfig {

    @Bean
    public CommandLineRunner commandLineRunner(PicocliSpringFactory factory, @Lazy RootCommand rootCommand) {
        return args -> {
            CommandLine cmd = new CommandLine(rootCommand, factory);
            cmd.setCaseInsensitiveEnumValuesAllowed(true);
            int exitCode = cmd.execute(args);
            if (exitCode != 0) {
                System.exit(exitCode);
            }
        };
    }
}
