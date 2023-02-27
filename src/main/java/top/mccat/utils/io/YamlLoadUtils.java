package top.mccat.utils.io;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import top.mccat.annonation.Value;
import top.mccat.annonation.YamlFile;
import top.mccat.constants.StrengthPlusValue;
import top.mccat.utils.SpLogger;
import top.mccat.utils.message.ColorParseUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Distance
 * @date 2023/2/27
 */
public class YamlLoadUtils {
    public static final YamlConfiguration CONFIGURATION = new YamlConfiguration();

    public static Optional<Object> loadEssentialsYamlObject(Class<?> loadClass) throws IOException, InvalidConfigurationException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Object objResult = loadClass.newInstance();
        YamlFile yamlFile = loadClass.getAnnotation(YamlFile.class);
        File file = new File(StrengthPlusValue.BASE_DIR +"\\" +yamlFile.value());
        if(!file.exists()){
            throw new FileNotFoundException("文件 "+ file.getName() +" 未找到！请检查插件配置文件是否正常！");
        }
        //加载yml到对象
        CONFIGURATION.load(file);
        //这是开发者定义的注解参数，不应当出现异常所以断言必不可能为空
        ConfigurationSection section = CONFIGURATION.getConfigurationSection(yamlFile.section());
        assert section != null;
        Map<String, Object> values = section.getValues(true);
        if(values.isEmpty()){
            throw new InvalidConfigurationException("加载yml配置文件失败！");
        }
        Field[] declaredFields = loadClass.getDeclaredFields();
        List<Method> methodList = loadSetMethods(loadClass);
        //设置参数
        for(Field field : declaredFields){
            Value value = field.getAnnotation(Value.class);
            methodList.stream().filter(method -> method.getName().substring(3).equalsIgnoreCase(field.getName())).forEach(method -> {
                try {
                    Object o = values.get(value.value());
                    if(o instanceof String) {
                        method.invoke(objResult, ColorParseUtils.parseColorStr(o.toString()));
                    }else {
                        method.invoke(objResult, o);
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        }
        return Optional.of(objResult);
    }

    /**
     * 加载类所有set方法
     * @param objectClass 对象类
     * @return set方法列表
     */
    public static List<Method> loadSetMethods(Class<?> objectClass){
        return Arrays.stream(objectClass.getMethods()).filter(method -> method.getName().contains("set")).collect(Collectors.toList());
    }
}
