# 1. Gradle과 Java 17이 포함된 베이스 이미지로 빌드 스테이지 생성
FROM gradle:8.2-jdk17 AS build

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. Gradle 캐싱을 위해 build.gradle, settings.gradle 파일만 먼저 복사
COPY build.gradle settings.gradle ./

# 4. 의존성 다운로드 (Gradle 빌드가 아닌 의존성 설치)
RUN gradle dependencies --no-daemon --no-watch-fs

# 5. 소스 코드 복사
COPY src ./src

# 6. 애플리케이션 빌드 (테스트는 제외)
RUN gradle bootJar -x test --no-daemon --no-watch-fs

# 7. 경량의 JRE 이미지를 사용하여 애플리케이션 실행을 위한 새로운 스테이지 생성
FROM openjdk:17-jdk-slim

# 8. 작업 디렉토리 설정
WORKDIR /app

# 9. 빌드 스테이지에서 생성된 JAR 파일 복사
COPY --from=build /app/build/libs/*.jar myapp.jar

# 10. 애플리케이션 실행
CMD ["java", "-jar", "myapp.jar"]
