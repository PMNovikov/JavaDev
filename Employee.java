public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String telephone;
    private double salary;
    private int age;

    public Employee(String fullName, String position, String email, String telephone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public void showEmployeeData(){
        System.out.println("Employee:");
        System.out.printf("\tFull Name:\t%s\n", fullName);
        System.out.printf("\tPosition:\t%s\n", position);
        System.out.printf("\tEmail:\t\t%s\n", email);
        System.out.printf("\tTelephone:\t%s\n", telephone);
        System.out.printf("\tSalary:\t\t%.2f\n", salary);
        System.out.printf("\tAge:\t\t%d\n", age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
