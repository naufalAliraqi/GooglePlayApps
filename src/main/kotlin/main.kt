fun main() {
    val csvTest = CSVParser()

    val appAnalyzer = AppAnalyzer()

    val googlePlayAppList = csvTest.parseCSV()



     println("This is a develop by google " + appAnalyzer.findAppDevelopedByGivenCompany(googlePlayAppList,"Google") + " apps" )
     println("The percentage of Medical apps is " + appAnalyzer.findPercentageOfAppsByCategory(googlePlayAppList,"Medical") + "%")
     println("The oldest app in the dataset is " + appAnalyzer.findOldestApp(googlePlayAppList))
     println("The percentage of apps running on android 9 and up only is " + appAnalyzer.findPercentageOfAppRunningOnSpecificAndroid(googlePlayAppList,9.0) + "%")
     println("The largest 10 apps in the dataset are: ")
    println(appAnalyzer.findLargestApps(googlePlayAppList,10))
    println(appAnalyzer.findTopNumberInstalledApps(googlePlayAppList,10))






}

/*
private fun printInConsole(){
    // This code is just rudimentary and subject to modification
    do {
        println("1- how many apps were developed by Google in the dataset.")
        println("2- the percentage of Medical apps. ")
        println("3- what is the oldest app in the dataset. ")
        println("4- the percentage of apps running on android 9 and up only. ")
        println("5- what are the largest 10 apps in the dataset. ")
        println("6- what are the top 10 installed apps. ")
        println("7- exit")
        println("Please enter the number of the app you want to know more about: ")
        val inputToCheck = readLine()!!.toInt()
        when (inputToCheck) {
            1 -> println("This is a develop by google " + appAnalyzer.findAppDevelopedByGoogle(googlePlayAppList) + " apps" )
            2 -> println("The percentage of Medical apps is " + appAnalyzer.findPercentageOfMedicalApps(googlePlayAppList) + "%")
            3 -> println("The oldest app in the dataset is " + appAnalyzer.findOldestApp(googlePlayAppList))
            4 -> println("The percentage of apps running on android 9 and up only is " + appAnalyzer.findPercentageOfAppRunningOnSpecificAndroid(googlePlayAppList,9.0) + "%")
            5 -> {println("The largest 10 apps in the dataset are: ")
                println(appAnalyzer.findLargest10App(googlePlayAppList))}
            6 -> {println("The top 10 installed apps are: ")
                println(appAnalyzer.findTop10InstalledApps(googlePlayAppList))}
            7 -> println("Goodbye...")
            else -> println("Please enter a valid number")
        }
    }while (inputToCheck != 7)
}*/