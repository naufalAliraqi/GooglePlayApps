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
    fun finedPercentageOfAppRunningOnAndroid9AndUp(PercAPP:MutableList<GooglePlayApp>): Int {
        run {

            var count = 0

            PercAPP.forEach {
                if (it.requiresAndroid.contains("9 to up ")) {
                    count++
                }
            }
            return (PercAPP.size / count) * 100

        }
        fun finedLargest10App() {


        }

        fun finedTop10InstalledApp() {


        }

    }}