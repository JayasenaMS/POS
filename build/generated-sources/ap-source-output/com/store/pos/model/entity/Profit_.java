package com.store.pos.model.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-30T18:08:16")
@StaticMetamodel(Profit.class)
public class Profit_ { 

    public static volatile SingularAttribute<Profit, Date> date;
    public static volatile SingularAttribute<Profit, Float> income;
    public static volatile SingularAttribute<Profit, Float> coast;
    public static volatile SingularAttribute<Profit, Long> id;
    public static volatile SingularAttribute<Profit, Float> profit;

}