/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.book.util;

import poly.book.entity.User;


/**
 *
 * @author Dell
 */
public class XAuth {
    public static User user = User.builder()
.username("tranln")
.password("123")
.enabled(true)
.Manager(true)
.fullName("Lê Ngọc Trân")
.photo("trump.png")
.build(); // biến user này sẽ được thay thế sau khi đăng nhập
    
}
