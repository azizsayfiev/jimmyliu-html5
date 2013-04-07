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
			System.out.println("��ʾʱ���ݳ���");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("��ʾ����");
			e.printStackTrace();
		}
		return array.toString();
	}	
	
}
