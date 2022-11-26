import java.util.List;

public interface IBook {
  List<String> getDetails();

  String getInternalCode(String authToken);
}
