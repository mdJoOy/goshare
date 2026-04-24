def testApp() {
        echo "Testing the program...."
    }
def buildApp() {
   
    echo "Building the program...."
    sh "docker build -t 192.168.0.45:8083/goshare:1.0 ."

    }
def deployApp() {
   
    withCredentials([usernamePassword(credentialsId:'nexus-user-credentials', usernameVariable: 'USER', passwordVariable:'PWD')]){
        sh "echo '${PWD}' | docker login -u '${USER}' --password-stdin 192.168.0.45:8083"
        }
    sh "docker push 192.168.0.45:8083/goshare:1.0"

    }
return this
