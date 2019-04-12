import hudson.EnvVars

def app

node {

  // Pooling the docker image
  checkout scm

  stage('Build docker image') {

      // Build the docker image
      app = docker.build("florinen/grafana", "-f ${WORKSPACE}/Dockerfile .")
  }


  stage('Push image') {

     // Push docker image to the Docker hub
      docker.withRegistry('', 'my-dockerhub-cred') {
          app.push("0.${BUILD_NUMBER}")
          app.push("latest")
      }
  }
}
