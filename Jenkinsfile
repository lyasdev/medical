pipeline {
    agent any
    
    tools {
    	maven 'apache-maven-3.6.3'
    	jdk 'AdoptOpenJDK-15.0.1+9'
    }
    
    stages {
        stage('build') {
            steps {
                sh 'mvn clean install -Dmaven.test.skip=true'
            }
        }
        stage('unit test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}