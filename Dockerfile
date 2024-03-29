FROM openjdk

WORKDIR /home/app

COPY /build/libs/Bball-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "Bball-0.0.1-SNAPSHOT.jar"]

