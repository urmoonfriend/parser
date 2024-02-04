FROM adoptopenjdk:17-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", \
"-Djava.security.egd=file:/dev/./urandom", \
#"-Dspring.profiles.active=local", \
#"-Dcom.sun.management.jmxremote=true", \
#"-Dcom.sun.management.jmxremote.port=9090", \
#"-Dcom.sun.management.jmxremote.ssl=false", \
#"-Dcom.sun.management.jmxremote.authenticate=false", \
#"-Dcom.sun.management.jmxremote.rmi.port=9090", \
#"-Dcom.sun.management.jmxremote.local.only=false", \
#"-Djava.rmi.server.hostname=localhost", \
"-jar", \
"-Xms128M", \
"-Xmx256M", \
"/app.jar"]
ENV TZ="Asia/Almaty"
ENV MANAGEMENT_SERVER_PORT=9002
ENV SPRING_MAIN_BANNER-MODE=off
ENV SERVER_SHUTDOWN=graceful