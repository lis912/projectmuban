package com.lishichang.gui.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;


/**
 * 工具类 ReadWriteUtil 读写offic相关辅助方法
 */
public class ReadWriteUtil {
    /**
     *  getCellStringValue()：
     * @param cell : 输入单元格
     * @return String : 返货字符串 或者 “ ”
     */
    public static String getCellStringValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        CellType type = cell.getCellType();

        String cellValue;
        switch (type) {
            case BLANK:
                cellValue = " ";
                break;
            case _NONE:
                cellValue = " ";
                break;
            case ERROR:
                cellValue = " ";
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case NUMERIC:
                cellValue = String.valueOf((long)cell.getNumericCellValue());
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case FORMULA:
                cellValue = cell.getCellFormula();
                break;
            default:
                cellValue = " ";
                break;
        }
        return cellValue;
    }

    /**
     *  isRowNotEmpty()： 判断空行 del的单元格POI判断是BLANK而不是NUL
     * @param row : 输入某一行
     * @return false : 是空行
     * @return true: 不是空行
     */
    public static boolean isRowNotEmpty(XSSFRow row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            XSSFCell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return true;
            }
        }

        return false;
    }
    /**
     *  isRowNotEmpty()：获取列数
     * @param row : 输入某一行
     * @return int : 列数
     */
    public static int getRowCellCount(XSSFRow row){
        return row.getLastCellNum()-row.getFirstCellNum();
    }

}
