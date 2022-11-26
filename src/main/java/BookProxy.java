import java.util.List;

public class BookProxy implements IBook {
  private IBook book;

  private String bookId;

  public BookProxy(String bookId) {
    this.bookId = bookId;
  }

  @Override
  public List<String> getDetails() {
    if (this.book == null) {
      this.book = new Book(this.bookId);
    }
    return this.book.getDetails();
  }

  @Override
  public String getInternalCode(String authToken) {
    if (authToken != "access_token") {
      throw new IllegalArgumentException("Acesso não autorizado");
    }
    if (this.book == null) {
      this.book = new Book(this.bookId);
    }
    return this.book.getInternalCode(authToken);
  }
}
