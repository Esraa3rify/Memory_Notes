package com.example.memorynotes.frameWork

import com.example.core.useCase.*

data class UseCases(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote,
    //val getWordCount: GetWordCount
)