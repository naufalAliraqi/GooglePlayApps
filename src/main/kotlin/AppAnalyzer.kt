import model.GooglePlayApp

class AppAnalyzer {

    // region functions finedAppDevelopedByGoogle
    /**
     * @param googleApp This is a list of GooglePlayApp object
     * @return This method returns a list of GooglePlayApp object specific count
     * @author omar izziddeen
     * @version 1.0
     * @since 2022-05-26
     * @see GooglePlayApp
     * @see AppAnalyzer
     *
     */
    fun finedAppDevelopedByGoogle(googleApp: MutableList<GooglePlayApp>): Int{
        val listGoogleApps = mutableListOf<String>()
        googleApp.forEach {
            if (it.company.contains("Google")) {
                listGoogleApps.add(it.appName)
            }
        }
        return listGoogleApps.size
    }
    // endregion

    fun finedPercentageOfMedicalApp(){



    }
    fun finedOldestApp(){



    }
    fun finedPercentageOfAppRunningOnAndroid9AndUp(){



    }
    fun finedLargest10App(){



    }
    fun finedTop10InstalledApp(){



    }
}