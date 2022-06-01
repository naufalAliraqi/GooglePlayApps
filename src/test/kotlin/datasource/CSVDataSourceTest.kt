package datasource

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable
import utilities.Constant
import java.text.SimpleDateFormat


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CSVDataSourceTest {

    lateinit var csvDataSource: CSVDataSource

    @BeforeAll
    fun setUp(){
        csvDataSource = CSVDataSource()
    }

    @Test
    fun should_ReturnDate_When_StringDateIsCorrectFormat(){
        // given correct string date
        val dateStr = "May 5 2022"
        csvDataSource.run {
            // when convert string date to date
            val dateResult = dateStr.stringToDate()
            //then check the correct convert to stringDate to object of Date
            val expected = SimpleDateFormat(Constant.DATE_FORMAT).parse("MAY 5 2022")
            assertEquals(expected,dateResult)
        }
    }

    @Test
    fun should_ThrowException_When_StringDateIsWrongFormat(){
        // given empty different format for the string date
        val date = "5 5 2022"
        csvDataSource.run {
            //when convert StringDate to date
            val wrongFormatException = Executable { date.stringToDate() }
            // then check the result should throw exception
            assertThrows(Exception::class.java, wrongFormatException)
        }
    }
}