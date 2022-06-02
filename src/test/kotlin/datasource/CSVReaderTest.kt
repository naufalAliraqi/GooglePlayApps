package datasource

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CSVReaderTest {

    private lateinit var csvReader: CSVReader

    @BeforeAll
    fun setup() {
        csvReader = CSVReader()
    }

    @Test
    fun should_ReturnNull_When_FileNotFound() {
        // given a not found file
        val fileName ="NotFoundFile"
        // when try open the file
        val result = csvReader.getTableRows(fileName)
        // then check
        assertNull( result)
    }

    @Test
    fun should_ReturnListOfAppsAsString_When_CorrectFileNameWithoutSuffix() {
        // given correct file name
        val fileName ="google_play"
        // when try open the file
        val result = csvReader.getTableRows(fileName)
        // then check
        assertFalse(result.isNullOrEmpty())
    }

    @Test
    fun should_ReturnListOfAppsAsString_When_CorrectFileNameWithSuffix() {
        // given correct file name
        val fileName ="google_play.csv"
        // when try open the file
        val result = csvReader.getTableRows(fileName)
        // then check
        assertFalse(result.isNullOrEmpty())
    }
}