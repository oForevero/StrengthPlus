package top.mccat.utils;

import top.mccat.utils.message.ColorParseUtils;

/**
 * @author Raven
 * @date 2023/02/16 20:35
 */
public abstract class BaseUtils {
    /**
     * 重载配置文件到工具
     */
    public abstract void reloadConfig();

    public String parseStr(String str){
        return ColorParseUtils.parseColorStr(str);
    }
}
