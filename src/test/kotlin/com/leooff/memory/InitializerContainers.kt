package com.leooff.memory


import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.ComposeContainer
import org.testcontainers.containers.wait.strategy.Wait
import java.io.File
import java.time.Duration

class InitializerContainers : ApplicationContextInitializer<ConfigurableApplicationContext> {

    companion object {
        val composeContainer: ComposeContainer =
            ComposeContainer(File("src/test/resources/docker-compose-test.yaml"))
                .withExposedService("postgres-1", 5432,Wait.forListeningPort().withStartupTimeout(Duration.ofSeconds(30)))
                .withLocalCompose(true)
    }

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        composeContainer.start()

        val host = composeContainer.getServiceHost("postgres-1", 5432)
        val port = composeContainer.getServicePort("postgres-1", 5432)

        TestPropertyValues.of(
            "spring.datasource.url=jdbc:postgresql://${host}:${port}/postgres"
        ).applyTo(applicationContext.environment)
    }
}