# MrBet

Sistema simples de gerenciamento de campeonatos de futebol, onde é possível cadastrar times, criar campeonatos, inserir times nesses campeonatos e até realizar apostas.

---

## 📌 Objetivo

Este projeto simula um sistema de apostas esportivas chamado **MrBet**, permitindo:

- Cadastro de times com nome, código e mascote
- Criação de campeonatos com quantidade limitada de participantes
- Inclusão de times nos campeonatos
- Consulta de quais campeonatos um time participa
- Realização e listagem de apostas em campeonatos

---

## 🚀 Como Executar

### Pré-requisitos

- Java JDK 8 ou superior
- IDE de sua preferência (Eclipse, IntelliJ, VSCode) **ou** terminal com `javac`/`java`

### Compilando e Executando via Terminal

```bash
javac mrbet/*.java
java mrbet.MrBetMain
```
---

## 🧠 Funcionalidades

### Cadastro de Times
- Permite registrar times únicos por código com nome e mascote.

### Inclusão de Times em Campeonatos
- Permite associar um time a um campeonato, respeitando o limite de participantes.

### Verificação de Participação
- Consulta se um time está cadastrado em determinado campeonato.

### Apostas
#### O usuário pode realizar apostas indicando:
- Time
- Campeonato
- Colocação Final esperada
- Valor da Aposta

---
## Status das Apostas
- Lista todas as apostas realizadas no sistema.

---
## 🧪 Exemplo de Uso
- Ao iniciar o programa,basta seguir o seguinte menu que será exibido:
```
MENU
(M)Minha inclusão de times
(R)Recuperar Time
(.)Adicionar Campeonato
(B)Bora incluir time em campeonato e Verificar se time está em campeonato
(E)Exibir campeonatos que o time participa
(T)Tentar a sorte e status
(!)Já pode fechar o programa!
```
---
## 🛠️ Tecnologias Utilizadas
- Java – Linguagem principal do projeto
- CLI (Command Line Interface) – Interface textual simples com menus interativos

---
## ⚖️ Licença
- Este projeto está licenciado sob a Licença MIT. Sinta-se à vontade para usar, estudar e modificar!
---
## ✍️ Autor
### Antonio Neto
- Projeto construído nas aulas de Programação da UFCG.
