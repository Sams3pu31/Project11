package org.example.inputoutput.app;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderWriter {
    public void writeToFile(String fileName, String text) {
        try {
            Path filePath = Paths.get("src/main/java/org/example/inputoutput/app/", fileName);
            Path parentDir = filePath.getParent();
            if (parentDir != null && Files.notExists(parentDir)) {
                Files.createDirectories(parentDir);
            }
            try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath.toFile(), true)))) {
                writer.println(text);
                System.out.println("Текст успешно добавлен в файл: " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public void copyFile(String sourceFileName, String destinationFileName) {
        try {
            Path sourcePath = Paths.get("src/main/java/org/example/inputoutput/app/", sourceFileName);
            Path destPath = Paths.get("src/main/java/org/example/inputoutput/app/", destinationFileName);
            Path destParentDir = destPath.getParent();
            if (destParentDir != null && Files.notExists(destParentDir)) {
                Files.createDirectories(destParentDir);
            }
            if (Files.exists(destPath)) {
                Files.delete(destPath);
            }

            Files.copy(sourcePath, destPath);
            System.out.println("Текст успешно скопирован из файла: " + sourceFileName + " в файл: " + destinationFileName);
        } catch (IOException e) {
            System.err.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }

    public void readAndPrintFile(String fileName) {
        try {
            Path filePath = Paths.get("src/main/java/org/example/inputoutput/app/", fileName);
            try (Stream<String> lines = Files.lines(filePath)) {
                System.out.println("Содержимое файла: " + fileName + ":");
                lines.forEach(System.out::println);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }}}
