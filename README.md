# CI/CD Pipeline on AWS EC2

## Overview

This project demonstrates an end-to-end CI/CD pipeline for a Java web application deployed on AWS EC2.
On every git push, the pipeline automatically builds, tests, containerizes, and deploys the application using Jenkins, Maven, Docker, and Tomcat.

---

## Architecture

Developer → GitHub → Jenkins (Port 8080)
→ Maven Build → Docker Image → Deploy to Tomcat (Port 8090) → Run via Docker (Port 8081)

---

## Tech Stack

* Java (Servlet)
* Maven
* Jenkins
* Docker
* Apache Tomcat 9
* AWS EC2 (Amazon Linux)

---

## AWS Configuration

* Instance: Amazon Linux
* Jenkins: Port 8080
* Tomcat: Port 8090
* Docker Application: Port 8081

---

## Pipeline Stages

* Start
* Source — Checkout code from GitHub
* Build — mvn clean package (WAR file)
* Test — mvn test
* Dockerize — Build Docker image
* Deploy — Deploy WAR to Tomcat
* Run Docker — Run container on port 8081
* End

---

## Docker Commands

```bash
docker build -t cicd-demo .
docker run -d -p 8081:8080 --name cicd-container cicd-demo
```

---

## Application Access

* Tomcat Deployment:
  http://<EC2-IP>:8090/cicd-demo/hello

* Docker Deployment:
  http://<EC2-IP>:8081/hello

---

## Key Highlights

* Automated CI/CD pipeline using Jenkins
* Multi-stage Docker build for efficient image creation
* Dual deployment: Tomcat (WAR) and Docker container
* Resolved compatibility issue between Tomcat 9 and 10 (javax vs jakarta)
* Deployed on AWS EC2 with proper networking and security configuration

---

## Notes

* Tomcat 9 is used for compatibility with `javax.servlet`
* Tomcat 10 requires `jakarta.servlet`, which is not used in this project

---
<img width="1320" height="646" alt="image" src="https://github.com/user-attachments/assets/33dcd1d6-bf50-4f49-acc1-2b5b2e5f192a" />
<img width="1349" height="668" alt="image" src="https://github.com/user-attachments/assets/46246854-8130-471d-b8d2-54dd6e6c8fdd" />
<img width="1355" height="726" alt="image" src="https://github.com/user-attachments/assets/30700674-5539-4f73-897f-de7f0691a03d" />

