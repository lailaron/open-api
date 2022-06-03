package job.search

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

// Fuel
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result


class App {

    val greeting: String
    get() {
        return "Hello World!"
    }

    suspend fun fetchOneVideo(id: Int): String {
        println("Fetching one video: " + id)
        val httpAsync =
            "https://my-json-server.typicode.com/kotlin-hands-on/kotlinconf-json/videos/$id"
                .httpGet()
                .responseString {result ->
                    when (result) {
                        is Result.Failure -> {
                            val ex = result.getException()
                            println("EX:" + ex)
                        }
                        is Result.Success -> {
                            val data = result.get()
                            println("DATA:" + data)
                        }
                    }
                }

        httpAsync.join()
        return httpAsync.toString()
    }

    suspend fun fetchVideos(): List<String> = coroutineScope {
        (1..25).map { id ->
            async {
                fetchOneVideo(id)
            }
        }.awaitAll()
    }
}

fun main() {
    println(App().greeting)
}