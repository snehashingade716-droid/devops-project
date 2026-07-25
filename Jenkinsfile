pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/snehashingade716-droid/devops-project.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
