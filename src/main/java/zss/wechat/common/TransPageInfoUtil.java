package zss.wechat.common;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class TransPageInfoUtil {
    public static <T, E> PageInfo<E> TransVo(List<E> convertTo, PageInfo<T> convert) {
        PageInfo<E> pageInfo;
        if (null == convertTo || convertTo.isEmpty() || convert == null) {
            return null;
        } else {
            try {
                pageInfo = new PageInfo<>(convertTo);
                org.springframework.beans.BeanUtils.copyProperties(convert, pageInfo);
                pageInfo.setList(convertTo);
            } catch (Exception e) {
                throw e;
            }
        }
        return pageInfo;
    }
}
