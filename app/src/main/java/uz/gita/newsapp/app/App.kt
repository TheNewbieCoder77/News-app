package uz.gita.newsapp.app

import android.app.Application
import uz.gita.newsapp.data.local.AppPreferences

class App : Application() {
    companion object{
        lateinit var context: App
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        AppPreferences.init(this)
    }
}