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
    fun should_ReturnTop10InstalledAppName_When_TheListOfAppsIsCorrectAndContainsMoreThan9Apps() {
        // given list of google play apps have 15 element
        val googlePlayAppList : MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(GooglePlayApp("Jewel Blast : Temple", "SUPERBOX.Inc", "Puzzle",
            LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0,1000,
            "4.4 and up"))
        googlePlayAppList.add(GooglePlayApp("FOX 4 Dallas-Fort Worth: Weather", "Fox Television Stations Inc.",
            "Weather", LocalDate.parse("March 27 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            51.0,2000,"8.0 and up"))
        googlePlayAppList.add(GooglePlayApp("Eyes : Nonogram","GAMEFOX", "Puzzle",
            LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            51.0,1500,"5.0 and up"))
        googlePlayAppList.add(GooglePlayApp("Real Drift Car Racing","Real Games srls","Racing",
            LocalDate.parse("March 26 2021", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            51.0,500,"4.1 and up"))
        googlePlayAppList.add(GooglePlayApp("Slice: Pizza Delivery-Pick Up","Slice Pizza App","Food & Drink",
            LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            51.0,2500,"7.0 and up"))
        googlePlayAppList.add(GooglePlayApp("Angel Saga: Hero Action RPG","Alchemist Games Inc.","Action",
            LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            58.0,200,"5.0 and up"))
        googlePlayAppList.add(GooglePlayApp("Crazy Pusher","Borg Studio","Casino",
            LocalDate.parse("March 25 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            52.0,3000,"4.1 and up"))
        googlePlayAppList.add(GooglePlayApp("Baby Game for 2 3 4 Year Old","IDZ Digital Private Limited","Educational",
            LocalDate.parse("March 9 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            52.0,2800,"5.2 and up"))
        googlePlayAppList.add(GooglePlayApp("Garage Master - games for kids","KIN GO GAMES FOR KIDS AND TODDLERS","Educational",
            LocalDate.parse("March 15 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            52.0,2600,"4.1 and up"))
        googlePlayAppList.add(GooglePlayApp("Manta: Comics & Graphic Novels","RIDI Corporation","Comics",
            LocalDate.parse("May 16 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            52.0,2300,"5.0 and up"))
        googlePlayAppList.add(GooglePlayApp("Sago Mini School (Kids 2-5)","Sago Mini","Education",
            LocalDate.parse("February 24 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            52.0,800,"4.4 and up"))
        googlePlayAppList.add(GooglePlayApp("Rolling Luck: Win Real Money","Shape Keeper Ltd","Casino",
            LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            52.0,1100,"5.0 and up"))
        googlePlayAppList.add(GooglePlayApp("StyleSeat: Book Hair & Beauty","Styleseat","Beauty",
            LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            54.0,2300,"5.1 and up"))
        googlePlayAppList.add(GooglePlayApp("Dinosaur Airport:Game for kids","Yateland - Learning Games For Kids","Educational",
            LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            21.0,4000,"4.1 and up"))
        googlePlayAppList.add(GooglePlayApp("myAudi","Audi","Auto & Vehicles",
            LocalDate.parse("May 10 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            53.0,1250,"8.0 and up"))

        // when find the top 10 installed apps name
        val result = appAnalyzer.finedTop10InstalledApps(googlePlayAppList)
        // then
        assertEquals(mutableListOf("Dinosaur Airport:Game for kids", "Crazy Pusher", "Baby Game for 2 3 4 Year Old", "Garage Master - games for kids",
            "Slice: Pizza Delivery-Pick Up", "Manta: Comics & Graphic Novels", "StyleSeat: Book Hair & Beauty", "FOX 4 Dallas-Fort Worth: Weather",
            "Eyes : Nonogram", "myAudi"), result)
    }

    @Test
    fun should_ReturnAllElementAppName_When_TheListOfAppsIsCorrectAndContainsLiseThan10Apps() {
        // given list of google play apps have 5 element
        val googlePlayAppList : MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(GooglePlayApp("Slice: Pizza Delivery-Pick Up","Slice Pizza App","Food & Drink",
            LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            51.0,2500,"7.0 and up"))
        googlePlayAppList.add(GooglePlayApp("Crazy Pusher","Borg Studio","Casino",
            LocalDate.parse("March 25 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            52.0,3000,"4.1 and up"))
        googlePlayAppList.add(GooglePlayApp("Baby Game for 2 3 4 Year Old","IDZ Digital Private Limited","Educational",
            LocalDate.parse("March 9 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            52.0,2800,"5.2 and up"))
        googlePlayAppList.add(GooglePlayApp("Garage Master - games for kids","KIN GO GAMES FOR KIDS AND TODDLERS","Educational",
            LocalDate.parse("March 15 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            52.0,2600,"4.1 and up"))
        googlePlayAppList.add(GooglePlayApp("Dinosaur Airport:Game for kids","Yateland - Learning Games For Kids","Educational",
            LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
            21.0,4000,"4.1 and up"))

        // when find the top installed apps name
        val result = appAnalyzer.finedTop10InstalledApps(googlePlayAppList)
        // then
        assertEquals(mutableListOf("Dinosaur Airport:Game for kids", "Crazy Pusher", "Baby Game for 2 3 4 Year Old", "Garage Master - games for kids",
            "Slice: Pizza Delivery-Pick Up"), result)
    }

    @Test
    fun should_ReturnNullValue_When_TheListOfAppsIsEmpty() {
        // given list of google play apps have 5 element
        val googlePlayAppList : MutableList<GooglePlayApp> = mutableListOf()

        // when find the top installed apps name
        val result = appAnalyzer.finedTop10InstalledApps(googlePlayAppList)
        // then
        assertNull(result)
    }
}