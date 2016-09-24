#!/usr/bin/env groovy

node('swarm'){

    stage 'Checkout SCM'

        checkout scm

    stage 'Build Jar'

        sh "./gradlew assemble"

}