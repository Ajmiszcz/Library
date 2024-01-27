import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Library {
    private Map<Book, User> bookToUserMap;
    private Set<Book> availableBooks;
    private Set<User> users;

    public Library() {
        this.bookToUserMap = new HashMap<>();
        this.availableBooks = new HashSet<>();
        this.users = new HashSet<>();
    }

    public void addBook(Book book) {
        availableBooks.add(book);
    }

    public void removeBook(Book book) {
        availableBooks.remove(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void rentBook(Book book, User user) {
        if (availableBooks.contains(book) && users.contains(user)) {
            bookToUserMap.put(book, user);
            availableBooks.remove(book);
            System.out.println(user.getUsername() + " rented the book: " + book);
        } else {
            System.out.println("Cannot rent the book. Invalid book or user.");
        }
    }

    public void returnBook(Book book) {
        if (bookToUserMap.containsKey(book)) {
            User user = bookToUserMap.get(book);
            bookToUserMap.remove(book);
            availableBooks.add(book);

            LocalDate today = LocalDate.now();
            if (today.isAfter(user.getPenaltyExpirationDate(today.minusDays(5)))) {
                int daysOverdue = today.getDayOfMonth() - user.getPenaltyExpirationDate(today.minusDays(5)).lengthOfMonth();
                user.increasePenaltyPoints(daysOverdue);
            }

            System.out.println(user.getUsername() + " returned the book: " + book);
        } else {
            System.out.println("Cannot return the book. Book not rented.");
        }
    }
}