pipeline {
    agent any
    parameters {
        booleanParam(name: 'HEADLESS', defaultValue: true, description: 'Headless browser')
    }
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/Kuznikit/SauceDemo.git'
                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"
                // To run Maven on a Windows agent, use
                 bat "mvn clean test"
            }
        }
        stage('reports') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                         jdk: '',
                        properties: [],
                         reportBuildPolicy: 'ALWAYS',
                         results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }

    }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
}
