
import com.formdev.flatlaf.FlatLightLaf;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FlatLightLaf.setup();
        new MainPageWithSideBar().setVisible(true);
    }
}
