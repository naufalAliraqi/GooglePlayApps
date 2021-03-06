import model.GooglePlayApp
import kotlin.math.roundToInt

class AppAnalyzer {

    // region functions findAppDevelopedByGoogle
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
    fun findAppDevelopedByGoogle(googleApp: MutableList<GooglePlayApp>): Int {
        var count = 0
        googleApp.forEach {
            if (it.company.contains("Google")) {
                count++
            }
        }
        return count
    }

    // endregion

    fun findPercentageOfMedicalApps(googleApp: MutableList<GooglePlayApp>): Double {
        var countofmedicalapp = 0
        var countofallapps = 0
        if (googleApp.size == 0)
            return  0.0
        googleApp.forEach {
            if (it.category.contains("Medical")) {
                countofmedicalapp++
            }
            countofallapps++
        }
        return (((countofmedicalapp * 1.0 / countofallapps) * 100) * 10).roundToInt() / 10.0


    }

    fun findOldestApp(googleApp: MutableList<GooglePlayApp>): String? {
        return if (googleApp.isEmpty()) {
            null
        } else {
            var oldestApp = googleApp[0]
            googleApp.forEach {
                if (it.updated < oldestApp.updated) {
                    oldestApp = it
                }
            }
            oldestApp.appName
        }
    }

    //
    fun findPercentageOfAppRunningOnAndroid9AndUp(App_perc: MutableList<GooglePlayApp>): Double {
        var count = 0
        if (App_perc.size == 0)
            return 0.0
        App_perc.forEach {
            if (it.requiresAndroid.contains("9 and up")) {
                count++
            }
        }
        return (((count * 1.0 / App_perc.size) * 100) * 10).roundToInt() / 10.0
    }

    fun findLargest10App(listOfGooglePlayApp: MutableList<GooglePlayApp>): MutableList<String>? {
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


    fun findTop10InstalledApps(listOfGooglePlayApp: MutableList<GooglePlayApp>): MutableList<String>? {
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
}
