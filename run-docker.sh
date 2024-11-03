#!/bin/bash

# 필요한 디렉토리로 이동 (예: /BackEnd 경로)
#cd hellocat || { echo "Directory hellocat not found!"; exit 1; }

# 1. gradlew에 실행 권한 부여
chmod +x ./gradlew || { echo "Failed to give execute permission to gradlew!"; exit 1; }

# 2. 자바 파일 빌드 (Gradle Wrapper 사용, 테스트 건너뜀)
echo "Building Java application without tests..."
./gradlew build -x test || { echo "Java build failed!"; exit 1; }

# 3. 기존 컨테이너 및 네트워크 종료 및 정리
echo "Stopping and removing existing containers..."
docker-compose down || { echo "Failed to stop containers!"; exit 1; }

# 4. 오래된 이미지 삭제 (옵션)
echo "Removing old images..."
old_images=$(docker images -q my-java-app)  # 실제 이미지 이름으로 변경 필요
if [ -n "$old_images" ]; then
    docker rmi -f $old_images || { echo "Failed to remove old images!"; exit 1; }
else
    echo "No old images to remove."
fi

# 5. 빌드 및 실행
echo "Building and starting containers..."
docker-compose up -d --build || { echo "Failed to build and start containers!"; exit 1; }

# 6. 컨테이너 상태 확인
echo "Checking container status..."
docker-compose ps || { echo "Failed to check container status!"; exit 1; }

echo "Deployment successful!"
exit 0
