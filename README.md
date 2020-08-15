# Projeto API E-Commerce

![Imagem Redis- Mysql](img/Redis-Mysql.png)

##  Pré-requisitos para execução da API
 - Tecnologias necessárias.
 
    1- Para executar o projeto é necessário ter instalado Java SE Development Kit.
 
    2- Utilizar uma IDE para execução.
---

http://localhost:8080/ecommerce/cadastro/pedido/ <br>
http://localhost:8080/ecommerce/cadastro/produto/<br>
http://localhost:8080/ecommerce/cadastro/cliente/<br>

A solução proposta visa usar o Redis para fazer o cache e agilizar o as consultas feitas para todas as entidades do sistema e o mysql para fazer persistência dos dados.
Como as duas soluções pretendemos garantir que o sistema funcione de forma ágil e desacoplada do Mysql quando for necessário fazer as consultas.
