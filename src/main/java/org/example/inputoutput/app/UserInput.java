package org.example.inputoutput.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    public String getUserInput() {
        System.out.println("Введите то, что хотите сохранить в файл, с последующим его чтением и выводом в консоль:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Ошибка ввода, проверьте что все введено правильно: " + e.getMessage());
        }
        return "";
    }
}
