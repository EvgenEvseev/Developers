package view;

import controller.Controller;
import model.Developer;

import java.util.Scanner;

public class DeveloperView {
    Controller con = new Controller();
    Scanner scan = new Scanner(System.in);

    public void DevScan() {
        String name;
        String prof;
        int sal;
        long i;
        System.out.println("Введите имя ");
        name = scan.nextLine();

        System.out.println("Введите профессию");
        prof = scan.nextLine();

        while (true) {
            System.out.println("Введите зарпалту");
            if (scan.hasNextInt()) {
                sal = scan.nextInt();
                break;
            } else System.out.println("Некоректный ввод данных, введите число ");
            scan.next();
        }

        while (true) {
            System.out.println("Введите ID");
            if (scan.hasNextLong()) {
                i = scan.nextLong();
                break;
            } else System.out.println("Некоректный ввод данных, введите число");
            scan.next();
        }
        Developer devscan = new Developer(i, name, prof, sal);
        con.ConSave(devscan);
    }

    public long IDscan() {
        for (; ; ) {
            if (scan.hasNextLong()) {
                return scan.nextLong();
            } else System.out.println("Неверный тип данных,введите число");
            scan.next();
        }
    }

    public void ViRemove(){
        long id= IDscan();
        con.ConRemove(id);
    }

    public void ViGet(){
        long id=IDscan();
        con.ConGetByID(id);
    }
    public void ViGetAll(){
        con.ConGetAll();
    }
}













