package com.zs.wechat.message.req;

/**
 * ClassName: ImageMessage
 * @Description: 图片消息
 * @author zs
 * @date 2018/11/15 Pm 2:30:00
 */
public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}