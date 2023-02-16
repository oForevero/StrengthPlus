package top.mccat.utils;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import top.mccat.constants.StrengthPlusValue;

/**
 * @author Raven
 * @date 2023/02/16 20:34
 */
public class MessageUtils extends BaseUtils{
    private String title;
    private final ConsoleCommandSender commandSender;

    public MessageUtils() {
        commandSender = Bukkit.getConsoleSender();

        if(StringUtils.isBlank(title)){
            title = StrengthPlusValue.DEFAULT_TITLE;
        }
    }

    /**
     * 发送消息到玩家
     * @param player 发送消息到玩家
     * @param message 消息
     */
    public void sendToPlayer(Player player, String message){
        player.sendMessage(parseStr(title + message));
    }

    /**
     * 发送消息到控制台
     * @param message 消息
     */
    public void sendToConsole(String message){
        commandSender.sendMessage(parseStr(title + message));
    }

    /**
     * 重载配置文件到工具
     */
    @Override
    public void reloadConfig() {

    }
}
