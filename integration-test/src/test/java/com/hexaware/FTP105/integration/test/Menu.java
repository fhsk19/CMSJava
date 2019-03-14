package com.hexaware.FTP105.model;

import java.util.Objects;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
/**
 * foodId to store foodId.
 */
  private int foodId;
  private int vId;
  private String foodName;
  private Float price;
  private String foodCategory;
  private String foodDescription;
/**
 * Default Constructor.
 */
  public Menu() {

  }
/**
 * @param argFoodId to initialize FoodId.
 * used to get details through constructor.
 * @param argVId to initialize VId.
 * used to get details through constructor.
 * @param argFoodName to initialize FoodName.
 * used to get details through constructor.
 * @param argPrice to initialize gPrice.
 * used to get details through constructor.
 * @param argFoodCategory to initialize argFoodCategory.
 * used to get details through constructor.
 * @param argFoodDescription to initialize FoodDescription.
 * used to get details through constructor.
 */
  public Menu(final int argFoodId, final int argVId,
      final String argFoodName, final Float argPrice, final String argFoodCategory,
      final String argFoodDescription) {
    this.foodId = argFoodId;
    this.vId = argVId;
    this.foodName = argFoodName;
    this.price = argPrice;
    this.foodCategory = argFoodCategory;
    this.foodDescription = argFoodDescription;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId)
        && Objects.equals(vId, menu.vId)
        && Objects.equals(foodName, menu.foodName)
        && Objects.equals(price, menu.price)
        && Objects.equals(foodCategory, menu.foodCategory)
        && Objects.equals(foodDescription, menu.foodDescription)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(foodId, vId, foodName, price, foodCategory, foodDescription);
  }
/**
 * @return this food ID.
 */
  public final int getFoodId() {
    return foodId;
  }
/**
 * @return this V ID.
 */
  public final int getVId() {
    return vId;
  }
/**
 * @return this FoodName.
 */
  public final String getFoodName() {
    return foodName;
  }
/**
 * @return this Price.
 */
  public final Float getPrice() {
    return price;
  }
/**
 * @return this FoodCategory.
 */
  public final String getFoodCategory() {
    return foodCategory;
  }
/**
 * @return this FoodDescription.
 */
  public final String getFoodDescription() {
    return foodDescription;
  }
/**
 * @param argFoodId gets the food id.
 */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
/**
 * @param argVId gets the food id.
 */
  public final void setVId(final int argVId) {
    this.vId = argVId;
  }
/**
 * @param argFoodName gets the food id.
 */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }
/**
 * @param argPrice gets the food id.
 */
  public final void setPrice(final Float argPrice) {
    this.price = argPrice;
  }
/**
 * @param argFoodCategory gets the food id.
 */
  public final void setFoodCategory(final String argFoodCategory) {
    this.foodCategory = argFoodCategory;
  }
/**
 * @param argFoodDescription gets the food id.
 */
  public final void setFoodDescription(final String argFoodDescription) {
    this.foodDescription = argFoodDescription;
  }
  @Override public final String toString() {
    return String.format(this.foodId + "\t" + this.vId + "\t" + this.foodName
        + "\t" + this.price + "\t" + this.foodCategory + "\t" + this.foodDescription);
  }
}
