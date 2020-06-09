import java.lang.reflect.Field;
import java.sql.Connection;

import org.json.JSONException;
import org.json.JSONObject;

public class first {

	public static void main(String[] args) throws JSONException {
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
		
//		{"VS.RemoteControl.DownloadFile.FullUrl":"https://az667904.vo.msecnd.net/pub/Default/v2/dyntelconfig.json",
//			"VS.RemoteControl.DownloadFile.IsSuccess":"False","VS.RemoteControl.DownloadFile.IsFromCache":"False",
//			"VS.RemoteControl.DownloadFile.ErrorMessage":"Non-Protocol Error SendFailure",
//			"Reserved.EventId":"675d6645-0559-403a-b4ec-dd875ab0767b",
//			"Reserved.SessionId":"f5fe275f-9f4d-4978-91ab-e1d16fb71f64",
//			"Context.Default.VS.Core.Machine.Id":"8a1c401d-5f10-4c1e-a7b1-4e2e785c25fb",
//			"Context.Default.VS.Core.TelemetryApi.ProductVersion":"14.1.674-updateE2B5AE29",
//			"Context.Default.VS.Hub.Session.ProductBranch":"d14rel",
//			"Context.Default.VS.Core.User.Type":"External",
//			"Context.Default.VS.Core.MacAddressHash":"f0fac6c4beb085f58951048a965daf69cdf4fcaeccd2de3ddd50bd35f5f02f3c",
//			"Context.Default.VS.Hub.Session.HubVersion":"1.0",
//			"Context.Default.VS.Hub.Session.ProductVersion":"14.0.25420.1",
//			"Context.Default.VS.Core.OS.Version":"6.1.7601.1",
//			"Context.Default.VS.Core.User.IsMicrosoftInternal":"False",
//			"Context.Default.VS.Core.User.Id":"183b263e-f76e-4eb1-9e98-dd947d1c4762",
//			"Context.Default.VS.Core.ExeVersion":"14.0.25420.1",
//			"Context.Default.VS.Core.ExeName":"microsoft.vshub.server.httphostx64",
//			"Context.Default.VS.Core.User.IsInternal":"False",
//			"Context.Default.VS.Core.User.IsOptedIn":"True","Reserved.ChannelUsed":"aivortex"}
         
         
		String[] key=new String[3];
	    String[] value={"INL123","123","12"};
		DayPlan Test=new DayPlan(value);
		JSONObject result=Test.DayPlanToJSON(Test);
//        JSONObject result=JSONSynthesizer.SynthesizerJSONList("cese",Test);
		 System.out.println(result);
	}
}
