@echo off
setlocal

rem 1. gradlew에 실행 권한 부여
echo Granting execute permission to gradlew...
icacls gradlew /grant Everyone:F || (echo Failed to give execute permission to gradlew! & exit /b 1)

rem 2. 자바 파일 빌드 (Gradle Wrapper 사용, 테스트 건너뜀)
echo Building Java application without tests...
call gradlew.bat build -x test || (echo Java build failed! & exit /b 1)

rem 3. 기존 컨테이너 및 네트워크 종료 및 정리
echo Stopping and removing existing containers...
docker-compose down || (echo Failed to stop containers! & exit /b 1)

rem 4. 오래된 이미지 삭제 (옵션)
echo Removing old images...
for /f %%i in ('docker images -q my-java-app') do (
    docker rmi -f %%i || (echo Failed to remove old images! & exit /b 1)
)

rem 5. 빌드 및 실행
echo Building and starting containers...
docker-compose up -d --build || (echo Failed to build and start containers! & exit /b 1)

rem 6. 컨테이너 상태 확인
echo Checking container status...
docker-compose ps || (echo Failed to check container status! & exit /b 1)

echo Deployment successful!
exit /b 0
