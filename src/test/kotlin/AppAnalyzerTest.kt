import model.GooglePlayApp
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AppAnalyzerTest {

    lateinit var appAnalyzer: AppAnalyzer

    @BeforeAll
    fun setup(){
        appAnalyzer = AppAnalyzer()
    }

    @Test
    fun should_ReturnNumber1_When_HaveListWith1App() {
        // given list contain one "Google" word
        val googlePlayAppList : MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(GooglePlayApp("Jewel Blast : Temple", "Google", "Puzzle",
            LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0,1000,
            "4.4 and up"))
        // when calculate number of Apps
        val numberOfApps = appAnalyzer.finedAppDevelopedByGoogle(googlePlayAppList)
        // then check the result
        assertEquals(1, numberOfApps)
    }

    @Test
    fun should_ReturnZero_When_HaveListDoesntContainApp() {
        // given list that doesn't contain the word Google
        val googlePlayAppList : MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(GooglePlayApp("Jewel Blast : Temple", "Hutch Games", "Puzzle",
            LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0,1000,
            "4.4 and up"))
        // when calculate number of Apps
        val numberOfApps = appAnalyzer.finedAppDevelopedByGoogle(googlePlayAppList)
        // then check the result
        assertEquals(0, numberOfApps)
    }

    @Test
    fun should_ReturnZero_When_HaveNullList() {
        // given null list
        val googlePlayAppList : MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(GooglePlayApp("Jewel Blast : Temple", "", "Puzzle",
            LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0,1000,
            "4.4 and up"))
        // when calculate number of Apps
        val numberOfApps = appAnalyzer.finedAppDevelopedByGoogle(googlePlayAppList)
        // then check the result
        assertEquals(0, numberOfApps)
    }

    @Test
    fun finedPercentageOfMedicalApp() {
    }

    @Test
    fun finedOldestApp() {
    }

    @Test
    fun finedPercentageOfAppRunningOnAndroid9AndUp() {
    }

    @Test
    fun finedLargest10App() {
    }

    @Test
    fun finedTop10InstalledApp() {
    }
}