package com.task;

import java.util.List;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public class App {
    public static void main(String[] args) {
        try {
            OptionsArgs optionsArgs = new OptionsArgs();
            JCommander cmd = JCommander.newBuilder().addObject(optionsArgs).acceptUnknownOptions(true).build();
            cmd.parse(args);

            String path = "";

            String preffix = optionsArgs.getPreffix();

            List<String> inputFilesList = cmd.getUnknownOptions();
            if (inputFilesList.isEmpty()) {
                throw new Exception("Не были найдены входные файлы");
            }
            FilesToRead fileToRead = new FilesToRead(inputFilesList);
            fileToRead.readFile();
            fileToRead.statistic(optionsArgs.getSimpleStatCond(),
                    optionsArgs.getFullStatCond());

            FilesToWrite filesToWrite = new FilesToWrite(fileToRead.getInts(),
                    fileToRead.getFloats(),
                    fileToRead.getStrings(), preffix, optionsArgs.getAddition());
            if (optionsArgs.pathCreated()) {
                path = optionsArgs.getPathName() + "/";
                filesToWrite.makeFullFilePath(path);
            } else {
                filesToWrite.makeFullFilePath();
            }

            filesToWrite.createFiles();

        } catch (ParameterException e) {
            System.out.println("Ошибка параметра для опциии " + e.getMessage().split(" ")[4]);
        } catch (Exception exception) {
            System.out.println("Ошибка при обработке консольных данных!\n");

            System.out.println(exception.getLocalizedMessage());
        }

    }
}
