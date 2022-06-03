/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package job.search

import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertNotNull

class AppTest {

    val app = App()

    @Test fun appHasAGreeting() {
        assertNotNull(app.greeting, "app should have a greeting")
    }

    @Test fun video_get_one() {
        runBlocking {
            val video = app.fetchOneVideo(1)
            println(video)
        }
    }

    @Test fun get_more_videos() {
        runBlocking {
            (1..25).map { id ->
                app.fetchOneVideo(id)
            }
        }
    }

    @Test fun get_more_videos_async() {
        runBlocking {
            app.fetchVideos()
        }
    }
}