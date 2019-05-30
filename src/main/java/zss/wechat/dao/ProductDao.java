package zss.wechat.dao;

import zss.wechat.model.Product;
import zss.wechat.model.Size;

import java.util.List;

/**
 * Created by zs on 19/2/24.
 */
public interface ProductDao {

    List<Product> findEntityListByCond(Product product);

    int addEntity(Product product);

    int updateEntity(Product product);

    Product findEntityById(Integer id);

    int deleteEntity(Product product);

    List<Product> findEntityListByCondForUp(Product product);

    List<Product> getAllProductList();

}
