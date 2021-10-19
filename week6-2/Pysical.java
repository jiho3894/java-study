package classTest06;

public class Pysical {
	String name;
	int age;
	float height;
	float weight;
	String email;
	
	Pysical(String name ,int age,float height,float weight , String email)	{
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.email = email;
	}
	
	void update(int age) {
		this.age = age;
	}
	
	void update(int age,float weight) {
		this.age = age;
		this.weight = weight;
	}
	
	void update(int age,float weight , String email) {
		this.age = age;
		this.weight = weight;
		this.email = email;
	}
}
