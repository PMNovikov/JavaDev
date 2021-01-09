public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        fillData(employees);
        showData(employees);

    }
    public static void fillData(Employee[] employees){
        employees[0] = new Employee("Ivanov Ivan Ivanovich", "Director",
                "ivanov@organisation.com", "+7(495)495-95-95", 90000, 32);
        employees[1] = new Employee("Smirnov Alexander Petrovich", "Manager",
                "smirnov@organisation.com", "+7(495)495-95-95", 30000, 45);
        employees[2] = new Employee("Petrov Petr Petrovich", "Seller",
                "ivanov@organisation.com", "+7(495)495-95-95", 30000, 41);
        employees[3] = new Employee("Sidorov Egor Petrovich", "Accountant",
                "ivanov@organisation.com", "+7(495)495-95-95", 60000, 35);
        employees[4] = new Employee("Hrenova Gadya Petrovich", "Secretar",
                "hgp@organisation.com", "+7(495)495-95-95", 120000, 19);
    }

    public static void showData(Employee[] employees){
        for (int i=0; i<employees.length; i++){
            if (employees[i].getAge() > 40){
                employees[i].showEmployeeData();
            }
        }
    }
}
