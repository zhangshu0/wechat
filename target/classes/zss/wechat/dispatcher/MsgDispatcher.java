package zss.wechat.dispatcher;

import zss.web.util.MessageUtil;
import zss.wechat.message.resp.NewsMessage;
import zss.wechat.util.HttpPostUploadUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import zss.wechat.message.resp.Article;
import zss.wechat.message.resp.Image;
import zss.wechat.message.resp.ImageMessage;

import java.util.*;

/**
 * ClassName: MsgDispatcher
 *
 * @author zs
 * @Description: 消息业务处理分发器
 * @date 2018/11/16 Pm 6:00:00
 */
public class MsgDispatcher {
    private static Logger logger = Logger.getLogger(MsgDispatcher.class);

    public static String processMessage(Map<String, String> map) {
        String openid = map.get("FromUserName"); //用户 openid
        String mpid = map.get("ToUserName");   //公众号原始 ID

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
            System.out.println("==============这是文本消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
            System.out.println("==============这是图片消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
            System.out.println("==============这是链接消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
            System.out.println("==============这是位置消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
            System.out.println("==============这是视频消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
            ImageMessage imgmsg = new ImageMessage();
            imgmsg.setToUserName(openid);
            imgmsg.setFromUserName(mpid);
            imgmsg.setCreateTime(new Date().getTime());
            imgmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Image);

            Image img = new Image();
            HttpPostUploadUtil util = new HttpPostUploadUtil();
            String filepath = "/Users/zhangshuo/wechat/src/main/webapp/WEB-INF/img/stt.jpg";
            Map<String, String> textMap = new HashMap<String, String>();
            textMap.put("name", "ahhh");
            Map<String, String> fileMap = new HashMap<String, String>();
            fileMap.put("userfile", filepath);
            String mediaidrs = util.formUpload(textMap, fileMap);
            System.out.println(mediaidrs);
            String mediaid = JSONObject.fromObject(mediaidrs).getString("media_id");
            img.setMediaId(mediaid);
            imgmsg.setImage(img);
            logger.info(MessageUtil.imageMessageToXml(imgmsg));
            System.out.println("==============这是语音消息！");
            return MessageUtil.imageMessageToXml(imgmsg);
        }
        //普通文本消息


        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
//            TextMessage txtmsg = new TextMessage();
//            txtmsg.setToUserName(openid);
//            txtmsg.setFromUserName(mpid);
//            txtmsg.setCreateTime(new Date().getTime());
//            txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//            txtmsg.setContent("你好，这里是张硕个人账号！");
//            return MessageUtil.textMessageToXml(txtmsg);

            ImageMessage imgmsg = new ImageMessage();
            imgmsg.setToUserName(openid);
            imgmsg.setFromUserName(mpid);
            imgmsg.setCreateTime(new Date().getTime());
            imgmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Image);
            Image img = new Image();
            HttpPostUploadUtil util = new HttpPostUploadUtil();
            String filepath = "/Users/zhangshuo/wechat/src/main/webapp/WEB-INF/img/zs.jpg";
            Map<String, String> textMap = new HashMap<String, String>();
            textMap.put("name", "STTT");
            Map<String, String> fileMap = new HashMap<String, String>();
            fileMap.put("userfile", filepath);
            String mediaidrs = util.formUpload(textMap, fileMap);
            System.out.println(mediaidrs);
            String mediaid = JSONObject.fromObject(mediaidrs).getString("media_id");
            img.setMediaId(mediaid);
            imgmsg.setImage(img);
            logger.info(MessageUtil.imageMessageToXml(imgmsg));
            return MessageUtil.imageMessageToXml(imgmsg);


        } else if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
            NewsMessage newmsg = new NewsMessage();
            newmsg.setToUserName(openid);
            newmsg.setFromUserName(mpid);
            newmsg.setCreateTime(new Date().getTime());
            newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
            System.out.println("==============这是图片消息！");
            Article article = new Article();
            article.setDescription("这是图文消息 1"); //图文消息的描述
            article.setPicUrl("http://res.zs.com/2016/03/201603086749_6850.png"); //图文消息图片地址
            article.setTitle("图文消息 1");  //图文消息标题
            article.setUrl("http://www.zs.com");  //图文 url 链接
            List<Article> list = new ArrayList<Article>();
            list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个 Article 即可！
            newmsg.setArticleCount(list.size());
            newmsg.setArticles(list);
            return MessageUtil.newsMessageToXml(newmsg);
        }
        return null;
    }
}
