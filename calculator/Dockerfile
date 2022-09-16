FROM golang:1.19.0

RUN apt update -y && apt install -y collectd collectd-utils

COPY ./collectd.conf /etc/collectd/collectd.conf

WORKDIR /app

COPY ./go.mod ./
COPY ./go.sum ./
COPY ./*.go ./

RUN go mod tidy && go build -o ./calc

EXPOSE 8081

ENTRYPOINT /etc/init.d/collectd start && /app/calc
