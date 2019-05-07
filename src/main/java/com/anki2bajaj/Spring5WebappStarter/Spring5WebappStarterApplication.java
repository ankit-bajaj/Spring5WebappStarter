package com.anki2bajaj.Spring5WebappStarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring5WebappStarterApplication {
/*


http://localhost:8080/h2-console/login.jsp?jsessionid=56550b5427dd140983c701b0ad4af6ca
accesing H2 database , on localhost , but first enable in Application.properties
for H2 database to e enabled to true

note -- > jdbc url should be ========== >> jdbc:h2:mem:testdb
default is this comming when it is started , -- >jdbc:h2:~/test
but we use in memeory database so use ========== >> jdbc:h2:mem:testdb
*/
	public static void main(String[] args) {
		SpringApplication.run(Spring5WebappStarterApplication.class, args);
	}

}
