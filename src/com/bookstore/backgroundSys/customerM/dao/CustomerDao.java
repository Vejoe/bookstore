package com.bookstore.backgroundSys.customerM.dao;


import java.util.List;

import com.bookstore.customer.model.Customer;

public interface CustomerDao {
    public List<Customer> queryCustomer();
    public List<Customer> queryByPage(int pageNo,int pageSize);
    public List<Customer> queryCustomerByID(int id);
    public boolean changeCustomerByID(Customer ncustomer);
}
