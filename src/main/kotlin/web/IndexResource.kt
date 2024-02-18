package web

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import service.TaskService

fun Route.index(taskService: TaskService) {
    get("/") {
        val tasks = taskService.getAll()
        val response = mapOf(
            "data" to tasks
        )
        call.respond(response)
    }
}
