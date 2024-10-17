#!/bin/bash

# 필요한 디렉토리로 이동 (예: /BackEnd 경로)
cd /BackEnd || { echo "Directory /BackEnd not found!"; exit 1; }

# 1. 자바 파일 빌드 (Gradle Wrapper 사용)
echo "Building Java application..."
./gradlew build || { echo "Java build failed!"; exit 1; }

# 2. 기존 컨테이너 및 네트워크 종료 및 정리
echo "Stopping and removing existing containers..."
docker-compose down || { echo "Failed to stop containers!"; exit 1; }

# 3. 오래된 이미지 삭제 (옵션)
echo "Removing old images..."
docker rmi -f $(docker images -q my-java-app) || { echo "Failed to remove old images!"; exit 1; }

# 4. 빌드 및 실행
echo "Building and starting containers..."
docker-compose up -d --build || { echo "Failed to build and start containers!"; exit 1; }

# 5. 컨테이너 상태 확인
echo "Checking container status..."
docker-compose ps || { echo "Failed to check container status!"; exit 1; }

# 6. 로그 출력 (로그 출력은 백그라운드에서 실행)
echo "Tailing logs..."
docker-compose logs -f &

echo "Deployment successful!"
exit 0
