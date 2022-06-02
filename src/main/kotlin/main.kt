import datasource.CSVDataSource
import datasource.DataSource

fun main() {

    val appAnalyzer= AppAnalyzer()

    val dataSource:DataSource = CSVDataSource()

    val appList = dataSource.getAllApps()

     println("This is a develop by google " + appAnalyzer.findAppDevelopedByGivenCompany(appList,"Google") + " apps" )
     println("The percentage of Medical apps is " + appAnalyzer.findPercentageOfAppsByCategory(appList,"Medical") + "%")
     println("The oldest app in the dataset is " + appAnalyzer.findOldestApp(appList))
     println("The percentage of apps running on android 9 and up only is " +
            " ${appAnalyzer.findPercentageOfAppRunningOnSpecificAndroid(appList,9.0)} %")
     println("The largest 10 apps in the dataset are: ${appAnalyzer.findLargestApps(appList,10)}")
    println(appAnalyzer.topAppInstall(appList,10))
    println("${appAnalyzer.getLargestAppSizeByCompanyName(appList,"Meta")}")
}
