package seedu.addressbook.data.person;

public class Street{
	public final String value;
	
	public Street(String street){
		this.value = street;
	}
	
	public String toString(){
		return value;
	}
}