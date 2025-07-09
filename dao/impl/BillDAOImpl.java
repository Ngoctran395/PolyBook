/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.book.dao.impl;

import java.util.List;
import poly.book.dao.BillDAO;
import poly.book.entity.Bill;
import poly.book.util.XJdbc;
import poly.book.util.XQuery;

/**
 *
 * @author Dell
 */
public class BillDAOImpl implements BillDAO {

    String createSql = "INSERT INTO Bills(Username, CustomerId, CreatedAt, Status) VALUES(?, ?, ?, ?)";
    String updateSql = "UPDATE Bills SET Username=?, CustomerId=?, CreatedAt=?, Status=? WHERE Id=?";
    String deleteSql = "DELETE FROM Bills WHERE Id=?";
    String findAllSql = "SELECT * FROM Bills";
    String findByIdSql = "SELECT * FROM Bills WHERE Id=?";

    @Override
    public Bill create(Bill b) {
        XJdbc.executeUpdate(createSql, b.getUsername(), b.getCustomerID(), b.getCreatedAt(), b.getStatus());
        return b;
    }

    @Override
    public void update(Bill b) {
        XJdbc.executeUpdate(updateSql, b.getUsername(), b.getCustomerID(), b.getCreatedAt(), b.getStatus(), b.getBillID());
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<Bill> findAll() {
        return XQuery.getBeanList(Bill.class, findAllSql);
    }

    @Override
    public Bill findById(Long id) {
        return XQuery.getSingleBean(Bill.class, findByIdSql, id);
    }
}