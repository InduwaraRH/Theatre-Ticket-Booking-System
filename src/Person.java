public class Person {
    private String name;
    private String surname;
    private String email;

    public Person(String name, String surname, String email) { //Parameterized the constructor
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
   //Getters and setters for name, surname,email
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "person: "+
                "Name= "+name +
                ",Surname= " + surname +
                ",Email= " + email;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
