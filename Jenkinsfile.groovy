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
            options {
                lock(label: 'swm1', quantity: 1, variable: 'SWM1');
            }
            steps {
                echo "Section: Verifying parameters"
                sh """
                    sleep 10
                    echo ${SWM1}
                """
            }
        }
    }
}