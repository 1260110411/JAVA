import java.lang.reflect.Field;
import java.sql.Connection;

public class first {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 String[] key={"����","DE"};
//	        String[] value={"INL123","123"};
//	        String result=JSONSynthesizer.SynthesizerJSON(key,value);
//	        System.out.println(result);
//	        System.out.println("------------------------------------------------------------------------");
//	        String result1=JSONSynthesizer.SynthesizerJSONList("���",key,value);
//	        System.out.println(result1);
//	        System.out.println("------------------------------------------------------------------------");
//	        String result2=JSONSynthesizer.SynthesizerJSONJSON("���",key,value);
//	        System.out.println(result2);
		
//			String sql_1="insert into student values('990403','����','��','12','1','2101')";
//			JDBC_SQLHelp.jdbcTest("select * from ClassInfo");
		 
		String[] key=new String[3];
	    String[] value={"INL123","123","12"};
		DayPlan Test=new DayPlan();
		try {
			Field[] fields = Test.getClass().getDeclaredFields();
			if(value.length==fields.length) {
				for(int i = 0 ; i < fields.length ; i++) {
				    //�����Ƿ�������ʣ������޸�ԭ���ķ���Ȩ�����δʡ�
					fields[i].setAccessible(true);
					System.out.println(fields[i].getName());
					key[i]=fields[i].getName();
					//System.out.println(fields[i].getName()+":"+fields[i].get(Test));
				}
			}
			else {
				System.out.println("�ַ������Ȳ�ƥ�䣡");
			}
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		 String result=JSONSynthesizer.SynthesizerJSON(key,value);
		 System.out.println(result);
	}
}
