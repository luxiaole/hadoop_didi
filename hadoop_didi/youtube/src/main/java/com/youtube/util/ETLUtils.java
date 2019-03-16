package com.youtube.util;




//_5QUdvUhCZc	lendavis	693	Travel & Places	105	819974	4.2	4007	2778	gvI7D4tpZis	oITIfGz46to	jO3AMZgVz44
public class ETLUtils {
    /*
    * 1.过滤不合法数据
    * 2.去掉&两边的空格
    * 3.\t换成&符号
    *
    *
    * */
    public static String getETLString(String ori){
        //切割数据
        String[] splits = ori.split("\t");
        //1.过滤不合法数据
        if(splits.length < 9)
        return null;
        //2.去掉&两边的空格
        splits[3] = splits[3].replaceAll(" ","");
        StringBuilder sb = new StringBuilder();
        //\t换成&符号
        for (int i = 0; i < splits.length; i++){
            sb.append(splits[i]);
            if(i < 9){
                if(i != splits.length - 1){
                    sb.append("\t");
                }
            }else {
                if(i != splits.length - 1){
                    sb.append("&");
                }
            }
        }
        return sb.toString();
    }


//测试清洗效果
    public static void main(String[] args) {
        String a = "_5QUdvUhCZc	lendavis	693	Travel & Places	105	819974	4.2	4007	2778	gvI7D4tpZis	oITIfGz46to	jO3AMZgVz44";
        String etlString = getETLString(a);
        System.out.println(etlString);
    }

}
