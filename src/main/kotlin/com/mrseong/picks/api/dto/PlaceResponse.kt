package com.mrseong.picks.api.dto

import com.mrseong.picks.domain.place.entity.Place
import com.mrseong.picks.domain.place.entity.PlaceType
import java.time.LocalDateTime

data class PlaceResponse(
    val id: Long,
    val name: String,
    val type: PlaceType,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val description: String?,
    val imageUrl: String?,
    val grade: Int?,
    val googlePlaceId: String?,
    val googleRating: Double?,
    val googleRatingsTotal: Int?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun from(place: Place) = PlaceResponse(
            id = place.id,
            name = place.name,
            type = place.type,
            address = place.address,
            latitude = place.latitude,
            longitude = place.longitude,
            description = place.description,
            imageUrl = place.imageUrl,
            grade = place.grade,
            googlePlaceId = place.googlePlaceId,
            googleRating = place.googleRating,
            googleRatingsTotal = place.googleRatingsTotal,
            createdAt = place.createdAt,
            updatedAt = place.updatedAt
        )
    }
}

data class PlaceDetailResponse(
    val id: Long,
    val name: String,
    val type: PlaceType,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val description: String?,
    val imageUrl: String?,
    val grade: Int?,
    val googlePlaceId: String?,
    val googleRating: Double?,
    val googleRatingsTotal: Int?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun from(place: Place) = PlaceDetailResponse(
            id = place.id,
            name = place.name,
            type = place.type,
            address = place.address,
            latitude = place.latitude,
            longitude = place.longitude,
            description = place.description,
            imageUrl = place.imageUrl,
            grade = place.grade,
            googlePlaceId = place.googlePlaceId,
            googleRating = place.googleRating,
            googleRatingsTotal = place.googleRatingsTotal,
            createdAt = place.createdAt,
            updatedAt = place.updatedAt
        )
    }
}
