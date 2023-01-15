package com.example.core.useCase

import com.example.core.data.Note
import com.example.core.repository.NoteRepository

class GetNote(private val noteRepository:NoteRepository) {

    suspend operator fun invoke(id: Long) =noteRepository.getNote(id)

}