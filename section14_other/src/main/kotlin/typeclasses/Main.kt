package typeclasses

fun main() {

    // Exercise 1
    exercise1()
    println()

    // Exercise 2
    val medal = Olympics().yourMedalIs(1)
    println(medal)
    println(Olympics().whatIsYourPosition(medal))
}

/*
A network server responds with this information about blog articles
- Title
- Content
- Number of readers
You receive 2 articles from the server.
Update the title to suit your blog but also keep the originals.
Print out all the article information.
 */
fun exercise1() {
    val article1 = BlogArticle("Titanic", "...." , 1000)
    val article2 = BlogArticle("News in Limpopo", "...." , 7)
    val myBlogArticle1 = article1.copy(title = "My thoughts about: ${article1.title}")
    val myBlogArticle2 = article2.copy(title = "My observation about: ${article1.title}")

    println(article1)
    println(article2)

    println(myBlogArticle1)
    println(myBlogArticle2)
}
data class BlogArticle(val title: String, val content: String, var readCnt: Int)

/*
The medals in the olympics are
GOLD - 1st place
SILVER - 2nd place
BRONZE - 3rd place
NONE - other
Create a class Olympics that has a function which returns the medal a contestant won based on the position they finished on.
It also has a function which returns the position of a contestant based on the medal they won.
Create an object of that class and call its methods.
 */
class Olympics {
    fun yourMedalIs(finishPlace: Int): Medal {
        val res = Medal.entries.filter { it.ordinal == finishPlace }
        return if (res.isEmpty()) {
            Medal.NONE
        } else {
            res.first()
        }
    }

    fun whatIsYourPosition(medal: Medal): String {
        return when (medal) {
            Medal.GOLD -> "1st place"
            Medal.SILVER -> "2nd place"
            Medal.BRONZE -> "3rd place"
            Medal.NONE -> "Other"
        }
    }
}
enum class Medal {
    GOLD,
    SILVER,
    BRONZE,
    NONE
}