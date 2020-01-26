package hu.karolyp.reactivekotlintodo.utils

import hu.karolyp.reactivekotlintodo.model.Todo
import hu.karolyp.reactivekotlintodo.repository.TodoRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class DataLoader(
        private val todoRepository: TodoRepository
) : ApplicationRunner {
    private val log = LoggerFactory.getLogger(DataLoader::class.java)


    override fun run(args: ApplicationArguments?) {
        todoRepository.deleteAll()
                .then(Mono.just(Todo(null, "Today", listOf("Take kids to school", "Go to lunch with Kevin",
                        "Go shopping", "Make dinner")))
                        .flatMap { todoRepository.save(it) }
                        .doOnNext{log.info("Saved: {}", it)}
                )
                .then().block()
    }
}