package datasource

import model.App
import utilities.*

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
}