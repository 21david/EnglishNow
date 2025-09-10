mvn clean package -DskipTests

docker build -t en --no-cache .

docker-compose up