# ========================================
# 株式会社SHINE ホームページ Dockerfile
# Java 21 + Spring Boot 最適化版
# ========================================

# ビルドステージ（Maven + JDK 21）
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# pom.xmlを先にコピー（依存関係キャッシュ最適化）
COPY pom.xml .

# 依存関係のダウンロード
RUN mvn dependency:go-offline -B

# ソースコード全体をコピー
COPY src ./src

# ビルド実行（テストスキップで高速化）
RUN mvn clean package -DskipTests -B

# 実行ステージ（軽量JRE）
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# ビルド成果物をコピー
COPY --from=builder /app/target/*.jar app.jar

# ポート設定
EXPOSE 8080

# 無料プラン対応メモリ設定
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# アプリケーション起動
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
