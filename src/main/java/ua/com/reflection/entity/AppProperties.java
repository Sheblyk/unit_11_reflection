package ua.com.reflection.entity;

import ua.com.reflection.annotation.PropertyKey;

public class AppProperties {
    @PropertyKey("user.password")
    public String password;
    @PropertyKey("user.orderCount")
    public int orderCount;
    @PropertyKey("user.email")
    public String email;
    @PropertyKey("user.cashback")
    public double cashback;
    @PropertyKey("user.newUser")
    public boolean newUser;
    @PropertyKey("user.role")
    public Role role;

    public enum Role {
        CUSTOMER, ADMIN, MANAGER
    }

    @Override
    public String toString() {
        return "AppProperties{" +
                "password='" + password + '\'' +
                ", orderCount=" + orderCount +
                ", email='" + email + '\'' +
                ", cashback=" + cashback +
                ", newUser=" + newUser +
                ", role=" + role +
                '}';
    }
}
