package com.vivekvishwanath.sprint12.repository

import com.vivekvishwanath.sprint12.model.Country


interface CheckCountry {
    fun test(country: Country): Boolean

    companion object {
        inline operator fun invoke(crossinline op: (country: Country) -> Boolean) =
                object  : CheckCountry {
                    override fun test(country: Country): Boolean = op(country)
                }
    }
}