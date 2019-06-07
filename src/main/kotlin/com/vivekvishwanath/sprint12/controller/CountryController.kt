package com.vivekvishwanath.sprint12.controller

import com.vivekvishwanath.sprint12.Sprint12Application
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.*

@RestController
@RequestMapping("/countries")
class CountryController {

    val allCountriesByGDP: ResponseEntity<*>
        @GetMapping(value = ["/economy"], produces = ["application/json"])
        get() {
            return ResponseEntity(Sprint12Application.myCountryList.countryList.
                    sortedByDescending { it.gdp?.toLong() }, HttpStatus.OK)
        }

}