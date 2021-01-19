pipeline {
  
     agent 
  {
    docker
    {
      image 'adoptopenjdk/openjdk15'
    }
  }
       environment
       {
          dockerHome= tool 'myDocker'
          mavenHome= tool 'myMaven'
         PATH="$dockerHome/bin:$mavenHome/bin:$PATH"
       }
    stages {
        stage('build') {
            steps {
              echo "PATH - $PATH"
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
