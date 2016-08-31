package seedu.addressbook.data.person;

public class PostalCode{
	public final String value;
	
	public PostalCode(String code){
		this.value = code;
	}
	
	public String toString(){
		return value;
	}
}