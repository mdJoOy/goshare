def gv
pipeline {
        agent any
        stages {
                stage(init) {
                        steps {
                            script {
                                echo 'loading the script'
                                gv = load 'script.groovy' 
                            }
                        }
                    }
                stage(test) {
                    steps {
                        script {
                            gv.testApp()
                        }
                    }
                    }
                stage(build) {
                         when {
                            expression {
                                    BRANCH_NAME == 'main'
                                }
                        }
                    steps { 
                        script {
                            gv.buildApp()
                        }

                    }
                    }
                stage(deploy) {
                        when {
                            expression {
                                    BRANCH_NAME == 'main'
                                }
                        }
                        steps {
                            script {
                                gv.deployApp()
                            }
                        }
                    }
            }
    }
