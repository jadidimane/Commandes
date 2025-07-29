pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'Java 17'
    }

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=true"
        ALLURE_RESULTS_DIR = "${env.WORKSPACE}\\allure-results"
        ALLURE_REPORT_DIR = "${env.WORKSPACE}\\allure-report"
        echo "Chemin du workspace : ${env.WORKSPACE}"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/jadidimane/Commandes.git'
            }
        }
        stage('Clean Allure Results & Reports') {
            steps {
                bat '''
                    del /Q ${ALLURE_RESULTS_DIR}\\*.* >nul 2>&1
                    del /Q ${ALLURE_REPORT_DIR}\\*.* >nul 2>&1

                '''
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        /* stage('Download PDF') {
            steps {

                bat '''
                    if not exist target\\pdf-report mkdir target\\pdf-report
                    move /Y target\\generated-report\\rapport.pdf target\\pdf-report\\
                '''


            }
        } */

        stage('Allure Report') {
            steps {
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }

        stage('Publish JUnit Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo "Pipeline finished. You can check the test results above."
        }

        failure {
            echo "Pipeline failed — please review the logs."
        }
    }
}