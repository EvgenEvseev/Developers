package controller;

import dao.DeveloperDAO;
import model.Developer;
import view.DeveloperView;

import java.util.ArrayList;

public class Controller {
    public static void main(String[] args) {
        DeveloperDAO dao=new DeveloperDAO();

        //запуск по методам

        Developer Teodor = new Developer(21,"Teodor","TeamLeader",120000);
        dao.safe(Teodor);

        dao.safe(20,"George","Junior Java",40000);

        dao.getAll();

        Developer George=dao.getByID(20);


        //запуск консольного типа
        DeveloperView vi = new DeveloperView();
        vi.start();
    }
}