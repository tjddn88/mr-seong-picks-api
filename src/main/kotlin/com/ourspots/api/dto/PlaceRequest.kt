package com.ourspots.api.dto

import com.ourspots.domain.place.entity.PlaceType
import jakarta.validation.constraints.*

data class PlaceCreateRequest(
    @field:NotBlank
    val name: String,

    @field:NotNull
    val type: PlaceType,

    @field:NotBlank
    val address: String,

    @field:NotNull
    @field:DecimalMin("-90.0")
    @field:DecimalMax("90.0")
    val latitude: Double,

    @field:NotNull
    @field:DecimalMin("-180.0")
    @field:DecimalMax("180.0")
    val longitude: Double,

    val description: String? = null,

    @field:Min(1)
    @field:Max(3)
    val grade: Int? = null
)

data class PlaceUpdateRequest(
    @field:Size(min = 1)
    val name: String? = null,
    val type: PlaceType? = null,
    @field:Size(min = 1)
    val address: String? = null,
    @field:DecimalMin("-90.0")
    @field:DecimalMax("90.0")
    val latitude: Double? = null,
    @field:DecimalMin("-180.0")
    @field:DecimalMax("180.0")
    val longitude: Double? = null,
    val description: String? = null,
    @field:Min(1)
    @field:Max(3)
    val grade: Int? = null,
    val googlePlaceId: String? = null,
    val googleRating: Double? = null,
    val googleRatingsTotal: Int? = null
)
