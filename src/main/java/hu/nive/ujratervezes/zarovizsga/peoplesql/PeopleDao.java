package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private DataSource dataSource;
    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    String findIpByName(String firstName, String lastName) {
        String ipAddress = null;
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("SELECT  ip_address as ip FROM people WHERE lower(first_name) = lower(?) AND lower(last_name) = lower(?)");
        ) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                ipAddress = rs.getString("ip");
            }
            return ipAddress;
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Cannot ...", sqle);
        }
    }
}
