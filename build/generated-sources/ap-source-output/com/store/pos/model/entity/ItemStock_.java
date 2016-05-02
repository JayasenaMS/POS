package com.store.pos.model.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-30T18:08:16")
@StaticMetamodel(ItemStock.class)
public class ItemStock_ { 

    public static volatile SingularAttribute<ItemStock, String> itemName;
    public static volatile SingularAttribute<ItemStock, Date> exDate;
    public static volatile SingularAttribute<ItemStock, Float> wholeSaleDis;
    public static volatile SingularAttribute<ItemStock, String> itemCode;
    public static volatile SingularAttribute<ItemStock, Float> retailDis;
    public static volatile SingularAttribute<ItemStock, Long> id;
    public static volatile SingularAttribute<ItemStock, Integer> contity;

}