package com.ourspots.api.controller

import com.ourspots.api.dto.MarkerResponse
import com.ourspots.common.response.ApiResponse
import com.ourspots.domain.place.entity.PlaceType
import com.ourspots.domain.place.service.PlaceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/map")
class MapController(
    private val placeService: PlaceService
) {

    @GetMapping("/markers")
    fun getMarkers(
        @RequestParam(required = false) type: PlaceType?,
        @RequestParam(required = false) swLat: Double?,
        @RequestParam(required = false) swLng: Double?,
        @RequestParam(required = false) neLat: Double?,
        @RequestParam(required = false) neLng: Double?
    ): ApiResponse<List<MarkerResponse>> {
        return ApiResponse.success(placeService.getMarkers(type, swLat, swLng, neLat, neLng))
    }

    @PostMapping("/markers/refresh")
    fun refreshMarkers(): ApiResponse<List<MarkerResponse>> {
        placeService.evictMarkersCache()
        return ApiResponse.success(placeService.getMarkers(null, null, null, null, null))
    }
}
