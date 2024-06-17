# Указываем образ, от которого наследуемся
FROM eclipse-temurin:20-jdk

# Аргументы для версии Gradle и JAR файла
ARG GRADLE_VERSION=8.2
ARG JAR_FILE=build/libs/docker.jar

# Устанавливаем необходимые пакеты
RUN apt-get update && apt-get install -yq make unzip

# Скачиваем и распаковываем Gradle
RUN wget -q https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip \
    && unzip gradle-${GRADLE_VERSION}-bin.zip \
    && rm gradle-${GRADLE_VERSION}-bin.zip

ENV GRADLE_HOME=/opt/gradle
ENV PATH=$PATH:$GRADLE_HOME/bin

# Устанавливаем рабочую директорию
WORKDIR /docker

# Копируем JAR файл из основной файловой системы внутрь образа
COPY ${JAR_FILE} docker.jar

# Определяем действие, которое будет выполнено при старте контейнера
ENTRYPOINT ["java", "-jar", "docker.jar"]

# Сообщаем, что контейнер использует 8000 порт (если ваше приложение слушает на этом порту)
EXPOSE 8080
