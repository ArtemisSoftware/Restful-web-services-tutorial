package com.artemissoftware.restful_web_services.filter

import com.fasterxml.jackson.databind.ser.FilterProvider
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
class FilteringController {

    @GetMapping("/filtering") //field2
    fun filtering(): SomeBean {
        val someBean = SomeBean("value1", "value2", "value3")

//        val mappingJacksonValue = MappingJacksonValue(someBean)
//
//        val filter =
//            SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3")
//
//        val filters: FilterProvider =
//            SimpleFilterProvider().addFilter("SomeBeanFilter", filter)
//
//        mappingJacksonValue.filters = filters
//
//
//        return mappingJacksonValue
        return someBean
    }

    @GetMapping("/filtering-list") //field2, field3
    fun filteringList(): List<SomeBean> {
        val list =  listOf(
            SomeBean("value1", "value2", "value3"),
            SomeBean("value4", "value5", "value6")
        )
//        val mappingJacksonValue = MappingJacksonValue(list)
//
//        val filter =
//            SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3")
//
//        val filters: FilterProvider =
//            SimpleFilterProvider().addFilter("SomeBeanFilter", filter)
//
//        mappingJacksonValue.filters = filters


        return list
    }
}