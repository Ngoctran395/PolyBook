/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.book.dao.impl;

import java.util.List;
import poly.book.dao.CustomerDAO;
import poly.book.entity.Customer;
import poly.book.util.XJdbc;
import poly.book.util.XQuery;

/**
 *
 * @author Dell
 */
public class CustomerDAOImpl implements CustomerDAO {

    String createSql = "INSERT INTO Customers(Id, Name, Phone, Email, Address) VALUES(?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Customers SET Name=?, Phone=?, Email=?, Address=? WHERE Id=?";
    String deleteSql = "DELETE FROM Customers WHERE Id=?";
    String findAllSql = "SELECT * FROM Customers";
    String findByIdSql = "SELECT * FROM Customers WHERE Id=?";

    @Override
    public Customer create(Customer c) {
        XJdbc.executeUpdate(createSql, c.getCustomerID(), c.getFullName(), c.getPhone(), c.getEmail(), c.getAddress());
        return c;
    }

    @Override
    public void update(Customer c) {
        XJdbc.executeUpdate(updateSql, c.getFullName(), c.getPhone(), c.getEmail(), c.getAddress(), c.getCustomerID());
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<Customer> findAll() {
        return XQuery.getBeanList(Customer.class, findAllSql);
    }

    @Override
    public Customer findById(String id) {
        return XQuery.getSingleBean(Customer.class, findByIdSql, id);
    }
}