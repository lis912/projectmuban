package com.lishichang.service;

import com.lishichang.dao.CleanTableDAO;
import com.lishichang.dao.ProblemDAO;
import com.lishichang.dao.TmpProblemDAO;
import com.lishichang.entity.Problem;
import com.lishichang.entity.TmpProblem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.lishichang.gui.util.ReadWriteUtil.*;


/**
 *  ReadTmpProblemSourcetoDB 读取某一项目的问题汇总的临时数据：该表由测评能手导出
 */
public class ReadTmpProblemSourcetoDB {
    public void ReadTmpProblemSourcetoDB(String pathname) throws IOException {
        CleanTableDAO cleantable = new CleanTableDAO();
        cleantable.deleteTmpProblem();

        FileInputStream fis;
        fis = new FileInputStream(pathname);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        ReadTmpProblemSource(workbook);
    }


    public void ReadTmpProblemSource(XSSFWorkbook workbook){
        TmpProblemDAO dao = new TmpProblemDAO();
        XSSFSheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i=1; i<=lastRowNum; i++){
            XSSFRow row = sheet.getRow(i);
            // getCellStringValue(row.getCell(2))!=" " 目的是过滤中间拓展项的行
            if (row != null && isRowNotEmpty(row) && getCellStringValue(row.getCell(2))!=" "){
                List<String> list = new ArrayList<>();
                for (Cell cell : row){
                    if (cell != null){
                        String vaule = getCellStringValue(cell);
                        if(vaule!=null){
                            list.add(vaule);
                        }
                    }
                }
//                list.get(4).Substring(0,list.get(4).Length - 1);
                //TmpProblem tmpproblem = new TmpProblem(i,list.get(1),list.get(2),list.get(4));
                TmpProblem tmpproblem = new TmpProblem(i,list.get(1),list.get(2),list.get(4).substring(0,list.get(4).length() - 1));
                dao.add(tmpproblem);

            }
        }
    }
}
