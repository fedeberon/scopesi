FROM maven:3.5.2-jdk-8-alpine
WORKDIR .
COPY . /workspace
WORKDIR /workspace
RUN mvn clean install
CMD ["mvn", "spring-boot:run"]
