# 📦 Consulta de CEPs com ViaCEP

Este é um projeto Java simples que permite ao usuário consultar endereços a partir de CEPs brasileiros utilizando a API pública [ViaCEP](https://viacep.com.br/). Os dados retornados são exibidos no terminal e salvos localmente em arquivos `.json`.

---

## 🚀 Funcionalidades

- Consulta de endereço a partir de um CEP.
- Tratamento de erros e CEPs inválidos.
- Salvamento automático dos dados consultados em arquivos JSON.
- Interface simples via terminal.
- Criação de arquivos separados para cada CEP consultado.

---

## 📸 Exemplo de uso

```
Bem-vindo ao consultador de CEPs (digite 'Sair' para fechar o software)
Digite o CEP que deseja consultar: 01001000
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "estado": "SP",
  "regiao": null
}
Endereço salvo no arquivo: 01001000.json
```

---

## 🛠️ Tecnologias utilizadas

Java 17+

API HTTP do Java (java.net.http.HttpClient)

Gson para serialização e desserialização JSON

API pública ViaCEP

---

## 📂 Estrutura do Projeto

```
src/
├── br/com/alura/consultaCep/
│   ├── principais/
│   │   └── Main.java
│   ├── modelos/
│   │   └── Endereco.java
│   └── excecoes/
│       └── BuscaInvalidaException.java
```

---

## ⚙️ Como executar

Clone o repositório:

1. **Clone o repositório (ou copie os arquivos):**

```
git clone https://github.com/marcus-viniciusdev/ConsultaCep.git
cd ./ConsultaCep
```

Compile o projeto
Na sua IDE preferida
Certifique-se de estar usando o Java 11 ou superior e ter instalado a dependência [Gson](https://github.com/google/gson).

---

## 📁 Onde os dados são salvos?

Cada endereço é salvo em um arquivo JSON nomeado com o CEP, por exemplo:

    01001000.json

---

## 📜 Licença

Este projeto é de uso educacional, inspirado nos cursos da [Alura](https://alura.com.br). Sinta-se livre para modificar e melhorar.
