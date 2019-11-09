package com.github.lleuad0.abbyydevcourse;

import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        HashMap<Character, Integer> symbols = new HashMap<>();

        try (FileReader fileReader = new FileReader("res/text.txt")) {
            int i;
            while ((i = fileReader.read()) != -1) {
                char ch = (char) i;
                if (!symbols.containsKey(ch)) {
                    symbols.put(ch, 1);
                } else {
                    int count = symbols.get(ch);
                    symbols.put(ch, ++count);
                }
            }
        }

        try (FileWriter fileWriter = new FileWriter("res/symbols.txt")) {
            for (char ch : symbols.keySet()) {
                fileWriter.write(ch + " " + symbols.get(ch) + "\n");
                // в файле будут два символа, которые выглядят как перевод строки
                // это служебные символы Юникода, NL и CR (не баг, а фича!)
            }
        }

    }
}

