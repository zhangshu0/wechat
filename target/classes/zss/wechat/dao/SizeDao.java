package zss.wechat.dao;

import zss.wechat.model.Size;

import java.util.List;

/**
 * Created by zs on 19/2/24.
 */
public interface SizeDao {

    List<Size> findEntityListByCond(Size size);

    int addEntity(Size size);

    int updateEntity(Size size);

    Size findEntityById(Integer id);

    int deleteEntity(Size size);

    List<Size> findEntityListByCondForUp(Size size);

    List<Size> getAllSizeList();

}
