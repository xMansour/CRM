package com.mansour.crm.dao;

import com.mansour.crm.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Customer order by firstName", Customer.class)
                .getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int customerId) {
        return sessionFactory
                .getCurrentSession()
                .get(Customer.class, customerId);
    }

    @Override
    public void deleteCustomer(int customerId) {
        Customer customer = getCustomer(customerId);
        sessionFactory
                .getCurrentSession()
                .remove(customer);
    }

    @Override
    public List<Customer> searchForCustomer(String customerName) {
        String sqlQuery = "";
        if (customerName.length() > 0)
            sqlQuery = "from Customer where firstName =:customerName";
        else
            sqlQuery = "from Customer";
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(sqlQuery);
        if (customerName.length() > 0)
            query.setParameter("customerName", customerName);
        return query.getResultList();


    }
}
