package com.store.pos.model.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-30T18:08:16")
@StaticMetamodel(CustomerLoan.class)
public class CustomerLoan_ { 

    public static volatile SingularAttribute<CustomerLoan, Float> loan;
    public static volatile SingularAttribute<CustomerLoan, Boolean> isPay;
    public static volatile SingularAttribute<CustomerLoan, Date> dueDate;
    public static volatile SingularAttribute<CustomerLoan, Long> customerID;
    public static volatile SingularAttribute<CustomerLoan, String> name;
    public static volatile SingularAttribute<CustomerLoan, Long> id;
    public static volatile SingularAttribute<CustomerLoan, Date> giveDate;

}