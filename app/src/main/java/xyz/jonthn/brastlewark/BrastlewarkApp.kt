package xyz.jonthn.brastlewark

import android.app.Application
import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class BrastlewarkApp : Application() {

    companion object {
        var mBrastlewarkAppInstance: BrastlewarkApp? = null
        var mAppContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()

        mBrastlewarkAppInstance = this
        mAppContext = this.applicationContext

        /**
         * Koin DI init
         */
        initDI()

        /**
         * Timber init config
         */
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        Fresco.initialize(this);
    }
}