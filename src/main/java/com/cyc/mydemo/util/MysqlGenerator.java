package com.cyc.mydemo.util;

import java.util.HashMap;
import java.util.Map;

public class MysqlGenerator {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("url","jdbc:mysql://localhost:3306/test");
        map.put("userName","root");
        map.put("password","root");
        map.put("mainDir","C:/Users/91714/mydemo/src/main");
        map.put("entityDir","C:\\Users\\91714\\mydemo\\src\\main\\java\\com\\cyc\\mydemo\\entity");
        map.put("mapperDir","C:\\Users\\91714\\mydemo\\src\\main\\java\\com\\cyc\\mydemo\\mapper");
        map.put("packageDir","C:/Users/91714/mydemo/src/main");
        map.put("parentPackageDir","com.cyc.mydemo");
        map.put("serviceDir","C:\\Users\\91714\\mydemo\\src\\main\\java\\com\\cyc\\mydemo\\service");
        map.put("controllerDir","C:\\Users\\91714\\mydemo\\src\\main\\java\\com\\cyc\\mydemo\\user\\controller");
        String[] excludedTable = null;
        ResourcesCommonGenerator.generator(map,excludedTable);
    }
    }



