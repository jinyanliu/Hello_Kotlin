package book

import kotlin.random.Random

fun main() {
    val myBook = Book("ThreeBody", "Liu", "2015")
    println("Here is your book ${myBook.title} written by ${myBook.author} in ${myBook.year}")
    val bookTitleAuthor = myBook.getTitleAndAuthor()
    println("Here is your book ${bookTitleAuthor.first} written by ${bookTitleAuthor.second}")
    val (title, author, year) = myBook.getBook()
    println("Here is your book $title written by $author in $year")

    println("Already borrowed 24, Can borrow again: ${myBook.canBorrow(24)}")
    println("Already borrowed 4, Can borrow again: ${myBook.canBorrow(4)}")
    myBook.printUrl()

    val myPuppy = Puppy()
    while (myBook.pages > 0) {
        myPuppy.playWithBook(myBook)
    }
}

class Book(
    val title: String,
    val author: String,
    val year: String,
    val initialPages: Int = 100,
    var pages: Int = initialPages
) {
    fun getTitleAndAuthor(): Pair<String, String> {
        return title to author
    }

    fun getBook(): Triple<String, String, String> {
        return Triple(title, author, year)
    }

    fun canBorrow(alreadyBorrowed: Int) = alreadyBorrowed < MAX_NUMBER_BORROW

    fun printUrl() {
        println("$BASE_URL$title.html")
    }

    companion object {
        const val BASE_URL = "https://book_api"
        const val MAX_NUMBER_BORROW = 20
    }
}

fun Book.weight() = pages * 1.5
fun Book.tornPages(tornPages: Int) {
    pages -= tornPages
    if (pages < 0) pages = 0
}

class Puppy {
    fun playWithBook(book: Book) {
        println("Current book pages: ${book.pages}. Puppy playing...")
        book.tornPages(Random.nextInt(until = book.initialPages))
        println("Book pages update: ${book.pages}")
    }
}