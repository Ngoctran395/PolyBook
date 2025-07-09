package poly.book.dao.impl;
import java.util.List;
import poly.book.dao.BillDetailDAO;
import poly.book.entity.BillDetail;
import poly.book.util.XJdbc;
import poly.book.util.XQuery;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
public class BillDetailDAOImpl implements BillDetailDAO {

    String insertSql = "INSERT INTO BillDetails(BillId, BookId, UnitPrice, Quantity, Discount) VALUES(?, ?, ?, ?, ?)";
    String deleteSql = "DELETE FROM BillDetails WHERE Id=?";
    String findByBillSql = "SELECT * FROM BillDetails WHERE BillId=?";

    @Override
    public BillDetail create(BillDetail detail) {
        XJdbc.executeUpdate(insertSql, detail.getBillID(), detail.getBookID(), detail.getUnitPrice(), detail.getQuantity(), detail.getDiscount());
        return detail;
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<BillDetail> findByBillId(Long billId) {
        return XQuery.getBeanList(BillDetail.class, findByBillSql, billId);
    }
}