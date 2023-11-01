package com.example.plugins

import com.example.dao.DAOFacade
import com.example.dao.DAOFacadeCacheImpl
import com.example.dao.DAOFacadeImpl
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import kotlinx.coroutines.runBlocking
import java.io.File

fun Application.configureRouting() {
    routing {
       static("/static") {
           resources("files")
       }





            val dao: DAOFacade = DAOFacadeCacheImpl(
                delegate = DAOFacadeImpl(),
                storagePath = File(environment?.config?.property("storage.ehcacheFilePath")?.getString())
            ).apply {
                runBlocking {
                    if(allArticles().isEmpty()) {
                        addNewArticle("The drive to develop!", "...it's what keeps me going.")
                    }
                }
            }






        get("/") {
            call.respondRedirect("articles")
        }

        route("articles") {

            get {
//                call.respond(FreeMarkerContent("index.ftl", mapOf("articles" to articles)))
                call.respond(FreeMarkerContent("index.ftl", mapOf("articles" to dao.allArticles())))
            }
            get("new") {
                call.respond(FreeMarkerContent("new.ftl", model = null))
            }

            get {
                // Show a list of articles
            }
            get("new") {
                // Show a page with fields for creating a new article
            }
            post {
                // Save an article
                val formParameters = call.receiveParameters()
                val title = formParameters.getOrFail("title")
                val body = formParameters.getOrFail("body")
//                val newEntry = Article.newEntry(title = title, body = body)
//                articles.add(newEntry)
                val article = dao.addNewArticle(title = title, body = body)
//                call.respondRedirect("/articles/${newEntry.id}")
                call.respondRedirect("/articles/${article?.id}")

            }
            get("{id}") {
                // Show an article with a specific id
                val id = call.parameters.getOrFail<Int>("id").toInt()
//                call.respond(FreeMarkerContent("show.ftl", mapOf("article" to articles.find { it.id == id })))
                call.respond(FreeMarkerContent("show.ftl", mapOf("article" to dao.article(id = id))))
            }
            get("{id}/edit") {
                // Show a page with fields for editing an article
                val id = call.parameters.getOrFail<Int>("id").toInt()
//                call.respond(FreeMarkerContent("edit.ftl", mapOf("article" to articles.find { it.id == id })))
                call.respond(FreeMarkerContent("edit.ftl", mapOf("article" to dao.article(id = id))))
            }
            post("{id}") {
                // Update or delete an article
                val id = call.parameters.getOrFail<Int>("id").toInt()
                val formParameters = call.receiveParameters()
                when (formParameters.getOrFail("_action")) {
                    /*"update" -> {
                        val index = articles.indexOf(articles.find { it.id == id })
                        val title = formParameters.getOrFail("title")
                        val body = formParameters.getOrFail("body")
                        articles[index].title = title
                        articles[index].body = body
                        call.respondRedirect("/articles/$id")
                    }
                    "delete" -> {
                        articles.removeIf { it.id == id }
                        call.respondRedirect("/articles")
                    }*/
                    "update" -> {
                        val title = formParameters.getOrFail("title")
                        val body = formParameters.getOrFail("body")
                        dao.editArticle(id, title, body)
                        call.respondRedirect("/articles/$id")
                    }
                    "delete" -> {
                        dao.deleteArticle(id)
                        call.respondRedirect("/articles")
                    }
                }
            }
        }
    }

}
