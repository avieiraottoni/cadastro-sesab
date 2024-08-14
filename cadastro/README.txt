pom.xml

Descrição:
O pom.xml é o arquivo de configuração principal do Maven. 
Ele define as dependências, plugins, configurações de compilação, 
e outras propriedades essenciais para a construção e gerenciamento do projeto Java.

Uso e Manutenção:

Dependências:
Lista todas as bibliotecas necessárias para o projeto. 
Inclui as dependências do Hibernate, SQLite, JSF, PrimeFaces, e JUnit. 
Para adicionar novas dependências, insira um novo bloco 
<dependency> dentro da seção <dependencies>.

Propriedades:
Especifica as versões do compilador e configurações de codificação do projeto. 
Modifique as propriedades como <maven.compiler.source> e <maven.compiler.target> 
para alterar as versões do Java.

Plugins:
Define os plugins utilizados pelo Maven para compilar o código e criar o arquivo WAR. 
O maven-compiler-plugin compila o código, enquanto o maven-war-plugin cria o pacote WAR 
para a aplicação. Ajuste as configurações dos plugins se necessário.

Empacotamento:
Define o tipo de empacotamento como war, que é utilizado para aplicações web. 
Se o projeto mudar para um tipo diferente de aplicação, altere esta configuração.

Manutenção:

Adicionar Dependências: Para incluir uma nova biblioteca, adicione um bloco de dependência na 
seção <dependencies>.
Atualizar Versões: Verifique regularmente as versões das dependências e plugins para 
manter o projeto atualizado.
Plugins: Se houver necessidade de mudar o processo de build ou adicionar novas etapas, 
edite ou adicione novos plugins conforme necessário.
