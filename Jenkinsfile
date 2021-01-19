pipeline {
  
     agent 
  {
       docker
       {
           image 'maven'
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
