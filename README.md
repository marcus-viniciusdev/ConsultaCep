# 📍 Consulta de CEP com API ViaCEP + Exportação em JSON

Este projeto Java permite consultar endereços a partir de CEPs usando a API pública do [ViaCEP](https://viacep.com.br), armazenando os resultados em um arquivo JSON formatado. É uma aplicação de linha de comando com tratamento de erros e exportação local dos dados.

## 🚀 Funcionalidades

- Solicita ao usuário múltiplos CEPs.
- Realiza requisições GET para a API do ViaCEP.
- Exibe as informações do endereço obtido.
- Armazena os resultados em um arquivo `enderecos.json`.
- Trata exceções:
  - CEP inválido ou não encontrado.
  - Problemas de conexão com a API.

## 🛠️ Tecnologias Utilizadas

- Java 11+
- `java.net.http.HttpClient` (requisições HTTP)
- [Gson](https://github.com/google/gson) para manipulação de JSON
- API pública do [ViaCEP](https://viacep.com.br)

## 📁 Estrutura do Projeto

```
br/com/alura/consultaCep/
│
├── excecoes/
│ └── BuscaInvalidaException.java // Exceção personalizada para CEPs inválidos ou não encontrados
│
├── modelos/
│ └── Endereco.java // Classe modelo que representa os dados retornados pelo ViaCEP
│
└── principais/
└── Main.java // Classe principal: entrada de dados, chamada API, exportação JSON
```

## 📦 Como Executar o Projeto

1. **Clone o repositório (ou copie os arquivos):**

```
git clone https://github.com/marcus-viniciusdev/ConsultaCep.git
cd ./ConsultaCep
```

Compile o projeto
Na sua IDE preferida
Certifique-se de estar usando o Java 11 ou superior e ter instalado a dependência [Gson](https://github.com/google/gson).

## ⚠️ Tratamento de Erros

    BuscaInvalidaException: Lançada para CEPs inexistentes (400 ou 404).

    IOException / InterruptedException: Tratadas com mensagens de erro amigáveis.

    Arquivo JSON: Erros ao salvar o arquivo também são tratados.

## 📄 Licença

Este projeto é para fins educacionais e está sob a licença MIT. Sinta-se livre para modificar, usar ou distribuir.
