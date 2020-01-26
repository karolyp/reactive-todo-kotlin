package hu.karolyp.reactivekotlintodo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Todo(
        @Id
        val id: String? = null,
        val title: String,
        val items: List<String>
)