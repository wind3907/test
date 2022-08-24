properties(
    [
        buildDiscarder(logRotator(numToKeepStr: '20')),
        parameters(
            [   
                string(name: 'PREFIX', defaultValue: 'lx', description: 'Host name prefix'),
            ]
        )
    ]
)
pipeline {
    agent { label 'master' }
    stages {
        stage('Test') {
            steps {
                echo "Section: Verifying parameters"
                sh """
                    echo "hi"
                """
            }
        }
        stage('Hello') {
            steps {
                echo "Section: Verifying parameters"
                sh """
                    echo "hi"
                """
            }
        }
    }
}