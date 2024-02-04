package com.task;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * FilesToWrite
 */
public class FilesToWrite {
    private String fileIntName = "integers.txt";
    private String fileFloatName = "floats.txt";
    private String fileStringName = "strings.txt";

    private List<Integer> intsList = new ArrayList<>();
    private List<Float> floatsList = new ArrayList<>();
    private List<String> stringsList = new ArrayList<>();

    private String fullPathInt;
    private String fullPathFloat;
    private String fullPathString;

    private boolean addingToExisting = false;

    public FilesToWrite(List<Integer> intsList, List<Float> floatsList, List<String> stringsList, String preffix,
            boolean addingToExisting) {
        this.intsList = intsList;
        this.floatsList = floatsList;
        this.stringsList = stringsList;
        setPreffix(preffix);
        this.addingToExisting = addingToExisting;
    }

    public void setPreffix(String preffix) {
        this.fileIntName = preffix + this.fileIntName;
        this.fileFloatName = preffix + this.fileFloatName;
        this.fileStringName = preffix + this.fileStringName;
    }

    public void makeFullFilePath(String path) {
        this.fullPathInt = path + this.fileIntName;
        this.fullPathFloat = path + this.fileFloatName;
        this.fullPathString = path + this.fileStringName;
    }

    public void makeFullFilePath() {
        this.fullPathInt = this.fileIntName;
        this.fullPathFloat = this.fileFloatName;
        this.fullPathString = this.fileStringName;
    }

    public void createFiles() {
        if (!intsList.isEmpty()) {
            try (FileWriter intWriter = new FileWriter(fullPathInt, addingToExisting)) {
                for (Integer elemInteger : intsList) {

                    intWriter.write(elemInteger.toString());
                    intWriter.append("\n");
                }

                System.out.println("Файл " + fileIntName + " успешно создан");
            } catch (FileNotFoundException e) {
                System.out.println("Не получилось создать файл " + fullPathInt + " в заданной директории");
                try (FileWriter rootWriter = new FileWriter(fileIntName, addingToExisting)) {
                    for (Integer elemInteger : intsList) {
                        rootWriter.write(elemInteger.toString());
                        rootWriter.append("\n");
                    }
                    System.out.println("Файл " + fileIntName + " успешно создан");
                } catch (Exception exception) {
                    System.out.println("Ошибка при создании файла");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при создании файла");
            }
        }

        if (!floatsList.isEmpty()) {
            try (FileWriter floatWriter = new FileWriter(fullPathFloat, addingToExisting)) {
                for (Float elemFloat : floatsList) {
                    floatWriter.write(elemFloat.toString());
                    floatWriter.append("\n");
                }
                System.out.println("Файл " + fileFloatName + " успешно создан");
            } catch (FileNotFoundException e) {
                System.out.println("Не получилось создать файл " + fullPathFloat + " в заданной директории");
                try (FileWriter rootWriter = new FileWriter(fileFloatName, addingToExisting)) {
                    for (Float elemFloat : floatsList) {
                        rootWriter.write(elemFloat.toString());
                        rootWriter.append("\n");
                    }
                    System.out.println("Файл " + fileFloatName + " успешно создан");
                } catch (Exception exception) {
                    System.out.println("Ошибка при создании файла");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при создании файла");
            }
        }

        if (!stringsList.isEmpty()) {
            try (FileWriter stringWriter = new FileWriter(fullPathString, addingToExisting)) {
                for (String elemString : stringsList) {
                    stringWriter.write(elemString.toString());
                    stringWriter.append("\n");
                }
                System.out.println("Файл " + fileStringName + " успешно создан");
            } catch (FileNotFoundException e) {
                System.out.println("Не получилось создать файл " + fullPathString + " в заданной директории");
                try (FileWriter rootWriter = new FileWriter(fileStringName, addingToExisting)) {
                    for (String elemString : stringsList) {
                        rootWriter.write(elemString.toString());
                        rootWriter.append("\n");
                    }
                    System.out.println("Файл " + fileStringName + " успешно создан");
                } catch (Exception exception) {
                    System.out.println("Ошибка при создании файла");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при создании файла");
            }
        }

    }
}