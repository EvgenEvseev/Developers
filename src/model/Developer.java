package model;



public class Developer {
    private static  long i;
    private static String n;
    private static String p;
    private static int s;

    public  Developer(long ID, String name, String profession, int salary) {
        i = ID;
        n = name;
        p = profession;
        s = salary;
    }

    public static String getID(){
        return String.valueOf(i);
    }

    public static String getName() {
        return n;
    }

    public static String getProf(){
        return p;
    }

    public static String getSal(){
        return String.valueOf(s);
    }
}
