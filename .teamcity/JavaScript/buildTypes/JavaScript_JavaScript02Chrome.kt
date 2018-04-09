package JavaScript.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*

object JavaScript_JavaScript02Chrome : BuildType({
    template(JavaScript.buildTypes.JavaScript_Template)
    uuid = "b4d99251-dcdc-41bf-a66f-9ad8b69812a5"
    id = "JavaScript_JavaScript02Chrome"
    name = "02. Chrome"

    params {
        param("Browser", "Chrome")
    }

    dependencies {
        dependency(JavaScript.buildTypes.JavaScript_01FastTests) {
            snapshot {
            }
        }
    }
})
