pipeline {
    agent { label 'one' }  // Restrict the job to run on a node with the specified label

    stages {
        // stage('Check out') {
        //     steps {
        //         echo "Checking out from GitHub and cloning..."
        //         git credentialsId: 'GITHUB', url: 'https://github.com/GowthamReddy-E/OrangeHRM_Automation.git'
        //     }
        // }
        // stage('Test') {
        //    steps {
        //        echo 'Testing...'
        //        sh 'mvn clean test'
        //    }
        //}
        stage('Build') {
            steps {
                echo 'Building...'
                sh 'mvn clean package'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add deployment steps as needed
            }
        }
    }
}
