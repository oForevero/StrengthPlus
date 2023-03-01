package top.mccat.bean.stone;

import org.bukkit.Material;

import java.util.List;

/**
 * @author Distance
 * @date 2023/3/1
 */
public abstract interface StrengthItem {
    /**
     * 获取物品名
     * @return 物品名
     */
    String getItemName();

    /**
     * 设置物品名
     * @param itemName 物品名字符串
     */
    void setItemName(String itemName);

    /**
     * 获取物品material
     * @return material枚举
     */
    Material getMaterial();

    /**
     * 设置物品Material
     * @param material 枚举 对象
     */
    void setMaterial(String material);

    /**
     * 获取lore
     * @return lore 列表
     */
    List<String> getLore();

    /**
     * 设置lore
     * @param lore lore 列表
     */
    void setLore(List<String> lore);
}
