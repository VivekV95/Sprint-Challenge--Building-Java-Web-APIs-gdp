package com.vivekvishwanath.sprint12.controller

import com.vivekvishwanath.sprint12.Sprint12Application
import com.vivekvishwanath.sprint12.model.Country
import com.vivekvishwanath.sprint12.repository.CheckCountry
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
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

    //localhost:8081/countries/country/{id}
    @GetMapping(value = ["/country/{id}"], produces = ["application/json"])
    fun getCountryById(@PathVariable id: Long): ResponseEntity<*> {
        val rtnGdp = Sprint12Application.myCountryList.findCountry(
                CheckCountry{ it.id == id })
        return ResponseEntity(rtnGdp, HttpStatus.OK)
    }

    //localhost:8081/countries/total
    val totalGdp: ResponseEntity<*>
        @GetMapping(value = ["/total"], produces = ["application/json"])
        get() {
            var sum: Long? = 0
            for (country in Sprint12Application.myCountryList.countryList) {
                sum = country.gdp?.toLong()?.let { sum?.plus(it) }
            }
            return ResponseEntity(Country("Total", sum.toString(), 0), HttpStatus.OK)
        }

    //localhost:8081/countries/economy/table
    @GetMapping(value = ["/economy/table"], produces = ["application/json"])
    fun getCountryTable(): ModelAndView {
        val mav = ModelAndView()
        mav.viewName = "countries"
        mav.addObject("countryList",
                Sprint12Application.myCountryList.countryList.sortedByDescending { it.gdp?.toLong() })
        return mav
    }

    //localhost:8081/countries/names/{s}/{e}
    @GetMapping(value = ["/names/{s}/{e}"], produces = ["application/json"])
    fun getCountryTableByNameRange(@PathVariable s: Char, @PathVariable e: Char): ModelAndView {
        val mav = ModelAndView()
        mav.viewName = "countries"
        mav.addObject("countryList",
                Sprint12Application.myCountryList.countryList.sortedBy { it.name }.
                        filter { it.name?.get(0)?.toLowerCase() in s..e })
        return mav
    }
}
