import org.json.JSONException;
import org.json.JSONObject;

public class DayPlan {
String Name;
int Age;
String Address;
public String getName() {
	return Name;
}
public void setName(String name) {
	this.Name = name;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	this.Age = age;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	this.Address = address;
}
public DayPlan(){
	
}
public DayPlan(String[] value){
	Name=value[0];
	Age=Integer.parseInt(value[1]);
	Address=value[2];
}

public JSONObject DayPlanToJSON(DayPlan Test) throws JSONException{
	JSONObject result=JSONSynthesizer.SynthesizerJSON(Test);
	System.out.println(result);
	return result;
}
public JSONObject DayPlanToJSONList(DayPlan Test) throws JSONException{
	JSONObject result=JSONSynthesizer.SynthesizerJSONList("cese",Test);
	System.out.println(result);
	return result;
}
public JSONObject DayPlanToJSONJSON(DayPlan Test) throws JSONException{
	JSONObject result=JSONSynthesizer.SynthesizerJSONJSON("cese",Test);
	System.out.println(result);
	return result;
}
}
