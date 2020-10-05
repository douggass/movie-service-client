# Movie Service

## Cliente que pode fazer requisições para o servidor onde se que lista filmes do imdb8

Desenho técnico: https://app.lucidchart.com/documents/view/4698e7fc-8786-4646-b1c8-6d46f4f4cd70

## Requisitos

1. Java - 1.8.x

## Requisitos para desenvolvimento

1. Lombok plugin - 1.x.x


## Configuração 

**1. Clone a aplicação**

```bash
git clone https://github.com/douggass/movie-service-client.git
```

**2. Compilando e rodando a aplicação**

```bash
gradlew build run
```

O servidor irá iniciar e as requisições serão feitas para o endereço <http://localhost:8080>.

## Explorando a aplicação

A aplicação irá solicitar um nome de filme, fazer a pesquisa e listar os filmes com o nome ou próximos. 

Exemplo:
```


```

## Rodando os testes

O projeto contem uma serie de testes que podem ser rodados utilizando o comando `gradlew test`. 

Os resultados podem ser visto acesso o html: build/reports/tests/test/index.html
