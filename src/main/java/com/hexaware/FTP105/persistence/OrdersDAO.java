package com.hexaware.FTP105.persistence;
import java.util.List;

import com.hexaware.FTP105.model.Orders;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
/**
 * OrdersDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OrdersDAO {
/**
  * @return the all the Order record.
 */
  @SqlQuery("Select * from ORDERS")
  @Mapper(OrdersMapper.class)
  List<Orders> show();
/**
  * @param vId where Id given.
  * @return all Order record.
 */
  @SqlQuery("SELECT * FROM ORDERS GROUP BY V_ID= :vId")
  @Mapper (OrdersMapper.class)
  Orders getOrdersForVendorId(@Bind("vId") int vId);
/**
  * @param oId where Id given.
  * @param qty where Id given.
  */
  @SqlUpdate("INSERT INTO ORDERS values(:oId, :qty)")
  @Mapper (OrdersMapper.class)
  void insert(@Bind("oId") int oId, @Bind("qty") int qty);
 /**
   * @param cId where Id given.
   * @return all Order record.
   */
  @SqlQuery("SELECT C_ID, O_ID, FOOD_ID, QTY, ORDER_STATUS, TOTAL_PRICE, ESTIMATED_TIME, ORDER_TIME, V_ID, ORDER_DATE FROM ORDERS ORDER BY C_ID= :cId")
  @Mapper (OrdersMapper.class)
  Orders getOrdersForCustomerId(@Bind("cId") int cId);
/**
  * @return the orders.
  * @param cId where Id given.
  * @param fId where Id given.
  * @param qty where Id given.
  * @param o where Id given.
  * @param totalPrice where Id given.
  * @param ot1 where Id given.
  * @param ot2 where Id given.
  * @param vId where Id given.
  * @param od where Id given.
  */
  @SqlUpdate("INSERT INTO ORDERS (C_ID,FOOD_ID,QTY,ORDER_STATUS,TOTAL_PRICE,ESTIMATED_TIME,ORDER_TIME,V_ID,ORDER_DATE) VALUES (:C_ID,:FOOD_ID,:QTY,:ORDER_STATUS,:TOTAL_PRICE,:ESTIMATED_TIME,:ORDER_TIME,:V_ID,:ORDER_DATE)")
  @Mapper (OrdersMapper.class)
  int insertQuery(@Bind("C_ID") int cId, @Bind("FOOD_ID")int fId, @Bind("QTY")int qty,
      @Bind("ORDER_STATUS")String o, @Bind("TOTAL_PRICE")float totalPrice,
      @Bind("ESTIMATED_TIME")String ot1, @Bind("ORDER_TIME")String ot2,
      @Bind("V_ID")int vId, @Bind("ORDER_DATE")String od);
/**
  * @param vid where Id given.
  * @param ostatus where Id given.
  * @return all Order record.
 */
  @SqlQuery("Select * from ORDERS where V_ID=:V_ID and ORDER_STATUS=:ORDER_STATUS")
  @Mapper (OrdersMapper.class)
  List<Orders> showOrderStatus(@Bind("V_ID") int vid, @Bind("ORDER_STATUS") String ostatus);
/**
  * @param oid where Id given.
  * @param ordstatus where Id given.
  * @return true value.
 */
  @SqlUpdate("update ORDERS set ORDER_STATUS =:ostatus where O_ID=:oid and ORDER_STATUS='PLACED'")
  @Mapper (OrdersMapper.class)
  int showUpdateStatus(@Bind("ostatus") String ordstatus, @Bind("oid") int oid);

/**
  * @param vId where Id given.
  * @return the all the Vendor record.
 */
  @SqlQuery("Select * from Orders where V_ID=:V_ID")
  @Mapper(OrdersMapper.class)
  List<Orders> showVHis(@Bind("V_ID") int vId);

/**
  * @param cId where Id given.
  * @return all the Vendor record.
 */
  @SqlQuery("Select * from Orders where C_ID=:C_ID")
  @Mapper(OrdersMapper.class)
  List<Orders> showCHis(@Bind("C_ID") int cId);
/**
  * @param com where Id given.
  * @param o where Id given.
  * @return the updated comment.
 */
  @SqlUpdate("update ORDERS set O_COMMENT =:O_COMMENT where O_ID=:O_ID")
  @Mapper (OrdersMapper.class)
  int updateCom(@Bind("O_COMMENT")String com, @Bind("O_ID")int o);

/**
  * @param foodId where Id given.
  * @return the all the Vendor record.
 */
  @SqlQuery("Select * from Orders where FOOD_ID=:FOOD_ID")
  @Mapper(OrdersMapper.class)
  List<Orders> showFId(@Bind("FOOD_ID") int foodId);
  /**
  * @param vId where Id given.
  * @return the all the Vendor record.
 */
  @SqlQuery("Select * from Orders where V_ID=:V_ID and ORDER_STATUS='PLACED'")
  @Mapper(OrdersMapper.class)
  List<Orders> showPHis(@Bind("V_ID") int vId);
}
