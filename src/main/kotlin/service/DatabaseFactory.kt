package service

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.LoggerFactory
import javax.sql.DataSource

object DatabaseFactory {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun connectAndMigrate() {
        log.info("Initialising database")
        val pool = hikari()
        Database.connect(pool)
        runFlyway(pool)
    }

    private fun hikari(): HikariDataSource {
        val path = System.getenv("DATABASE_PRIVATE_URL").split("@")[1]
        println("jdbc:postgresql://$path")
        println(System.getenv("PGUSER"))
        println(System.getenv("PGPASSWORD"))
        val config = HikariConfig().apply {
            jdbcUrl = "jdbc:postgresql://$path"
            driverClassName = "org.postgresql.Driver"
            username = System.getenv("PGUSER")
            password = System.getenv("PGPASSWORD")
        }
        return HikariDataSource(config)
    }

    private fun runFlyway(datasource: DataSource) {
        val flyway = Flyway.configure().dataSource(datasource).load()
        try {
            flyway.info()
            flyway.migrate()
        } catch (e: Exception) {
            log.error("Exception running flyway migration", e)
            throw e
        }
        log.info("Flyway migration has finished")
    }

    suspend fun <T> dbExec(
        block: () -> T
    ): T = withContext(Dispatchers.IO) {
        transaction { block() }
    }

}