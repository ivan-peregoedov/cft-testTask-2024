Работа над тестовым заданием проводилась на ОС Linux Ubuntu 22.04.2 LTS

Инструкция по запуску:
1) В папке startup:
1.1. java -jar application.jar < опции коммандой строки, например: -p result- > < список входных файлов >
   
3) В папке cft-task:
2.1. Для компиляции: mvn clean compile assembly:single
2.2. Для запуска: java -jar target/cft-task-1.0-SNAPSHOT-jar-with-dependencies.jar < опции коммандой строки > < список входных файлов >

Доп. данные:

Java: 17
Система сборки: Apache Maven 3.6.3 
Доп. библиотеки: Jcommander 1.78
