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
        var count = 0
        googleApp.forEach {
            if (it.company.contains("Google")) {
                count++
            }
        }
        return count
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
    fun finedTop10InstalledApps(listOfGooglePlayApp: MutableList<GooglePlayApp>): MutableList<String>? {
        val listOfAppName: MutableList<String> = mutableListOf()
        if(listOfGooglePlayApp.size > 9) {
            listOfGooglePlayApp.sortedByDescending { it.installs }.subList(0, 10).forEach {
                listOfAppName.add(it.appName)
            }
        }
        else{
            listOfGooglePlayApp.sortedByDescending { it.installs }.forEach {
                listOfAppName.add(it.appName)
            }
        }
        if(listOfAppName.size == 0)
            return null
        return listOfAppName
    }
}