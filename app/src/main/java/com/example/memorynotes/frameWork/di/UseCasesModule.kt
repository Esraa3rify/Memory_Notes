package com.example.memorynotes.frameWork.di

import com.example.core.repository.NoteRepository
import com.example.core.useCase.*
import com.example.memorynotes.frameWork.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {
    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
        GetWordCount()
    )
}