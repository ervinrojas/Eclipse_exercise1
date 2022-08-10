package DataProvider;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.packagefactory.Base.Setup;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class DataUtil extends Setup {
	
	public DataUtil(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@DataProvider
	public Object[] dataProvider1() {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		
		//Read JSON file
		try {
			Object obj = parser.parse(new FileReader("/JavaProject/Json/data.json"));
			jsonObject = (JSONObject) obj;
		}catch(IOException | ParseException exception) {
			exception.printStackTrace();
		}
		
		//Array to store JSOn data
		Object[] data = new Object[1];
		
		//Store JSON data as key/value pairs in a hasMap
		HashMap<String, String> hashMap = new LinkedHashMap<>();
		if(jsonObject != null) {
			Set<String> jsonObjKeys = jsonObject.keySet(); 
			for (String jsonObjKey : jsonObjKeys) {
				hashMap.put(jsonObjKey, (String) jsonObject.get(jsonObjKey));
			}
		}else {
			//log.error("error retrieving JSON data");
			throw new RuntimeException();
		}
		
		//Store HashMap in an Array and return array
		data[0] = hashMap;
		return data;
	}

}
