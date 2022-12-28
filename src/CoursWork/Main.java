package CoursWork;

public class Main {
    private static final Employee[] employees = {
            new Employee("Иванова Дарья Олеговна", 5, 48000),
            new Employee("Копылова Анна Дмитриевна", 4, 55000),
            new Employee("Григорьев Иван Евгеньевич", 2, 25000),
            new Employee("Бастрыкин Анатолий Николаевич", 3, 58200),
            new Employee("Хлыстов Евгений Сергеевич", 1, 45877),
            new Employee("Пирогов Святослав Львович", 5, 98000),
            new Employee("Казиматова Алия Аликовна", 2, 78000),
            new Employee("Игнатьев Игнат Борисович", 4, 65000),
            new Employee("Сидоров Артем Артемович", 3, 38800),
            new Employee("Пирогова Екатерина Анатольевна", 1, 103000),

    };
    public static void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static double sumSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }

    public static Employee EmployeeMinSalary() {
        Employee result = employees[0];
        double minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee EmployeeMaxSalary() {
        Employee result = employees[0];
        double maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static double averageSalary() {
        double average = 0;
        sumSalary();
        average = sumSalary() / employees.length;
        return average;
    }

    public static void receiveFullName() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    public static void indexingWages(double percent) {
        Employee result = null;
        for (Employee employee : employees) {
            employee.setSalary((employee.getSalary() * percent) / 100 + employee.getSalary());
            result = employee;
            System.out.println(result);
        }
    }

    public static Employee findEmployeeMinSalary(int department) {
        double employeeMinSalary = Integer.MAX_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (employee.getSalary() < employeeMinSalary) {
                employeeMinSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee findEmployeeMaxSalary(int department) {
        double employeeMaxSalary = Integer.MIN_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                continue;
            }
            if (employee.getSalary() > employeeMaxSalary) {
                employeeMaxSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static double sumOfExpenses(int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static double averageSalary(int department) {
        int countEmployee = 0;
        double sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
                countEmployee++;
            }
        }
        return sum / countEmployee;
    }

    public static void indexingWagesByDepartment(int department, int percent) {
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + (employee.getSalary() * percent / 100));
                result = employee;
                System.out.println("Индексация зарплаты сотрудника отдела на " + percent + " процентов: " + result);
            }
        }
    }

    public static void printEmployeeOfDepartment(int department) {
        for (Employee employee : employees) {
            if ((employee.getDepartment() == department)) {
                System.out.println(employee.getFullName() + ", " + employee.getSalary());
            }
        }
    }

    public static void findUsingWithSmallerNumber(int number) {
        for (Employee employee : employees) {
            if (employee.getSalary() < number) {
                System.out.println(employee);
            }
        }
    }

    public static void findUsingWithBiggerNumber(int number) {
        for (Employee employee : employees) {
            if (employee.getSalary() > number) {
                System.out.println(employee);
            }
        }
    }

    public static void printSeparator() {
        System.out.println("===============================================================================================================================");
    }

    public static void main(String[] args) {
        printEmployees();
        printSeparator();
        System.out.println("Сумма затрат на зарплаты в месяц: " +sumSalary());
        printSeparator();
        System.out.println("Сотрудник с минимальной заработной платой " + EmployeeMinSalary());
        printSeparator();
        System.out.println("Сотрудник с максимальной заработной платой " + EmployeeMaxSalary());
        printSeparator();
        System.out.println("Среднее значение зарплат "+ averageSalary());
        printSeparator();
        receiveFullName();
        printSeparator();
        //indexingWages(7);
        printSeparator();
        System.out.println("Сотрудник с минальной зарплатой: " + findEmployeeMinSalary(5));
        printSeparator();
        System.out.println("Сотрудник с максимальной зарплатой: "+ findEmployeeMaxSalary(3));
        printSeparator();
        System.out.println("Сумма затрат на зарплату по отделу: " + sumOfExpenses(2));
        printSeparator();
        System.out.println("Средняя зарплата по отделу: " + averageSalary(1));
        printSeparator();
        //indexingWagesByDepartment(3,5);
        printSeparator();
        printEmployeeOfDepartment(3);
        printSeparator();
        findUsingWithSmallerNumber(40000);
        printSeparator();
        findUsingWithBiggerNumber(70000);
        printSeparator();
    }
}

