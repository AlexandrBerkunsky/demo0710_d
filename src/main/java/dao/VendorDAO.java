package dao;

import entities.Country;
import entities.Vendor;
import exceptions.CantFindCountryException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {
    private Connection connection;

    public VendorDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Vendor> findAll(int countryId) {
        try {
            List<Vendor> result = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(
                    "select vendor.id as vendorid, vendor.name as vendorname, country_id, c.name as countryname from vendor join country c on c.id = vendor.country_id where country_id = ?");

//            PreparedStatement ps = connection.prepareStatement
//                    ( "select * from vendor where country_id = ?");
            ps.setInt(1, countryId);
//            ps.executeUpdate();

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                System.out.println(metaData.getColumnName(i+1));
            }
            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
                int id = rs.getInt("vendorid");
                String name = rs.getString("vendorname");
                String countryName = rs.getString("countryname");

                result.add(new Vendor(id, name, countryName));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CantFindCountryException(e);
        }

    }

}
