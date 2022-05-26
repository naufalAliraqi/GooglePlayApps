fun main() {
    val csvTest = CSVParser()
    csvTest.parseCSV()

    val appAnalyzer = AppAnalyzer()

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
        when (readLine()!!.toInt()) {
            1 -> println("This is a develop by google " + appAnalyzer.finedAppDevelopedByGoogle(csvTest.googlePlayApps) + " apps" )
            2 -> println("The percentage of Medical apps is " + appAnalyzer.finedPercentageOfMedicalApp() + "%")
            3 -> println("The oldest app in the dataset is " + appAnalyzer.finedOldestApp())
            4 -> println("The percentage of apps running on android 9 and up only is " + appAnalyzer.finedPercentageOfAppRunningOnAndroid9AndUp() + "%")
            5 -> println("The largest 10 apps in the dataset are: " + appAnalyzer.finedLargest10App())
            6 -> println("The top 10 installed apps are: " + appAnalyzer.finedTop10InstalledApp())
            7 -> println("Goodbye...")
            else -> println("Please enter a valid number")
        }
    }while (readLine()!!.toInt() == 7)

}