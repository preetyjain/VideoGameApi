package BASERestAssuedBDDProject;

import java.util.HashMap;

public class BaseRestAssuredBDD {
	public static HashMap PUT_DATA() {
		HashMap data=new HashMap();
		
		  data.put("id","103");
		  data.put("name", "Pac-Man");
		  data.put("releaseDate", "2020-01-18T00:16:43.928Z");
		  data.put("reviewSfcore", "5");
		  data.put("catehgory", "Adventure");
		  data.put("ratking", "Universal");
		return data;
	}
	
}
