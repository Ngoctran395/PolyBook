/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.book.dao;

import java.util.List;
import poly.book.entity.Bill;

/**
 *
 * @author Dell
 */
public interface BillController {
      List<Bill> getAll();
    Bill getById(Long id);
    Bill create(Bill bill);
    void update(Bill bill);
    void delete(Long id);
}
