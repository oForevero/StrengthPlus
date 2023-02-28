package top.mccat.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.mccat.utils.BaseUtils;
import top.mccat.utils.ColorParseUtils;

import java.util.Objects;

public class ChatWindow extends ColorParseUtils implements CommandExecutor  {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (commandSender instanceof Player){
            if ("t".equals(s)){
                player = commandSender.getServer().getPlayer(strings[0]);
                if (!Objects.isNull(player)){
                    player.sendMessage(commandSender.getName()+":"+strings[1]);
                }else{
                    commandSender.sendMessage("玩家不在线或不存在！");
                }
            }
        }
        return false;
    }

}
