package com.vivekvishwanath.sprint12.repository

import com.vivekvishwanath.sprint12.model.Country
import org.springframework.stereotype.Component

@Component
class CountryList {
    final val countryList: MutableList<Country> = mutableListOf()
    init {
        countryList.add(Country("United States", "20513000"))
        countryList.add(Country("China", "13457267"))
        countryList.add(Country("Japan", "5070626"))
        countryList.add(Country("Germany", "4029140"))
        countryList.add(Country("United Kingdom", "2808899"))
        countryList.add(Country("France", "2794696"))
        countryList.add(Country("India", "2689992"))
        countryList.add(Country("Italy", "2086911"))
        countryList.add(Country("Brazil", "1909386"))
        countryList.add(Country("Canada", "1733706"))
        countryList.add(Country("South Korea", "1655608"))
        countryList.add(Country("Russia", "1576488"))
        countryList.add(Country("Spain", "1437047"))
        countryList.add(Country("Australia", "1427767"))
        countryList.add(Country("Mexico", "1199264"))
        countryList.add(Country("Indonesia", "1005268"))
        countryList.add(Country("Netherlands", "909887"))
        countryList.add(Country("Saudi Arabia", "769878"))
        countryList.add(Country("Turkey", "713513"))
        countryList.add(Country("Switzerland", "709118"))
        countryList.add(Country("Taiwan", "602678"))
        countryList.add(Country("Sweden", "554659"))
        countryList.add(Country("Poland", "549478"))
        countryList.add(Country("Belgium", "536055"))
        countryList.add(Country("Thailand", "490120"))
        countryList.add(Country("Argentina", "475429"))
        countryList.add(Country("Austria", "459401"))
        countryList.add(Country("Norway", "441439"))
        countryList.add(Country("United Arab Emirates", "432612"))
        countryList.add(Country("Iran", "430082"))
        countryList.add(Country("Nigeria", "397472"))
        countryList.add(Country("South Africa", "376679"))
        countryList.add(Country("Ireland", "366448"))
        countryList.add(Country("Israel", "365599"))
        countryList.add(Country("Hong Kong", "360315"))
        countryList.add(Country("Denmark", "354683"))
        countryList.add(Country("Malaysia", "347290"))
        countryList.add(Country("Singapore", "346621"))
        countryList.add(Country("Colombia", "336940"))
        countryList.add(Country("Philippines", "331678"))
        countryList.add(Country("Pakistan", "306987"))
        countryList.add(Country("Chile", "299887"))
        countryList.add(Country("Bangladesh", "286275"))
        countryList.add(Country("Finland", "276553"))
        countryList.add(Country("Egypt", "249471"))
        countryList.add(Country("Czech Republic", "244540"))
        countryList.add(Country("Vietnam", "241434"))
        countryList.add(Country("Romania", "239440"))
        countryList.add(Country("Portugal", "237962"))
        countryList.add(Country("Iraq", "230911"))
        countryList.add(Country("Peru", "228944"))
        countryList.add(Country("Greece", "218057"))
        countryList.add(Country("New Zealand", "205997"))
        countryList.add(Country("Algeria", "188342"))
        countryList.add(Country("Qatar", "188295"))
        countryList.add(Country("Kazakhstan", "184209"))
        countryList.add(Country("Hungary", "156393"))
        countryList.add(Country("Kuwait", "144523"))
        countryList.add(Country("Ukraine", "126390"))
        countryList.add(Country("Morocco", "118178"))
        countryList.add(Country("Angola", "114504"))
        countryList.add(Country("Ecuador", "107266"))
        countryList.add(Country("Slovakia", "106940"))
        countryList.add(Country("Puerto Rico", "104557"))
        countryList.add(Country("Venezuela", "96328"))
        countryList.add(Country("Sri Lanka", "92504"))
        countryList.add(Country("Kenya", "89591"))
        countryList.add(Country("Ethiopia", "83836"))
        countryList.add(Country("Oman", "81682"))
        countryList.add(Country("Dominican Republic", "81103"))
        countryList.add(Country("Guatemala", "79109"))
        countryList.add(Country("Syria", "77460"))
        countryList.add(Country("Myanmar", "71543"))
        countryList.add(Country("Luxembourg", "68993"))
        countryList.add(Country("Panama", "66031"))
        countryList.add(Country("Bulgaria", "63651"))
        countryList.add(Country("Uruguay", "60933"))
        countryList.add(Country("Costa Rica", "60816"))
        countryList.add(Country("Croatia", "59971"))
        countryList.add(Country("Belarus", "56934"))
        countryList.add(Country("Lebanon", "56709"))
        countryList.add(Country("Tanzania", "55645"))
        countryList.add(Country("Slovenia", "54969"))
        countryList.add(Country("Macau", "53961"))
        countryList.add(Country("Lithuania", "52468"))
        countryList.add(Country("Ghana", "51815"))
        countryList.add(Country("Serbia", "47564"))
        countryList.add(Country("Cote d'Ivoire", "45875"))
        countryList.add(Country("Azerbaijan", "45592"))
        countryList.add(Country("Uzbekistan", "43303"))
        countryList.add(Country("Libya", "43236"))
        countryList.add(Country("Democratic Republic of the Congo", "42692"))
        countryList.add(Country("Turkmenistan", "42764"))
        countryList.add(Country("Jordan", "41869"))
        countryList.add(Country("Paraguay", "41851"))
        countryList.add(Country("Bolivia", "41833"))
        countryList.add(Country("Tunisia", "41662"))
        countryList.add(Country("Bahrain", "39300"))
        countryList.add(Country("Cameroon", "38445"))
        countryList.add(Country("Latvia", "34286"))
        countryList.add(Country("Sudan", "33249"))
    }

    fun findCountry(tester: CheckCountry): Country? {
        for (country in countryList) {
            if (tester.test(country)) {
                return country
            }
        }
        return null
    }

    fun findCountries(tester: CheckCountry): List<Country> {
        val tempCountryList = mutableListOf<Country>()
        for (country in countryList) {
            if (tester.test(country)) {
                tempCountryList.add(country)
            }
        }
        return tempCountryList
    }
}