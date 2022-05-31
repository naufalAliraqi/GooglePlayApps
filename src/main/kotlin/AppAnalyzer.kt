import model.App
import kotlin.math.roundToInt

class AppAnalyzer {

    //Refactor
    fun findAppDevelopedByGivenCompany(apps: List<App>, companyName: String?): Int =
        apps.count { app: App -> app.company.contains(companyName ?: "", true) }

    //Refactor
    fun findPercentageOfAppsByCategory(apps: List<App>, categoryName: String?): Double? =
        if (apps.isNotEmpty() && !categoryName.isNullOrBlank()) {
            apps.count { app: App -> app.category.contains(categoryName, true) }
                .also { count: Int -> (((count * 1.0 / apps.size) * 100) * 10).roundToInt() / 10 }.toDouble() }
        else { null }

    //Refactor
    fun findOldestApp(apps: List<App>): App? =
        if (apps.isNotEmpty()) { apps.minByOrNull { selector -> selector.updated } }
        else { null }

    //Refactor
    fun findPercentageOfAppRunningOnSpecificAndroid(apps: List<App>, androidVersion: Double): Double? =
        if (apps.isNotEmpty() && !androidVersion.isNaN()) {
            apps.count { app: App -> app.requiresAndroid == androidVersion }
                .also { count: Int -> (((count * 1.0 / apps.size) * 100) * 10).roundToInt() / 10 }.toDouble() }
        else { null }


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
