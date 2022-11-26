
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Book implements IBook {
  private String id;
  private String name;
  private String author;
  private String internalCode;

  public Book(String id, String name, String author) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.internalCode = UUID.randomUUID().toString();
  }

  public Book(String id) {
    this.id = id;
    Book book = Database.getBook(id);
    this.name = book.name;
    this.author = book.author;
    this.internalCode = book.internalCode;
  }

  public String getId() {
    return id;
  }

  @Override
  public List<String> getDetails() {
    return Arrays.asList(this.name, this.author);
  }

  @Override
  public String getInternalCode(String authToken) {
    return this.internalCode;
  }

}
