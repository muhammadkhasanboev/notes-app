package com.android.notes.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.jvm.java

@Database(entities = [Note::class],version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun NoteDao(): NoteDao

    companion object{
        @Volatile
        private var Instance: NoteDatabase? = null
        fun getDatabase(context: Context): NoteDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, NoteDatabase::class.java, "item_database")
                    .build()
                    .also{Instance=it}
            }
        }
    }
}