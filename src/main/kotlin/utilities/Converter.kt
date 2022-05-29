package utilities

import java.time.LocalDate
import java.time.format.DateTimeFormatter

//will change all this to extension

fun convertToDouble(version:String):Double? = version.split(" ").first().toDoubleOrNull()

// convert from String to Date
fun stringToDate(value: String): LocalDate {
    return LocalDate.parse(value, DateTimeFormatter.ofPattern(Constant.DATE_FORMAT))
}

// convert from GB or KB to MB
fun megaByteConverter(value: String): Double {
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

// convert from String to Long Number
fun stringToLongNum(value: String): Long {
    return value.toLong()
}