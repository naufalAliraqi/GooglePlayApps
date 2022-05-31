package datasource

import java.io.File

class CSVReader {

    fun getTableRows(fileName:String):List<String>?{
        val tableRows = mutableListOf<String>()
         File(fileName).apply {
            if (this.exists()){
                this.forEachLine { row ->
                    tableRows.add(row )
                }
            }else
                return null
        }
        return tableRows
    }
}