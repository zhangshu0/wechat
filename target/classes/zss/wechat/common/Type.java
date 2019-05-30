package zss.wechat.common;

import java.util.ArrayList;
import java.util.List;


public enum Type {

    FALAN(10001, "法兰"),
    SANTONG(10002, "三通"),
    ZHUIGUAN(10003, "锥管"),
    WANTOU(10004, "弯头"),
    SITONG(10005, "四通"),
    DAXIAOTOU(10006, "大小头"),
    CL(10007,"BB"),
    RF(10008,"FL"),
    LSS(10009,"FG"),
    SpectacleBlind(10010,"Spectacle Blind"),



    FEIBIAO(20001, "非标"),
    MEIBIAO(20002, "美标"),
    GUOBIAO(20003, "国标"),
    RIBIAO(20004, "日标"),
    ERBIAO(20005, "二标"),
    ASME(20006,"ASME"),

    TANGANG(30001, "碳钢"),
    BAIGANG(30002, "白钢"),
    BUXIUGANG(30003, "不锈钢"),

    YOUFENG(40001, "有缝"),
    WUFENG(40002, "无缝"),;


    public static List<Type> genName = new ArrayList<Type>();

    static {
        genName.add(FALAN);
        genName.add(SANTONG);
        genName.add(SITONG);
        genName.add(WANTOU);
        genName.add(ZHUIGUAN);
        genName.add(DAXIAOTOU);
        genName.add(CL);
        genName.add(RF);
        genName.add(LSS);
        genName.add(SpectacleBlind);

    }

    public static List<Type> genStandard = new ArrayList<Type>();

    static {
        genStandard.add(FEIBIAO);
        genStandard.add(MEIBIAO);
        genStandard.add(GUOBIAO);
        genStandard.add(RIBIAO);
        genStandard.add(ERBIAO);
        genStandard.add(ASME);
    }

    public static List<Type> genMaterial = new ArrayList<Type>();

    static {
        genMaterial.add(TANGANG);
        genMaterial.add(BAIGANG);
        genMaterial.add(BUXIUGANG);
    }

    public static List<Type> genGap = new ArrayList<Type>();

    static {
        genGap.add(YOUFENG);
        genGap.add(WUFENG);
    }

    Type(int type, String msg) {
        this.type = type;
        this.msg = msg;

    }

    private int type;
    private String msg;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
