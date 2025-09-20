package com.android.notes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * from notes_table WHERE id= :id")
    fun getItem(id: Int): Flow<Note>

    @Query("SELECT * from notes_table ORDER BY timeStamp DESC")
    fun getAllNotes(): Flow<List<Note>>
}