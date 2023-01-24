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
import com.example.memorynotes.frameWork.di.ApplicationModule
import com.example.memorynotes.frameWork.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel(application: Application): AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule((getApplication())))
            .build()
            .inject(this)
    }


    val notes = MutableLiveData<List<Note>>()

    fun getNotes(){

        coroutineScope.launch {
           val noteList=useCases.getAllNotes()
            noteList.forEach { it.wordCount = useCases.getWordCount.invoke(it) }

            notes.postValue(noteList)
        }
    }

}