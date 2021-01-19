pipeline {
  
    agent any
       environment
       {
          dockerHome= tool 'myDocker'
          mavenHome= tool 'myMaven'
          myJdkHome= tool 'myJdk'
         PATH="$dockerHome/bin:$mavenHome/bin:$myJdkHome/bin:$PATH"
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
