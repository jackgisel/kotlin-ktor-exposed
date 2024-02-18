package db.migration

import model.TaskTable
import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class V1__create_schema: BaseJavaMigration() {
    override fun migrate(context: Context?) {
        transaction {
            SchemaUtils.create(TaskTable)

            val todoList = arrayOf(
                    "Make a grocery list for the week.",
                    "Schedule a dentist appointment.",
                    "Complete the report for work/school.",
                    "Organize and declutter the living room.",
                    "Research and sign up for a local fitness class.",
                    "Call a friend or family member you haven't spoken to in a while.",
                    "Set aside time for a creative hobby or project.",
                    "Plan a healthy meal prep for the upcoming week.",
                    "Read a chapter of that book you've been meaning to finish.",
                    "Set up automatic bill payments for recurring expenses."
            )

            for (item in todoList) {
                TaskTable.insert {
                    it[completed] = false
                    it[description] = item
                }
            }
        }
    }
}
