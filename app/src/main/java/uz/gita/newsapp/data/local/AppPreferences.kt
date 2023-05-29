package uz.gita.newsapp.data.local

import android.content.Context
import android.content.SharedPreferences

class AppPreferences private constructor(){
    companion object{
        private lateinit var pref: SharedPreferences
        private lateinit var instance: AppPreferences

        fun init(context: Context){
            pref = context.getSharedPreferences("MY_PREF",Context.MODE_PRIVATE)
            instance = AppPreferences()
        }

        fun getInstance(): AppPreferences = instance
    }

    var language: String
        set(value) = pref.edit().putString("LANG",value).apply()
        get() = pref.getString("LANG","")!!


}