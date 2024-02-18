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
                    "Set up automatic bill payments for recurring expenses.",
                    "Plan a weekend getaway.",
                    "Clean out your email inbox.",
                    "Go for a 30-minute walk.",
                    "Update your resume.",
                    "Research and learn a new skill.",
                    "Write a thank-you note to someone who has helped you recently.",
                    "Try a new recipe for dinner.",
                    "Create a budget for the month.",
                    "Sort through old clothes and donate what you no longer wear.",
                    "Start a gratitude journal.",
                    "Take a digital detox day.",
                    "Schedule a home maintenance check-up.",
                    "Learn a new language.",
                    "Create a vision board for your goals.",
                    "Set up a meeting with a financial advisor.",
                    "Practice meditation or mindfulness.",
                    "Try a new workout routine.",
                    "Attend a local community event.",
                    "Start a DIY project you've been putting off.",
                    "Update your social media profiles.",
                    "Research and plan your next career move.",
                    "Set goals for the next month.",
                    "Plan a fun activity with friends or family.",
                    "Clean and organize your workspace.",
                    "Sign up for a volunteer opportunity.",
                    "Watch a documentary on a topic you're interested in.",
                    "Take a photography walk and capture interesting scenes.",
                    "Create a playlist of your favorite songs.",
                    "Start a new book.",
                    "Try a new restaurant or cuisine.",
                    "Attend a workshop or seminar.",
                    "Practice a musical instrument for at least 30 minutes.",
                    "Explore a nearby town or neighborhood you've never been to.",
                    "Research and book tickets for a cultural event.",
                    "Update your passwords for online accounts.",
                    "Take a short online course on a topic of interest.",
                    "Start a savings plan for a specific goal.",
                    "Organize your digital files and folders.",
                    "Create a meal plan for the week.",
                    "Research and make a list of places you'd like to travel to.",
                    "Start a daily journaling habit.",
                    "Practice a random act of kindness for someone.",
                    "Review and update your insurance policies.",
                    "Go through old photos and create a digital album.",
                    "Set up a regular exercise schedule.",
                    "Research and invest in a good ergonomic chair or desk setup.",
                    "Practice deep breathing exercises for relaxation.",
                    "Make a list of things you're grateful for.",
                    "Create a bucket list of things you want to do in your lifetime.",
                    "Schedule a family game night.",
                    "Explore a new hobby or interest."
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
