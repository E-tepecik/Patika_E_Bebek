package E_Bebek;


public class Employee {
    public String name;
    public double salary;
    public int workHours;
    public int hireYear;


    public Employee() {
    }

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {
        double vergi = 0;
        if (salary > 1000) {
            vergi = (salary * 0.03);
        }

        return vergi;
    }

    public double raiseSalary() {
        int yıl = 2021;
        double maasArtısı = 0;
        if (yıl - hireYear > 19) {
            maasArtısı = (salary + bonus() - tax()) * 0.15;
        } else if (9 < yıl - hireYear && yıl - hireYear < 20) {
            maasArtısı = (salary + bonus() - tax()) * 0.10;
        } else if (yıl - hireYear < 10) {
            maasArtısı = (salary + bonus() - tax()) * 0.05;
        }

        return maasArtısı;

    }

    public double bonus() {
        double haftalıkBonus;

        double aylıkBonus = 0;
        if (workHours > 40) {
            haftalıkBonus = (workHours - 40) * 30;
        } else {
            haftalıkBonus = 0;
        }
        aylıkBonus = haftalıkBonus * 4;
        return aylıkBonus;
    }

    @Override
    public String toString() {
        return
                "name= " + name + "\n" +
                        "salary= " + salary + "\n" +
                        "workHours= " + workHours + "\n" +
                        "hireYear= " + hireYear + "\n" +
                        "vergi= " + tax() + "\n" +
                        "bonus=" + bonus() + "\n" +
                        "vergi ve bonuslar ile birlikte toplam maas =" + ((salary - tax()) + bonus()) + "\n" +
                        "maas artısı=" + raiseSalary() + "\n" +
                        "toplam maas=" + (salary + raiseSalary() + bonus());
    }

    public static void main(String[] args) {

        String name = "Kemal";
        double salary = 2000.0;
        int workHours = 45;
        int hireYear = 1985;


        Employee employee = new Employee(name, salary, workHours, hireYear);

        System.out.println(employee.toString());

        //workHours haftalık çalışma saati olarak hesaplamaya dahil edilmiştir.
        // Bir ay 4 hafta baz alınarak hesaplamalar yapılmıştır.

    }
}