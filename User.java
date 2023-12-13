public class User {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private int age;

    public User(String email, String firstName, String lastName, String password, int age) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.age = age;
    }
    private boolean isValidEmail() {
        return email.matches("^(.+)@(\\S+)$");
    }
    private boolean isValidFirstName() {
        return firstName != null && !firstName.isEmpty();
    }
    private boolean isValidLastName() {
        return lastName != null && !lastName.isEmpty();
    }
    private boolean isValidPassword() {
        return (password.length() >= 8 && password.length() <  40 && password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*"));
    }
    private boolean isValidAge() {
        return age > 13;
    }

    public boolean isValid() {
        return isValidEmail() && isValidPassword() && isValidAge() && isValidFirstName() && isValidLastName();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return this.email;
    }
}
