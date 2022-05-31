package datasource

import model.App
import utilities.*

open class CSVDataSource(private var fileName: String = Constant.FILE_NAME): DataSource {

    private var csvReader = CSVReader()

    override fun getAllApps(): List<App> {
        val apps = mutableListOf<App>()

        csvReader.getTableRows(fileName)?.forEach{ line->
            val appStr = line.split(",")
            apps.add(
                App(
                    appName = appStr[Constant.ColumnIndex.APP_NAME],
                    company = appStr[Constant.ColumnIndex.COMPANY],
                    category = appStr[Constant.ColumnIndex.CATEGORY],
                    updated = appStr[Constant.ColumnIndex.UPDATE_DATE].stringToDate(),
                    size = appStr[Constant.ColumnIndex.SIZE].megaByteConverter(),
                    installs = appStr[Constant.ColumnIndex.INSTALLS].toLong(),
                    requiresAndroid = appStr[Constant.ColumnIndex.REQUIRED_ANDROID].convertToDouble(),
                )
            )
        }
        return apps.distinctBy { Pair(it.appName, it.company)}
    }

}