package zss.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: WeChatController
 * @Description: 前端用户微信配置获取
 * @author zs
 * @date 2018/11/16 Pm 4:40:00
 */
@Controller
@RequestMapping("/wechatconfig")
public class WeChatController {

    /**
     * @Description: 前端获取微信 JSSDK 的配置参数
     * @param @param response
     * @param @param request
     * @param @param url
     * @param @throws Exception
     * @author zs
     * @date 2018/11/16 Pm 4:40:00
     */
//    @RequestMapping("jssdk")
//    public Message JSSDK_config(
//            @RequestParam(value = "url", required = true) String url) {
//        try {
//            System.out.println(url);
//            Map<String, String> configMap = JSSDK_Config.jsSDK_Sign(url);
//            return Message.success(configMap);
//        } catch (Exception e) {
//            return Message.error();
//        }
//
//    }

}
