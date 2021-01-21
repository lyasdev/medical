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

        stage('Sacnner-Sonar-Qube') {
             steps {
            def sonarQubeScannerHome= tool 'mySonar'
            withCredentials([string(credentialsId:'sonarToken',variable:'sonarLogin')]){
              sh "${sonarQubeScannerHome}/bin/sonar-scanner -e -Dsonar.host.url=http://sqube.centralus.cloudapp.azure.com:9000 -Dsonar.login=${sonarLogin} -Dsonar.projectName=medical -Dsonar.projectVersion=${env.BUILD_NUMBER} -Dsonar.projectKey=GS -Dsonar.sources=medical/src/main/ -Dsonar.tests=medical/src/test/ -Dsonar.language=java"
            }
             }
        }
        stage('unit test') {
            steps {
                sh 'mvn test' 
            }
        }
    }
}
