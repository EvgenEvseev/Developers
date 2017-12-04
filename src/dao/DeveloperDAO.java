package dao;


import model.Developer;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class DeveloperDAO {
    public String path ="./src/DEV.txt";
    public void safe(Developer developer) {
        try (FileWriter wr = new FileWriter(path, true)) {
            String dev = developer.getID()+", "+developer.getName()+", "+developer.getProf()+", "+developer.getSal()+" /";
            wr.write(dev);
            wr.write("\r\n");
            System.out.println("Сотрудник успешно добавлен :");
            System.out.println(dev);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void safe(long ID,String name,String profession,int salary) {
        Developer developer = new Developer(ID,name,profession,salary);
        try (FileWriter wr = new FileWriter(path, true)) {
            String dev = String.valueOf(ID)+", "+name+", "+profession+", "+String.valueOf(salary)+" /";
            wr.write(dev);
            wr.write("\r\n");
            System.out.println("Сотрудник успешно добавлен :");
            System.out.println(dev);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void remove(long ID) {
        ArrayList<String> AL = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            boolean rly= true;
            String line = null;
            while ((line = br.readLine()) != null) {
                if (Long.valueOf(line.split(",")[0]) != ID){
                    AL.add(line);
                }else {
                    System.out.println("Сотрудник с ID "+ID+" успешно удален");
                    rly=false;
                }
            }
            if(rly) System.out.println("Сотрудник с ID "+ID+" не найден");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                for (String aAL : AL) {
                    bw.write(aAL);
                    bw.write("\r\n");
                }
            }
        } catch (IOException e) {
        }
    }

    public Developer getByID(long ID) {
         Developer dev = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            boolean rly=true;
            while ((line = br.readLine()) != null) {
                if (Objects.equals(line.split(",")[0], Long.toString(ID))) {
                    System.out.println("Информация о сотруднике получена :");
                    System.out.println(line);
                    rly = false;
                    long IDi = Long.valueOf(line.split(",")[0]);
                    String name = line.split(",")[1];
                    String prof = line.split(",")[2];
                    String sal0 = line.split(",")[3];
                    int sal = Integer.valueOf(sal0.substring(1, sal0.length() - 2));
                    dev = new Developer(IDi, name, prof, sal);
                }
            }
            if(rly)System.out.println("Сотрудник с ID "+ID+" не найден. ");
        } catch (IOException e) {
            System.out.println("Ошибка"+e);
        }
        return dev;
    }


    public ArrayList<Developer> getAll() {
        ArrayList<Developer> AL = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                long ID = Long.valueOf(line.split(",")[0]);
                String name=line.split(",")[1];
                String prof=line.split(",")[2];
                String sal0=line.split(",")[3];
                int sal=Integer.valueOf(sal0.substring(1,sal0.length()-2));
                AL.add(new Developer (ID,name,prof,sal));
            }

        } catch (IOException e) {
            System.out.println("Ошибка "+e);
        }
        return AL;
    }
}