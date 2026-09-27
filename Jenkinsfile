pipeline {

    agent any

    environment {
        DOCKER_IMAGE = 'sneha18devops/hello-app'
        DOCKER_TAG = '3.0'
    }

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

        stage('Test') {
            steps {
                dir('hello-app') {
                    sh 'mvn test'
                }
            }
        }

        stage('Docker Build') {
            steps {
                dir('hello-app') {
                    sh 'docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .'
                }
            }
        }

        stage('Docker Push') {
            steps {
                sh 'docker push ${DOCKER_IMAGE}:${DOCKER_TAG}'
            }
        }

        stage('Kubernetes Deploy') {
            steps {
                sh 'kubectl apply -f hello-app/k8s/deployment.yaml'
                sh 'kubectl apply -f hello-app/k8s/service.yaml'
            }
        }

        stage('Verify Deployment') {
            steps {
                sh 'kubectl rollout status deployment/hello-app'
                sh 'kubectl get pods'
                sh 'kubectl get service hello-app-service'
            }
        }
    }

    post {
        success {
            echo 'CI/CD Pipeline completed successfully!'
        }

        failure {
            echo 'CI/CD Pipeline failed. Check the Jenkins console output.'
        }
    }
}
