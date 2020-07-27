import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JSONSynthesizer {
	 /**
     * 合成Json文件
	 * @throws JSONException 
     * */
    public static JSONObject SynthesizerJSON(Object DP) throws JSONException{
       try{
   			Field[] fields = DP.getClass().getDeclaredFields();
   		    JSONObject JSON = new JSONObject(new LinkedHashMap());
   			for(int i = 0 ; i < fields.length ; i++) {
				    //设置是否允许访问，不是修改原来的访问权限修饰词。
					fields[i].setAccessible(true);
					JSON.put(fields[i].getName(), fields[i].get(DP));//将类中字段名存为Key,字段值存为Value
				}	
   			return JSON;
       }
       catch(Exception ex){
    	   JSONObject JSON = new JSONObject();
    	   JSON.put("result","Json转换异常！");
           return JSON;
       }
    }
    /**
     * 合成Json-List文件
     * @throws JSONException 
     * */
    public static JSONObject SynthesizerJSONList(String Key,Object DP) throws JSONException{
        try{
//        	DayPlan DP=(DayPlan)DP1;
                JSONObject JSON = new JSONObject(new LinkedHashMap());
                List<Object> list = new ArrayList<Object>();
                Field[] fields = DP.getClass().getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    //设置是否允许访问，不是修改原来的访问权限修饰词。
					fields[i].setAccessible(true);
                    map.put(fields[i].getName(), fields[i].get(DP));
                    list.add(map);
                }
                JSON.put(Key, list); 
                return JSON;
        }
        catch(Exception ex){
        	JSONObject JSON = new JSONObject();
     	    JSON.put("result","Json转换异常！");
            return JSON;
        }
    }
    /**
     * 合成Json-Json文件
     * @throws JSONException 
     * */
    public static JSONObject SynthesizerJSONJSON(String Key,Object DP) throws JSONException{
        try{
        	JSONObject JSONOne = new JSONObject(new LinkedHashMap());
            JSONObject JSONTwo = new JSONObject(new LinkedHashMap());
            Field[] fields = DP.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
            	//设置是否允许访问，不是修改原来的访问权限修饰词。
				fields[i].setAccessible(true);
                JSONTwo.put(fields[i].getName(), fields[i].get(DP));
            }
            JSONOne.put(Key,JSONTwo);
            return JSONOne;
        }
        catch(Exception ex){
        	JSONObject JSON = new JSONObject();
     	    JSON.put("result","Json转换异常！");
            return JSON;
        }
    }
}
