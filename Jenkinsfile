#!/usr/bin/env groovy

node('node'){

    stage 'Checkout SCM'

        checkout scm

    stage 'Build Jar'

        sh "gradle assemble -pBranch=${env.BRANCH_NAME}"

}