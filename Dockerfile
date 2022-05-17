FROM openjdk:11
ARG PROFILE
ARG ADDITIONAL_OPTIONS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTIONS=${ADDITIONAL_OPTIONS}

WORKDIR /opt/spring_boot

COPY /target/cat*.jar cat_mysql.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTIONS} -jar cat_mysql.jar --spring.profiles.active=${PROFILE}