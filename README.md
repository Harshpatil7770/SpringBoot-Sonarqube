# SpringBoot-Sonarqube
#### We need to add to plugins
#### 1) Jacoco maven plugin
#### 2) sonar maven plugin

#### Start Sonar on your machine with sonar cmd

#### default port no 9000

#### First run your application as maven build 
     clean org.jacoco:jacoco-maven-plugin:prepare-agent install 
     
#### Second your application as maven build
     sonar:sonar -Dsonar.login=2e617cf34ac2531ea92e7aeb73f395a7f12be229
     
     
     
