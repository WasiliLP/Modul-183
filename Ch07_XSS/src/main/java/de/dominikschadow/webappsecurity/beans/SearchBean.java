/*
 * Copyright (C) 2013 Dominik Schadow, dominikschadow@gmail.com
 *
 * This file is part of Java-Web-Security
.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.dominikschadow.webappsecurity.beans;

import de.dominikschadow.webappsecurity.daos.CustomerDAO;
import de.dominikschadow.webappsecurity.domain.Customer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 *
 * @author Dominik Schadow
 */
@ManagedBean(name = "searchBean")
@RequestScoped
public class SearchBean {
    private Customer customer;
    private CustomerDAO customerDAO;
    private List<Customer> customers;

    public SearchBean() {
        customer = new Customer();
        customerDAO = new CustomerDAO();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String search() {
        customers = customerDAO.findCustomers(customer);

        return "/searchCustomer.xhtml";
    }
}