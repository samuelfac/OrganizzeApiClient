# Organizze API Client

Biblioteca Client das APIs do [Organizze](https://www.organizze.com.br). Para mais informações, visite o site do Organizze e consulte a [documentação da API](https://github.com/organizze/api-doc).

Não tenho nenhuma ligação com a empresa Organizze. Este é apenas um projeto cliente que realiza chamadas nas APIs utilizando seu próprio usuário e senha. Não tenho nenhuma responsabilidade pelo uso das APIs. Qualquer problema relacionado às chamadas deve ser tratado diretamente com a empresa Organizze.

## Instalação

Para adicionar a biblioteca ao seu projeto Maven, inclua a seguinte dependência no seu `pom.xml`:

```xml
<dependency>
  <groupId>samuelfac</groupId>
  <artifactId>organizze.client</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Uso
### Variáveis de Ambiente

 - `ORGANIZZE.USER=email@gmail.com`
 - `ORGANIZZE.PASS=`[Gerar no site do Organizze](https://app.organizze.com.br/configuracoes/api-keys) 
 - `ORGANIZZE.AGENT=Nome (email@gmail.com)`

### Configuração

Adicione `@EnableFeignClients` e `@Import(FeignConfig.class)` na sua classe Application.

### Execução

```java
@Autowired
OrganizzeClient client;
//...
client.getAllUsers();

```



