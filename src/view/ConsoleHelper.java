package view;

import java.util.Scanner;

public class ConsoleHelper {
    DeveloperView Devi=new DeveloperView();
    public void Start() {

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
                    System.out.println("Для добавления сотрудника введите данные :");
                    System.out.println();
                    Devi.DevScan();
                    break;

                case 2:
                    System.out.println("Для удаления сотрудника введите ID :");
                    Devi.ViRemove();
                    break;
                case 3:
                    System.out.println("Для получения информации о сотруднике введите ID :");
                    Devi.ViGet();
                    break;

                case 4:
                    System.out.println("Информация о сотрудниках по списку: ");
                    Devi.ViGetAll();
                    break;

                case 5:
                    System.out.println("Выход");
                    System.exit(0);
            }
        }
    }
}
