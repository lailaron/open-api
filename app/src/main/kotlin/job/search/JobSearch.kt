package job.search

// Fuel
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

data class Job(val id: Int, val description: String)

fun getOneJob() {
    "".httpGet()
}