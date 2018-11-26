package com.zs.wechat.message.resp;

/**
 * ClassName: ImageMessage
 * @Description: 图片消息
 * @author zs
 * @date 2018/11/15 Pm 2:30:00
 */
public class ImageMessage extends BaseMessage{

    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }

}