import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONSynthesizer {
	 /**
     * �ϳ�Json�ļ�
     * */
    public static String SynthesizerJSON(String[] Key,String[] Value){
       try{
           if(Key.length==Value.length){
               JSONObject JSON = new JSONObject();
               for (int i=0;i<Key.length;i++){
                   JSON.put(Key[i],Value[i]);
               }
               return JSON.toString();
           }
           else {
               return "��ֵ��������ƥ�䣬���飡";
           }
       }
       catch(Exception ex){
           return ex.getMessage();
       }
    }
    /**
     * �ϳ�Json-List�ļ�
     * */
    public static String SynthesizerJSONList(String Key,String[] ValueKey,String[] ValueValue){
        try{
            if(ValueKey.length==ValueValue.length){
                JSONObject JSON = new JSONObject();
                List<Object> list = new ArrayList<Object>();
                for (int i = 0; i < ValueKey.length; i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put(ValueKey[i],  ValueValue[i]);
                    list.add(map);
                }
                JSON.put(Key, list);
                return JSON.toString();
            }
            else {
                return "��ֵ��������ƥ�䣬���飡";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    /**
     * �ϳ�Json-Json�ļ�
     * */
    public static String SynthesizerJSONJSON(String Key,String[] ValueKey,String[] ValueValue){
        try{
            if(ValueKey.length==ValueValue.length){
                JSONObject JSONOne = new JSONObject();
                JSONObject JSONTwo = new JSONObject();
                for (int i = 0; i < ValueKey.length; i++) {
                    JSONTwo.put(ValueKey[i], ValueValue[i]);
                }
                JSONOne.put(Key,JSONTwo);
                return JSONOne.toString();
            }
            else {
                return "��ֵ��������ƥ�䣬���飡";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
}
