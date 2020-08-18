package persistence;

import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnimalDAO {
    public static void newAnimal(Animal animal) {
        Connection con = DbUtil.getDatabaseConnection();
        String sql = "insert into animals(reportid, name, species, age, origin) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, animal.getReportId());
            st.setString(2, animal.getName());
            st.setString(3, animal.getClass().getSimpleName());
            st.setInt(4, animal.getAge());
            st.setString(5, animal.getOrigin());
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
