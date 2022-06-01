package datasource

import model.App
import utilities.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.pow

open class CSVDataSource(private var fileName: String = Constant.FILE_NAME): DataSource {

    override fun getAllApps(): List<App> {
        val csvReader = CSVReader()
        val apps = mutableListOf<App>()
        csvReader.getTableRows(fileName)?.forEach{ line->
            apps.add(parseStringToApp(line))
        }
        return apps.distinctBy {app-> Pair(app.appName, app.company)}
    }

    private fun parseStringToApp(appStr:String):App{
        val appFields = appStr.split(",")

       return App(appName = appFields[Constant.ColumnIndex.APP_NAME],
            company = appFields[Constant.ColumnIndex.COMPANY],
            category = appFields[Constant.ColumnIndex.CATEGORY],
            updated = appFields[Constant.ColumnIndex.UPDATE_DATE].stringToDate(),
            size = appFields[Constant.ColumnIndex.SIZE].megaByteConverter(),
            installs = appFields[Constant.ColumnIndex.INSTALLS].toLong(),
            requiresAndroid = appFields[Constant.ColumnIndex.REQUIRED_ANDROID].convertToDouble(),)
    }

    private fun String.convertToDouble():Double? = this.split(" ").first().toDoubleOrNull()

    fun String.stringToDate(): Date? {
        return SimpleDateFormat(Constant.DATE_FORMAT).parse(this)
    }

    private fun String.megaByteConverter(): Long?{
        var result = ""
        for (c in this){
            result += if (c.isDigit())
                c
            else if ( c == '.' && !result.contains("."))
                c
            else if ( c == '.' && result.contains("."))
                return null
            else break
        }
        val value = result.toDoubleOrNull()
        if (value!= null) {
            return when(this.last()) {
                'K','k' ->  (value*Constant.KILO_BYTE).toLong()
                'M','m' -> (value*Constant.KILO_BYTE.pow(2)).toLong()
                'G','g' -> (value*Constant.KILO_BYTE.pow(3)).toLong()
                else -> null
            }
        }
        return null
    }

}