pipeline {
  
     agent 
  {
       docker
       {
          
           image 'adoptopenjdk/openjdk15'
       }
     
  }
  agent
  {
    docker
       {
           image 'maven'
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
