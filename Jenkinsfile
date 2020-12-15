pipeline { 
agent any 
    stages { 
        stage ('Build') { 
            steps{
                echo "Building"

            }
        }
        stage ('Deploy to QA') { 
        steps{
                echo "Deploy to QA"

            }
        }
        stage ('Test on QA') { 
        steps{
                echo "REgression test on QA"

            }
        }
        stage ('Deploy to stage') { 
        steps{
                echo "Deploy to stage"

            }
        }

        stage ('Test on stage') { 
        steps{
                echo "sanity test on stage"

            }
        }

         stage ('Deploy to prod') { 
        	steps{
                echo "Deploy to PROD"

            }
        }


        stage ('Monitor') { 
 			steps{
                echo "Monitor the PROD logs"

            }
        }
 
    }           
 }
