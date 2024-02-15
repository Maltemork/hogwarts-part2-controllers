package generic;

public class Person {

  // Fields
  private String firstName;
  private String lastName;
  private String middleName;
  private String birthday;
  private int age = 0;

  // Getters
  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFullName() {
    if (lastName == null) {
      return firstName;
    } else if (middleName == null) {
      return firstName + " " + lastName;
    }
    else {
      return firstName + " " + middleName + " " + lastName;
    }
  }

  public int getAge() {
    return age;
  }

  // Setters
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  // Full name setter.
  public void setFullName(String fullName) {
    String fixedName = fullName.trim();
    // If there are no spaces in the given name (only first name given).
    if (!fixedName.contains(" ")) {
      this.firstName = fixedName;
      this.middleName = "";
      this.lastName = "none";
      //   If there is only 1 space in the given name (first name + last name).
    } else if (fixedName.indexOf(" ") == fixedName.lastIndexOf(" ")) {
      this.firstName = fixedName.substring(0, fixedName.indexOf(" "));
      this.lastName =
        fixedName.substring(fixedName.indexOf(" ") + 1);
      this.middleName = "";
      // If there are more than 1 space in the given name (first name + middle name + last name).
    } else {
      this.firstName = fixedName.substring(0, fixedName.indexOf(" "));

      this.middleName =
        fixedName.substring(
          fixedName.indexOf(" ") + 1,
          fixedName.lastIndexOf(" ")
        );

      this.lastName =
        fixedName.substring(fixedName.lastIndexOf(" ") + 1);
    }
  }

  public void setAge(int age) {
    this.age = age;
  }

  // Get nice little string with information.
  @Override
  public String toString() {
    if (middleName == null) {
      return (
        "Firstname: " +
        firstName +
        " | Lastname: " +
        lastName +
        " | Age: " +
        age
      );
    } else {
      return (
        "Firstname: " +
        firstName +
        " | Middlename: " +
        middleName +
        " | Lastname: " +
        lastName +
        " | Age: " +
        age
      );
    }
  }

  // Person constructors.
  public Person(
    String firstName,
    String middleName,
    String lastName,
    String birthday,
    int age
  ) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.birthday = birthday;
    this.age = age;
  }

  public Person(String firstName, String middleName, String lastName, int age) {
    this(firstName, middleName, lastName, null, age);
  }

  public Person(String firstName, String middleName, String lastName) {
    this(firstName, middleName, lastName, null, 0);
  }

  public Person(String firstName, String lastName, int age) {
    this(firstName, null, lastName, null, age);
  }

  public Person(String firstName, String lastName) {
    this(firstName, null, lastName, null, 0);
  }

  public Person(String fullName, int age) {
    this.setFullName(fullName);
    this.age = age;
  }

  public Person(String fullName) {
    this.setFullName(fullName);
  }

  public Person(Person other) {
    firstName = other.firstName;
    middleName = other.middleName;
    lastName = other.lastName;
    birthday = other.birthday;
    age = other.age;
  }

  public Person() {}
}
