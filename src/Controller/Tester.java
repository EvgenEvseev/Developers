package Controller;

import DAO.DeveloperDAO;
import View.DeveloperView;

public class Tester {
    public static void main(String[] args) {
        DeveloperView vi = new DeveloperView();
        DeveloperDAO de=new DeveloperDAO();
        de.getByID(3);
    }
}
