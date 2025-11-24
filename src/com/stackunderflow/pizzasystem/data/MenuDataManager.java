package com.stackunderflow.pizzasystem.data;

import com.stackunderflow.pizzasystem.model.MenuItem;
import com.stackunderflow.pizzasystem.model.Ingredient; 
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages data fetching operations related to the menu and inventory tables.
 */

public class MenuDataManager {

    // -----------------------------------------------------------------------------
    // 1. Load All Menu Items (For P1.6: Main Menu Screen)
    // -----------------------------------------------------------------------------
    
    /**
     * Retrieves all basic sellable items (pizzas, drinks, sides) from the MenuItems table.
     */
    public List<MenuItem> loadAllMenuItems() {
        String sql = "SELECT Item_ID, Item_Name, Base_Price, Category FROM MenuItems";
        List<MenuItem> itemsList = new ArrayList<>();

        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Convert database row to MenuItem model object.
                MenuItem item = new MenuItem(
                    rs.getInt("Item_ID"),
                    rs.getString("Item_Name"),
                    rs.getDouble("Base_Price"),
                    rs.getString("Category")
                );
                itemsList.add(item);
            }
        } catch (SQLException e) {
            System.err.println("SQL Error loading MenuItems: " + e.getMessage());
        }
        return itemsList;
    }

    // -----------------------------------------------------------------------------
    // 2. Load Toppings and Crusts (For P1.7: Customization Screen)
    // -----------------------------------------------------------------------------
    
    /**
     * Retrieves all available components and their associated costs from the Inventory table.
     */
    public List<Ingredient> loadToppingsAndCrusts() {
        // Query fetches components that are either paid add-ons (Extra_Cost > 0) or simple component types.
        String sql = "SELECT Ingredient_ID, Ingredient_Name, Extra_Cost, Unit_Type FROM Inventory"; 
        List<Ingredient> componentList = new ArrayList<>();

        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Convert database row to Ingredient model object.
                Ingredient component = new Ingredient(
                    rs.getInt("Ingredient_ID"),
                    rs.getString("Ingredient_Name"),
                    rs.getDouble("Extra_Cost"),
                    rs.getString("Unit_Type")
                );
                componentList.add(component);
            }
        } catch (SQLException e) {
            System.err.println("SQL Error loading Inventory components: " + e.getMessage());
        }
        return componentList;
    }
}
