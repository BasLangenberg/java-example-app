#!/usr/bin/env groovy

node('master'){

    stage 'Checkout SCM'

        checkout scm

    stage 'Build Jar'

        sh "./gradlew assemble -pBranch=${env.BRANCH_NAME}"

}