package server;

import beans.CountryBean;
import beans.VendorBean;
import dao.CountryDAO;
import dao.VendorDAO;
import entities.Country;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "DataBaseServlet", urlPatterns = {"*.html"})
public class DataBaseServlet extends HttpServlet {

//    Connection connection;
    private CountryDAO countryDAO;
    private VendorDAO vendorDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/example");
            Connection connection = ds.getConnection();
            countryDAO = new CountryDAO(connection);
            vendorDAO = new VendorDAO(connection); //
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VendorBean vendorBean = new VendorBean();
        String getoo = request.getParameter("getoo");
        System.out.println(getoo);
        vendorBean.setVendors(vendorDAO.findAll(Integer.parseInt(getoo)));
        request.setAttribute("vendorBean", vendorBean);
        request.getRequestDispatcher("/showvendorswithcountry.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Country> countries = countryDAO.findAll();

        CountryBean countryBean = new CountryBean();
        countryBean.setCountries(countryDAO.findAll());
        request.setAttribute("countryBean", countryBean);
        request.getRequestDispatcher("/showcountries.jsp").forward(request, response);


    }
}
