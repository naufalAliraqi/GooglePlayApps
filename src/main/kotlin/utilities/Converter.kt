package utilities

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.pow


fun Int.calculatePercentage(divisor: Int): Double? {
    return  if (divisor != 0) {
        String.format("%.1f", 100.0 * this.div(divisor.toDouble())).toDouble()
    } else {
        null
    }
}

fun String.convertToDouble(): Double? = this.split(" ").first().toDoubleOrNull()

fun String.stringToDate(): Date? {
    return SimpleDateFormat(Constant.DATE_FORMAT).parse(this)
}

fun String.megaByteConverter(): Long? {
    var result = ""
    for (c in this) {
        result += if (c.isDigit())
            c
        else if (c == '.' && !result.contains("."))
            c
        else if (c == '.' && result.contains("."))
            return null
        else break
    }
    val value = result.toDoubleOrNull()
    if (value != null) {
        return when (this.last()) {
            'K', 'k' -> (value * Constant.KILO_BYTE).toLong()
            'M', 'm' -> (value * Constant.KILO_BYTE.pow(2)).toLong()
            'G', 'g' -> (value * Constant.KILO_BYTE.pow(3)).toLong()
            else -> null
        }
    }
    return null
}