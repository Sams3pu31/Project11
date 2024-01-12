package org.example.inputoutput.app;

public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        String inputText = userInput.getUserInput();

        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        fileReaderWriter.writeToFile("input/input.txt", inputText);
        fileReaderWriter.copyFile("input/input.txt", "output/output.txt");
        fileReaderWriter.readAndPrintFile("output/output.txt");
    }
}
