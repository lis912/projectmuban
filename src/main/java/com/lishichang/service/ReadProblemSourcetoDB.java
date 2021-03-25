package com.lishichang.service;

import com.lishichang.dao.*;
import com.lishichang.entity.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.lishichang.gui.util.ReadWriteUtil.getCellStringValue;
import static com.lishichang.gui.util.ReadWriteUtil.isRowNotEmpty;


/**
 *  ReadProblemSourcetoDB 读取更新问题汇总的源数据
 *  通过 GlobalVar 选择导入参数
 */
public class ReadProblemSourcetoDB {
    public void ReadProblemSourcetoDBForHost(String pathname) throws IOException {
        CleanTableDAO cleantable = new CleanTableDAO();
        cleantable.deleteProblem();

        FileInputStream fis;
        fis = new FileInputStream(pathname);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        ReadProblemSourceForHost(workbook);
    }

//    public void ReadProblemSourcetoDBForNet(String pathname) throws IOException {
//        CleanTableDAO cleantable = new CleanTableDAO();
//        cleantable.deleteProblemForNet();
//
//        FileInputStream fis;
//        fis = new FileInputStream(pathname);
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        ReadProblemSourceForNet(workbook);
//    }

    public void ReadProblemSourceForHost(XSSFWorkbook workbook){
        ProblemDAO dao = new ProblemDAO();
        XSSFSheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i=1; i<=lastRowNum; i++){
            XSSFRow row = sheet.getRow(i);
            if (row != null && isRowNotEmpty(row)){
                List<String> list = new ArrayList<>();
                for (Cell cell : row){
                    if (cell != null){
                        String vaule = getCellStringValue(cell);
                        //System.out.println(cell.getCellType());
                        if(vaule!=null){
                            list.add(vaule);
                        }
                    }
                }
                Problem problem = new Problem(i,list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7),list.get(8),list.get(9),list.get(10),list.get(11),list.get(12));
                dao.add(problem);

            }
        }

    }

//    public void ReadProblemSourceForNet(XSSFWorkbook workbook){
//        ProblemDAO dao = new ProblemDAO();
//        XSSFSheet sheet = workbook.getSheetAt(0);
//        int lastRowNum = sheet.getLastRowNum();
//        for (int i=1; i<=lastRowNum; i++){
//            XSSFRow row = sheet.getRow(i);
//            if (row != null && isRowNotEmpty(row)){
//                List<String> list = new ArrayList<>();
//                for (Cell cell : row){
//                    if (cell != null){
//                        String vaule = getCellStringValue(cell);
//                        //System.out.println(cell.getCellType());
//                        if(vaule!=null){
//                            list.add(vaule);
//                        }
//                    }
//                }
//                Problem problem = new Problem(i,list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7),list.get(8),list.get(9),list.get(10),list.get(11),list.get(12));
//                dao.addNet(problem);
//
//            }
//        }
//
//    }

}
