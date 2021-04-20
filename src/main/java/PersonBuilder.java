public class PersonBuilder {
	private  String name;
	private String surname;
	private int age;
	private String city;

	public PersonBuilder(String name, String surname, int age, String city){
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.city = city;
	}

	public PersonBuilder() {

	}

	public PersonBuilder setName(String name) {
		this.name = name;
		return PersonBuilder.this;
	}

	public PersonBuilder setSurname(String surname) {
		this.surname = surname;
		return PersonBuilder.this;
	}

	public PersonBuilder setAge(int age) {
		this.age = age;
		return PersonBuilder.this;
	}

	public PersonBuilder setCity(String city) {
		this.city = city;
		return PersonBuilder.this;
	}

	public Person build() {
		if (name == null || surname == null){
			throw new IllegalArgumentException("Не указан основные поля NAME или SURNAME");
		}

		if (age < 0){
			throw new IllegalArgumentException("Указан не корректный возраст");
		}

		return new Person(name, surname, age, city);
	}
}