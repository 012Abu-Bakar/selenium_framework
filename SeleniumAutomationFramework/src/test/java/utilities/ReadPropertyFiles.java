package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFiles {

	public static void main(String[] args) throws IOException {
		
		FileReader fileR = new FileReader("C:\\Users\\huzai\\eclipse-workspace\\SeleniumAutomationFramework\\src\\test\\resources\\configfiles\\config.properties");
		Properties p = new Properties();
		p.load(fileR);
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("testurl"));
}

}
