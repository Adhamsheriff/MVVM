package com.adhamsheriff.mvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adhamsheriff.mvvm.data.db.entities.User
import com.adhamsheriff.mvvm.data.db.entities.UserDao

@Database(
    entities = [User::class],
    version = 1
)
abstract class AppDatabase() : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {

        @Volatile
        private var instances: AppDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instances ?: synchronized(LOCK)
        {
            instances ?: buildDatabase(context).also {
                instances = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db"
            ).build()
    }
}