package hu.karolyp.reactivekotlintodo.repository

import hu.karolyp.reactivekotlintodo.model.Todo
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface
TodoRepository : ReactiveMongoRepository<Todo, String>