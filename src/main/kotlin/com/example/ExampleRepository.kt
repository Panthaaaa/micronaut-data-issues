package com.example

import io.micronaut.data.annotation.Embeddable
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository
import reactor.core.publisher.Flux
import java.util.UUID

@MappedEntity
data class ExampleUserDTO(
        @field:Id
        val id: UUID,
        @Relation(Relation.Kind.EMBEDDED) val userProfile: ExampleUserProfileDTO
)

@Embeddable
data class ExampleUserProfileDTO(
        val firstName: String? = null,
        val lastName: String? = null
)

@JdbcRepository(dialect = Dialect.POSTGRES)
interface ExampleUserRepository : ReactiveStreamsCrudRepository<ExampleUserDTO, UUID> {
    fun findByUserProfileFirstNameIlike(firstName: String): Flux<ExampleUserDTO>
}
