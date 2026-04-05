# Sistema de Gerenciamento de Biblioteca 📚

Este repositório contém um sistema de gestão de biblioteca desenvolvido em **Java**. O projeto foi estruturado para aplicar e consolidar conceitos fundamentais de **Programação Orientada a Objetos (POO)** e a manipulação de coleções de dados em memória.

O sistema oferece uma solução prática para o controlo de acervos, permitindo gerir livros, utilizadores e o fluxo de empréstimos.

---

## 🚀 Funcionalidades

* **Gestão de Livros (CRUD):** Registo, consulta, atualização e remoção de exemplares no sistema.
* **Gestão de Utilizadores:** Cadastro de leitores com validação por identificadores únicos.
* **Sistema de Empréstimos e Devoluções:** Lógica de negócio para verificar a disponibilidade de livros e atualizar o status de ocupação.
* **Armazenamento em Memória:** Utilização de `HashMap` para garantir uma performance de busca eficiente ($O(1)$) através de chaves únicas (IDs ou E-mails).

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (Versão 11 ou superior)
* **IDE recomendada:** NetBeans, IntelliJ IDEA ou VS Code.
* **Estruturas de Dados:** `java.util.HashMap`, `java.util.ArrayList`.

## 📂 Estrutura do Projeto

O código está organizado seguindo as melhores práticas de encapsulamento:

* `Livro.java`: Representa a entidade do livro (Título, Autor, Disponibilidade).
* `Usuario.java`: Representa a entidade do utilizador que interage com a biblioteca.
* `Core.java`: Classe central que detém a lógica de negócio.
* `Main.java`: Ponto de entrada da aplicação para testes e interface via terminal.

## ⚙️ Como Executar

1.  **Requisitos:** Certifique-se de ter o JDK instalado e configurado no seu PATH.
2.  **Clonar o Repositório:**
    ```bash
    git clone [https://github.com/ArmrDevBr/biblioteca.git](https://github.com/ArmrDevBr/biblioteca.git)
    ```
3.  **Compilar e rodar:**
    * Navegue até a pasta `src`.
    * Compile: `javac Main.java`
    * Execute: `java Main`

## 📝 Roadmap de Desenvolvimento

- [ ] Adicionar persistência de dados (Base de Dados SQL ou JSON).
- [ ] Implementar Interface Gráfica com Swing ou JavaFX.
- [ ] Adicionar sistema de datas para controlo de multas por atraso.

---
**Projeto desenvolvido no âmbito do curso de Análise e Desenvolvimento de Sistemas (ADS).**
