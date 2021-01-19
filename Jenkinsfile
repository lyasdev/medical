pipeline {
  
     agent 
  {
       docker
       {
           image 'apache-maven-3.6.3'
           image 'adoptopenjdk/openjdk15'
       }
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
