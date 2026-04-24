FROM golang

RUN mkdir -p /home/goshare
COPY . /home/goshare
WORKDIR /home/goshare

RUN go mod tidy



CMD ["go", "run", "main.go" ]




