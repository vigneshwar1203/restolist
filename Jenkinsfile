pipeline {
    agent any
    tools {
         maven 'maven3'
    }
    stages{
        stage('Build'){
            steps{
                  sh script: 'mvn clean package'
            }
        }
        stage('Upload War To Nexus'){
            steps{
                nexusArtifactUploader artifacts:[
                   [
                        artifactId: 'team5',
                       classifier: '',
                       file: 'target/RestaurantProj-0.0.1-SNAPSHOT.jar',
                      type: 'jar'
                 ]
             ],
                   credentialsId: 'e32f4d61-d576-47dd-ba86-177c96233dfe',
                   groupId: 'restaurant',
                   nexusUrl: '18.219.133.110:8081',
                   nexusVersion: 'nexus3',
                   protocol: 'http',
                   repository: 'maven-snapshots',
                   version: '0.0.1-SNAPSHOT'
  
            }
        }
    }
 }
