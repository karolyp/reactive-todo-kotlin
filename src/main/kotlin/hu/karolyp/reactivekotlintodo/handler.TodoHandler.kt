package hu.karolyp.reactivekotlintodo

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body

@RestController
class TodoHandler(
        private val todoRepository: TodoRepository
) {
    fun findAll(req: ServerRequest) = ok().body(todoRepository.findAll())

    fun findTodoById(req: ServerRequest) = ok().body(todoRepository.findById(req.pathVariable("id")))

    fun createTodo(req: ServerRequest) = req.bodyToMono(Todo::class.java)
            .flatMap { todo -> ok().body(todoRepository.save(todo)) }

}