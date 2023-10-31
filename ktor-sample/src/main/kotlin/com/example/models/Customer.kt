package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Customer(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String
)

//val customers = mutableListOf<Customer>()

val customers = mutableListOf(
    Customer("1", "fatiq", "hussnain", "fatiqhussnain1@gmail.com"),
    Customer("1", "fatiq", "hussnain", "fatiqhussnain1@gmail.com")
)


