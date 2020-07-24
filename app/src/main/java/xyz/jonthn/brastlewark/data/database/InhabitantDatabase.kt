package xyz.jonthn.brastlewark.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Inhabitant::class], version = 1)
@TypeConverters(Converters::class)
abstract class InhabitantDatabase : RoomDatabase() {

    companion object {
        fun build(context: Context) = Room.databaseBuilder(
            context,
            InhabitantDatabase::class.java,
            "app-db"
        ).build()
    }

    abstract fun inhabitantDAO(): InhabitantDAO
}