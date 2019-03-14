package com.hexaware.FTP105.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP105.model.Vendor;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
    /**
     * @return the all the Vendor record.
     */
  @SqlQuery("Select * from Vendor")
    @Mapper(VendorMapper.class)
    List<Vendor> show();
/**
  * @param vUserName for username.
  * @param vPassword for password.
  * @return the all the Vendor record.
  */
  @SqlQuery("Select * from Vendor where V_USERNAME = :V_USERNAME and V_PASSWORD=:V_PASSWORD")
    @Mapper(VendorMapper.class)
    Vendor showVLogin(@Bind("V_USERNAME") String vUserName, @Bind("V_PASSWORD") String vPassword);
}
