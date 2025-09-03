package exercise;

public class EmployeeLDAPWrapper implements Employee {
    private final EmployeeLDAP employeeLDAP;

    public EmployeeLDAPWrapper(EmployeeLDAP employeeLDAP) {
        this.employeeLDAP = employeeLDAP;
    }

    @Override
    public String getId() {
        return employeeLDAP.get("id");
    }

    @Override
    public String getFirstName() {
        return employeeLDAP.get("firstName");
    }

    @Override
    public String getLastName() {
        return employeeLDAP.get("lastName");
    }

    @Override
    public String getEmail() {
        return employeeLDAP.get("email");
    }
}
