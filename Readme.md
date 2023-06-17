Для запуска тестов необходимо:
1. Установить на локальной машине Java 16, Gradle 7.4
2. В командной строке перейти в папку прокета apiProjectTest
3. Затем выполнить команду ./gradlew test --tests "ApiTests"

После чего произойдёт сборка проекта и запуск тестов.

В прогону будет два теста, один успешый, successfulGettingAlbumsData, 
второй unsuccessfulGettingAlbumsData не успешный