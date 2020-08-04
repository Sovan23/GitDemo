package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Locationdetails;

public class TestDataBuild {

	public AddPlace addplace(String language,String name,String address)
	
	{
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setName(name);
		p.setPhone_number("+91-9916433416");
		p.setWebsite("www.sovan.com");
		Locationdetails l = new Locationdetails();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		List<String> mylist = new ArrayList<String>();
		mylist.add("Boka park");
		mylist.add("test");
		p.setTypes(mylist);
		return p;
	}
}
