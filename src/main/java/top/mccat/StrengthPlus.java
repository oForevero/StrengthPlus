package top.mccat;

import org.bukkit.plugin.java.JavaPlugin;
import top.mccat.command.ChatWindow;
import top.mccat.utils.ColorParseUtils;
import top.mccat.utils.SpLogger;

/**
 * @author Raven
 * @date 2022/05/05 16:05
 * 主插件启动类
 */
public class StrengthPlus extends JavaPlugin {
    /**
     * 被spigot读取的方法
     */
    @Override
    public void onLoad() {

    }

    /**
     * 插件被允许时的方法
     */
    @Override
    public void onEnable() {
        System.out.println("插件已加载！");
        getCommand("chatWindow").setExecutor(new ChatWindow());
    }

    /**
     * 禁用时的方法
     */
    @Override
    public void onDisable() {

    }

    /**
     * 重载配置方法
     */
    @Override
    public void reloadConfig() {

    }

}
