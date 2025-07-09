/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.book.dao;

import java.util.List;
import poly.book.entity.User;

/**
 *
 * @author Dell
 */
public interface UserController {
     List<User> getAll();
    User getById(String username);
    User create(User user);
    void update(User user);
    void delete(String username);
}
