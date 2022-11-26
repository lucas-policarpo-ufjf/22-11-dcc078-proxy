import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;

public class BookProxyTest {

  @BeforeEach
  void setUp() {
    Database.saveBook(new Book("id_1", "The End of Eternity", "Isaac Asimov"));
    Database.saveBook(new Book("id_2", "Robot Dreams", "Isaac Asimov"));
  }

  @Test
  void shouldReturnBookDetailsCorrectly() {
    BookProxy book = new BookProxy("id_1");
    assertEquals(Arrays.asList("The End of Eternity", "Isaac Asimov"), book.getDetails());
  }

  @Test
  void shouldReturnInternalCodeWithCorrectAuthCode() {
    BookProxy book = new BookProxy("id_2");
    assertNotEquals(null, book.getInternalCode("access_token"));
  }

  @Test
  void shouldThrowsExceptionWithInvalidAuthCodeToGetInternalCode() {
    try {
      BookProxy book = new BookProxy("id_1");

      book.getInternalCode("invalid_token");
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Acesso não autorizado", e.getMessage());
    }
  }

}
