package PageObjects;

import java.util.ArrayList;
import java.util.List;
 
import org.openqa.selenium.WebElement;
 
public class ElementToString {

	public static List<String> convertData(List<WebElement> a, List<String> b ){
		b = new ArrayList<String>();
		for(int i =0; i<a.size(); i++) {
			b.add(a.get(i).getText());			
		}

		return b;
	}
 
}
