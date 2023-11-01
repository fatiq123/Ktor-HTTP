package com.example.models

import org.jetbrains.exposed.sql.*
import java.io.Serializable

import java.util.concurrent.atomic.AtomicInteger

//class Article private constructor(val id: Int, var title: String, var body: String) {
//
//    companion object {
//        private val idCounter = AtomicInteger()
//
//        fun newEntry(title: String, body: String) =
//            Article(id = idCounter.getAndIncrement(), title = title, body = body)
//    }
//}
//
//
//val articles = mutableListOf(Article.newEntry(
//    "The drive to develop!",
//    "...it's what keeps me going."
//))

data class Article(val id: Int, val title: String, val body: String): Serializable

object Articles : Table() {
    val id = integer("id").autoIncrement()
    val title = varchar("title", 128)
    val body = varchar("body", 1024)

    override val primaryKey = PrimaryKey(id)
}
