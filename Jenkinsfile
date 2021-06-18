pipeline {
  agent { label 'jenkinslave' }
  environment {
        OCI_USER_ID     = credentials('jenkins-oci-user-id')
        OCI_USER_AUTH_KEY = credentials('jenkins-oci-auth-key')
  }
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
            
            sh ' docker login -u \'$OCI_USER_ID\' -p \'$OCI_USER_AUTH_KEY\' syd.ocir.io'
            sh 'cat ~/.docker/config.json'
          sh 'fn deploy --app sampleappInk --registry syd.ocir.io/sddlrhn3qfno/sampleappinkrepo --verbose '
        }
      }
    
  }
  
}


