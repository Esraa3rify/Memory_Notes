package com.example.memorynotes.frameWork.di

import android.app.Application
import com.example.core.repository.NoteRepository
import com.example.memorynotes.frameWork.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))
}