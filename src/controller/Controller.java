package controller;

import dao.DeveloperDAO;
import model.Developer;

import java.util.ArrayList;

public class Controller {
        DeveloperDAO dao=new DeveloperDAO();

        public void ConSave(Developer developer){
                 dao.safe(developer);
        }

        public void ConSafe(long id,String name,String profession,int salary){
                dao.safe(id,name,profession,salary);
        }

        public void ConRemove(long id){
                dao.remove(id);
        }

        public Developer ConGetByID(long id){
                return dao.getByID(id);
        }

        public ArrayList<Developer> ConGetAll(){
               return dao.getAll();
        }
}