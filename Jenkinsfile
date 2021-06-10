pipeline {
  agent { label 'jenkinslave' }
  stages {
      stage('Create Fn Context') {
          
          steps {
            echo 'fn create context InkItApplications --provider oracle <== to be added conditionally if context doesnt exist'
            echo ' fn use context InkItApplications'
            sh ' fn update context oracle.compartment-id ocid1.compartment.oc1..aaaaaaaadbceuq6km7y27ufzdmihj6tb35dbv2sgpy6j3dtf2gypbkejflyq'
            sh ' fn update context api-url https://functions.ap-sydney-1.oraclecloud.com'
            sh ' fn update context registry syd.ocir.io/sddlrhn3qfno/sampleappinkrepo'
            sh ' fn update context InkItApplications default'
          }
        }

      stage('Test image') {
        steps {
           
        sh 'echo "Tests successful"'
        }
      }
     
     
      
      stage('Deploy') {
        steps {
          sh 'sudo docker login -u sddlrhn3qfno/oracleidentitycloudservice/jason.greene@nanoputian.io -p '4sHW;(wJqn;f<21CA0cG' syd.ocir.io'
          sh 'fn -v deploy --app sampleappInk'
        }
      }
    
  }
  
}

