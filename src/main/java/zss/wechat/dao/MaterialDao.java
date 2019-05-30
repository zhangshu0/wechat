package zss.wechat.dao;

import zss.wechat.model.Material;

import java.util.List;

/**
 * Created by zs on 19/2/24.
 */
public interface MaterialDao {

    List<Material> findEntityListByCond(Material material);

    int addEntity(Material material);

    int updateEntity(Material material);

    Material findEntityById(Integer id);

    int deleteEntity(Material material);

    List<Material> findEntityListByCondForUp(Material material);

    List<Material> getAllMaterialList();

}
