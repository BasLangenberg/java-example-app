#!/usr/bin/env groovy

node('swarm'){

    stage 'Checkout SCM'

        checkout scm

    stage 'Build Jar'

        sh "./gradlew assemble"

    stage 'Stop containers (optionally)'

        sh "docker service rm ${env.BRANCH_NAME}-java-example-app || true"
        sh "curl \"swarm.brycks.nl:8080/v1/docker-flow-proxy/remove?serviceName=${env.BRANCH_NAME}-java-example-app\""

    stage 'Build Container'

        sh "cp build/libs/dockerdemo*.jar Docker/"
        sh "docker build -t ${env.BRANCH_NAME}-java-example-app-${env.BUILD_NUMBER} ./Docker/"
        sh "docker tag ${env.BRANCH_NAME}-java-example-app-${env.BUILD_NUMBER} swarm.brycks.nl:5000/${env.BRANCH_NAME}-java-example-app-${env.BUILD_NUMBER}"
        sh "docker push swarm.brycks.nl:5000/${env.BRANCH_NAME}-java-example-app-${env.BUILD_NUMBER}" 

    stage 'Start Containers'

        sh "docker network create --driver overlay ${env.BRANCH_NAME}-java-example-app || true"
        sh "docker service create --name ${env.BRANCH_NAME}-java-example-app --network proxy --network ${env.BRANCH_NAME}-java-example-app  --mode global swarm.brycks.nl:5000/${env.BRANCH_NAME}-java-example-app-${env.BUILD_NUMBER}"
        sh "curl \"swarm.brycks.nl:8080/v1/docker-flow-proxy/reconfigure?serviceName=${env.BRANCH_NAME}-java-example-app&servicePath=/${env.BRANCH_NAME}&port=8080\""

}
