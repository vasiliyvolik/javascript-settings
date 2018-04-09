package JavaScript.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script


object JavaScript_03DeployToStaging : BuildType({
    uuid = "105ca106-8f8a-41a0-aec4-1719c16787bd"
    id = "JavaScript_03DeployToStaging"
    name = "03. Deploy to Staging"

    vcs {
        root(JavaScript.vcsRoots.JavaScript_HttpsGithubComG0t4teamcityCourseCards)

    }

    steps {
        script {
            name = "IIS Deploy"
            id = "RUNNER_6"
            scriptContent = """
mkdir /S /Q /interpub/wwwroot
xcopy /S /I /Y app /interpub/wwwroot
			"""
        }
    }


    dependencies {
        dependency(JavaScript.buildTypes.JavaScript_02Firefox) {
            snapshot {
            }
        }
        dependency(JavaScript.buildTypes.JavaScript_JavaScript02Chrome) {
            snapshot {
            }
        }
        dependency(JavaScript.buildTypes.JavaScript_02IE) {
            snapshot {
            }
        }
    }

    triggers {
        vcs {
            id = "vcsTrigger"
        }
    }

})
