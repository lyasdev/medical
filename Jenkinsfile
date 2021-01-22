pipeline {
  
    agent any
       environment
       {
          dockerHome= tool 'myDocker'
          mavenHome= tool 'myMaven'
          myJdkHome= tool 'myJdk'
          sonarQubeScannerHome= tool 'mySonar'
         PATH="$dockerHome/bin:$mavenHome/bin:$myJdkHome/bin:${sonarQubeScannerHome}/bin/sonar-scanner: $PATH"
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
        stage('Sacnner-Sonar-Qube') {
             steps {
            withCredentials([string(credentialsId:'sonarToken',variable:'sonarLogin')]){
              sh "${sonarQubeScannerHome}/bin/sonar-scanner -e \
               -Dsonar.host.url=http://sqube.centralus.cloudapp.azure.com:9000 \
               -Dsonar.login=${sonarLogin} -Dsonar.projectName=medical \
               -Dsonar.projectVersion=${env.BUILD_NUMBER} \
               -Dsonar.projectKey=MD \
               -Dsonar.language=java"
            }
             }
        }
       
    }
}
