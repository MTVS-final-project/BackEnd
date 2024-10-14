@echo off

REM 1. 자바 파일 빌드 (Gradle Wrapper 사용)
echo Building Java application...
call gradlew.bat build

REM 2. 기존 컨테이너 및 네트워크 종료 및 정리
echo Stopping and removing existing containers...
docker-compose down

REM 3. 오래된 이미지 삭제 (옵션)
echo Removing old images...
for /f "tokens=*" %%i in ('docker images -q my-java-app') do (
    docker rmi -f %%i
)

REM 4. 빌드 및 실행
echo Building and starting containers...
docker-compose up -d --build

REM 5. 컨테이너 상태 확인
echo Checking container status...
docker-compose ps

REM 6. 컨테이너 로그 출력
echo Tailing logs...
docker-compose logs -f