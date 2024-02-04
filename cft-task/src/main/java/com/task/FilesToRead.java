package com.task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class FilesToRead {
    private List<String> filesName;

    private List<Integer> intsList = new ArrayList<>();
    private List<Float> floatsList = new ArrayList<>();
    private List<String> stringsList = new ArrayList<>();

    FilesToRead(List<String> filename) {
        this.filesName = filename;
    }

    public List<Integer> getInts() {
        return intsList;
    }

    public List<Float> getFloats() {
        return floatsList;
    }

    public List<String> getStrings() {
        return stringsList;
    }

    public void readFile() {
        for (String fileName : filesName) {
            try (Scanner scanner = new Scanner(new File(fileName))) {
                String variable;
                while (scanner.hasNextLine()) {
                    variable = scanner.nextLine();
                    sortByType(variable);
                }
                scanner.close();
            } catch (IOException e) {
                System.out.println("Файл " + fileName + " не найден!");
            }
        }
    }

    public void sortByType(String variable) {
        if (isInteger(variable)) {
            intsList.add(Integer.parseInt(variable));
        } else if (isFloat(variable)) {
            floatsList.add(Float.parseFloat(variable));
        } else {
            stringsList.add(variable);
        }
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean isFloat(String str) {
        try {
            Float.parseFloat(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void statistic(boolean simpleStat, boolean fullStat) {
        if (simpleStat) {
            System.out.println("\nКраткая статистика входных данных: \n");
            System.out.println("  Integers count: " + getInts().size());
            System.out.println("  Floats count: " + getFloats().size());
            System.out.println("  Strings count: " + getStrings().size());
            System.out.println();
        }
        if (fullStat) {
            fullStatistic();
        }
    }

    public void fullStatistic() {

        System.out.println("\nПолная статистика входных данных: \n");

        if (!getInts().isEmpty()) {
            System.out.println("  Integers count: " + getInts().size());

            Optional<Integer> optionalInt = getInts().stream().max(Integer::compare);
            System.out.println("  Integer max: " + optionalInt.get());

            optionalInt = getInts().stream().min(Integer::compare);
            System.out.println("  Integer min: " + optionalInt.get());

            int sumInt = getInts().stream().mapToInt(Integer::intValue).sum();
            System.out.println("  Integer sum: " + sumInt);

            float midInt = sumInt / getInts().size();
            System.out.println("  Integer mid: " + midInt);
            System.out.println();
        }

        if (!getFloats().isEmpty()) {
            System.out.println("  Floats count: " + getFloats().size());

            Optional<Float> optionalFloat = getFloats().stream().max(Float::compare);
            System.out.println("  Float max: " + optionalFloat.get());

            optionalFloat = getFloats().stream().min(Float::compare);
            System.out.println("  Float min: " + optionalFloat.get());

            float sumFloat = (float) getFloats().stream().mapToDouble(Float::floatValue).sum();
            System.out.println("  Float sum: " + sumFloat);

            float midFloat = sumFloat / getFloats().size();
            System.out.println("  Float mid: " + midFloat);
            System.out.println();
        }

        if (!getStrings().isEmpty()) {
            System.out.println("  Strings count: " + getStrings().size());

            Stream<Integer> stream = getStrings().stream().map(String::length);
            int max = stream.max(Integer::compare).get();
            System.out.println("  String max: " + max);

            stream = getStrings().stream().map(String::length);
            int min = stream.min(Integer::compare).get();
            System.out.println("  String min: " + min);
            System.out.println();
        }
        System.out.println();
    }

}
