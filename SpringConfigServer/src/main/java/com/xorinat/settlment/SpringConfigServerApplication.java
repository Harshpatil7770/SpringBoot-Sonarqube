package com.xorinat.settlment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
// Spring cloud config server act as centralized or common service.
// We kept all common properties on git and provide repository inside this 
//application.properties file.
//git fetch means fetch changes into your local repository
//<<<<<<< HEAD
////git pull is combination of git fetch and git merge.
//=======
////git pull-
//>>>>>>> refs/remotes/origin/master
@SpringBootApplication
@EnableConfigServer
public class SpringConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigServerApplication.class, args);
	}

}
