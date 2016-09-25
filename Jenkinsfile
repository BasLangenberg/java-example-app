#!/usr/bin/env groovy

node('swarm'){

    stage 'Checkout SCM'

        checkout scm

    stage 'Build Jar'

        sh "./gradlew assemble"

    stage 'Stop containers (optionally)'

        sh "bash Docker/cleanup.sh ${env.BRANCH_NAME}"

    stage 'Build Container'

        sh "cp build/libs/dockerdemo*.jar Docker/"
        sh "docker build -t ${env.BRANCH_NAME}-java-example-app-${env.BUILD_NUMBER} ./Docker/"

    stage 'Start Containers'

        sh "echo disabled for now"

}
