package persistence;

import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnimalDAO {
    public static int newAnimal(Animal animal) {
        Connection con = DbUtil.getDatabaseConnection();
        String sql = "insert into animals(reportid, name, species, age, origin) values (?, ?, ?, ?, ?) ";
        try {
            PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, animal.getReportId());
            st.setString(2, animal.getName());
            st.setString(3, animal.getClass().getSimpleName());
            st.setInt(4, animal.getAge());
            st.setString(5, animal.getOrigin());
            st.executeUpdate();

            int animalid = -2;
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()) animalid = rs.getInt(2);
            con.close();
            return animalid;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -2;
    }

    public static HashMap<String, Integer> getNumberOfAnimals(int reportid) {
        HashMap<String, Integer> numberOfAnimals = new HashMap<String, Integer>();
        Connection con = DbUtil.getDatabaseConnection();
        String sql = "select * from animals where reportid = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, reportid);
            ResultSet rs = st.executeQuery();

            int nLions = 0, nTigers = 0, nMonkeys = 0, nGiraffes = 0, nElephants = 0;
            while(rs.next()) {
                switch (rs.getString(4)) {
                    case "Elephant": nElephants += 1; break;
                    case "Giraffe": nGiraffes += 1; break;
                    case "Lion": nLions += 1; break;
                    case "Monkey": nMonkeys += 1; break;
                    default: nTigers += 1; break; //case "Tiger"
                }
            }
            numberOfAnimals.put("Lions", nLions);
            numberOfAnimals.put("Tigers", nTigers);
            numberOfAnimals.put("Monkeys", nMonkeys);
            numberOfAnimals.put("Giraffes", nGiraffes);
            numberOfAnimals.put("Elephants", nElephants);
            con.close();
            return numberOfAnimals;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return numberOfAnimals;
    }
}
