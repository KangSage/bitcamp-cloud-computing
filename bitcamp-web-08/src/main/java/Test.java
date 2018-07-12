import java.io.File;
import java.net.URL;

public class Test {

    public static void main(String[] args) throws Exception {
        ClassLoader defaultClassLoader = 
                ClassLoader.getSystemClassLoader();
        
        URL url = ClassLoader.getSystemResource("bitcamp/pms");
        
        File file = new File(url.toURI());
        System.out.println(url.toString());
        
        System.out.println(file.getAbsolutePath());
        System.out.println(file.isDirectory());
        file.list();
        
    }

}
