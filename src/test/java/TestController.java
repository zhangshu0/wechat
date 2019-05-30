import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zss.wechat.dao.MaterialDao;
import zss.wechat.dao.ProductDao;
import zss.wechat.dao.SizeDao;
import zss.wechat.dao.StandardDao;
import zss.wechat.model.Material;
import zss.wechat.model.Standard;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext-test.xml"})
@Controller
public class TestController {
    @Autowired
    ProductDao productDao;
    @Autowired
    MaterialDao materialDao;
    @Autowired
    SizeDao sizeDao;
    @Autowired
    StandardDao standardDao;

    @Test
    public void insert() {
//        String[] arr = {"20#","Q235","Q345", "20G",  "16MN",  "0Cr18Ni9",  "0Cr19Ni10", "15CrMO", "L245","A234WPB",  "A234WPC",  "A234WP11",  "A234WP5", "A234WP9", "A234WP11", "A234WP22",  "A234WP91",  "A105",  "A403WP304", "304L","316","316L",  "A812 -F53",  "A350LF2",  "A420 WPL6",  "A694 F60", "A516GR60", "A516GR70",  "A182-F51",  "A53GRB",  "A106 GRB",
//                "A182 F304" ,"F304L", "F316", "F316L",  "A335 P11",  "A335 P22",  "A335 P91",  "A333GR6",
//                "X42", "X52", "X60", "X65", "X70", "X80",  "A790-S31803",  "A790-S32750","1.4301"," 1.4306", "1.4401"," 1.4404","STPT42", "STPT49", "STPL39", "STPA22", "SUS304", "SUS316"};
//        for (String temp: arr) {
//            Material material = new Material();
//            material.setName(temp.replaceAll(" ",""));
//            materialDao.addEntity(material);
//        }
        Map<String,String> map = new HashMap<String, String>();
        map.put("GB12459","钢制对焊无缝管件");
        map.put("GB/T13401","钢板制对焊管件");
        map.put("GB/T14383","锻钢制承插焊管件");
        map.put("GB/T9112-9131","钢制管法兰、法兰盖及法兰用垫片");
        map.put("GB/T17185-1997","钢制法兰管件");
        map.put("GB/T 9711-2011","石油天然气工业管线输送用钢管");
        map.put("GB/T8163-2008","无缝钢管标准");
        map.put("HG-20592","钢制法兰");
        map.put("ANSI B16.9","对焊管件");
        map.put("ASME/ANSI B16.11","承插焊和螺纹锻造管件");
        map.put("ASME/ANSI B16.28","钢制对焊小半径弯头和回头弯");
        map.put("ASME B16.5","管法兰和法兰配件");
        map.put("ASME B16.48","八字盲板");
        map.put("ASME B16.49","弯管");
        map.put("MSS SP-43","锻制不锈钢对焊管件");
        map.put("MSS SP-79","承插焊异径插入件");
        map.put("MSS SP-83","承插焊和螺纹活接头");
        map.put("MSS SP-97","承插焊、螺纹和对焊端的整体加强式管座");
        map.put("ASME B36.10","焊接和无缝轧制钢管");
        map.put("API5L"," 管线钢管标准");
        map.put("DIN 17456","不锈钢制无缝圆形钢管");
        map.put("DIN2527","法兰盖");
        map.put("DIN2633","带颈对焊法兰");
        map.put("DIN2632","带颈对焊法兰");
        map.put("DIN2634","带颈对焊法兰");
        map.put("DIN2635","带颈对焊法兰");
        map.put("DIN2576","法兰");
        map.put("DIN2543","法兰");
        map.put("DIN2544","法兰");
        map.put("DIN2545","法兰");
        map.put("JISB2220","法兰");
        map.put("JIS B2311","法兰标准");
        map.put("JIS B2312","钢制对焊管件");
        map.put("JIS B2313","钢板制对焊管件");
        map.put("JIS B2316","钢制承插焊管件");
        Set<String> sets = map.keySet();
        for (String item: sets) {
            String value = map.get(item);
            Standard standard = new Standard();
            standard.setK(item.replaceAll(" ",""));
            standard.setV(value.replaceAll(" ",""));
            standardDao.addEntity(standard);
        }
    }
}
