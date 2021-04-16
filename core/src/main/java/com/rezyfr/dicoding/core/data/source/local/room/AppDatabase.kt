package com.rezyfr.dicoding.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rezyfr.dicoding.core.data.source.local.entity.MovieEntity
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory

@Database(version = 1, exportSchema = false, entities = [MovieEntity::class])
abstract class AppDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private val passPhrase: ByteArray = SQLiteDatabase.getBytes("submission".toCharArray())
        val factory = SupportFactory(passPhrase)

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MADE-Submission.db"
            ).openHelperFactory(factory).build()
    }

    abstract fun movieDao(): MovieDao
}