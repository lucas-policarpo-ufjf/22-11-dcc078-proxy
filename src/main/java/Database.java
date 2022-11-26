import java.util.HashMap;
import java.util.Map;

public class Database {
  private static Map<String, Book> books = new HashMap<>();

  public static Book getBook(String id) {
    return books.get(id);
  }

  public static void saveBook(Book book) {
    books.put(book.getId(), book);
  }

}