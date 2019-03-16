package com.didi365;


import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

@Description(name="HelloWorld",value="_FUNC_(input), return the string \"HelloWorld\".",extended ="E.g. \n select hello(1);")

public class Lower extends UDF {
    public String evaluate (final String s) {

        if (s == null) {
            return null;
        }

        return s.toString().toLowerCase();
    }




}
