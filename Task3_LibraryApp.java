import java.util.*;
class Book {
    int id;
    String title;
    boolean isIssued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Issued: " + (isIssued ? "Yes" : "No");
    }
}

class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void viewBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    void issueBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued.");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void returnBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned.");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

public class Task3_LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        // sample books
        lib.addBook(new Book(1, "Java Basics"));
        lib.addBook(new Book(2, "DSA Handbook"));
        lib.addBook(new Book(3, "Spring Boot Guide"));

        boolean running = true;
        while (running) {
            System.out.println("\n1. View Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    lib.viewBooks();
                    break;
                case 2:
                    System.out.print("Enter book ID to issue: ");
                    int issueId = sc.nextInt();
                    lib.issueBook(issueId);
                    break;
                case 3:
                    System.out.print("Enter book ID to return: ");
                    int returnId = sc.nextInt();
                    lib.returnBook(returnId);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
