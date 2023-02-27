package top.mccat.domain;

import top.mccat.annonation.Value;
import top.mccat.annonation.YamlFile;
import top.mccat.constants.StrengthPlusValue;

/**
 * @author Distance
 * @date 2023/2/27
 */
@YamlFile(value = "config.yml", section = "StrengthPlus")
public class Config {
    @Value(value = "pluginName", defaultValue = StrengthPlusValue.DEFAULT_TITLE)
    private String pluginName;

    @Value(value = "debug")
    private boolean debug;

    /**
     * 是否允许菜单
     */
    @Value(value = "modelEnable.menu")
    private boolean menu;

    /**
     * 是否允许额外参数
     */
    @Value(value = "modelEnable.strengthExtra")
    private boolean strengthExtra;

    /**
     * 是否允许eco挂载
     */
    @Value(value = "modelEnable.eco")
    private boolean eco;

    /**
     * 是否允许papi挂载
     */
    @Value(value = "modelEnable.papi")
    private boolean papi;

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isMenu() {
        return menu;
    }

    public void setMenu(boolean menu) {
        this.menu = menu;
    }

    public boolean isStrengthExtra() {
        return strengthExtra;
    }

    public void setStrengthExtra(boolean strengthExtra) {
        this.strengthExtra = strengthExtra;
    }

    public boolean isEco() {
        return eco;
    }

    public void setEco(boolean eco) {
        this.eco = eco;
    }

    public boolean isPapi() {
        return papi;
    }

    public void setPapi(boolean papi) {
        this.papi = papi;
    }

    @Override
    public String toString() {
        return "Config{" +
                "pluginName='" + pluginName + '\'' +
                ", debug=" + debug +
                ", menu=" + menu +
                ", strengthExtra=" + strengthExtra +
                ", eco=" + eco +
                ", papi=" + papi +
                '}';
    }
}
