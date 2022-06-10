pipeline {

    agent any
    def gradle = "./gradlew"
    stages {
        stage('Clean & Build') {
            steps {
                sh '${gradle} clean'
            }
        }

        stage("SonarQube analysis") {
            script{
                 withSonarQubeEnv("sonarServerTests") {
                     sh "./gradlew sonarqube"
                 }
            }
        }

        stage("Quality Gate"){
            script{
                timeout(time: 5, unit: 'MINUTES') {
                    def qg = waitForQualityGate()
                    if (qg.status != 'OK') {
                      error "Pipeline aborted due to quality gate failure: ${qg.status}"
                    }
                }
            }
        }

        stage('Tests') {
            steps {
                script {
                    try {
                        echo "########################################\n" +
                             "#                                      #\n" +
                             "#          EVIDENCIA DE TESTES         #\n" +
                             "#                                      #\n" +
                             "########################################\n"
                        sh "${gradle} test --info"
                        echo "########################################\n" +
                            "#                                      #\n" +
                            "#            FIM DOS TESTES            #\n" +
                            "#                                      #\n" +
                            "########################################\n"

                    } catch (err) {
                        echo err.message
                    }
                }
            }
        }
    }