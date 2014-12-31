package edu.javacourse.clazz;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class ObjectTypeExample {

    public static void main(String[] args) {

        Book book = new Book();
        book.setName("Java for beginners");

        System.out.println("Inside main: " + book);

        Book returnedBook = changeName(book, "Java for advanced");

        System.out.println("Inside main after changing name - book: " + book);
        System.out.println("Inside main after changing name - returnedBook: " + returnedBook);

    }

    public static Book changeName(Book book, String name) {
        System.out.println("Inside changeName: " + book);

        book.setName(name);

        System.out.println("Inside changeName after change: " + book);
        return book;
    }

    static class Book {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
