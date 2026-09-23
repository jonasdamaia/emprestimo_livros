# SGE - Sistema de Gerenciamento de Empréstimos

Aplicação web para controlar o empréstimo e a devolução de livros de um pequeno acervo. Tudo roda em um único arquivo `index.html`, sem dependências, sem instalação e sem servidor.

O projeto nasceu como um programa Java de console (classes `Livros`, `Pessoas`, `Emprestimo` e `Main`) e foi convertido para HTML, CSS e JavaScript puros.

## Funcionalidades

- **Listar livros:** mostra o acervo com título, autor e exemplares disponíveis.
- **Listar pessoas:** mostra as pessoas cadastradas com nome e idade.
- **Iniciar empréstimo:** escolha a pessoa, o livro e a quantidade de exemplares, confira os dados e confirme.
- **Registrar devolução:** o mesmo fluxo, devolvendo os exemplares ao estoque.
- **Sair:** encerra a sessão e permite voltar ao início.

Se a quantidade pedida for maior que a disponível, o sistema oferece emprestar apenas os exemplares que existem. Livros sem estoque não podem ser emprestados.

## Como usar

Abra o arquivo `index.html` em qualquer navegador moderno.

## Estrutura

```
.
├── index.html   # interface, estilos e lógica da aplicação
└── README.md
```

Dentro do `index.html`, a lógica segue a organização do projeto original:

| Classe       | Responsabilidade                                               |
|--------------|----------------------------------------------------------------|
| `Livros`     | Títulos, autores e quantidade de exemplares do acervo          |
| `Pessoas`    | Nomes e idades das pessoas cadastradas                         |
| `Emprestimo` | Regras de empréstimo e devolução sobre o estoque de livros     |

## Dados iniciais

O acervo tem 10 livros com 1 exemplar cada, e há 5 pessoas cadastradas. Para alterar, edite os arrays nas classes `Livros` e `Pessoas`, dentro da tag `<script>` do `index.html`.

## Limitações

- Os dados ficam apenas na memória da página: ao recarregar, o estoque volta ao estado inicial.
- O sistema não registra quem está com cada livro, então a devolução não verifica se o empréstimo existiu.

## Tecnologias

HTML5, CSS3 e JavaScript (ES6+).
