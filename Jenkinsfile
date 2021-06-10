pipeline {
  agent any
  stages {
      stage('Create Fn Context') {
          
          steps {
            echo 'fn create context InkItApplications --provider oracle <== to be added conditionally if context doesnt exist'
            sh ' fn use context InkItApplications'
            sh ' fn update context oracle.compartment-id ocid1.compartment.oc1..aaaaaaaadbceuq6km7y27ufzdmihj6tb35dbv2sgpy6j3dtf2gypbkejflyq'
            sh ' fn update context api-url https://functions.ap-sydney-1.oraclecloud.com'
            sh ' fn update context registry syd.ocir.io/sddlrhn3qfno/sampleappInkrepo'
          }
        }

      stage('Test image') {
        steps {
        sh 'echo "Tests successful"'
        }
      }

      stage('Push image to OCIR') {
        steps {
          sh 'sudo docker login -u \'sddlrhn3qfno/oracleidentitycloudservice/jason.greene@nanoputian.io\' -p \'4sHW;(wJqn;f<21CA0cG\' syd.ocir.io'
          sh 'sudo docker tag customdemo syd.ocir.io/sddlrhn3qfno/sampleappInkrepo'
          sh 'sudo docker push  syd.ocir.io/sddlrhn3qfno/sampleappInkrepo'
        }
      }
      
      stage('Deploy') {
        steps {
          sh 'fn -v deploy --app sampleappInk'
        }
      }
    
  }
  
}
