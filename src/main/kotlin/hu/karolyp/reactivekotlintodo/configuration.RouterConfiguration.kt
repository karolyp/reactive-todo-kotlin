package hu.karolyp.reactivekotlintodo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class RouterConfiguration {
    @Bean
    fun router(todoHandler: TodoHandler) = router {
        "/todos".nest {
            GET("/", todoHandler::findAll)
            GET("/{id}", todoHandler::findTodoById)
            POST("/", todoHandler::createTodo)
        }
    }
}