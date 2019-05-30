package zss.wechat.util;

import zss.wechat.common.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringUtil {
    public static List<String> getModel(String str) {
        List<String> resultList = new ArrayList<String>();
        StringBuilder numBuilder = new StringBuilder();
        str = str.replaceAll(" ", "");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 48 && ch <= 57) {
                numBuilder.append(ch);
                if (i == str.length() - 1) {
                    resultList.add(numBuilder.toString());
                }
            } else {
                if (!numBuilder.toString().equals("") && numBuilder.length() > 0) {
                    resultList.add(numBuilder.toString());
                    numBuilder = new StringBuilder();
                }
            }
        }
        return resultList;
    }


    public static List<String> getMaterial(String param) {
        List<String> result = new ArrayList<String>();
        List<Type> list = Type.genMaterial;
        for (Type temp : list) {
            if (param.contains(temp.getMsg())) {
                result.add(temp.getMsg());
            }
        }
        return new ArrayList<String>(new HashSet(result));
    }

    public static List<String> getName(String param) {
        List<String> result = new ArrayList<String>();
        List<Type> list = Type.genName;
        for (Type temp : list) {
            if (param.contains(temp.getMsg())) {
                result.add(temp.getMsg());
            }
        }
        return new ArrayList<String>(new HashSet(result));
    }

    public static List<String> getStandard(String param) {
        List<String> result = new ArrayList<String>();
        List<Type> list = Type.genStandard;
        for (Type temp : list) {
            if (param.contains(temp.getMsg())) {
                result.add(temp.getMsg());
            }
        }
        return new ArrayList<String>(new HashSet(result));
    }

    public static List<String> getGap(String param) {
        List<String> result = new ArrayList<String>();
        List<Type> list = Type.genGap;
        for (Type temp : list) {
            if (param.contains(temp.getMsg())) {
                result.add(temp.getMsg());
            }
        }
        return new ArrayList<String>(new HashSet(result));
    }

    public static int genRandom() {
        return (int) ((Math.random() * 9 + 1) * 100000);
    }
}
