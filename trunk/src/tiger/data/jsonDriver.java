package tiger.data;

import  org.json.JSONArray;
import  org.json.JSONObject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jsonDriver {
	
	public static String rsToJsonString (ResultSet rs)
	{		

        JSONArray array = new JSONArray(); 
		try 
		{
			while (rs.next()) 
			{
				 JSONObject json = new JSONObject();
			     json.put("id", rs.getInt("id"));
			     json.put("name", rs.getString("name"));
			     json.put("message", rs.getString("message"));
			     json.put("postdate", rs.getString("postdate")); 
			     array.put(json);     
			}
			
		} catch (SQLException e) {
			System.out.println("显示时数据出错。");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("显示出错。");
			e.printStackTrace();
		}
		return array.toString();
	}	
	
}
