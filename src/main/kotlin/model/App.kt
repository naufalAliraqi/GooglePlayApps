package model

import java.time.LocalDate

data class App(
    var appName: String,
    var company: String,
    var category: String,
    var updated: LocalDate,
    var size: Double,
    var installs: Long,
    var requiresAndroid: Double?,
){
    override fun toString() = "App Name is: $appName"
}