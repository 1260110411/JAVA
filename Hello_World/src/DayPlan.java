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
DayPlan(){
	
}
DayPlan(String[] value){
	Name=value[0];
	Age=Integer.parseInt(value[1]);
	Address=value[2];
	}
JSONObject DayPlanToJSON(DayPlan Test) throws JSONException{
	//DayPlan Test=new DayPlan();
	JSONObject result=JSONSynthesizer.SynthesizerJSONList("cese",Test);
	System.out.println(result);
	return result;
}
}
