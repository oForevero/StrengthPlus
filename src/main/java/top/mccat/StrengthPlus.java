package top.mccat;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;
import top.mccat.command.ChatWindow;
import top.mccat.domain.Config;
import top.mccat.utils.SpLogger;
import top.mccat.utils.io.YamlLoadUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

/**
 * @author Raven
 * @date 2022/05/05 16:05
 * 主插件启动类
 */
public class StrengthPlus extends JavaPlugin {
    private final SpLogger spLogger = new SpLogger(StrengthPlus.class);
    /**
     * 被spigot读取的方法
     */
    @Override
    public void onLoad() {
        Optional<Object> strengthUtils = Optional.empty();
        try {
            strengthUtils = YamlLoadUtils.loadEssentialsYamlObject(Config.class);
        } catch (IOException | InvalidConfigurationException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        spLogger.debug(strengthUtils.get().toString());
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
