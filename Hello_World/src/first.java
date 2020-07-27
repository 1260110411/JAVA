import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;

import org.json.JSONException;
import org.json.JSONObject;

public class first {

	public static void main(String[] args) throws JSONException, IOException {
		// TODO Auto-generated method stub
//		 String[] key={"测试","DE"};
//	        String[] value={"INL123","123"};
//	        String result=JSONSynthesizer.SynthesizerJSON(key,value);
//	        System.out.println(result);
//	        System.out.println("------------------------------------------------------------------------");
//	        String result1=JSONSynthesizer.SynthesizerJSONList("结果",key,value);
//	        System.out.println(result1);
//	        System.out.println("------------------------------------------------------------------------");
//	        String result2=JSONSynthesizer.SynthesizerJSONJSON("结果",key,value);
//	        System.out.println(result2);
		
//			String sql_1="insert into student values('990403','佩奇','男','12','1','2101')";
//			JDBC_SQLHelp.jdbcTest("select * from ClassInfo");
	
         
         
	     String[] value={"INL123","123","12"};
	     
//	     DayPlan Test=new DayPlan(value);
//		JSONObject result=Test.DayPlanToJSON(Test);
//	     JSONObject result= Start.st(value);
//	     String as=result.toString();
	     
//	     JSONObject result=new JSONObject();
//	     DayPlan Test=new DayPlan(value);
//		 result=Test.DayPlanToJSONJSON(Test);
//		  System.out.println(result.toString());
	     person p=new teacher();
	     p.work();
	}
}
