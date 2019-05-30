package zss.wechat.quartz;
import org.apache.log4j.Logger;
import zss.wechat.common.WeChatTask;

public class QuartzJob{
    private static Logger logger = Logger.getLogger(QuartzJob.class);
    /**
     * @Description: 任务执行获取 token
     * @param
     * @author zs
     * @date 2018/11/15 Pm 2:30:00
     */
    public void workForToken() {
        try {
            WeChatTask timer = new WeChatTask();
            timer.getToken_getTicket();
        } catch (Exception e) {
            logger.error(e, e);
        }
    }

}
