package com.hthyaq.learnadmin.common.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.io.File;

/*
    容器启动后立即执行
    创建项目需要的目录
        D:/learnFile/ureportfiles
        D:/learnFile/excel
 */
//@Component
public class CreateDirectoryConfig implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String directory = "D:/learnFile";
        File dir1 = new File(directory + "/ureportfiles");
        if (!dir1.exists()) {
            dir1.mkdirs();
        }
        File dir2 = new File(directory + "/excel");
        if (!dir2.exists()) {
            dir2.mkdirs();
        }
    }
}
