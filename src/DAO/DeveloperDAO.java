package DAO;


import Model.Developer;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class DeveloperDAO {
    public String path = "C:\\DEV.txt";
    public void safe(Developer developer) {
        try (FileWriter wr = new FileWriter(path, true)) {
            wr.write(developer.toString());
            wr.write("\r\n");
            System.out.println(developer);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void remove(long ID) {
        ArrayList<String> AL = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = null;
            while ((line = br.readLine()) != null) {
                if (Long.valueOf(line.split(",")[0]) != ID)
                    AL.add(line);
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                for (int n = 0; n < AL.size(); n++) {
                    bw.write(AL.get(n));
                    bw.write("\r\n");
                }
            }
        } catch (IOException e) {
        }
    }


    public void remove(Developer developer) {
        ArrayList<String> AL = new ArrayList<>();
        String dev = developer.toString();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = null;
            while ((line = br.readLine()) != null) {
                if (!Objects.equals(line.split(",")[0], dev.split(",")[0]))
                    AL.add(line);
                System.out.println();
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                for (int n = 0; n < AL.size(); n++) {
                    bw.write(AL.get(n));
                    bw.write("\r\n");
                }
            }
        } catch (IOException e) {
        }
    }


    public Developer getByID(long ID) {
         Developer dev = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                if (Objects.equals(line.split(",")[0], Long.toString(ID)))
                    System.out.println(line);
                long IDi = Long.valueOf(line.split(",")[0]);
                String name=line.split(",")[1];
                String prof=line.split(",")[2];
                String sal0=line.split(",")[3];
                int sal=Integer.valueOf(sal0.substring(1,sal0.length()-2));
                dev = new Developer(IDi,name,prof,sal);
            }
        } catch (IOException e) {
        }
        return dev;
    }


    public ArrayList<Developer> getAll() {
        ArrayList<Developer> AL = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                long ID = Long.valueOf(line.split(",")[0]);
                String name=line.split(",")[1];
                String prof=line.split(",")[2];
                String sal0=line.split(",")[3];
                int sal=Integer.valueOf(sal0.substring(1,sal0.length()-2));
                AL.add(new Developer (ID,name,prof,sal));
            }
            for(Developer n:AL)
                System.out.println(n);
        } catch (IOException e) {
        }
        return AL;
    }
}