import dao.AddressDAO;
import dao.EmployeeDAO;
import dao.ProjectDAO;

import entity.Address;
import entity.Employee;
import entity.Project;

import service.AddressDAOService;
import service.EmployeeDAOService;
import service.ProjectDAOService;

import java.sql.Date;
import java.util.Calendar;

import java.util.HashSet;
import java.util.Set;

public class Start {
    public static void main(String[] args) {

        Address address = new Address();
        address.setCountry("DC");
        address.setCity("Gotham City");
        address.setStreet("Arkham street 1");
        address.setPostCode("0987");


        Employee employee = new Employee();
        employee.setFirstName("James");
        employee.setLastName("Gordon");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Project project = new Project();
        project.setTitle("5678");

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

        AddressDAO addressDAO = new AddressDAOService();
        EmployeeDAO employeeDAO = new EmployeeDAOService();
        ProjectDAO projectDAO = new ProjectDAOService();

  /*      addressDAO.add(address);
        employeeDAO.add(employee);
        projectDAO.add(project);
        */
        Address a = addressDAO.getById(1L);
        System.out.println(a);

    }
}
