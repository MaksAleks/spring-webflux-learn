# syntax=docker/dockerfile:1
FROM gradle:7.6-jdk17-alpine AS builder
WORKDIR /workspace/app

# place layers in order from less likly to chahge to more likely to cange
COPY build.gradle .
COPY reactive-server/src src

# When building a project, gradle downloads all the dependencies from the internet
# and it downloads them every time the source code changes, if they are not cached.
#
# To avoid it, we can cache dependencies: --mount=type=cache,target=/container/cache/path

# And since the builder container will run on behalf of root user, the path is /root/.gradle/)
# Then gradle will get dependencies from the cache, hence build will run faster
RUN --mount=type=cache,target=/home/gradle/.gradle gradle --stacktrace --info clean build -x test -x gatlingRun
RUN mkdir -p build/libs/extracted && java -Djarmode=layertools -jar build/libs/*.jar extract --destination build/libs/extracted

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG EXTRACTED=/workspace/app/build/libs/extracted
COPY --link --from=builder ${EXTRACTED}/dependencies/ ./
COPY --link --from=builder ${EXTRACTED}/spring-boot-loader/ ./
COPY --link --from=builder ${EXTRACTED}/snapshot-dependencies/ ./
COPY --link --from=builder ${EXTRACTED}/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]