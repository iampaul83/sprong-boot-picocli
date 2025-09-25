package com.example.cli.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
@CommandLine.Command(name = "file-info", description = "Print metadata about a file")
public class FileInfoCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "FILE", description = "Path to the file")
    private Path file;

    @Override
    public void run() {
        if (Files.notExists(file)) {
            throw new CommandLine.ParameterException(new CommandLine(this),
                    "File does not exist: " + file);
        }

        try {
            BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                    .withZone(ZoneId.systemDefault());

            System.out.printf("Size: %d bytes%n", attrs.size());
            System.out.printf("Created: %s%n", formatter.format(attrs.creationTime().toInstant()));
            System.out.printf("Modified: %s%n", formatter.format(attrs.lastModifiedTime().toInstant()));
            System.out.printf("Directory: %s%n", attrs.isDirectory());
        } catch (IOException e) {
            throw new CommandLine.ExecutionException(new CommandLine(this),
                    "Unable to read file metadata: " + e.getMessage(), e);
        }
    }
}
