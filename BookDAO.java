import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
    // Add a book
    public void addBook(String title, String author, String isbn, String publisher, int year, int copies) {
        String sql = "INSERT INTO books (title, author, isbn, publisher, published_year, copies) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, isbn);
            stmt.setString(4, publisher);
            stmt.setInt(5, year);
            stmt.setInt(6, copies);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " book(s) added successfully.");
        } catch (SQLException e) {
            System.err.println("Error while adding book: " + e.getMessage());
        }
    }

    // List all books
    public void listBooks() {
        String sql = "SELECT * FROM books";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                System.out.println(
                        "ID: " + resultSet.getInt("book_id") +
                        ", Title: " + resultSet.getString("title") +
                        ", Author: " + resultSet.getString("author") +
                        ", Copies: " + resultSet.getInt("copies")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error while listing books: " + e.getMessage());
        }
    }
}
