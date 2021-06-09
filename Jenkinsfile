pipeline {
  agent any
  stages {
    stage('Fetch dependencies') {
          steps {
            sh 'sudo docker pull nginx:latest'
            sh 'whoami'
          }
        }

    stage('Build docker image') {
      steps {
        sh 'sudo docker build . -t customnginx:1'
      }
    }

    stage('Test image') {
      steps {
        sh 'echo "Tests successful"'
      }
    }

    stage('Push image to Object Storage') {
      steps {
        sh 'sudo docker login -u \'sddlrhn3qfno/oracleidentitycloudservice/jason.greene@nanoputian.io\' -p \'4sHW;(wJqn;f<21CA0cG\' syd.ocir.io'
        sh 'sudo docker tag customnginx:1 syd.ocir.io/sddlrhn3qfno/nginx:custom'
        sh 'sudo docker push  syd.ocir.io/sddlrhn3qfno/nginx:custom'
      }
    }
  }
  
}
