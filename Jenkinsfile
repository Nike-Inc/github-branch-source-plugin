pipeline {
    agent {
        docker {
            image 'maven:latest'
            reuseNode true
        }
    }

    stages {
        stage('Clean Workspace') {
            steps {
              cleanWs() // Clean workspace
            }
        }
        stage('Clone Repository') {
            steps {
              sh 'git clone https://github.com/raphaelokere/github-branch-source-plugin.git'
              sh 'cd github-branch-source-plugin'
              sh 'git checkout credentials'
            }
        }

        stage('Build Plugin') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Install Plugin') {
            steps {
                script {
                    def pluginFile = findFiles(glob: 'target/*.hpi').get(0)
                    if (pluginFile != null) {
                        jenkins.installPlugin(pluginFile.path)
                        jenkins.restart()
                    } else {
                        error 'Plugin file not found'
                    }
                }
            }
        }
    }
}
