package zss.web.util;

import java.util.Properties;

public class GlobalConstants {

    public static Properties interfaceUrlProperties;

    /**
     *
     * @Description: TODO
     * @param @param key
     * @param @return
     * @author zs
     * @date 2018/11/15 Pm 3:30:00
     */
    public static String getInterfaceUrl(String key) {
        return (String) interfaceUrlProperties.get(key);
    }

}
