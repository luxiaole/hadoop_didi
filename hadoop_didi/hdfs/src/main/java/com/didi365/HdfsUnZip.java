package com.didi365;


import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.*;

import java.util.ArrayList;
import java.util.List;



/**
 * hdfs上解压zip包，命令不支持zip包解压，只能通过代码实现
 */
public class HdfsUnZip {

}