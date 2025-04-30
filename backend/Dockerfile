# ベースイメージとしてOpenJDK 21を指定
FROM openjdk:21-jdk

# 作業ディレクトリとして/tmpを指定
VOLUME /tmp

# ビルドされたJARファイルをコンテナにコピー
COPY target/todo-0.0.1-SNAPSHOT.jar app.jar

# アプリケーションを実行するためのエントリポイントを指定
ENTRYPOINT ["java", "-jar", "/app.jar"]