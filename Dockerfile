FROM dragonwell-registry.cn-hangzhou.cr.aliyuncs.com/dragonwell/dragonwell:17

COPY build/libs/*.jar /mydata/app.jar

ENTRYPOINT ["java", "-jar", "/mydata/app.jar", "--spring.profiles.active=prod"]