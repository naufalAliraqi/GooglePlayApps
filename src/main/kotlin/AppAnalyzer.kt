import model.App
import utilities.calculatePercentage
import kotlin.math.roundToInt

class AppAnalyzer {

    //Refactor
    fun findAppDevelopedByGivenCompany(apps: List<App>, companyName: String?): Int =
        apps.count { app: App -> app.company.contains(companyName ?: "", true) }

    //Refactor
    fun findPercentageOfAppsByCategory(apps: List<App>, categoryName: String): Double? =
        if (apps.isNotEmpty() && categoryName.isNotEmpty()) {
            apps.count { it.category.contains(categoryName.trim(), true) }.calculatePercentage(apps.size) }
        else {null}

    //Refactor
    fun findOldestApp(apps: List<App>): App? =
        if (apps.isNotEmpty()) { apps.minByOrNull { selector -> selector.updated } }
        else { null }

    //Refactor
    fun findPercentageOfAppRunningOnSpecificAndroid(apps: List<App>, version: Double): Double? =
        apps.count { count-> count.requiresAndroid != null && count.requiresAndroid == version }.calculatePercentage(apps.size)


    // I can't refactor this function more than that😦😦😦😦 sorrrrrrrrrrrrrrrrrrrrrry
    fun findLargestApps(app: MutableList<App>,rankSize:Int?): List<App>? =
        app.asSequence().sortedByDescending { sortedData-> sortedData.size }.map {app-> app }.take(rankSize?:0).toList()?:null

    //Replace
    fun topAppInstall(apps: List<App>, size: Int?): List<String>? =
        if (apps.isNotEmpty()) {
            apps.asSequence()
                .sortedByDescending { dataSorted -> dataSorted.installs }
                .map { data -> data.appName }
                .take(size ?: 0)
                .toList() }
        else { null }

}
