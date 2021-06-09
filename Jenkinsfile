pipeline {
    agent any
    stages {
        stage('Fetch dependencies') {
        /* This stage pulls the latest nginx image from
           Dockerhub */
            steps {
                sh 'sudo docker pull nginx:latest'
          }
        }
        stage('Build docker image') {
        /* This stage builds the actual image; synonymous to
           docker build on the command line */
            steps {
            sh "sudo docker build . -t customnginx:1"
            }    
        }
        stage('Test image') {
         /* This stage runs unit tests on the image; we are
            just running dummy tests here */
            steps {
                sh 'echo "Tests successful"'
          }
        }
        stage('Push image to Object Storage') {
         /* Final stage of build; Push the 
            docker image to our OCI private Registry*/
        steps {
            sh "sudo docker login -u 'sddlrhn3qfno/oracleidentitycloudservice/jason.greene@nanoputian.io' -p '4sHW;(wJqn;f<21CA0cG' syd.ocir.io"
            sh "sudo docker tag customnginx:1 syd.ocir.io/sddlrhn3qfno/nginx:custom"
            sh 'sudo docker push  syd.ocir.io/sddlrhn3qfno/nginx:custom'
            
           }
         }      
    }
}
