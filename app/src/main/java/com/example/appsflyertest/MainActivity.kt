package com.example.appsflyertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.appsflyer.AFInAppEventParameterName
import com.appsflyer.AFInAppEventType
import com.appsflyer.AppsFlyerLib
import com.appsflyer.attribution.AppsFlyerRequestListener

//SDK Dev key Shvyi23km84X4xbNvX38Vg
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val eventValues = HashMap<String, Any>()
        eventValues.put(AFInAppEventParameterName.PRICE, 7888.56)
        eventValues.put(AFInAppEventParameterName.CONTENT_ID,"1234567")

        AppsFlyerLib.getInstance().logEvent(getApplicationContext(),
            AFInAppEventType.PURCHASE,
            eventValues,
            object : AppsFlyerRequestListener {
                override fun onSuccess() {
                    Log.d("LogTag", "Event sent successfully")
                }
                override fun onError(errorCode: Int, errorDesc: String) {
                    Log.d("LogTag", "Event failed to be sent:\n" +
                            "Error code: " + errorCode + "\n"
                            + "Error description: " + errorDesc)
                }
            })
    }
}