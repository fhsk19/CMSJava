package com.hexaware.FTP105.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.FTP105.model.Vendor;
import com.hexaware.FTP105.persistence.VendorDAO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
/**
  * Test class for Vendor Fcatory.
 */
@RunWith(JMockit.class)

public class VendorFactoryTest {
/**
  * setup method.
 */
  @Before
public void initInput() {
  }
/* *
  * vendor factory
  */
  private VendorFactory vend = new VendorFactory();
/**
  * @param vdao .
  * test .
 */
  @Test
    public final void showVendorTest(@Mocked final VendorDAO vdao) {
    final List<Vendor> fm = new ArrayList<Vendor>();
    final Vendor ve = new Vendor(3000, "varun", "varunabc", "abcd", "97901156");
    fm.add(ve);
    new Expectations() { {
        System.out.println("mocked inserted");
        vdao.show();
        result = fm;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock VendorDAO dao() {
        System.out.println("mocked data");
        return vdao;
      } };
    Vendor[] vfArr = VendorFactory.showVendor();

    List<Vendor> rm = new ArrayList<Vendor>();
    for (Vendor ven : vfArr) {
      rm.add(ven);
    }
    assertEquals(fm, rm);
  }
 /**
  * test .
 */
  @Test
    public final void testMapper() {
    Vendor[] v = VendorFactory.showVendor();
    assertNotNull(v);
  }
  /**
   * @param vdao .
   * @throws NullPointerException .
  * test .
 */
  @Test
    public final void showVLoginTes(@Mocked final VendorDAO vdao) throws NullPointerException {
    //final List<Vendor> lstexp = new ArrayList<Vendor>();
    final Vendor ve = new Vendor(3000, "varun", "varun", "abc", "97901156");

    new Expectations() { {
        System.out.println("mocked");

        vdao.showVLogin("varunabc", "abcd");
        result = any;
      } };
    new MockUp<VendorFactory>() {
        @Mock VendorDAO dao() {
        System.out.println("mocked data");
        return vdao;
      } };
    Vendor v1 = VendorFactory.vLogin("varunabc", "abcd");
    assertNotEquals(ve, v1);

  }
/**
  * @param vdao .
  * test .
 */
  @Test
    public final void showVendorloginTest1(@Mocked final VendorDAO vdao) {
    final List<Vendor> lstexp = new ArrayList<Vendor>();
    final Vendor ve = new Vendor(3000, "varun", "varunabc", "abcd", "97901156");
    lstexp.add(ve);
    new Expectations() { {
        System.out.println("mocked");
        vdao.showVLogin("sddsd", "avgfbcd");
        result = ve;
      } };
    new MockUp<VendorFactory>() {
      @Mock VendorDAO dao() {
        System.out.println("mocked data");
        return vdao;
      } };
    Vendor v2 = VendorFactory.vLogin("sddsd", "avgfbcd");
    assertNotEquals(v2, ve);
  }
  /**
   * @param vdao .
  * test .
 */
  @Test
    public final void showVendorloginTest3(@Mocked final VendorDAO vdao) {
    final List<Vendor> lstexp = new ArrayList<Vendor>();
    final Vendor ve = new Vendor(3000, "varun", "varunabc", "abcd", "97901156");
    lstexp.add(ve);
    new Expectations() { {
        System.out.println("mocked");
        vdao.showVLogin(null, null);
        result = null;
      } };
    new MockUp<VendorFactory>() {
        @Mock VendorDAO dao() {
        System.out.println("mocked data");
        return vdao;
      } };
    Vendor v3  = VendorFactory.vLogin(null, null);
    assertNull(v3);
  }
}

