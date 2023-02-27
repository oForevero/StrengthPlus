package top.mccat.utils.message;

import net.md_5.bungee.api.ChatColor;

/**
 * @author Raven
 * @date 2023/02/16 19:23
 */
public class ColorParseUtils {
    public static String parseColorStr(String str){
        return ChatColor.translateAlternateColorCodes('&',str);
    }
}
