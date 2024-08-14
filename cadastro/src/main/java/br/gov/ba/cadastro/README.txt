Classes Java

Usuario.java

Descrição:
Representa um usuário no sistema. Contém os atributos essenciais como nome, CPF, 
e-mail, data de cadastro, perfil e endereços associados. 
Mapeada para a tabela usuarios no banco de dados.

Uso e Manutenção:

Atributos: Gerencia dados do usuário e suas associações.
Métodos: Inclui métodos para acessar e modificar os atributos (getters e setters). 
Adicione novos atributos ou métodos conforme necessário para suportar novas funcionalidades.
Endereco.java
Descrição:
Representa um endereço no sistema, com atributos como logradouro, número, 
bairro, cidade, estado e CEP. Mapeada para a tabela enderecos no banco de dados.

Uso e Manutenção:

Atributos: Gerencia detalhes do endereço e suas associações.
Métodos: Inclui métodos para acessar e modificar os atributos (getters e setters). 
Atualize conforme necessário para suportar novas funcionalidades.

UsuarioBean.java

Descrição:
Managed Bean responsável por gerenciar a interação com a camada de dados do Usuario. 
Inclui métodos para criar, editar, excluir e pesquisar usuários.

Uso e Manutenção:

Métodos: Implementa a lógica para operações CRUD e pesquisa de usuários.
Propriedades: Gerencia os dados exibidos na interface de usuário e controla a navegação.

EnderecoBean.java

Descrição:
Managed Bean responsável por gerenciar operações relacionadas a Endereco. 
Permite criar, editar, excluir e listar endereços.

Uso e Manutenção:

Métodos: Implementa a lógica para operações CRUD e pesquisa de endereços.
Propriedades: Gerencia os dados exibidos na interface de usuário e controla a navegação.

UsuarioDAO.java
Descrição:
Data Access Object (DAO) para Usuario, contendo métodos para interagir com o 
banco de dados usando Hibernate.

Uso e Manutenção:

Métodos: Implementa a lógica para salvar, excluir, e buscar usuários no banco de dados. 
Modifique conforme necessário para suportar novas consultas ou alterações.

EnderecoDAO.java

Descrição:
Data Access Object (DAO) para Endereco, contendo métodos para interagir com o banco de dados usando Hibernate.

Uso e Manutenção:

Métodos: Implementa a lógica para salvar, excluir, e buscar endereços no banco de dados. 
Modifique conforme necessário para suportar novas consultas ou alterações.