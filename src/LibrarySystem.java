import java.time.LocalDate;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Ferdydurke", "Witold Gombrowicz");
        Book book2 = new Book("Lalka", "Bolesław Prus");

        User user1 = new User("JohnDoe");
        User user2 = new User("JaneSmith");

        library.addBook(book1);
        library.addBook(book2);
        library.addUser(user1);
        library.addUser(user2);

        library.rentBook(book1, user1);

        LocalDate today = LocalDate.now().plusDays(15);
        user1.increasePenaltyPoints(5);
        user1.getPenaltyExpirationDate(today.minusDays(5));
        library.returnBook(book1);
        
        library.rentBook(book2, user2);
        library.returnBook(book2);
    }
}