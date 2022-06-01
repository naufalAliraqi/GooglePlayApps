package model

import java.util.*

data class App(
    var appName: String,
    var company: String,
    var category: String,
    var updated: Date?,
    var size: Long?,
    var installs: Long,
    var requiresAndroid: Double?,
){
    override fun toString() =  appName
}