package com.example.memorynotes.frameWork

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.core.data.Note
import com.example.core.repository.NoteRepository
import com.example.core.useCase.AddNote
import com.example.core.useCase.GetAllNotes
import com.example.core.useCase.GetNote
import com.example.core.useCase.RemoveNote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(application: Application): AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    val repository= NoteRepository(RoomNoteDataSource(application))


    val useCases=UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
    )

    val notes = MutableLiveData<List<Note>>()

    fun getNotes(){

        coroutineScope.launch {
           val noteList=useCases.getAllNotes()
            notes.postValue(noteList)
        }
    }

}