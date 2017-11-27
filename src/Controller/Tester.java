package Controller;

import DAO.DeveloperDAO;
import Model.Developer;
import View.DeveloperView;

public class Tester {
    public static void main(String[] args) {
        DeveloperView vi = new DeveloperView();
        DeveloperDAO de=new DeveloperDAO();
        vi.start();
    }
}
