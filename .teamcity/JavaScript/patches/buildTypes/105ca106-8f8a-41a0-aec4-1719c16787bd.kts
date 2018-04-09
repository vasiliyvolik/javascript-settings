package JavaScript.patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2017_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with uuid = '105ca106-8f8a-41a0-aec4-1719c16787bd' (id = 'JavaScript_03DeployToStaging')
accordingly and delete the patch script.
*/
changeBuildType("105ca106-8f8a-41a0-aec4-1719c16787bd") {
    expectSteps {
        script {
            name = "IIS Deploy"
            scriptContent = """
                mkdir /S /Q /interpub/wwwroot
                xcopy /S /I /Y app /interpub/wwwroot
            """.trimIndent()
        }
    }
    steps {
        update<ScriptBuildStep>(0) {
            scriptContent = """
                rem mkdir /S /Q \interpub\wwwroot
                xcopy /S /I /Y app \interpub\wwwroot
            """.trimIndent()
        }
    }

    dependencies {
        remove("JavaScript_02IE") {
            snapshot {
            }
        }

    }
}
