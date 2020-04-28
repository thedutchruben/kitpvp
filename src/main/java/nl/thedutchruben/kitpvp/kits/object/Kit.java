package nl.thedutchruben.kitpvp.kits.object;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Kit {
    private int id;
    private String name;
    private Material displayItem;
    private String description;
    private double cost;
    private List<ItemStack> items;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Material getDisplayItem() {
        return displayItem;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public List<ItemStack> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisplayItem(Material displayItem) {
        this.displayItem = displayItem;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
