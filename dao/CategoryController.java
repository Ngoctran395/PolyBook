/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.book.dao;

import java.util.List;
import poly.book.entity.Category;

/**
 *
 * @author Dell
 */
public interface CategoryController {
     List<Category> getAll();
    Category getById(String id);
    Category create(Category category);
    void update(Category category);
    void delete(String id);
}
