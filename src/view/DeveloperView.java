package view;


import dao.DeveloperDAO;
import model.Developer;

import java.util.Scanner;

public class DeveloperView {
    private void devscan(){
        DeveloperDAO Dao=new DeveloperDAO();
        Scanner scan = new Scanner(System.in);
        String name;
        String prof;
        int sal;
        long i;
        System.out.println("Введите имя ");
        name = scan.nextLine();

        System.out.println("Введите профессию");
        prof = scan.nextLine();


        while(true) {
            System.out.println("Введите зарпалту");
            if (scan.hasNextInt()) {
                sal = scan.nextInt();
                break;
            } else System.out.println("Некоректный ввод данных, введите число ");
            scan.next();
        }

        while(true) {
            System.out.println("Введите ID");
            if(scan.hasNextLong()){
                i = scan.nextLong();
                break;
            }else System.out.println("Некоректный ввод данных, введите число");
           scan.next();
        }
        Developer devscan = new Developer(i, name, prof, sal);
        Dao.safe(devscan);
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
                        break;

                    case 2:
                        for(;;){
                            System.out.println("Удаление работника введите ID ");
                            if(scan.hasNextLong()){
                                long id= scan.nextLong();
                                Dao.remove(id);
                                break;
                            }else System.out.println("Неверный тип данных");
                            scan.next();
                        }
                            break;
                    case 3:
                        System.out.println("Для получения информация о сотруднике введите его ID ");
                        for(;;){
                            if(scan.hasNextLong()){
                                long ID = scan.nextLong();
                                Dao.getByID(ID);
                                break;
                            }else System.out.println("Неверный тип данных, введите число");
                            scan.next();
                         }
                        break;

                    case 4:
                        Dao.getAll();
                        break;

                    case 5:
                        System.out.println("Выход");
                        System.exit(0);
                    }
                }
             }
    }


