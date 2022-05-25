import model.GooglePlayApp
import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CSVParser {
    private val file = File("src/main/google_play.csv")
    var googlePlayApps = mutableListOf<GooglePlayApp>()
        private set

    fun parseCSV() {
        file.forEachLine {
            val apps = it.split(",")
            googlePlayApps.add(
                GooglePlayApp(
                    appName = apps[0],
                    company = apps[1],
                    category = apps[2],
                    updated = stringToDate(apps[3]),
                    size = megaByteConverter(apps[4]),
                    installs = stringToLongNum(apps[5]),
                    requiresAndroid = arrangeRequiresAndroidData(apps[7]),
                )
            )
        }
        googlePlayApps.forEach {
            println(it.size)
        }
    }

    // convert from String to Date
    private fun stringToDate(value: String): LocalDate {
        return LocalDate.parse(value, DateTimeFormatter.ofPattern("MMMM d yyyy"))
    }

    // convert from String to Long Number
    private fun stringToLongNum(value: String): Long {
        return value.toLong()
    }

    // remove Varies with device from data
    private fun arrangeRequiresAndroidData(value: String): String {
        if (value == "Varies with device") return value.replace("Varies with device", "")
        return value
    }


    // convert from GB or KB to MB
    private fun megaByteConverter(value: String): Double {
        var size = 0.0
        // 1. check if it is (Varies with device) return 0
        if (value == "Varies with device") return size
        // 2. check if megabytes then remove it and convert to double
        if (value.contains("M")) {
            size = value.replace("M", "").toDouble()
            // 3. check if kilobytes then remove it and convert to megabyte double
        } else if (value.contains("k")) {
            size = value.replace("k", "").toDouble() / 1024.0
            // 4. check if gigabyte then remove it and convert to megabyte double
        } else if (value.contains("G")) {
            size = value.replace("G", "").toDouble() * 1024.0
        }
        return size
    }
}