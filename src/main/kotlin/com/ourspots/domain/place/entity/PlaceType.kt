package com.ourspots.domain.place.entity

enum class PlaceType {
    RESTAURANT,              // 맛집
    KIDS_PLAYGROUND,         // 아이 놀이터
    RELAXATION,              // 아빠의 쉼터
    MY_FOOTPRINT,            // 나의 발자취
    RECOMMENDED_RESTAURANT,  // 추천 맛집
    RECOMMENDED_SPOT;        // 추천 명소

    companion object {
        val PERSONAL_TYPES = listOf(MY_FOOTPRINT, RECOMMENDED_RESTAURANT, RECOMMENDED_SPOT)
    }
}
