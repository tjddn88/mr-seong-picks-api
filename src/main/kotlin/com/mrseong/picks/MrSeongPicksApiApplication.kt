package com.mrseong.picks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class MrSeongPicksApiApplication

fun main(args: Array<String>) {
	runApplication<MrSeongPicksApiApplication>(*args)
}
