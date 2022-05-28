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
    fun finedAppDevelopedByGoogle(googleApp: MutableList<GooglePlayApp>): Int {
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
        return (countofmedicalapp / countofallapps) * 100


    }

    fun findOldestApp(googleApp: MutableList<GooglePlayApp>): String {
        var oldestApp = googleApp[0]
        googleApp.forEach {
            if (it.updated < oldestApp.updated) {
                oldestApp = it
            }
        }
        return oldestApp.appName
    }
}

fun finedPercentageOfAppRunningOnAndroid9AndUp(App_perc: MutableList<GooglePlayApp>): Int {
    var count = 0
    App_perc.forEach {
        if (it.requiresAndroid.contains("9 and up")) {
            count++
        }
    }
    return (App_perc.size / count) * 100


}

fun finedLargest10App(listOfGooglePlayApp: MutableList<GooglePlayApp>): MutableList<String>? {
    val listOfAppName: MutableList<String> = mutableListOf()
    if (listOfGooglePlayApp.size > 9) {
        listOfGooglePlayApp.sortedByDescending { it.size }.subList(0, 10).forEach {
            listOfAppName.add(it.appName)
        }
    } else {
        listOfGooglePlayApp.sortedByDescending { it.size }.forEach {
            listOfAppName.add(it.appName)
        }
    }
    if (listOfAppName.size == 0)
        return null
    return listOfAppName
}


fun finedTop10InstalledApps(listOfGooglePlayApp: MutableList<GooglePlayApp>): MutableList<String>? {
    val listOfAppName: MutableList<String> = mutableListOf()
    if (listOfGooglePlayApp.size > 9) {
        listOfGooglePlayApp.sortedByDescending { it.installs }.subList(0, 10).forEach {
            listOfAppName.add(it.appName)
        }
    } else {
        listOfGooglePlayApp.sortedByDescending { it.installs }.forEach {
            listOfAppName.add(it.appName)
        }
    }
    if (listOfAppName.size == 0)
        return null
    return listOfAppName
}
