import model.App
import utilities.Constant

class AppAnalyzer {

    //Refactor
    fun findAppDevelopedByGivenCompany(apps: List<App>, companyName: String): Int? {
        return if (apps.isNotEmpty() && companyName.isNotEmpty())
            apps.count { app: App -> app.company.contains(companyName.trim(), true) }
        else {
            null
        }
    }

    //Refactor
    fun findPercentageOfAppsByCategory(apps: List<App>, categoryName: String): Double? =
        if (apps.isNotEmpty() && categoryName.isNotEmpty()) {
            apps.count { it.category.contains(categoryName.trim(), true) }.calculatePercentage(apps.size)
        } else {
            null
        }

    //Refactor
    fun findOldestApp(apps: List<App>): App? =
        if (apps.isNotEmpty()) {
            apps.filterNot { app -> app.updated == null }.minByOrNull { selector -> selector.updated!! }
        } else {
            null
        }

    //Refactor
    fun findPercentageOfAppRunningOnSpecificAndroid(apps: List<App>, version: Double): Double? {
        return if (apps.isNotEmpty() && version >= Constant.MIN_COMPARE_INT ) {
            apps.count { count -> count.requiresAndroid != null && count.requiresAndroid == version }
                .calculatePercentage(apps.size)
        } else {
            null
        }
    }

    //Refactor
    fun findLargestApps(app: List<App>, rankSize: Int): List<App>? {
        return if (app.isNotEmpty() && rankSize in Constant.MIN_COMPARE_INT.. app.size  ) {
            app.sortedByDescending { it.size }.toList().take(rankSize)
        }else {null}
    }

    //Replace
    fun topAppInstall(apps: List<App>, size: Int): List<App>? {
        return if (apps.isNotEmpty() &&  size in Constant.MIN_COMPARE_INT..apps.size) {
            apps.sortedByDescending { dataSorted -> dataSorted.installs }
                .take(size)
                .toList()
        } else {
            null
        }
    }

    private fun Int.calculatePercentage(divisor: Int): Double? =
        if (divisor != 0) {
            String.format("%.1f", 100.0 * this.div(divisor.toDouble())).toDouble()
        } else {
            null
        }

}
