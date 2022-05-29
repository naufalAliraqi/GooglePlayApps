import model.App
import kotlin.math.roundToInt

class AppAnalyzer {

    fun findAppDevelopedByGivenCompany(app: MutableList<App>, companyName:String): Int {
       return app.count { it.company.contains(companyName,true) }
    }

    fun findPercentageOfAppsByCategory(apps: MutableList<App>, categoryName:String): Double {
        if (apps.isEmpty())
            return  0.0
        val counterbalance = apps.count { it.category.contains(categoryName,true) }
        return (((counterbalance * 1.0 / apps.size) * 100) * 10).roundToInt() / 10.0
    }

    fun findOldestApp(apps: MutableList<App>): App? {
        return if (apps.isNotEmpty()) {
            apps.minByOrNull { it.updated }}
                else null
    }

    fun findPercentageOfAppRunningOnSpecificAndroid(apps: MutableList<App>, androidVersion:Double): Double {
        if (apps.isEmpty())
            return -1.0
        val count = apps.count { it.requiresAndroid == androidVersion}
        return (((count * 1.0 / apps.size) * 100) * 10).roundToInt() / 10.0
    }

    fun findLargestApps(app: MutableList<App>,rankSize:Int): MutableList<App>? {
        val listOfApp: MutableList<App> = mutableListOf()
        if (listOfApp.isEmpty())
            return null

        if (app.size > rankSize) {
            app.sortedByDescending { it.size }.subList(0, rankSize).forEach {
                listOfApp.add(it)
            }
        } else {
            app.sortedByDescending { it.size }.forEach {
                listOfApp.add(it)
            }
        }
        return listOfApp
    }

    fun findTopNumberInstalledApps(listOfGooglePlayApp: MutableList<App>, topNumber:Int): MutableList<App>? {
        val listOfApp: MutableList<App> = mutableListOf()
        if (listOfGooglePlayApp.size > topNumber) {
            listOfGooglePlayApp.sortedByDescending { it.installs }.subList(0, topNumber).forEach {
                listOfApp.add(it)
            }
        } else {
            listOfGooglePlayApp.sortedByDescending { it.installs }.forEach {
                listOfApp.add(it)
            }
        }
        if (listOfApp.size == 0)
            return null
        return listOfApp
    }
}
