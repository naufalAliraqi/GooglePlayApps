import model.App
import utilities.*
import java.io.File

class CSVParser {
    private val file = File(Constant.FILE_NAME)

    fun parseCSV(): MutableList<App> {
        val apps = mutableListOf<App>()
        file.forEachLine {
            val tableRow = it.split(",")
            apps.add(
                App(
                    appName = tableRow[Constant.ColumnIndex.APP_NAME],
                    company = tableRow[Constant.ColumnIndex.COMPANY],
                    category = tableRow[Constant.ColumnIndex.CATEGORY],
                    updated = stringToDate(tableRow[Constant.ColumnIndex.UPDATE_DATE]),
                    size = megaByteConverter(tableRow[Constant.ColumnIndex.SIZE]),
                    installs = stringToLongNum(tableRow[Constant.ColumnIndex.INSTALLS]),
                    requiresAndroid = convertToDouble(tableRow[Constant.ColumnIndex.REQUIRED_ANDROID]),
                )
            )
        }
        return apps.distinctBy { Pair(it.appName, it.company)} as MutableList<App>
    }
}