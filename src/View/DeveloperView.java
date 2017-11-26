package View;


import DAO.DeveloperDAO;
import Model.Developer;

import java.io.IOException;
import java.util.Scanner;

public class DeveloperView {
    void devscan(){
        DeveloperDAO Dao=new DeveloperDAO();
        Scanner scan = new Scanner(System.in);
        String name = null;
        String prof = null;
        int sal = 0;
        long i = 0;
        String info;
        System.out.println("Введите имя ");
        name = scan.nextLine();

        System.out.println("Введите профессию");
        prof = scan.nextLine();


        while(true) {
            System.out.println("Введите зарпалту");
            Scanner scs=new Scanner(System.in);
            if (scs.hasNextInt()) {
                sal = scs.nextInt();
                break;
            } else System.out.println("Некоректный ввод данных, введите число ");
            continue;
        }

        while(true) {
            System.out.println("Введите ID");
            Scanner sci=new Scanner(System.in);
            if(sci.hasNextLong()){
                i = sci.nextLong();
                break;
            }else System.out.println("Некоректный ввод данных, введите число");
           continue;
        }

        Developer devscan = new Developer(i, name, prof, sal);
        Dao.safe(devscan);
        System.out.println("Работник добавлен");

    }

    public void start() {
        DeveloperDAO Dao=new DeveloperDAO();
  while(true){
             Scanner scan = new Scanner(System.in);
             System.out.println("\nДобро пожаловать в базу данных IT работников. Для выбора действий нажмите 1-5.");
             System.out.println("1) Добавить работника. ");
             System.out.println("2) Удалить работника. ");
             System.out.println("3) Информация о работнике по ID.");
             System.out.println("4) Информация в виде списка о всех работниках.");
             System.out.println("5) Выход.");

             int n =0;
             if(scan.hasNextInt()){
                 n = scan.nextInt();
             }else System.out.println("Некоректный ввод данных, введи число от 1 до 5");


                switch (n) {

                    case 1:
                        devscan();
                        continue;
                    case 2:
                        while (true){
                            System.out.println("Удаление работника, введите ID");
                            Scanner sc = new Scanner(System.in);
                            if(sc.hasNextLong()){
                             long id=sc.nextLong();
                             Dao.remove(id);
                                System.out.println("Работник с ID "+id+" удален.");
                             break;
                            }else System.out.println("Неверный тип данных ");
                                continue;
                        }
                        break;

                    case 3:
                        System.out.println("Для получения информация о сотруднике введите его ID ");
                        if(scan.hasNextLong()){
                        long IDget = scan.nextLong();
                        Dao.getByID(IDget);}
                        break;

                    case 4:
                        System.out.println("Информация получена: ");
                        Dao.getAll();
                        break;

                    case 5:
                        System.out.println("Выход");
                        System.exit(0);
                    }
                }
             }
    }


