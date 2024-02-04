package com.task;

import com.beust.jcommander.Parameter;

public class OptionsArgs {
    @Parameter(names = "-o", description = "Путь до файла записи", arity = 1, required = false)
    private String pathName = "";

    @Parameter(names = "-p", description = "Преффикс файла записи", arity = 1, required = false)
    private String preffix = "";

    @Parameter(names = "-a", description = "Флаг добавления в существующий файл", required = false)
    private boolean addition = false;

    @Parameter(names = "-s", description = "Краткая статистика", required = false)
    private boolean simpleStat = false;

    @Parameter(names = "-f", description = "Полная статистика", required = false)
    private boolean fullStat = false;

    public String getPathName() {
        return pathName;
    }

    public boolean pathCreated() {
        return !pathName.isEmpty();
    }

    public String getPreffix() {
        return preffix;
    }

    public boolean getSimpleStatCond() {
        return simpleStat;
    }

    public boolean getFullStatCond() {
        return fullStat;
    }

    public boolean getAddition() {
        return addition;
    }

}
