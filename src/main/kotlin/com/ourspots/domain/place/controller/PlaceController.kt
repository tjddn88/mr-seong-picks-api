package com.ourspots.domain.place.controller

import com.ourspots.api.dto.*
import com.ourspots.common.response.ApiResponse
import com.ourspots.domain.auth.service.JwtProvider
import com.ourspots.domain.place.entity.PlaceType
import com.ourspots.domain.place.service.PlaceService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/places")
class PlaceController(
    private val placeService: PlaceService,
    private val jwtProvider: JwtProvider
) {

    @GetMapping
    fun getAllPlaces(
        @RequestParam(required = false) type: PlaceType?,
        @RequestHeader("Authorization", required = false) authHeader: String?
    ): ApiResponse<List<PlaceResponse>> {
        val authenticated = jwtProvider.isValidAuthHeader(authHeader)
        return ApiResponse.success(placeService.getAllPlaces(type, authenticated))
    }

    @GetMapping("/{id}")
    fun getPlace(
        @PathVariable id: Long,
        @RequestHeader("Authorization", required = false) authHeader: String?
    ): ApiResponse<PlaceResponse> {
        val authenticated = jwtProvider.isValidAuthHeader(authHeader)
        return ApiResponse.success(placeService.getPlace(id, authenticated))
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPlace(
        @Valid @RequestBody request: PlaceCreateRequest
    ): ApiResponse<PlaceResponse> {
        return ApiResponse.success(placeService.createPlace(request))
    }

    @PutMapping("/{id}")
    fun updatePlace(
        @PathVariable id: Long,
        @Valid @RequestBody request: PlaceUpdateRequest
    ): ApiResponse<PlaceResponse> {
        return ApiResponse.success(placeService.updatePlace(id, request))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePlace(@PathVariable id: Long) {
        placeService.deletePlace(id)
    }

}
