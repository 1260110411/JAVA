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
     * �ϳ�Json�ļ�
	 * @throws JSONException 
     * */
    public static JSONObject SynthesizerJSON(Object DP) throws JSONException{
       try{
   			Field[] fields = DP.getClass().getDeclaredFields();
   		    JSONObject JSON = new JSONObject(new LinkedHashMap());
   			for(int i = 0 ; i < fields.length ; i++) {
				    //�����Ƿ�������ʣ������޸�ԭ���ķ���Ȩ�����δʡ�
					fields[i].setAccessible(true);
					JSON.put(fields[i].getName(), fields[i].get(DP));//�������ֶ�����ΪKey,�ֶ�ֵ��ΪValue
				}	
   			return JSON;
       }
       catch(Exception ex){
    	   JSONObject JSON = new JSONObject();
    	   JSON.put("result","Jsonת���쳣��");
           return JSON;
       }
    }
    /**
     * �ϳ�Json-List�ļ�
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
                    //�����Ƿ�������ʣ������޸�ԭ���ķ���Ȩ�����δʡ�
					fields[i].setAccessible(true);
                    map.put(fields[i].getName(), fields[i].get(DP));
                    list.add(map);
                }
                JSON.put(Key, list); 
                return JSON;
        }
        catch(Exception ex){
        	JSONObject JSON = new JSONObject();
     	    JSON.put("result","Jsonת���쳣��");
            return JSON;
        }
    }
    /**
     * �ϳ�Json-Json�ļ�
     * @throws JSONException 
     * */
    public static JSONObject SynthesizerJSONJSON(String Key,Object DP) throws JSONException{
        try{
        	JSONObject JSONOne = new JSONObject(new LinkedHashMap());
            JSONObject JSONTwo = new JSONObject(new LinkedHashMap());
            Field[] fields = DP.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
            	//�����Ƿ�������ʣ������޸�ԭ���ķ���Ȩ�����δʡ�
				fields[i].setAccessible(true);
                JSONTwo.put(fields[i].getName(), fields[i].get(DP));
            }
            JSONOne.put(Key,JSONTwo);
            return JSONOne;
        }
        catch(Exception ex){
        	JSONObject JSON = new JSONObject();
     	    JSON.put("result","Jsonת���쳣��");
            return JSON;
        }
    }
}
