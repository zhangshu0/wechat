package zss.web.controller;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import zss.wechat.dao.MaterialDao;
import zss.wechat.dao.ProductDao;
import zss.wechat.dao.SizeDao;
import zss.wechat.dao.StandardDao;
import zss.wechat.model.Material;
import zss.wechat.model.Standard;
import zss.wechat.util.ExcelUtils;
import zss.wechat.util.StringUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/doExcel")
public class DoExcelTest {
    @Autowired
    ExcelUtils excelUtils;
    @Autowired
    MaterialDao materialDao;
    @Autowired
    StandardDao standardDao;
    @Autowired
    SizeDao sizeDao;
    @Autowired
    ProductDao productDao;
    /**
     * excel读写工具类
     */
    private static Logger logger = Logger.getLogger(DoExcelTest.class);
    private final static String xls = "xls";
    private final static String xlsx = "xlsx";
    private static Map<String, Workbook> staticWorkbook = new HashMap<String, Workbook>();

    /**
     * 读入excel文件，解析后返回
     *
     * @param file
     * @throws IOException
     */
    @RequestMapping(value = "/match", method = RequestMethod.POST)
    public String readExcel(@RequestParam(value = "uploadFile", required = false) MultipartFile file, ModelMap modelMap) throws IOException {
        try {
            //检查文件
            checkFile(file);
            //获得Workbook工作薄对象
            Workbook workbook = getWorkBook(file);
            if (workbook != null) {
                Sheet csheet = workbook.createSheet();
                CellStyle style = workbook.createCellStyle();
                style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                Row rows = csheet.createRow(0);
                Cell cell0 = rows.createCell(0);
                cell0.setCellValue("序号");
                cell0.setCellStyle(style);
                Cell cell1 = rows.createCell(1);
                cell1.setCellValue("名称");
                cell1.setCellStyle(style);
                Cell cell2 = rows.createCell(2);
                cell2.setCellValue("规格");
                cell2.setCellStyle(style);
                Cell cell3 = rows.createCell(3);
                cell3.setCellValue("材质");
                cell3.setCellStyle(style);
                Cell cell4 = rows.createCell(4);
                cell4.setCellValue("标准");
                cell4.setCellStyle(style);
                Cell cell5 = rows.createCell(5);
                cell5.setCellValue("有无缝情况");
                cell5.setCellStyle(style);

                //获得当前sheet工作表
                Sheet sheet = workbook.getSheetAt(0);
                //获得当前sheet的开始行
                int firstRowNum = sheet.getFirstRowNum();
                //获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                //循环除了第一行的所有行
                for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
                    //获得当前行
                    Row row = sheet.getRow(rowNum);
                    if (row == null) {
                        continue;
                    }
                    //获得当前行的开始列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的列数
                    int lastCellNum = row.getLastCellNum();
                    //循环当前行
                    StringBuffer value = new StringBuffer();
                    for (int cellNum = firstCellNum + 1; cellNum < lastCellNum; cellNum++) {
                        Cell cell = row.getCell(cellNum);
                        value.append(getCellValue(cell));
                    }
                    List<String> material = StringUtil.getMaterial(value.toString());
                    List<String> gap = StringUtil.getGap(value.toString());
                    List<String> name = StringUtil.getName(value.toString());
                    List<String> standard = StringUtil.getStandard(value.toString());
                    String model = StringUtil.getModel(value.toString()).toString().replace("[", "").replace("]", "");
                    Row newRow = csheet.createRow(rowNum);
                    Cell newCell0 = newRow.createCell(0);
                    newCell0.setCellValue(rowNum);
                    Cell newCell1 = newRow.createCell(1);
                    newCell1.setCellValue(name.toString().replace("[", "").replace("]", ""));
                    Cell newCell2 = newRow.createCell(2);
                    newCell2.setCellValue(model);
                    Cell newCell3 = newRow.createCell(3);
                    newCell3.setCellValue(material.toString().replace("[", "").replace("]", ""));
                    Cell newCell4 = newRow.createCell(4);
                    newCell4.setCellValue(standard.toString().replace("[", "").replace("]", ""));
                    Cell newCell5 = newRow.createCell(5);
                    newCell5.setCellValue(gap.toString().replace("[", "").replace("]", ""));

                }
                String key = StringUtil.genRandom() + "";
                staticWorkbook.put(key, workbook);
                modelMap.put("errorNo", 0);
                modelMap.put("key", key);
            }
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("errorNo", 1);
            modelMap.put("errorMsg", e.getMessage());
        }
        return "upload";
    }

    public static void checkFile(MultipartFile file) throws IOException {
        //判断文件是否存在
        if (null == file) {
            logger.error("文件不存在！");
            throw new FileNotFoundException("文件不存在！");
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        //判断文件是否是excel文件
        if (!fileName.endsWith(xls) && !fileName.endsWith(xlsx)) {
            logger.error(fileName + "不是excel文件");
            throw new IOException(fileName + "不是excel文件");
        }
    }

    public static Workbook getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if (fileName.endsWith(xls)) {
                //2003
                workbook = new HSSFWorkbook(is);
            } else if (fileName.endsWith(xlsx)) {
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return workbook;
    }

    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    @RequestMapping(value = "/getUpLoadPage", method = RequestMethod.GET)
    public String getUpLoadPage() {
        return "upload";
    }

    @RequestMapping(value = "/genExcel", method = RequestMethod.GET)
    public void genExcel(HttpServletRequest request, HttpServletResponse response) {
        try {
            String key = request.getParameter("key");
            String fileName = key + ".xlsx";
            response.setContentType("application/x-msdownload");
            //禁止缓存
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "No-cache");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
            ServletOutputStream outputStream = response.getOutputStream();
            if (staticWorkbook != null) {
                staticWorkbook.get(key).write(outputStream);
            } else {
                outputStream.write(key.concat("对应的文件不存在！").getBytes("GBK"));
            }
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读入excel文件，解析后返回
     *
     * @param file
     * @throws IOException
     */
    @RequestMapping(value = "/excel2Html", method = RequestMethod.POST)
    public String excel2Html(@RequestParam(value = "uploadFile", required = false) MultipartFile file, ModelMap modelMap) throws IOException {
        String error = "抱歉，转换失败！";
        try {
            //检查文件
            checkFile(file);
            //获得Workbook工作薄对象
            Workbook workbook = getWorkBook(file);
            if (workbook != null) {
//                html = POIReadExcel.getExcelInfo(workbook,true);
                List<String> columnList = excelUtils.readColumnName(workbook);
                List<Material> mas = materialDao.getAllMaterialList();
                List<Standard> stas = standardDao.getAllStandardList();

                modelMap.put("columnList", columnList);
                List<List<String>> maps = excelUtils.readAndBuild(excelUtils.read(workbook),mas,stas);
                modelMap.put("dataList",maps);
//                modelMap.put("dataList", maps.subList((page.getCurrentPage()-1)*page.getRecordPerPage(),page.getCurrentPage()*page.getRecordPerPage()>maps.size()?maps.size():page.getCurrentPage()*page.getRecordPerPage()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("errorNo", 1);
            modelMap.put("errorMsg", error);
        }
        return "sql";
    }

}
