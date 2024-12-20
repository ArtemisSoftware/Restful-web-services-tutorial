package com.artemissoftware.restful_web_services.filter

import com.fasterxml.jackson.annotation.JsonFilter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties


//@JsonIgnoreProperties(*["field1", "field2"])
//@JsonFilter("SomeBeanFilter")
data class SomeBean(
    val field1: String,
    @field:JsonIgnore
    val field2: String,
    var field3: String
)
