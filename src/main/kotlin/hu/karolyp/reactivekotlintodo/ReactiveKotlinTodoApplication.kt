package hu.karolyp.reactivekotlintodo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveKotlinTodoApplication

fun main(args: Array<String>) {
	runApplication<ReactiveKotlinTodoApplication>(*args)
}
