# 🔍 Consulta de CEP com API ViaCEP

Este projeto Java permite consultar informações de endereço com base em um CEP, utilizando a API pública do [ViaCEP](https://viacep.com.br). É uma aplicação de linha de comando com tratamento de exceções e resposta em formato JSON.

## 🚀 Funcionalidades

- Solicita ao usuário um CEP.
- Realiza uma requisição GET para a API do ViaCEP.
- Exibe os dados JSON retornados pela API.
- Trata exceções como:
  - Requisição malformada (400)
  - CEP inexistente (404)
  - Problemas de conexão

## 🛠️ Tecnologias Utilizadas

- Java 11+
- `java.net.http.HttpClient` para chamadas HTTP
- API pública do [ViaCEP](https://viacep.com.br)

## 📁 Estrutura do Projeto

```
br/com/alura/consultaCep/
│
├── excecoes/
│ └── BuscaInvalidaException.java // Exceção personalizada para CEPs inválidos ou não encontrados
│
└── principais/
└── Main.java // Classe principal com lógica de entrada, requisição HTTP e exibição de resultados
```

## 📦 Como Executar o Projeto

1. **Clone o repositório (ou copie os arquivos):**

```
git clone https://github.com/marcus-viniciusdev/ConsultaCep.git
cd ./ConsultaCep
```

Compile o projeto
Na sua IDE preferida
Certifique-se de estar usando o Java 11 ou superior.

⚠️ Tratamento de Erros

    400 ou 404: Se o CEP for malformado ou não encontrado, é lançada uma exceção BuscaInvalidaException.

    IOException / InterruptedException: Erros de conexão são tratados com mensagens amigáveis ao usuário.

📄 Licença

Este projeto tem fins educacionais e pode ser utilizado livremente conforme a licença MIT.
