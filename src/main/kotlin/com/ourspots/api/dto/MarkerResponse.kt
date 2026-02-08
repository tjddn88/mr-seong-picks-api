package com.ourspots.api.dto

import com.ourspots.domain.place.entity.Place
import com.ourspots.domain.place.entity.PlaceType

data class MarkerResponse(
    val id: Long,
    val name: String,
    val type: PlaceType,
    val latitude: Double,
    val longitude: Double,
    val grade: Int?
) {
    companion object {
        fun from(place: Place) = MarkerResponse(
            id = place.id,
            name = place.name,
            type = place.type,
            latitude = place.latitude,
            longitude = place.longitude,
            grade = place.grade
        )
    }
}
