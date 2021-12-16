#!groovy

pipeline {
    agent {
        label "master"
    }
    triggers {
        cron('00 5 * * 1-5')
    }
    environment {
        ORG = 'home-limited'
        APP_NAME = 'SelenoidTest'
    }

    parameters {
        choice(name: 'TestSuite', choices: ['allTests'],
                description: 'Select test suite')
     }

    stages {
        stage('Run tests') {
            when {
                branch 'master'
            }
            steps {
                    sh "git checkout master"
                    sh "git config --global credential.helper store"
                    sh "mvn clean test -Dsuite=${params.TestSuite}"
            }
            post {
                always {
                    script {
                        step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
                    }
                }

                cleanup {
                    cleanWs()
                }
            }
        }
        stage('Build tests project') {
            when {
                not {
                    anyOf {
                        branch 'master'
                    }
                }
            }
            steps {
                container('maven') {
                    sh "git config --global credential.helper store"
                    sh "jx step git credentials"
                    sh 'mvn clean compile'
                }
            }
            post {
                always {
                    cleanWs()
                }
            }
        }
    }
}
