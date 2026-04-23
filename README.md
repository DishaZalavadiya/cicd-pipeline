End-to-end CI/CD pipeline running on AWS EC2 (Amazon Linux 2023).
Every `git push` automatically builds, tests, containerizes,
and deploys the Java app to Apache Tomcat.

## Architecture
```
Developer → git push → GitHub → Webhook → Jenkins (EC2:8080)
→ Maven Build → Docker Image → Deploy to Tomcat (EC2:8090)
```

## AWS Setup
- **Instance:** t2.medium, Amazon Linux 2023
- **Jenkins:** port 8080
- **Tomcat:** port 8090
- **Docker:** CE latest

## Pipeline Stages
1. **Source** — checkout from GitHub
2. **Build** — `mvn clean package` → WAR file
3. **Test** — `mvn test` → JUnit reports
4. **Dockerize** — multi-stage Docker build
5. **Deploy** — WAR copied to Tomcat webapps

## Run with Docker containor
```bash 
docker build -t cicd-demo .
docker run -p 8080:8080 cicd-demo
```
