package com.example.routes

import io.ktor.server.routing.*
import com.example.models.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import org.apache.http.HttpStatus
import com.example.models.Customer.*


fun Route.customerRouting() {
    route("/customer") {
        get {
            if (customers.isNotEmpty()) {
                call.respond(customers)
            } else {
                call.respondText("No customer found", status = HttpStatusCode.OK)
            }
        }
        get("{id?}") {
            val id =
                call.parameters["id"] ?: return@get call.respondText("Missing id", status = HttpStatusCode.BadRequest)
            val customer = customers.find { it.id == id } ?: return@get call.respondText(
                "No customer found with id $id",
                status = HttpStatusCode.NotFound
            )
            call.respond(customer)
        }
        post {
            val customer = call.receive<Customer>()
            customers.add(customer)
            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (customers.removeIf { it.id == id }) {
                call.respondText("Customer removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Customer not found", status = HttpStatusCode.NotFound)
            }
        }

    }
}