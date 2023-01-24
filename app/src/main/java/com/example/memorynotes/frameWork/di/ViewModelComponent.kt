package com.example.memorynotes.frameWork.di
import com.example.memorynotes.frameWork.ListViewModel
import com.example.memorynotes.frameWork.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}