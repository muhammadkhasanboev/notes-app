package com.android.notes.ui.theme.newnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.notes.data.Note
import com.android.notes.data.NoteRepository
import kotlinx.coroutines.launch

class NewNoteViewModel(private val noteRepository: NoteRepository): ViewModel() {

    fun insertNote(title: String, content: String) {
        val note = Note(
            title = title,
            content = content,
            timeStamp = System.currentTimeMillis()
        )
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }
    }

}