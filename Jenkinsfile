#!/usr/bin/env groovy

node('swarm'){

    stage 'Checkout SCM'

        checkout scm

    stage 'Build Jar'

        sh "./gradlew assemble"

    stage 'Stop containers (optionally)'

        sh "docker service rm ${env.BRANCH_NAME}-java-example-app || true"

    stage 'Build Container'

        sh "cp build/libs/dockerdemo*.jar Docker/"
        sh "docker build -t ${env.BRANCH_NAME}-java-example-app-${env.BUILD_NUMBER} ./Docker/"
        sh "docker tag ${env.BRANCH_NAME}-java-example-app-${env.BUILD_NUMBER} swarm.brycks.nl:5000/${env.BRANCH_NAME}-java-example-app-${env.BUILD_NUMBER}"

    stage 'Start Containers'

        sh "docker service create --name ${env.BRANCH_NAME}-java-example-app --mode global swarm.brycks.nl:5000/${env.BRANCH_NAME}-java-example-app-${env.BUILD_NUMBER}"

}
