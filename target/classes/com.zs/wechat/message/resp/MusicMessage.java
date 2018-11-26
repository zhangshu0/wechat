package com.zs.wechat.message.resp;

/**
 * ClassName: MusicMessage
 * @Description: 音乐消息
 * @author zs
 * @date 2018/11/15 Pm 2:30:00
 */
public class MusicMessage extends BaseMessage {
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
