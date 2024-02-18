package model

import org.jetbrains.exposed.dao.id.IntIdTable

object TaskTable : IntIdTable() {
    val description = text("description")
    val completed = bool("completed")
}