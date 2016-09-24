#!/usr/bin/env groovy

node('swarm'){

    stage 'Checkout SCM'

        checkout scm

    stage 'Build Jar'

        sh "./gradlew assemble"

    stage 'Stop containers (optionally)'

        sh 'echo disabled for now'

    stage 'Build Container'

        sh "cp build/libs/dockerdemo*.jar Docker/"
        sh "docker build -t ${BRANCH_NAME}-java-example-app ./Docker/"

    stage 'Start Containers'

        sh "echo disabled for now"

}
