# arquitetura-camada
projeto de exemplo para arquitetura em camadas

 #Arquivos de configuração
*application.properties
    spring.profiles.active=test
    spring.jpa.open-in-view=false

*application-test.properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.username=sa
   spring.datasource.password=
   spring.h2.console.enabled=true
   spring.h2.console.path=/h2-console
