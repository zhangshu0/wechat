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
import zss.wechat.model.Product;
import zss.wechat.model.Size;
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
        Map<String, String> map = new HashMap<String, String>();
        map.put("GB12459", "钢制对焊无缝管件");
        map.put("GB/T13401", "钢板制对焊管件");
        map.put("GB/T14383", "锻钢制承插焊管件");
        map.put("GB/T9112-9131", "钢制管法兰、法兰盖及法兰用垫片");
        map.put("GB/T17185-1997", "钢制法兰管件");
        map.put("GB/T 9711-2011", "石油天然气工业管线输送用钢管");
        map.put("GB/T8163-2008", "无缝钢管标准");
        map.put("HG-20592", "钢制法兰");
        map.put("ANSI B16.9", "对焊管件");
        map.put("ASME/ANSI B16.11", "承插焊和螺纹锻造管件");
        map.put("ASME/ANSI B16.28", "钢制对焊小半径弯头和回头弯");
        map.put("ASME B16.5", "管法兰和法兰配件");
        map.put("ASME B16.48", "八字盲板");
        map.put("ASME B16.49", "弯管");
        map.put("MSS SP-43", "锻制不锈钢对焊管件");
        map.put("MSS SP-79", "承插焊异径插入件");
        map.put("MSS SP-83", "承插焊和螺纹活接头");
        map.put("MSS SP-97", "承插焊、螺纹和对焊端的整体加强式管座");
        map.put("ASME B36.10", "焊接和无缝轧制钢管");
        map.put("API5L", " 管线钢管标准");
        map.put("DIN 17456", "不锈钢制无缝圆形钢管");
        map.put("DIN2527", "法兰盖");
        map.put("DIN2633", "带颈对焊法兰");
        map.put("DIN2632", "带颈对焊法兰");
        map.put("DIN2634", "带颈对焊法兰");
        map.put("DIN2635", "带颈对焊法兰");
        map.put("DIN2576", "法兰");
        map.put("DIN2543", "法兰");
        map.put("DIN2544", "法兰");
        map.put("DIN2545", "法兰");
        map.put("JISB2220", "法兰");
        map.put("JIS B2311", "法兰标准");
        map.put("JIS B2312", "钢制对焊管件");
        map.put("JIS B2313", "钢板制对焊管件");
        map.put("JIS B2316", "钢制承插焊管件");
        Set<String> sets = map.keySet();
        for (String item : sets) {
            String value = map.get(item);
            Standard standard = new Standard();
            standard.setK(item.replaceAll(" ", ""));
            standard.setV(value.replaceAll(" ", ""));
            standardDao.addEntity(standard);
        }
    }

    @Test
    public void q() {
        List<Material> materials = materialDao.getAllMaterialList();
        List<Standard> standards = standardDao.getAllStandardList();
        System.out.println(materials);
        System.out.println(standards);
    }

    @Test
    public void insertb() {
        String[] arr = {"管件", "Fitting", "弯头", "elbow", "三通", "tee", "异径三通", "reducing tee", "等径三通", "straight tee", "45°", "斜三通45°", "lateral", "四通", "cross", "同心异径管", "concentric reducer", "偏心异径管", "eccentric reducer", "锻制异径管", "reducing swage", "螺纹支管台", "threadolet", "焊接支管台", "weldolet", "承插支管台", "sockolet", "弯头支管台", "elbolet", "斜接支管台", "latrolet", "镶入式支管嘴", "sweepolet", "短管支管台", "nipolet", "支管台，插入式支管台", "boss", "管接头", "coupling, full coupling", "半管接头", "half coupling", "异径管接头", "reducing coupling", "活接头", "union", "内外螺纹缩接", "bushing", "管帽", "cap (C)", "堵头", "plug", "短节", "nipple", "异径短节", "reducing nipple", "swage nipple", "螺纹法兰", "threaded flange", "滑套法兰", "slip-on flange (SO)", "slip-on welding flange", ",承插焊法兰", "socket welding flange", "松套法兰", "lap joint flange (LJF)", ",对焊法兰", "welding neckflange (WNF)", "法兰盖", "blind flange", "孔板法兰", "orifice flange", "异径法兰", "reducing flange", "松套带颈法兰", "loose hubbed flange", "焊接板式法兰", "welding plate flange", "弯管", "Bends", "盲板", "Blind Flange", "八字盲板", "spectacle blind"};
        for (String temp : arr) {
            Product product = new Product();
            product.setName(temp);
            productDao.addEntity(product);
            System.out.println(temp + "已完成");
        }
    }

    @Test
    public void inserts() {
        String[] arr = {"¼\"", "¼inch", "DN8", "13.7",
                "⅜\"", "⅜inch", "DN10", "17.1", "14",
                "½\"", "½inch", "DN15", "21.3/21", "18",
                "¾\"", "¾inch", "DN20", "26.7/27", "25",
                "1inch", "DN25", "33.4/33", "32",
                "1¼\"", "1¼inch", "1-¼\"", "1-¼inch", "DN32", "42.2/42", "38",
                "1½\"", "1½inch", "1-½\"", "1-½inch", "DN40", "48.3/48", "45",
                "2\"", "2inch", "DN50", "60.3/60", "57",
                "2½\"", "2½inch", "2-½\"", "2-½inch", "DN65", "73.2/73", "76",
                "3\"", "3inch", "DN80", "88.9/89", "89",
                "3½\"", "3½inch", "3-½\"", "3-½inch", "DN90", "101.6/102",
                "4\"", "4inch", "DN100", "114.3/114", "108",
                "5\"", "5inch", "DN125", "141.2/141.3/141", "133",
                "6\"", "6inch", "DN150", "168.1/168.3/168", "159",
                "8\"", "8inch", "DN200", "219.1/219", "219",
                "10\"", "10inch", "DN250", "273",
                "12\"", "12inch", "DN300", "323.8/323.9/325", "325",
                "14\"", "14inch", "DN350", "355.6/355", "377",
                "16\"", "16inch", "DN400", "406.4/406", "426",
                "18\"", "18inch", "DN450", "457.2/457", "480",
                "20\"", "20inch", "DN500", "508", "530",
                "22\"", "22inch", "DN550", "558.8/559",
                "24\"", "24inch", "DN600", "610/609.6", "630",
                "26\"", "26inch", "DN650", "660.4/660",
                "28\"", "28inch", "DN700", "711/711.2", "720",
                "30\"", "30inch", "DN750", "762",
                "32\"", "32inch", "DN800", "813", "820",
                "34\"", "34inch", "DN850", "863.6/864",
                "36\"", "36inch", "DN900", "914/914.4", "920",
                "38\"", "38inch", "DN950", "965.2/965",
                "40\"", "40inch", "DN1000", "1016", "1020",
                "42\"", "42inch", "DN1050", "1066.8/1067",
                "44\"", "44inch", "DN1100", "1117.6/1118",
                "46\"", "46inch", "DN1150", "1168.4/1168",
                "48\"", "48inch", "DN1200", "1219/1219.2",
                "50\"", "50inch", "DN1250", "1270",
                "52\"", "52inch", "DN1300", "1320.8/1321",
                "54\"", "54inch", "DN1350", "1371.6/1372",
                "56\"", "56inch", "DN1400", "1422.4/1422",
                "58\"", "58inch", "DN1450", "1473.3/1473",
                "60\"", "60inch", "DN1500", "1524.9/1525"};
        for (String temp : arr) {
            Size size = new Size();
            size.setSize(temp);
            sizeDao.addEntity(size);
            System.out.println(temp + "已完成");
        }
    }
}
