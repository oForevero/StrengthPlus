package top.mccat.bean.stone;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import top.mccat.annonation.Value;
import top.mccat.annonation.YamlFile;

import java.util.List;

/**
 * @author Distance
 * @date 2023/3/1
 */
@YamlFile(value = "strengthStone.yml", section = "strengthStone")
public class StrengthStone extends ItemStack implements StrengthItem{
    @Value(value = "name", defaultValue = "未知强化石")
    private String stoneName;

    @Value(value = "items", defaultValue = "SPONGE", classType = Material.class)
    private Material itemMaterial;

    @Value(value = "lore", classType = List.class)
    private List<String> strengthLore;

    public StrengthStone() {
        super();
    }

    @Override
    public String getItemName() {
        return stoneName;
    }

    @Override
    public void setItemName(String itemName) {
        this.stoneName = itemName;
    }

    @Override
    public Material getMaterial() {
        return itemMaterial;
    }

    @Override
    public void setMaterial(String material) {
        this.itemMaterial = Material.valueOf(material);
    }

    @Override
    public List<String> getLore() {
        return strengthLore;
    }

    @Override
    public void setLore(List<String> lore) {
        this.strengthLore = lore;
    }
}
