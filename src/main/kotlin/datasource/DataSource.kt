package datasource

import model.App

interface DataSource {

    fun getAllApps():List<App>
}
