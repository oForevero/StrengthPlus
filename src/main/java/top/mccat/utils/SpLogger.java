package top.mccat.utils;

import org.bukkit.Bukkit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Raven
 * @date 2023/02/16 19:19
 */
public class SpLogger{
    private boolean debug = true;
    private final Logger logger;
    private final String name;

    public SpLogger(Class cls){
        logger = Bukkit.getLogger();
        name = "["+cls.getName()+"] ";
    }

    /**
     * 发送log
     * @param level log消息
     * @param msg msg to log
     */
    public void log(Level level, String msg) {
        logger.log(level, name + msg);
    }

    /**
     * 发送debug日志
     * @param msg message str
     */
    public void debug(String msg){
        if(!debug){
            return;
        }
        logger.log(Level.INFO, name + msg);
    }

    /**
     * 发送info日志
     * @param msg message str
     */
    public void info(String msg) {
        if(!debug){
            return;
        }
        logger.info(name + msg);
    }

    public void warning(String msg) {
        logger.warning(name + msg);
    }

}
