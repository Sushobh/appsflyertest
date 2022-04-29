package com.example.appsflyertest

import android.app.Application
import android.util.Log
import com.appsflyer.AppsFlyerLib
import com.appsflyer.attribution.AppsFlyerRequestListener

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppsFlyerLib.getInstance().init("Shvyi23km84X4xbNvX38Vg", null, this)
        AppsFlyerLib.getInstance().start(this, "Shvyi23km84X4xbNvX38Vg", object : AppsFlyerRequestListener {
            override fun onSuccess() {
                Log.d("LogTag", "Launch sent successfully")
            }

            override fun onError(errorCode: Int, errorDesc: String) {
                Log.d("LogTag", "Launch failed to be sent:\n" +
                        "Error code: " + errorCode + "\n"
                        + "Error description: " + errorDesc)
            }
        })
    }
}