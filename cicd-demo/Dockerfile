# ---------- Stage 1: Build ----------
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy only pom.xml first (for caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build WAR file
RUN mvn clean package -DskipTests


# ---------- Stage 2: Run ----------
FROM tomcat:10.1-jre17

# Remove default ROOT app
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy WAR from builder stage
COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
