package ubb.dp1920.examples.structural;

/**
 * Example based on:
 * https://www.javacodegeeks.com/2015/09/proxy-design-pattern.html#proxy_pattern
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The report that will be accessed by staff
 */
interface ReportGenerator extends Remote {
    public String generateDailyReport() throws RemoteException;
}

/**
 * Staff classes used for role-based access
 */
interface Staff {
    public boolean isOwner();

    public void setReportGenerator(ReportGenerator reportGenerator);
}

class Employee implements Staff {
    private ReportGenerator reportGenerator;

    @Override
    public void setReportGenerator(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    @Override
    public boolean isOwner() {
        return false;
    }

    public String generateDailyReport() {
        try {
            return reportGenerator.generateDailyReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

class Owner implements Staff {
    private boolean isOwner = true;
    private ReportGenerator reportGenerator;

    @Override
    public void setReportGenerator(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    @Override
    public boolean isOwner() {
        return isOwner;
    }

    public String generateDailyReport() {
        try {
            return reportGenerator.generateDailyReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

/**
 * Proxy class to protect access to the daily report
 */
class ReportGeneratorProtectionProxy implements ReportGenerator {
    ReportGenerator reportGenerator;
    Staff staff;

    public ReportGeneratorProtectionProxy(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String generateDailyReport() {
        if (staff.isOwner()) {
            ReportGenerator reportGenerator = null;
            try {

                // Real-life solution
                // reportGenerator = (ReportGenerator)
                // Naming.lookup("rmi://127.0.0.1/PizzaCoRemoteGenerator");
                reportGenerator = new ReportGenerator() {
                    @Override
                    public String generateDailyReport() throws RemoteException {
                        return "my daily report";
                    }
                };

                return reportGenerator.generateDailyReport();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        } else {
            return "Not Authorized to view report.";
        }
    }
}

public class ProxyExampleProtection {
    public static void main(String[] args) {
        Owner owner = new Owner();
        ReportGenerator reportGenerator = new ReportGeneratorProtectionProxy(owner);
        owner.setReportGenerator(reportGenerator);

        Employee employee = new Employee();
        reportGenerator = new ReportGeneratorProtectionProxy(employee);
        employee.setReportGenerator(reportGenerator);
        System.out.println("For owner:");
        System.out.println(owner.generateDailyReport());
        System.out.println("For employee:");
        System.out.println(employee.generateDailyReport());
    }
}