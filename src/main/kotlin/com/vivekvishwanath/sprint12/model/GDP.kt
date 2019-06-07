package com.vivekvishwanath.sprint12.model

import java.io.Serializable
import java.util.concurrent.atomic.AtomicLong

data class GDP(var name: String? = null,
               var gdp: String? = null,
               val id: Long = counter.incrementAndGet()): Serializable {

    companion object {
        private val counter = AtomicLong()
    }
}