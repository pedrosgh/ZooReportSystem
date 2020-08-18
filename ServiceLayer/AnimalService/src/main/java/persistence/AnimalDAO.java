package persistence;

import models.*;

import javax.xml.transform.Result;
import java.sql.*;

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
}
