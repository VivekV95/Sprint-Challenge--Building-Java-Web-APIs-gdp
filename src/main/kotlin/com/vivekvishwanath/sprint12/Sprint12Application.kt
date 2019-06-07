package com.vivekvishwanath.sprint12

import com.vivekvishwanath.sprint12.repository.CountryList
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.DispatcherServlet

@SpringBootApplication
class Sprint12Application {

    companion object {
        lateinit var myCountryList: CountryList

        @JvmStatic
        fun main(args: Array<String>) {
            myCountryList = CountryList()
            val ctx = runApplication<Sprint12Application>(*args)

            val dispatcherServlet = ctx.getBean("dispatcherServlet") as DispatcherServlet
            dispatcherServlet.setThrowExceptionIfNoHandlerFound(true)
        }
    }

}
