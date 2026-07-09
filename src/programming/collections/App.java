package programming.collections;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        //List all distinct project in non-ascending order.
        List<String> allDistinctProjects =
                employeeList
                        .stream()
                        .flatMap(e -> e.getProjects().stream())
                        .map(project -> project.getName())
                        .distinct().sorted().collect(Collectors.toList());

        System.out.printf("List all distinct project in non-ascending order: \n%s\n\n" , allDistinctProjects);

        // Print full name of any employee whose firstName starts with ‘A’.
        List<String> employeesWithA =
                employeeList
                .stream()
                .filter(e-> e.getFirstName().startsWith("A"))
                .map(e -> e.getFirstName() + " " + e.getLastName())
                .collect(Collectors.toList());

        System.out.printf("List all employees with A: \n%s\n\n" , employeesWithA);

        //List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)
        List<String> employeesSince2003 =
                employeeList
                        .stream()
                        .filter(e-> e.getId().startsWith("2023"))
                        .map(e -> e.getFirstName() + " " + e.getLastName())
                        .collect(Collectors.toList());

        System.out.printf("List all employees since 2003: \n%s\n\n" , employeesSince2003);

        //Sort employees based on firstName, for same firstName sort by salary.
        Comparator<Employee> comparator = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary).reversed();
        List<Employee> employeesSortedByFirstNameThenSalary =
                employeeList
                        .stream()
                        .sorted(comparator)
                        .collect(Collectors.toList());

        System.out.println("\nSort employees based on firstName, for same firstName sort by salary\n");
        employeesSortedByFirstNameThenSalary
                .stream().map(e-> String.format("%-10s %-10s", e.getFirstName(),e.getSalary())).forEach(name -> System.out.println(name));

        // Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).
        Comparator<Employee> comparatorHigherSalary = Comparator.comparing(Employee::getSalary).reversed();
        long count = 5;
        List<Employee> topNEmployeesHigherSalary =
                employeeList
                        .stream()
                        .sorted(comparatorHigherSalary)
                        .limit(count)
                        .collect(Collectors.toList());

        System.out.printf("\nTop %d with higher salaries.\n", count);
        topNEmployeesHigherSalary
                .stream().map(e-> String.format("%-10s %d", e.getFirstName(),e.getSalary())).forEach(name -> System.out.println(name));

        //Print min salary.
        int minSalary = employeeList
                .stream()
                .mapToInt(e->e.getSalary())
                .min().getAsInt();
        System.out.println("\nMin salary is " +minSalary  );

        System.out.println("\nEmployees with Min salary is " +minSalary  );

        //Print list of all employee with min salary.
        List<Employee> employeesWithMinSalary =employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getSalary, TreeMap::new,Collectors.toList()))
                .firstEntry().getValue();
        employeesWithMinSalary
                .stream().map(e-> String.format("%-10s %10d", e.getFirstName(),e.getSalary())).forEach(name -> System.out.println(name));

        //List of people working on more than 2 projects.
        //e-> e.getProjects().stream().map(p-> p.getName()).collect(Collectors.joining(", ")
        Map<String, String> employeesWith2Projects =employeeList
                .stream()
                .filter(e->e.getProjects().size()>2)
                .collect(Collectors
                        .groupingBy(
                                Employee::getFirstName,
                                Collectors.flatMapping(employee -> employee.getProjects().stream().map(project -> project.getName()),Collectors.joining(","))
                        ));

        employeesWith2Projects.forEach((employee, projects)-> System.out.printf("\n%s is working in following projects:\n%s", employee,projects));

        System.out.println("\n\n");
        //Count of total laptops assigned to the employees.
        long totalLaptopsAssignedAllEmployees =employeeList
                .stream()
                .peek(e-> System.out.println(e.getFirstName() + " has " + e.getTotalLaptopsAssigned()+" laptops assigned"))
                .mapToInt(Employee::getTotalLaptopsAssigned)
                .sum();

        System.out.printf("\nCount of total laptops assigned to the employees: \n%s\n" , totalLaptopsAssignedAllEmployees);

        //Count of all projects with Robert Downey Jr as PM.
        long projectWithIronmanAsPM =employeeList
                .stream()
                .flatMap(e->e.getProjects().stream())
                .filter(p->"Robert Downey Jr".equalsIgnoreCase(p.getProjectManager()))
                .distinct()
                .count();

        System.out.printf("\nCount of all projects with Robert Downey Jr as PM: \n%s\n" , projectWithIronmanAsPM);

        //List of all projects with Robert Downey Jr as PM.
        String projectsWithIronmanAsPM =employeeList
                .stream()
                .flatMap(e->e.getProjects().stream())
                .filter(p->"Robert Downey Jr".equalsIgnoreCase(p.getProjectManager()))
                .distinct()
                .map(p-> p.getName())
                .collect(Collectors.joining (","));

        System.out.printf("\nProject with Robert Downey Jr as PM: \n%s\n" , projectsWithIronmanAsPM);

        //List of all people working with Robert Downey Jr.
        String employeesWorkingWithIronman = employeeList
                .stream()
                .filter(e -> e.getProjects().stream().filter(p->"Robert Downey Jr".equalsIgnoreCase(p.getProjectManager())).findFirst().isPresent())
                .map(Employee::getFirstName)
                .collect(Collectors.joining(", "));

        System.out.printf("\nPeople working with Robert Downey Jr as PM: \n%s\n" , employeesWorkingWithIronman);

        //Create a map based on this data, they key should be the year of joining,
        //and value should be list of all the employees who joined the particular year.

        Map<Integer, String> employeesByYear = employeeList
                .stream()
                .collect(
                        Collectors.groupingBy(
                                employee -> Integer.parseInt(employee.getId().substring(0,4)), Collectors.mapping(employee -> employee.getFirstName() + " " + employee.getLastName(),Collectors.joining(", "))));

        System.out.println("\n\nEmployees by Year:\n");
        employeesByYear.forEach((year, employees)-> System.out.printf("\nin %s following employees join to company:\n%s", year, employees));

        //Create a map based on this data, the key should be year of joining
        // and value should be the count of people joined in that particular year.
        Map<Integer, Long> NumberOfEmployeesByYear = employeeList
                .stream()
                .collect(
                        Collectors.groupingBy(
                                employee -> Integer.parseInt(employee.getId().substring(0,4)), Collectors.counting()));

        System.out.println("\n\nNumber of Employees by Year:\n");
        NumberOfEmployeesByYear.forEach((year, employees)-> System.out.printf("\nNumber of employees joined in %s was %s", year, employees));

    }
}
