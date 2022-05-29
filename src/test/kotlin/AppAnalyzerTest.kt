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
    fun setup() {
        appAnalyzer = AppAnalyzer()
    }

    // region test functions for findAppDevelopedByGoogle function
    @Test
    fun should_ReturnNumber1_When_HaveListWith1GoogleApp() {
        // given list contain one "Google" word
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(
            GooglePlayApp(
                "Jewel Blast : Temple", "Google", "Puzzle",
                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0, 1000,
                "4.4 and up"
            )
        )
        // when calculate number of Apps
        val numberOfApps = appAnalyzer.findAppDevelopedByGoogle(googlePlayAppList)
        // then check the result
        assertEquals(1, numberOfApps)
    }

    @Test
    fun should_ReturnZero_When_HaveListWithNoAnyGoogleApp() {
        // given list that doesn't contain the word Google
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(
            GooglePlayApp(
                "Jewel Blast : Temple", "Hutch Games", "Puzzle",
                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0, 1000,
                "4.4 and up"
            )
        )
        // when calculate number of Apps
        val numberOfApps = appAnalyzer.findAppDevelopedByGoogle(googlePlayAppList)
        // then check the result
        assertEquals(0, numberOfApps)
    }

    @Test
    fun should_ReturnZero_When_HaveNullList() {
        // given null list
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(
            GooglePlayApp(
                "Jewel Blast : Temple", "", "Puzzle",
                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0, 1000,
                "4.4 and up"
            )
        )
        // when calculate number of Apps
        val numberOfApps = appAnalyzer.findAppDevelopedByGoogle(googlePlayAppList)
        // then check the result
        assertEquals(0, numberOfApps)
    }

    // endregion

    // region test functions for findPercentageOfMedicalApps function
    @Test
    fun should_ReturnCorrectPercentageOfMedicalApps_When_HaveListOfMedicalAppsOnly() {
        // given list of apps with 100% medical apps
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(
            GooglePlayApp(
                "Medical Mnemonics", "Regular Rate and Rhythm Software", "Medical",
                LocalDate.parse("May 19 2011", DateTimeFormatter.ofPattern("MMMM d yyyy")), 0.362305, 1000,
                "1.6 and up"
            )
        )
        // when calculate percentage
        val percentage = appAnalyzer.findPercentageOfMedicalApps(googlePlayAppList)
        // then check the result
        assertEquals(100.0, percentage)
    }

    @Test
    fun should_ReturnCorrectPercentageOfMedicalApps_When_HaveListOfAppsWithMedicalApps() {
        // given list of apps with 50% medical apps
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(
            GooglePlayApp(
                "Medical Mnemonics", "Regular Rate and Rhythm Software", "Medical",
                LocalDate.parse("May 19 2011", DateTimeFormatter.ofPattern("MMMM d yyyy")), 0.362305, 1000,
                "1.6 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "FOX 4 Dallas-Fort Worth: Weather", "Fox Television Stations Inc.",
                "Weather", LocalDate.parse("March 27 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                51.0, 2000, "8.0 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Eyes : Nonogram","GAMEFOX", "Puzzle",
                LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                51.0,1500,"5.0 and up")
        )
        // when calculate percentage
        val percentage = appAnalyzer.findPercentageOfMedicalApps(googlePlayAppList)
        // then check the result
        assertEquals(33.3, percentage)
    }

    @Test
    fun should_ReturnZero_When_HaveListOfAppsWithOutMedicalApp() {
        // given list of apps with zero medical apps
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(
            GooglePlayApp(
                "Medical Mnemonics", "Regular Rate and Rhythm Software", "Photography",
                LocalDate.parse("May 19 2011", DateTimeFormatter.ofPattern("MMMM d yyyy")), 0.362305, 1000,
                "1.6 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "FOX 4 Dallas-Fort Worth: Weather", "Fox Television Stations Inc.",
                "Weather", LocalDate.parse("March 27 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                51.0, 2000, "8.0 and up"
            )
        )
        // when calculate percentage
        val percentage = appAnalyzer.findPercentageOfMedicalApps(googlePlayAppList)
        // then check the result
        assertEquals(0.0, percentage)
    }

    @Test
    fun should_ReturnZero_When_HaveEmptyList() {
        // given list of apps with zero medical apps
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()
        // when calculate percentage
        val percentage = appAnalyzer.findPercentageOfMedicalApps(googlePlayAppList)
        // then check the result
        assertEquals(0.0, percentage)
    }

    // endregion

    // region test functions for findOldestApp function
    @Test
    fun should_ReturnOlderApp_When_HaveListWithApp() {
        // given list contain one "Google" word
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(
            GooglePlayApp(
                "Medical Mnemonics", "Regular Rate and Rhythm Software", "Medical",
                LocalDate.parse("May 19 2011", DateTimeFormatter.ofPattern("MMMM d yyyy")), 0.362305, 1000,
                "1.6 and up"
            )
        )
        // when calculate number of Apps
        val olderApp = appAnalyzer.findOldestApp(googlePlayAppList)
        // then check the result
        assertEquals("Medical Mnemonics", olderApp)
    }

    @Test
    fun should_ReturnOlderApp_When_HaveListWithMultiApps() {
        // given list contain one "Google" word
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(
            GooglePlayApp(
                "Jewel Blast : Temple", "", "Puzzle",
                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0, 1000,
                "4.4 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "myAudi", "Audi", "Auto & Vehicles",
                LocalDate.parse("May 10 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                53.0, 1250, "8.0 and up"
            )
        )
        // when calculate number of Apps
        val olderApp = appAnalyzer.findOldestApp(googlePlayAppList)
        // then check the result
        assertEquals("Jewel Blast : Temple", olderApp)
    }

    @Test
    fun should_ReturnNull_When_HaveEmptyList() {
        // given list contain one "Google" word
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()
        // when calculate number of Apps
        val olderApp = appAnalyzer.findOldestApp(googlePlayAppList)
        // then check the result
        assertNull(olderApp)
    }

    // endregion

    // region test functions for findPercentageOfAppRunningOnAndroid9AndUp function
    @Test
    fun should_ReturnZero_When_NotAppRequiredAndroid9AndUp() {
        //given
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(
            GooglePlayApp(
                "Jewel Blast : Temple", "", "Puzzle",
                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0, 1000,
                "7 and up"
            )
        )

        //when
        val percentage = appAnalyzer.findPercentageOfAppRunningOnAndroid9AndUp(googlePlayAppList)

        //then
        assertEquals(0.0, percentage)
    }

    @Test
    fun should_ReturnCorrectPercentage_When_ListOfGoogleAppsHaveAppsRequiredAndroid9AndUp() {
        //given
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(
            GooglePlayApp(
                "Jewel Blast : Temple", "", "Puzzle",
                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0, 1000,
                "9 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Jewel Blast : Temple", "SUPERBOX.Inc", "Puzzle",
                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 0.02, 1000,
                "4.4 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "FOX 4 Dallas-Fort Worth: Weather", "Fox Television Stations Inc.",
                "Weather", LocalDate.parse("March 27 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                98.1, 2000, "8.0 and up"
            )
        )
        //when
        val percentage = appAnalyzer.findPercentageOfAppRunningOnAndroid9AndUp(googlePlayAppList)

        //then
        assertEquals(33.3, percentage)
    }

    @Test
    fun should_ReturnZero_When_ListEmpty() {
        //given
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()

        //when
        val percentage = appAnalyzer.findPercentageOfAppRunningOnAndroid9AndUp(googlePlayAppList)

        //then
        assertEquals(0.0, percentage)
    }

    // endregion


    // region test functions for findLargest10App function
    @Test
    fun should_ReturnLargest10AppName_When_TheListOfAppsIsCorrectAndContainsMoreThan9Apps() {
        // given list of google play apps have 15 element
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(
            GooglePlayApp(
                "Jewel Blast : Temple", "SUPERBOX.Inc", "Puzzle",
                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 0.02, 1000,
                "4.4 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "FOX 4 Dallas-Fort Worth: Weather", "Fox Television Stations Inc.",
                "Weather", LocalDate.parse("March 27 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                98.1, 2000, "8.0 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Eyes : Nonogram", "GAMEFOX", "Puzzle",
                LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                265.0, 1500, "5.0 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Real Drift Car Racing", "Real Games srls", "Racing",
                LocalDate.parse("March 26 2021", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                0.74, 500, "4.1 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Slice: Pizza Delivery-Pick Up", "Slice Pizza App", "Food & Drink",
                LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                62.2, 2500, "7.0 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Angel Saga: Hero Action RPG", "Alchemist Games Inc.", "Action",
                LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                58.0, 200, "5.0 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Crazy Pusher", "Borg Studio", "Casino",
                LocalDate.parse("March 25 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                1123.8, 3000, "4.1 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Baby Game for 2 3 4 Year Old", "IDZ Digital Private Limited", "Educational",
                LocalDate.parse("March 9 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                1532.0, 2800, "5.2 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Garage Master - games for kids", "KIN GO GAMES FOR KIDS AND TODDLERS", "Educational",
                LocalDate.parse("March 15 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                91.3, 2600, "4.1 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Manta: Comics & Graphic Novels", "RIDI Corporation", "Comics",
                LocalDate.parse("May 16 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                75.4, 2300, "5.0 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Sago Mini School (Kids 2-5)", "Sago Mini", "Education",
                LocalDate.parse("February 24 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                52.0, 800, "4.4 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Rolling Luck: Win Real Money", "Shape Keeper Ltd", "Casino",
                LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                52.0, 1100, "5.0 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "StyleSeat: Book Hair & Beauty", "Styleseat", "Beauty",
                LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                800.0, 2300, "5.1 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Dinosaur Airport:Game for kids", "Yateland - Learning Games For Kids", "Educational",
                LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                1045.0, 4000, "4.1 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "myAudi", "Audi", "Auto & Vehicles",
                LocalDate.parse("May 10 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                67.0, 1250, "8.0 and up"
            )
        )

        // when fined the largest10 app of the list
        val result = appAnalyzer.findLargest10App(googlePlayAppList)
        // then
        assertEquals(mutableListOf(
                "Baby Game for 2 3 4 Year Old",
        "Crazy Pusher",
        "Dinosaur Airport:Game for kids",
        "StyleSeat: Book Hair & Beauty",
        "Eyes : Nonogram",
        "FOX 4 Dallas-Fort Worth: Weather",
        "Garage Master - games for kids",
        "Manta: Comics & Graphic Novels",
        "myAudi",
        "Slice: Pizza Delivery-Pick Up"
        ), result)
    }

    @Test
    fun should_ReturnAllAppNameOfList_When_TheListOfAppsIsCorrectAndContainsLessThan9Apps() {
        // given list of google play apps have 5 element
        val googlePlayAppList: MutableList<GooglePlayApp> = mutableListOf()
        googlePlayAppList.add(
            GooglePlayApp(
                "Slice: Pizza Delivery-Pick Up", "Slice Pizza App", "Food & Drink",
                LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                23.2, 2500, "7.0 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Crazy Pusher", "Borg Studio", "Casino",
                LocalDate.parse("March 25 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                1.3, 3000, "4.1 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Baby Game for 2 3 4 Year Old", "IDZ Digital Private Limited", "Educational",
                LocalDate.parse("March 9 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                0.52, 2800, "5.2 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Garage Master - games for kids", "KIN GO GAMES FOR KIDS AND TODDLERS", "Educational",
                LocalDate.parse("March 15 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                52.0, 2600, "4.1 and up"
            )
        )
        googlePlayAppList.add(
            GooglePlayApp(
                "Dinosaur Airport:Game for kids", "Yateland - Learning Games For Kids", "Educational",
                LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
                762.3, 4000, "4.1 and up"
            )
        )

        // when fined the largest10 app of list
        val result = appAnalyzer.findLargest10App(googlePlayAppList)
        // then
        assertEquals(
            mutableListOf(
                "Dinosaur Airport:Game for kids",
                "Garage Master - games for kids",
                "Slice: Pizza Delivery-Pick Up",
                "Crazy Pusher",
                "Baby Game for 2 3 4 Year Old"
            ), result
        )
    }

    @Test
    fun should_ReturnNullValueAndNoLargestApp_When_TheListOfAppsIsEmpty() {
        // given empty list of google play apps
        val googlePlayAppList : MutableList<GooglePlayApp> = mutableListOf()

        // when find the top installed apps name
        val result = appAnalyzer.findLargest10App(googlePlayAppList)
        // then
        assertNull(result)
    }

    // endregion

    // region test functions for findTop10InstalledApps function
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
        val result = appAnalyzer.findTop10InstalledApps(googlePlayAppList)
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
        val result = appAnalyzer.findTop10InstalledApps(googlePlayAppList)
        // then
        assertEquals(mutableListOf("Dinosaur Airport:Game for kids", "Crazy Pusher", "Baby Game for 2 3 4 Year Old", "Garage Master - games for kids",
            "Slice: Pizza Delivery-Pick Up"), result)
    }

    @Test
    fun should_ReturnNullValueAndNoTopInstalled_When_TheListOfAppsIsEmpty() {
        // given empty list of google play apps
        val googlePlayAppList : MutableList<GooglePlayApp> = mutableListOf()

        // when find the top installed apps name
        val result = appAnalyzer.findTop10InstalledApps(googlePlayAppList)
        // then
        assertNull(result)
    }

    // endregion
}