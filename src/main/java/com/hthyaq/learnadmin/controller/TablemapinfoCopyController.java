package com.hthyaq.learnadmin.controller;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hthyaq.learnadmin.model.entity.TablemapinfoCopy;
import com.hthyaq.learnadmin.service.TablemapinfoCopyService;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 中英文表名、字段名的映射信息 前端控制器
 * </p>
 *
 * @author zhangqiang
 * @since 2019-09-01
 */
@RestController
@RequestMapping("/tablemapinfoCopy")
public class TablemapinfoCopyController {
    @Autowired
    TablemapinfoCopyService tablemapinfoCopyService;

    @GetMapping("/add")
    public void add() {
        ExcelReader reader = ExcelUtil.getReader("D:/政府监管.xlsx");
        List<TablemapinfoCopy> all = reader.readAll(TablemapinfoCopy.class);
        for (TablemapinfoCopy tablemapinfoCopy : all) {
//            tablemapinfoCopyService.save(tablemapinfoCopy);
        }
    }

    @GetMapping("/generateExcelModel")
    public boolean generateExcelModel() throws IOException {
        List<TablemapinfoCopy> list1 = tablemapinfoCopyService.list();
        for (TablemapinfoCopy tablemapinfoCopy : list1) {
            String englishTableName = tablemapinfoCopy.getEnglishTableName();
            generateExcelModelByTableName(englishTableName);
        }
        return true;
    }

    //根据表名生成ExcelModel
    private void generateExcelModelByTableName(String englishTableName) throws IOException {
        //将表名的首字母转为大写
        String excelModelFileName = WordUtils.capitalize(englishTableName);

        List<String> result = Lists.newArrayList();
        result.add("package com.hthyaq.learnadmin.model.excelModel;" + "\r\n");
        result.add("import com.alibaba.excel.annotation.ExcelProperty;");
        result.add("import com.alibaba.excel.metadata.BaseRowModel;");
        result.add("import lombok.Data;" + "\r\n");
        result.add("@Data");
        result.add("public class " + excelModelFileName + "Model extends BaseRowModel {");

        //拼接一行一行java代码
        List<TablemapinfoCopy> list = tablemapinfoCopyService.list(new QueryWrapper<TablemapinfoCopy>().eq("englishTableName", englishTableName).notIn("chineseColumnName", "主键", "外键"));
        for (int i = 0; i < list.size(); i++) {
            TablemapinfoCopy tableMapInfo = list.get(i);
            String chineseColumnName = tableMapInfo.getChineseColumnName();
            String englishColumnName = tableMapInfo.getEnglishColumnName();
            String dataType = tableMapInfo.getDataType();
            //拼接
            String annotationStr = "\t" + "@ExcelProperty(value = {\"" + chineseColumnName + "\"},index=" + i + ")";
            String propertyStr = "\t" + "private " + dataType + " " + englishColumnName + ";" + "\r\n";
            result.add(annotationStr);
            result.add(propertyStr);
        }

        result.add("}");
        //获取learn-admin的execelModel的路径
        String excelModelPath = System.getProperty("user.dir") + "/src/main/java/com/hthyaq/learnadmin/model/excelModel/";
        //生成excelModel的java文件
        IOUtils.writeLines(result, "\r\n", new FileOutputStream(excelModelPath + excelModelFileName + "Model.java"), "utf8");
    }

}

