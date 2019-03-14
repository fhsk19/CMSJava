package com.hexaware.FTP105.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.FTP105.model.OStatus;
import com.hexaware.FTP105.model.Orders;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * OrdersMapper class used to fetch orders data from database.
 * @author hexware
 */
public class OrdersMapper implements ResultSetMapper<Orders> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Orders
       */
    return new Orders(rs.getInt("O_ID"), rs.getInt("C_ID"), rs.getInt("FOOD_ID"),
    rs.getInt("QTY"), rs.getFloat("TOTAL_PRICE"), rs.getTime("ESTIMATED_TIME"), rs.getTime("ORDER_TIME"),
    rs.getInt("V_ID"), rs.getDate("ORDER_DATE"), OStatus.valueOf(rs.getString("ORDER_STATUS")), rs.getString("O_COMMENT"));
  }
}
