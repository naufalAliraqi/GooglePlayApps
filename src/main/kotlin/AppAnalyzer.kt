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
        fun finedPercentageOfMedicalApps(googleApp: MutableList<GooglePlayApp>): Int {
            var countofmedicalapp = 0
            var countofallapps = 0
            googleApp.forEach {
                if (it.category.contains("Medical")) {
                    countofmedicalapp++
                }
                countofallapps++
            }
            return (countofmedicalapp/countofallapps)*100


    }
    fun finedOldestApp(){



    }
    fun finedPercentageOfAppRunningOnAndroid9AndUp(){



    }
    fun finedLargest10App(){



    }
    fun finedTop10InstalledApps(listOfGooglePlayApp: MutableList<GooglePlayApp>): List<String> {
        val listOfAppName: MutableList<String> = mutableListOf()
        listOfGooglePlayApp.sortedBy { it.installs }.subList(0, 9).forEach {
            listOfAppName.add(it.appName)
        }
        return listOfAppName
    }
}