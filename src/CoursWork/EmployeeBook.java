package CoursWork;

public class EmployeeBook {
    private static final Integer EMPLOYEE_SIZE = 10;
    private final Employee[] employees = new Employee[EMPLOYEE_SIZE];

    public void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public double sumSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }

    public Employee EmployeeMinSalary() {
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

    public Employee EmployeeMaxSalary() {
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

    public double averageSalary() {
        double average = 0;
        sumSalary();
        average = sumSalary() / employees.length;
        return average;
    }

    public void receiveFullName() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    public void indexingWages(double percent) {
        Employee result = null;
        for (Employee employee : employees) {
            employee.setSalary((employee.getSalary() * percent) / 100 + employee.getSalary());
            result = employee;
            System.out.println(result);
        }
    }

    public Employee findEmployeeMinSalary(int department) {
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

    public Employee findEmployeeMaxSalary(int department) {
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

    public double sumOfExpenses(int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double averageSalary(int department) {
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

    public void indexingWagesByDepartment(int department, int percent) {
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + (employee.getSalary() * percent / 100));
                result = employee;
                System.out.println("Индексация зарплаты сотрудника отдела на " + percent + " процентов: " + result);
            }
        }
    }

    public void printEmployeeOfDepartment(int department) {
        for (Employee employee : employees) {
            if ((employee.getDepartment() == department)) {
                System.out.println(employee.getFullName() + ", " + employee.getSalary());
            }
        }
    }

    public void findUsingWithSmallerNumber(int number) {
        for (Employee employee : employees) {
            if (employee.getSalary() < number) {
                System.out.println(employee);
            }
        }
    }

    public void findUsingWithBiggerNumber(int number) {
        for (Employee employee : employees) {
            if (employee.getSalary() > number) {
                System.out.println(employee);
            }
        }
    }

    public void addNewEmployee(String fullName, int department, double salary) {
            int index = findFreeIndex();
            if (index == -1) {
                System.out.println("Нельзя добавить сотрудника, нет места!");
                return;
            }
            employees[index] = new Employee(fullName, department, salary);
    }
    public int findFreeIndex() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void removeEmployee(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullName().equals(fullName)) {
                employees[i] = null;
            }
        }
    }

    public void changeSalaryEmployee(String fullName, double salary) {
        for (Employee employee : employees) {
            if (employee.getFullName().equals(fullName)) {
                employee.setSalary(salary);
            }
        }
    }

    public void changeDepartmentEmployee(String fullName, int department) {
        for (Employee employee : employees) {
            if (employee.getFullName().equals(fullName)) {
                employee.setDepartment(department);
            }
        }
    }

    public void allDepartmentEmployees(String fullName) {
        int department = 5;
        for (int i = 0; i <= department; i++) {
            System.out.println(" Сотрудники " +i+" отдела: " );
            for (Employee employee : employees) {
                if (employee.getDepartment() == i) {

                System.out.println(employee);
                }
            }
        }
    }
}

