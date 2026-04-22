# Stage 1 — Build
FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2 — Run
FROM tomcat:10.1-jre17
RUN rm -rf /usr/local/tomcat/webapps/ROOT
COPY --from=builder /app/target/cicd-demo.war \
     /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
