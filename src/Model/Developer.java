package Model;



public class Developer {
    public  long i;
    public String n;
    public String p;
    public int s;

  public  Developer(long ID, String name, String profession, int salary) {
        i = ID;
        n = name;
        p = profession;
        s = salary;
    }
    public String toString(){
        return +i+", "+n+", "+p+", "+s+" /";
    }
}
