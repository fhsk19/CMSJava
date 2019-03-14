package com.hexaware.FTP105.persistence;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP105.model.Menu;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
/**
  * @return the all the Menu record.
  */
  @SqlQuery("Select * from Menu")
    @Mapper(MenuMapper.class)
    List<Menu> show();
/**
  * @param foodId where Food Id given.
  * @return all Order record.
  */
  @SqlQuery("SELECT * FROM MENU WHERE FOOD_ID= :FOOD_ID")
    @Mapper (MenuMapper.class)
    Menu getMenu(@Bind("FOOD_ID") int foodId);
}

