# arquitetura-camada
projeto de exemplo para arquitetura em camadas

 #Arquivos de configuração 
 
 ```application.properties```
   * spring.profiles.active=test
   * spring.jpa.open-in-view=false

 ```application-test.properties```
   * spring.datasource.url=jdbc:h2:mem:testdb
   * spring.datasource.username=sa
   * spring.datasource.password=
   * spring.h2.console.enabled=true
   * spring.h2.console.path=/h2-console


 #Insert banco 
 * INSERT INTO tb_pessoa(nome, idade) values('Denis', 42);
 * INSERT INTO tb_pessoa(nome, idade) values('marcelo', 110);
 * INSERT INTO tb_pessoa(nome, idade) values('Bidú', 24);
 * INSERT INTO tb_pessoa(nome, idade) values('Tiago', 65);
 * INSERT INTO tb_pessoa(nome, idade) values('Jairo', 31);
 * INSERT INTO tb_pessoa(nome, idade) values('Victor', 33);
 * INSERT INTO tb_pessoa(nome, idade) values('Matheus', 36);
