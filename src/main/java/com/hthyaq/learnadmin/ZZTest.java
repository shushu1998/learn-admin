package com.hthyaq.learnadmin;

import com.hthyaq.learnadmin.common.excle.MyExcelUtil;
import com.hthyaq.learnadmin.model.excelModel.AccidentOfSuperviseModel;

import java.io.IOException;
import java.util.List;

public class ZZTest {
    public static void main(String[] args) throws IOException {
        //读取excel的一个sheet
        List<Object> list = MyExcelUtil.readOneSheetExcel(null, AccidentOfSuperviseModel.class);
        Object obj = (Object) list;
        List<AccidentOfSuperviseModel> dataList = (List<AccidentOfSuperviseModel>) obj;
        //下载excel，包含一个sheet
////导出excel
//        @Controller
//        @RequestMapping("/salLxFile")
//        public class SalLxFileController {
//            @GetMapping("/writeExcel")
//            public void writeExcel(HttpServletResponse response) throws Exception {
//                List<ICBC> dataList = null;
//                //learnFile/excel
//                String file =globalcon.EXCEL_PATH + "/aaaa.xlsx";
//                //先删除
//                File fileTmp = new File(file);
//                if (fileTmp.exists()) {
//                    fileTmp.delete();
//                }
//                MyExcelUtil.writeOneSheetExcel(file, dataList, ICBC.class);
//                new DownloadFile().download(file, response);
//            }
//
        }
}
