# 💱 Conversor de Moedas em Java

Este projeto é um conversor de moedas baseado em uma API externa de câmbio (ExchangeRate API). Ele permite ao usuário converter valores entre diferentes moedas de forma interativa via terminal.

## ✨ Funcionalidades

- Conversão entre as seguintes moedas:
  - Dólar
  - Peso Argentino
  - Real Brasileiro
  - Peso Colombiano
- Consulta em tempo real das taxas de câmbio.
- Interface de linha de comando interativa.
- Validação de entradas numéricas e tratamento de erros.

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **HTTP Client** (Java nativo)
- **Gson** para parseamento JSON
- API: [ExchangeRate API](https://www.exchangerate-api.com/)


🛡️ Tratamento de Erros
Entradas inválidas como letras ou símbolos são detectadas e tratadas.

Números fora do intervalo 1 a 7 não são aceitos no menu.

Problemas de conexão com a API geram mensagens amigáveis.

📌 Observações
A API gratuita possui um limite de requisições por dia. Verifique os planos no site da ExchangeRate API.

Caso precise adicionar mais moedas, basta seguir o padrão nas chamadas da API (por sigla internacional).

Autora
Desenvolvido por Debora Neves 👩🏻‍💻
Contato: deboraesneves.dn@gmail.com
