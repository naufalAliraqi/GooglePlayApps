import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AppAnalyzerTest {

    lateinit var appAnalyzer: AppAnalyzer

    @BeforeAll
    fun setup(){
        appAnalyzer = AppAnalyzer()
    }

    @Test
    fun finedAppDevelopedByGoogle() {
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