
# Ktor-HTTP

Welcome to the ktor-HTTP repository! This repository contains a collection of projects aimed at building APIs using the Ktor framework. Below, you'll find information about the various projects and a section on contributions.

## API Reference

#### Get all items

```http
  GET /api/items
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

#### Get item

```http
  GET /api/items/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### add(num1, num2)

Takes two numbers and returns the sum.


## Authors

- [@fatiq123](https://github.com/fatiq123)


## Contributing

Contributions are always welcome!

See `contributing.md` for ways to get started.

Please adhere to this project's `code of conduct`.


## Features

- Ktor-Http
- Kotlin Embeeded
- CLean Code
- Cross platform


## Feedback

If you have any feedback, please reach out to us at fatiqhussnain1@gmail.com


## 🚀 About Me
I'm a Computer Science student At University of Engineering and Technology Lahore Pakistan. I have passion for creating amazing and helpful projects for people. My stacks includes Jetpack Compose. XML. Kotlin. Dart. Flutter. Node.js. Ktor. Python. AI. 


# Hi, I'm Fatiq Hussnain! 👋


## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/fatiq-hussnain-146a32293/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/fatiq_hussnain)


## 🛠 Skills
Jetpack Compose. XML. Kotlin. Dart. Flutter. Node.js. Ktor. Python. AI.


## Related

Here is my other github repository for Api Development using Node.js and Express.js

https://github.com/fatiq123/Api-Development


## Run Locally

Clone the project

```bash
  git clone https://github.com/your-username/Ktor-HTTP.git
  cd Ktor-HTTP
```

Go to the project directory

```bash
  cd Ktor-HTTP
```



## Usage/Examples

```Kotlin

                        Application.kt file

import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
}


                            Routing.kt file

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}


```


## Tech Stack

**Client:** Ktor-Kotlin

**Server:** Ktor-Http Client

