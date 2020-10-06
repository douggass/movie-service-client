# Movie Service

### Cliente que pode fazer requisições para o servidor onde se que lista filmes do imdb8

Desenho técnico: [lucidchart movie-service](https://app.lucidchart.com/documents/view/4698e7fc-8786-4646-b1c8-6d46f4f4cd70)

## Requisitos

1. Java - 1.8.x

2. A aplicação deve estar rodando [movie-service-server](https://github.com/douggass/movie-service-server)

## Requisitos para desenvolvimento

1. Lombok plugin - 1.x.x


## Configuração 

**1. Clone a aplicação**

```bash
git clone https://github.com/douggass/movie-service-client.git
```

**2. Compilando a aplicação**

```bash
gradlew build
```


## Explorando a aplicação

A aplicação irá criar um cliente que solicitará ao servido de filmes, o servidor irá retornar os filmes, então a aplicação irá printar cada filme retornado. 

Exemplo:
```
gradlew run --args="Nome do filme"

```

## Rodando os testes

O projeto contém uma série de testes que podem ser rodados utilizando o comando `gradlew test`. 

Os resultados podem ser visto acesso o html: build/reports/tests/test/index.html
