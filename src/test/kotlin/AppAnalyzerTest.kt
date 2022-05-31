import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AppAnalyzerTest {

    private lateinit var appAnalyzer: AppAnalyzer

    @BeforeAll
    fun setup() {
        appAnalyzer = AppAnalyzer()
    }
    /* Points That Will Be Tested:
    * 1. The apps that have been developed by Google.
    * 2. The percentage of medical apps.
    * 3. The oldest app.
    * 4. The percentage of apps running on android 9 or above.
    * 5. The largest 10 apps by size.
    * 6. The top 10 installed apps.
    * */

    /// - THE NEW TEST CASES - ///

    /*
    * Point 1: The apps that have been developed by Google.
    * No. of test cases: 8
    * */

    @Test // 1-1
    fun should_ReturnNumOfAppsDevelopedByGoogle_When_CompanyNameContainsSpaces() {
    }

    @Test // 1-2
    fun should_ReturnNumOfAppsDevelopedByGoogle_When_CompanyNameContainsDots() {
    }

    @Test // 1-3
    fun should_ReturnNumOfAppsDevelopedByGoogle_When_CompanyNameInUpperCase() {
    }

    @Test // 1-4
    fun should_ReturnNumOfAppsDevelopedByGoogle_When_CompanyNameInMixedCase() {
    }

    @Test // 1-5
    fun should_ReturnNull_When_CompanyNameNotFound() {
    }

    @Test // 1-6
    fun should_ReturnNull_When_CompanyNameIsEmpty() {
    }

    @Test // 1-7
    fun should_ReturnNull_When_AppListIsEmpty() {
    }

    @Test // 1-8
    fun should_ReturnNull_When_AppListIsNull() {
    }

    @Test // 1-9
    fun should_ReturnNull_When_AppDoseNotHaveCompanyField() {
    }

    /*
    * Point 2: The percentage of medical apps.
    * No. of test cases: 10
    * */

    @Test // 2-1
    fun should_ReturnPercentageOfGivenCategory_When_AppListIsNotEmpty() {
    }

    @Test // 2-2
    fun should_ReturnPercentageOfGivenCategory_When_CategoryContainsSpaces() {
    }

    @Test // 2-3
    fun should_ReturnPercentageOfGivenCategory_When_CategoryContainsDots() {
    }

    @Test // 2-4
    fun should_ReturnPercentageOfGivenCategory_When_CategoryInUpperCase() {
    }

    @Test // 2-5
    fun should_ReturnPercentageOfGivenCategory_When_CategoryInMixedCase() {
    }

    @Test // 2-6
    fun should_ReturnNullOfCategory_When_AppListIsEmpty() {
    }

    @Test // 2-7
    fun should_ReturnNullOfCategory_When_AppListIsNull() {
    }

    @Test // 2-8
    fun should_ReturnNullOfCategory_When_CategoryIsEmpty() {
    }

    @Test // 2-9
    fun should_ReturnNullOfCategory_When_AppDoseNotHaveCategory() {
    }

    @Test // 2-10
    fun should_ReturnZeroOfCategory_When_CategoryIsNotFound() {
    }

    /*
    * Point 3: The oldest app.
    * No. of test cases: 5
    * */

    @Test // 3-1
    fun should_ReturnOldestApp_When_ValidAppList() {
    }

    @Test // 3-2
    fun should_ReturnMultiOldestApp_When_TowOrMoreAppsHaveSameOldestDate() {
    }

    @Test // 3-3
    fun should_ReturnNullOfOldestApp_When_AppListIsEmpty() {
    }

    @Test // 3-4
    fun should_ReturnNullOfOldestApp_When_AppListIsNull() {
    }

    @Test // 3-5
    fun should_ReturnNullOfOldestApp_When_AppDoseNotHavePublishedDate() {
    }

    /*
    * Point 4: The percentage of apps running on android 9 or above.
    * No. of test cases: 5
    * */

    @Test // 4-1
    fun should_ReturnPercentageOfAppsRunningOnAndroid9OrAbove_When_ValidAppList() {
    }

    @Test // 4-2
    fun should_ReturnZero_When_NoAppsRunningOnAndroid9OrAbove() {
    }

    @Test // 4-3
    fun should_ReturnNullOfPercentage_When_AppListIsEmpty() {
    }

    @Test // 4-4
    fun should_ReturnNullOfPercentage_When_AppListIsNull() {
    }

    @Test // 4-5
    fun should_ReturnZeroOfPercentage_When_AppDoseNotHaveOsVersion() {
    }

    /*
    * Point 5: The largest 10 apps by size.
    * No. of test cases:
    * */

    @Test // 5-1
    fun should_ReturnLargest10Apps_When_ValidAppList() {
    }

    @Test // 5-2
    fun should_ReturnLargestXApps_When_AppListSizeIsBetween0And9() {
    }

    @Test // 5-3
    fun should_ReturnNullOfLargest10Apps_When_AppListIsEmpty() {
    }

    @Test // 5-4
    fun should_ReturnNullOfLargest10Apps_When_AppListIsNull() {
    }

    @Test // 5-5
    fun should_ReturnNullOfLargest10Apps_When_AppDoseNotHaveSizeField() {
    }








//
//    // region test functions for findAppDevelopedByGoogle function
//    @Test
//    fun should_ReturnNumber1_When_HaveListWith1GoogleApp() {
//        // given list contain one "Google" word
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        googlePlayAppList.add(
//            App(
//                "Jewel Blast : Temple", "Google", "Puzzle",
//                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0, 1000,
//                4.4
//            )
//        )
//        // when calculate number of Apps
//        val numberOfApps = appAnalyzer.findAppDevelopedByGivenCompany(googlePlayAppList)
//        // then check the result
//        assertEquals(1, numberOfApps)
//    }
//
//    @Test
//    fun should_ReturnZero_When_HaveListWithNoAnyGoogleApp() {
//        // given list that doesn't contain the word Google
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        googlePlayAppList.add(
//            App(
//                "Jewel Blast : Temple", "Hutch Games", "Puzzle",
//                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0, 1000,
//                4.4
//            )
//        )
//        // when calculate number of Apps
//        val numberOfApps = appAnalyzer.findAppDevelopedByGivenCompany(googlePlayAppList)
//        // then check the result
//        assertEquals(0, numberOfApps)
//    }
//
//    @Test
//    fun should_ReturnZero_When_HaveNullList() {
//        // given null list
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        googlePlayAppList.add(
//            App(
//                "Jewel Blast : Temple", "", "Puzzle",
//                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0, 1000,
//                4.4
//            )
//        )
//        // when calculate number of Apps
//        val numberOfApps = appAnalyzer.findAppDevelopedByGivenCompany(googlePlayAppList)
//        // then check the result
//        assertEquals(0, numberOfApps)
//    }
//
//    // endregion
//
//    // region test functions for findPercentageOfMedicalApps function
//    @Test
//    fun should_ReturnCorrectPercentageOfMedicalApps_When_HaveListOfMedicalAppsOnly() {
//        // given list of apps with 100% medical apps
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        googlePlayAppList.add(
//            App(
//                "Medical Mnemonics", "Regular Rate and Rhythm Software", "Medical",
//                LocalDate.parse("May 19 2011", DateTimeFormatter.ofPattern("MMMM d yyyy")), 0.362305, 1000,
//                1.6
//            )
//        )
//        // when calculate percentage
//        val percentage = appAnalyzer.findPercentageOfAppsByCategory(googlePlayAppList)
//        // then check the result
//        assertEquals(100.0, percentage)
//    }
//
//    @Test
//    fun should_ReturnCorrectPercentageOfMedicalApps_When_HaveListOfAppsWithMedicalApps() {
//        // given list of apps with 50% medical apps
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        googlePlayAppList.add(
//            App(
//                "Medical Mnemonics", "Regular Rate and Rhythm Software", "Medical",
//                LocalDate.parse("May 19 2011", DateTimeFormatter.ofPattern("MMMM d yyyy")), 0.362305, 1000,
//                1.6
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "FOX 4 Dallas-Fort Worth: Weather", "Fox Television Stations Inc.",
//                "Weather", LocalDate.parse("March 27 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                51.0, 2000, 8.0
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Eyes : Nonogram", "GAMEFOX", "Puzzle",
//                LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                51.0, 1500, 5.0
//            )
//        )
//        // when calculate percentage
//        val percentage = appAnalyzer.findPercentageOfAppsByCategory(googlePlayAppList)
//        // then check the result
//        assertEquals(33.3, percentage)
//    }
//
//    @Test
//    fun should_ReturnZero_When_HaveListOfAppsWithOutMedicalApp() {
//        // given list of apps with zero medical apps
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        googlePlayAppList.add(
//            App(
//                "Medical Mnemonics", "Regular Rate and Rhythm Software", "Photography",
//                LocalDate.parse("May 19 2011", DateTimeFormatter.ofPattern("MMMM d yyyy")), 0.362305, 1000,
//                1.6
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "FOX 4 Dallas-Fort Worth: Weather", "Fox Television Stations Inc.",
//                "Weather", LocalDate.parse("March 27 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                51.0, 2000, 8.0
//            )
//        )
//        // when calculate percentage
//        val percentage = appAnalyzer.findPercentageOfAppsByCategory(googlePlayAppList)
//        // then check the result
//        assertEquals(0.0, percentage)
//    }
//
//    @Test
//    fun should_ReturnZero_When_HaveEmptyList() {
//        // given list of apps with zero medical apps
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        // when calculate percentage
//        val percentage = appAnalyzer.findPercentageOfAppsByCategory(googlePlayAppList)
//        // then check the result
//        assertEquals(0.0, percentage)
//    }
//
//    // endregion
//
//    // region test functions for findOldestApp function
//    @Test
//    fun should_ReturnOlderApp_When_HaveListWithApp() {
//        // given list contain one "Google" word
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        googlePlayAppList.add(
//            App(
//                "Medical Mnemonics", "Regular Rate and Rhythm Software", "Medical",
//                LocalDate.parse("May 19 2011", DateTimeFormatter.ofPattern("MMMM d yyyy")), 0.362305, 1000,
//                1.6
//            )
//        )
//        // when calculate number of Apps
//        val olderApp = appAnalyzer.findOldestApp(googlePlayAppList)
//        // then check the result
//        assertEquals("Medical Mnemonics", olderApp)
//    }
//
//    @Test
//    fun should_ReturnOlderApp_When_HaveListWithMultiApps() {
//        // given list contain one "Google" word
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        googlePlayAppList.add(
//            App(
//                "Jewel Blast : Temple", "", "Puzzle",
//                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0, 1000,
//                4.4
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "myAudi", "Audi", "Auto & Vehicles",
//                LocalDate.parse("May 10 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                53.0, 1250, 8.0
//            )
//        )
//        // when calculate number of Apps
//        val olderApp = appAnalyzer.findOldestApp(googlePlayAppList)
//        // then check the result
//        assertEquals("Jewel Blast : Temple", olderApp)
//    }
//
//    @Test
//    fun should_ReturnNull_When_HaveEmptyList() {
//        // given list contain one "Google" word
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        // when calculate number of Apps
//        val olderApp = appAnalyzer.findOldestApp(googlePlayAppList)
//        // then check the result
//        assertNull(olderApp)
//    }
//
//    // endregion
//
//    // region test functions for findPercentageOfAppRunningOnAndroid9AndUp function
//    @Test
//    fun should_ReturnZero_When_NotAppRequiredAndroid9AndUp() {
//        //given
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        googlePlayAppList.add(
//            App(
//                "Jewel Blast : Temple", "", "Puzzle",
//                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0, 1000,
//                7
//            )
//        )
//
//        //when
//        val percentage = appAnalyzer.findPercentageOfAppRunningOnSpecificAndroid(googlePlayAppList)
//
//        //then
//        assertEquals(0.0, percentage)
//    }
//
//    @Test
//    fun should_ReturnCorrectPercentage_When_ListOfGoogleAppsHaveAppsRequiredAndroid9AndUp() {
//        //given
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        googlePlayAppList.add(
//            App(
//                "Jewel Blast : Temple", "", "Puzzle",
//                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0, 1000,
//                9
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Jewel Blast : Temple", "SUPERBOX.Inc", "Puzzle",
//                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 0.02, 1000,
//                4.4
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "FOX 4 Dallas-Fort Worth: Weather", "Fox Television Stations Inc.",
//                "Weather", LocalDate.parse("March 27 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                98.1, 2000, 8.0
//            )
//        )
//        //when
//        val percentage = appAnalyzer.findPercentageOfAppRunningOnSpecificAndroid(googlePlayAppList)
//
//        //then
//        assertEquals(33.3, percentage)
//    }
//
//    @Test
//    fun should_ReturnZero_When_ListEmpty() {
//        //given
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//
//        //when
//        val percentage = appAnalyzer.findPercentageOfAppRunningOnSpecificAndroid(googlePlayAppList)
//
//        //then
//        assertEquals(0.0, percentage)
//    }
//
//    // endregion
//
//
//    // region test functions for findLargest10App function
//    @Test
//    fun should_ReturnLargest10AppName_When_TheListOfAppsIsCorrectAndContainsMoreThan9Apps() {
//        // given list of google play apps have 15 element
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        googlePlayAppList.add(
//            App(
//                "Jewel Blast : Temple", "SUPERBOX.Inc", "Puzzle",
//                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 0.02, 1000,
//                4.4
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "FOX 4 Dallas-Fort Worth: Weather", "Fox Television Stations Inc.",
//                "Weather", LocalDate.parse("March 27 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                98.1, 2000, 8.0
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Eyes : Nonogram", "GAMEFOX", "Puzzle",
//                LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                265.0, 1500, 5.0
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Real Drift Car Racing", "Real Games srls", "Racing",
//                LocalDate.parse("March 26 2021", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                0.74, 500, 4.1
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Slice: Pizza Delivery-Pick Up", "Slice Pizza App", "Food & Drink",
//                LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                62.2, 2500, 7.0
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Angel Saga: Hero Action RPG", "Alchemist Games Inc.", "Action",
//                LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                58.0, 200, 5.0
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Crazy Pusher", "Borg Studio", "Casino",
//                LocalDate.parse("March 25 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                1123.8, 3000, 4.1
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Baby Game for 2 3 4 Year Old", "IDZ Digital Private Limited", "Educational",
//                LocalDate.parse("March 9 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                1532.0, 2800, 5.2
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Garage Master - games for kids", "KIN GO GAMES FOR KIDS AND TODDLERS", "Educational",
//                LocalDate.parse("March 15 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                91.3, 2600, 4.1
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Manta: Comics & Graphic Novels", "RIDI Corporation", "Comics",
//                LocalDate.parse("May 16 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                75.4, 2300, 5.0
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Sago Mini School (Kids 2-5)", "Sago Mini", "Education",
//                LocalDate.parse("February 24 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                52.0, 800, 4.4
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Rolling Luck: Win Real Money", "Shape Keeper Ltd", "Casino",
//                LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                52.0, 1100, 5.0
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "StyleSeat: Book Hair & Beauty", "Styleseat", "Beauty",
//                LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                800.0, 2300, 5.1
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Dinosaur Airport:Game for kids", "Yateland - Learning Games For Kids", "Educational",
//                LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                1045.0, 4000, 4.1
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "myAudi", "Audi", "Auto & Vehicles",
//                LocalDate.parse("May 10 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                67.0, 1250, 8.0
//            )
//        )
//
//        // when fined the largest10 app of the list
//        val result = appAnalyzer.findLargestApps(googlePlayAppList)
//        // then
//        assertEquals(
//            mutableListOf(
//                "Baby Game for 2 3 4 Year Old",
//                "Crazy Pusher",
//                "Dinosaur Airport:Game for kids",
//                "StyleSeat: Book Hair & Beauty",
//                "Eyes : Nonogram",
//                "FOX 4 Dallas-Fort Worth: Weather",
//                "Garage Master - games for kids",
//                "Manta: Comics & Graphic Novels",
//                "myAudi",
//                "Slice: Pizza Delivery-Pick Up"
//            ), result
//        )
//    }
//
//    @Test
//    fun should_ReturnAllAppNameOfList_When_TheListOfAppsIsCorrectAndContainsLessThan9Apps() {
//        // given list of google play apps have 5 element
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        googlePlayAppList.add(
//            App(
//                "Slice: Pizza Delivery-Pick Up", "Slice Pizza App", "Food & Drink",
//                LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                23.2, 2500, 7.0
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Crazy Pusher", "Borg Studio", "Casino",
//                LocalDate.parse("March 25 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                1.3, 3000, 4.1
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Baby Game for 2 3 4 Year Old", "IDZ Digital Private Limited", "Educational",
//                LocalDate.parse("March 9 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                0.52, 2800, 5.2
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Garage Master - games for kids", "KIN GO GAMES FOR KIDS AND TODDLERS", "Educational",
//                LocalDate.parse("March 15 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                52.0, 2600, 4.1
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Dinosaur Airport:Game for kids", "Yateland - Learning Games For Kids", "Educational",
//                LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                762.3, 4000, 4.1
//            )
//        )
//
//        // when fined the largest10 app of list
//        val result = appAnalyzer.findLargestApps(googlePlayAppList)
//        // then
//        assertEquals(
//            mutableListOf(
//                "Dinosaur Airport:Game for kids",
//                "Garage Master - games for kids",
//                "Slice: Pizza Delivery-Pick Up",
//                "Crazy Pusher",
//                "Baby Game for 2 3 4 Year Old"
//            ), result
//        )
//    }
//
//    @Test
//    fun should_ReturnNullValueAndNoLargestApp_When_TheListOfAppsIsEmpty() {
//        // given empty list of google play apps
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//
//        // when find the top installed apps name
//        val result = appAnalyzer.findLargestApps(googlePlayAppList)
//        // then
//        assertNull(result)
//    }
//
//    // endregion
//
//    // region test functions for findTop10InstalledApps function
//    @Test
//    fun should_ReturnTop10InstalledAppName_When_TheListOfAppsIsCorrectAndContainsMoreThan9Apps() {
//        // given list of google play apps have 15 element
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        googlePlayAppList.add(
//            App(
//                "Jewel Blast : Temple", "SUPERBOX.Inc", "Puzzle",
//                LocalDate.parse("April 11 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")), 50.0, 1000,
//                "4.4 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "FOX 4 Dallas-Fort Worth: Weather", "Fox Television Stations Inc.",
//                "Weather", LocalDate.parse("March 27 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                51.0, 2000, "8.0 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Eyes : Nonogram", "GAMEFOX", "Puzzle",
//                LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                51.0, 1500, "5.0 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Real Drift Car Racing", "Real Games srls", "Racing",
//                LocalDate.parse("March 26 2021", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                51.0, 500, "4.1 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Slice: Pizza Delivery-Pick Up", "Slice Pizza App", "Food & Drink",
//                LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                51.0, 2500, "7.0 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Angel Saga: Hero Action RPG", "Alchemist Games Inc.", "Action",
//                LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                58.0, 200, "5.0 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Crazy Pusher", "Borg Studio", "Casino",
//                LocalDate.parse("March 25 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                52.0, 3000, "4.1 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Baby Game for 2 3 4 Year Old", "IDZ Digital Private Limited", "Educational",
//                LocalDate.parse("March 9 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                52.0, 2800, "5.2 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Garage Master - games for kids", "KIN GO GAMES FOR KIDS AND TODDLERS", "Educational",
//                LocalDate.parse("March 15 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                52.0, 2600, "4.1 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Manta: Comics & Graphic Novels", "RIDI Corporation", "Comics",
//                LocalDate.parse("May 16 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                52.0, 2300, "5.0 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Sago Mini School (Kids 2-5)", "Sago Mini", "Education",
//                LocalDate.parse("February 24 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                52.0, 800, "4.4 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Rolling Luck: Win Real Money", "Shape Keeper Ltd", "Casino",
//                LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                52.0, 1100, "5.0 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "StyleSeat: Book Hair & Beauty", "Styleseat", "Beauty",
//                LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                54.0, 2300, "5.1 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Dinosaur Airport:Game for kids", "Yateland - Learning Games For Kids", "Educational",
//                LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                21.0, 4000, "4.1 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "myAudi", "Audi", "Auto & Vehicles",
//                LocalDate.parse("May 10 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                53.0, 1250, "8.0 and up"
//            )
//        )
//
//        // when find the top 10 installed apps name
//        val result = appAnalyzer.findTopNumberInstalledApps(googlePlayAppList)
//        // then
//        assertEquals(
//            mutableListOf(
//                "Dinosaur Airport:Game for kids",
//                "Crazy Pusher",
//                "Baby Game for 2 3 4 Year Old",
//                "Garage Master - games for kids",
//                "Slice: Pizza Delivery-Pick Up",
//                "Manta: Comics & Graphic Novels",
//                "StyleSeat: Book Hair & Beauty",
//                "FOX 4 Dallas-Fort Worth: Weather",
//                "Eyes : Nonogram",
//                "myAudi"
//            ), result
//        )
//    }
//
//    @Test
//    fun should_ReturnAllElementAppName_When_TheListOfAppsIsCorrectAndContainsLiseThan10Apps() {
//        // given list of google play apps have 5 element
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//        googlePlayAppList.add(
//            App(
//                "Slice: Pizza Delivery-Pick Up", "Slice Pizza App", "Food & Drink",
//                LocalDate.parse("May 13 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                51.0, 2500, "7.0 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Crazy Pusher", "Borg Studio", "Casino",
//                LocalDate.parse("March 25 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                52.0, 3000, "4.1 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Baby Game for 2 3 4 Year Old", "IDZ Digital Private Limited", "Educational",
//                LocalDate.parse("March 9 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                52.0, 2800, "5.2 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Garage Master - games for kids", "KIN GO GAMES FOR KIDS AND TODDLERS", "Educational",
//                LocalDate.parse("March 15 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                52.0, 2600, "4.1 and up"
//            )
//        )
//        googlePlayAppList.add(
//            App(
//                "Dinosaur Airport:Game for kids", "Yateland - Learning Games For Kids", "Educational",
//                LocalDate.parse("May 18 2022", DateTimeFormatter.ofPattern("MMMM d yyyy")),
//                21.0, 4000, "4.1 and up"
//            )
//        )
//
//        // when find the top installed apps name
//        val result = appAnalyzer.findTopNumberInstalledApps(googlePlayAppList)
//        // then
//        assertEquals(
//            mutableListOf(
//                "Dinosaur Airport:Game for kids",
//                "Crazy Pusher",
//                "Baby Game for 2 3 4 Year Old",
//                "Garage Master - games for kids",
//                "Slice: Pizza Delivery-Pick Up"
//            ), result
//        )
//    }
//
//    @Test
//    fun should_ReturnNullValueAndNoTopInstalled_When_TheListOfAppsIsEmpty() {
//        // given empty list of google play apps
//        val googlePlayAppList: MutableList<App> = mutableListOf()
//
//        // when find the top installed apps name
//        val result = appAnalyzer.findTopNumberInstalledApps(googlePlayAppList)
//        // then
//        assertNull(result)
//    }
//
//    // endregion
}