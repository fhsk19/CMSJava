package com.hexaware.FTP105.persistence;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import com.hexaware.FTP105.model.Customer;
import com.hexaware.FTP105.model.Menu;
import com.hexaware.FTP105.model.Orders;

import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
/**
  * CustomerDAO class used to fetch data from data base.
  * @author hexware
  */
public interface CustomerDAO {
/**
  * @return the all the Menu record.
  */
  @SqlQuery("Select * from Customer")
  @Mapper(CustomerMapper.class)
  List<Customer> show();
/**
  * @param foodId for taking record.
  * @return foodId.
  */
  @SqlQuery("Select * FROM MENU WHERE FOOD_ID= :FOOD_ID")
  @Mapper(MenuMapper.class)
  Menu getFoodId(@Bind("FOOD_ID") int foodId);
/**
  * @return the all the Menu record.
  * @param cUserName for username.
  * @param cPassword for password.
  */
  @SqlQuery("Select * FROM CUSTOMER WHERE C_USERNAME=:C_USERNAME and C_PASSWORD=:C_PASSWORD")
  @Mapper(CustomerMapper.class)
  Customer showCLogin(@Bind("C_USERNAME") String cUserName, @Bind("C_PASSWORD") String cPassword);

  /**
  * @return the all the Menu record.
  * @param cId for customer id.
  */
  @SqlQuery("Select O_ID FROM ORDERS WHERE C_ID= :C_ID")
  @Mapper(OrdersMapper.class)
  Orders getOId(@Bind("C_ID") int cId);

  /**
  * @return the all the Menu record.
  * @param cId for customer id.
  */
  @SqlQuery("Select * FROM CUSTOMER WHERE C_ID= :C_ID")
  @Mapper(CustomerMapper.class)
  Customer getWallet(@Bind("C_ID") int cId);

  /**
  * @return the wallet.
  * @param b for customer id.
  * @param bal for wallet balance.
  */
  @SqlUpdate("UPDATE CUSTOMER SET WALLET=:WALLET WHERE C_ID=:C_ID")
  @Mapper(CustomerMapper.class)
  int updateWallet(@Bind("C_ID") int b, @Bind("WALLET") float bal);

  /**
  * @return the all the Menu record.
  * @param oid for order id.
  */
  @SqlQuery("Select * FROM ORDERS WHERE O_ID= :O_ID")
  @Mapper(OrdersMapper.class)
  Orders getdet(@Bind("O_ID") int oid);

  /**
  * @return the all the Menu record.
  * @param cId for Customer Id.
  */
  @SqlQuery("Select * from Customer where C_ID= :C_ID")
  @Mapper(CustomerMapper.class)
  List<Customer> showC(@Bind("C_ID")int cId);
}

