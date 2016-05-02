package com.store.pos.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-30T18:08:16")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, String> itemName;
    public static volatile SingularAttribute<Item, String> itemCcode;
    public static volatile SingularAttribute<Item, Float> price;
    public static volatile SingularAttribute<Item, Long> id;
    public static volatile SingularAttribute<Item, String> category;
    public static volatile SingularAttribute<Item, Float> wholesalePrice;
    public static volatile SingularAttribute<Item, Float> retailPrice;
    public static volatile SingularAttribute<Item, String> barcode;

}