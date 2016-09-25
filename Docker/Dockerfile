FROM oracle/jdk:8
MAINTAINER Bas Langenberg <blangenberg@qualogy.com>

ADD dockerdemo*.jar /tmp/dockerdemo.jar

CMD ["java", "-jar", "/tmp/dockerdemo.jar", "--server.use-forward-headers=true"]
