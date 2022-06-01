import model.App

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

    //Refactor
    fun findLargestApps(app: List<App>,rankSize:Int): List<App>? {
        if (app.isEmpty()||rankSize> app.size)
            return null
        return app.sortedByDescending { it.size }.toList().take(rankSize)
    }

    //Replace
    fun topAppInstall(apps: List<App>, size: Int?): List<String>? {
       return if (apps.isNotEmpty()) {
            apps.asSequence()
                .sortedByDescending { dataSorted -> dataSorted.installs }
                .map { data -> data.appName }
                .take(size ?: 0)
                .toList() }
        else { null }
    }

    private fun Int.calculatePercentage(divisor:Int):Double? =
        if (divisor!=0){ String.format("%.1f", 100.0 * this.div(divisor.toDouble())).toDouble() } else { null }

}
