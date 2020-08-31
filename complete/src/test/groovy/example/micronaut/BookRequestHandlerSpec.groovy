package example.micronaut;
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class BookRequestHandlerSpec extends Specification {

    @AutoCleanup // <2>
    @Shared
    BookRequestHandler bookRequestHandler = new BookRequestHandler()  // <1>

    void "test Handler"() {
        given:
        Book book = new Book()
        book.name = 'Building Microservices'

        when:
        BookSaved bookSaved = bookRequestHandler.execute(book)  // <3>

        then: 'book name matches the one supplied'
        bookSaved.name == book.name

        and: 'isbn is populated'
        bookSaved.isbn
    }
}
