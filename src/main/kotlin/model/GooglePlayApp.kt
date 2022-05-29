package model

import java.time.LocalDate

class GooglePlayApp(
    var appName: String,
    var company: String,
    var category: String,
    var updated: LocalDate,
    var size: Double,
    var installs: Long,
    var requiresAndroid: String,
) {
}