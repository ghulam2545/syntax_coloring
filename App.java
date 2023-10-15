import com.ghulam.Lexer;
import com.ghulam.Reader;

public class App {
    public static void main(String[] args) {
        var source = Reader.read(args);
        Lexer.highlight(source);
    }
}