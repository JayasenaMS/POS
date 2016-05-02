package com.store.pos.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-30T18:08:16")
@StaticMetamodel(ItemDiscount.class)
public class ItemDiscount_ { 

    public static volatile SingularAttribute<ItemDiscount, String> itemName;
    public static volatile SingularAttribute<ItemDiscount, String> itemCcode;
    public static volatile SingularAttribute<ItemDiscount, Float> price;
    public static volatile SingularAttribute<ItemDiscount, Float> retailDiscount;
    public static volatile SingularAttribute<ItemDiscount, Long> id;
    public static volatile SingularAttribute<ItemDiscount, String> category;
    public static volatile SingularAttribute<ItemDiscount, Float> wholesaleDiscount;

}