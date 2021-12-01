#!groovy

pipeline {
    agent {
        label "jenkins-maven-java11"
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
                container('maven') {
                    sh "git checkout master"
                    sh "git config --global credential.helper store"
                    sh "jx step git credentials"
                    sh "mvn clean test -Dsuite=${params.TestSuite}"
                }
            }
            post {
                always {
                    script {
                        step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
                    }
                }
//                 success {
//                     slackSend message: "Build finished :tada:" +
//                             "\n BO UI/API AUTOTESTS - Auto Test Run (<${env.TEST_RESULT.readLines().get(2)}|Open>)" +
//                             "\n Test Suite - ${params.TestSuite}" +
//                             "\n ${env.TEST_RESULT.readLines().get(0)}" +
//                             "\n ${env.TEST_RESULT.readLines().get(1)}" +
//                             "\n (<${env.BUILD_URL}testngreports/|Open report>)",
//                             color: "good",
//                             channel: "dev-qa-autotests"
//                 }
//                 failure {
//                     slackSend message: "FAILED!!! :no_entry:" +
//                             "\n BO UI/API AUTOTESTS - Auto Test Run (<${env.TEST_RESULT.readLines().get(2)}|Open>)" +
//                             "\n Test Suite - ${params.TestSuite}" +
//                             "\n ${env.TEST_RESULT.readLines().get(0)}" +
//                             "\n ${env.TEST_RESULT.readLines().get(1)}" +
//                             "\n (<${env.BUILD_URL}testngreports/|Open report>)",
//                             color: "danger",
//                             channel: "dev-qa-autotests"
//                 }
//                 unstable {
//                     slackSend message: "Build finished :man-shrugging:" +
//                             "\n BO UI/API AUTOTESTS - Auto Test Run (<${env.TEST_RESULT.readLines().get(2)}|Open>)" +
//                             "\n Test Suite - ${params.TestSuite}" +
//                             "\n ${env.TEST_RESULT.readLines().get(0)}" +
//                             "\n ${env.TEST_RESULT.readLines().get(1)}" +
//                             "\n (<${env.BUILD_URL}testngreports/|Open report>)",
//                             color: "warning",
//                             channel: "dev-qa-autotests"
//                 }
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
