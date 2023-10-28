FROM alpine:3.18.4

RUN apk update
RUN apk upgrade
RUN apk --no-cache add curl
