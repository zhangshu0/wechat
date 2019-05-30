package zss.wechat.dao;

import zss.wechat.model.Standard;

import java.util.List;

/**
 * Created by zs on 19/2/24.
 */
public interface StandardDao {

    List<Standard> findEntityListByCond(Standard standard);

    int addEntity(Standard standard);

    int updateEntity(Standard standard);

    Standard findEntityById(Integer id);

    int deleteEntity(Standard standard);

    List<Standard> findEntityListByCondForUp(Standard standard);

    List<Standard> getAllStandardList();

}
