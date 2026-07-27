pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                dir('hello-app') {
                    sh 'mvn clean package'
                }
            }
        }
    }
}
