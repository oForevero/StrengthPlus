package top.mccat.utils.checker;

/**
 * @author Distance
 * @date 2023/2/27
 */
public class StringUtils {
    /**
     * 检查字符串方法
     * @param str 字符串
     * @return 是否为空字符串
     */
    public static boolean isBlank(String str) {
        int strLen;
        if(str != null && (strLen = str.length()) != 0) {
            for(int i=0; i<strLen; ++i) {
                if(!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }
}
