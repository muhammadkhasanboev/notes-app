package com.android.notes.data

import kotlinx.coroutines.flow.Flow

class OfflineNoteRepository(private val noteDao: NoteDao): NoteRepository {
    override fun getAllNotes(): Flow<List<Note>> = noteDao.getAllNotes()
    override fun getNote(id: Int): Flow<Note> = noteDao.getItem(id)
    override suspend fun insertNote(note: Note) = noteDao.insert(note)
    override suspend fun deleteNote(note: Note) = noteDao.delete(note)
    override suspend fun updateNote(note: Note) = noteDao.update(note)
}