package service

import kotlinx.serialization.Serializable
import model.TaskTable
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import service.DatabaseFactory.dbExec

@Serializable
data class TaskDTO(
    val description: String,
    val completed: Boolean
)

class TaskService {
    suspend fun getAll(): List<TaskDTO> {
        return dbExec {
            TaskTable.selectAll().map {
                TaskDTO(
                    description = it[TaskTable.description],
                    completed = it[TaskTable.completed]
                )
            }
        }
    }
}