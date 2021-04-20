import java.util.Objects;

public class Person {
	protected final String name;
	protected final String surname;
	int age;
	String city;

	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public Person(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}


	public Person(String name, String surname, int age, String city) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean hasAge() {
		if (getAge() != 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasCity() {
		if (getCity() == null) {
			return true;
		} else {
			return false;
		}
	}

	public void happyBirthday() {
		if (hasAge() == true) {setAge(getAge() + 1);}
	}

	@Override
	public String toString() {
		return "Person{" +
						"name='" + name + '\'' +
						", surname='" + surname + '\'' +
						", age=" + age +
						", city='" + city + '\'' +
						'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Person)) return false;
		Person person = (Person) o;
		return getAge() == person.getAge() && getName().equals(person.getName()) && getSurname().equals(person.getSurname()) && Objects.equals(getCity(), person.getCity());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getSurname(), getAge(), getCity());
	}

	public PersonBuilder newChildBuilder() {
		if (hasAge() == true) {
			setAge(age);
		} else {
			setAge(0);
		}

		if (hasCity() == true) {
			setCity("Город не известен");
		}
		return new PersonBuilder(name, surname, age, city);
	}
}

