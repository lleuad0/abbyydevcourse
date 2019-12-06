package com.github.lleuad0.abbyydevcourse;

import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        HashMap<Character, Integer> symbols = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("res/text.txt"))) {
            int i;
            while ((i = bufferedReader.read()) != -1) {
                char ch = (char) i;
                if (!symbols.containsKey(ch)) {
                    symbols.put(ch, 1);
                } else {
                    symbols.replace(ch, symbols.get(ch) + 1);
                }
            }
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("res/symbols.txt"))) {
            for (char ch : symbols.keySet()) {
                bufferedWriter.write(ch + " " + symbols.get(ch) + "\n");
                // в файле будут два символа, которые выглядят как перевод строки
                // это служебные символы Юникода, NL и CR (не баг, а фича!)
            }
        }

    }
}

