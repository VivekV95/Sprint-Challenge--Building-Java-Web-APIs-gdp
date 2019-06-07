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

    //localhost:8081/countries/economy
    val allCountriesByGDP: ResponseEntity<*>
        @GetMapping(value = ["/economy"], produces = ["application/json"])
        get() {
            return ResponseEntity(Sprint12Application.myCountryList.countryList.
                    sortedByDescending { it.gdp?.toLong() }, HttpStatus.OK)
        }

    //localhost:8081/countries/names
    val allCountriesByName: ResponseEntity<*>
        @GetMapping(value = ["/names"], produces = ["application/json"])
        get() {
            return ResponseEntity(Sprint12Application.myCountryList.
                    countryList.sortedBy { it.name }, HttpStatus.OK)
        }

    //localhost:8081/countries/country/stats/median
    val medianGdp: ResponseEntity<*>
        @GetMapping(value = ["country/stats/median"], produces = ["application/json"])
        get() {
            return ResponseEntity(Sprint12Application.
                    myCountryList.countryList.sortedBy { it.gdp?.toLong() }.get(
                    Sprint12Application.myCountryList.countryList.size/2),
                    HttpStatus.OK)
        }
}
