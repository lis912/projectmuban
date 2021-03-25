package com.lishichang.service;

import com.lishichang.dao.*;
import com.lishichang.entity.*;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lishichang.gui.util.ReadWriteUtil.getCellStringValue;
import static com.lishichang.gui.util.ReadWriteUtil.isRowNotEmpty;

/**
 *  ReadExceltoDB 读取调研表类
 *  通过 GlobalVar 选择导入参数
 *
 */
public class ReadExceltoDB {
    public void ReadExceltoDB(String pathname) throws IOException {
        CleanTableDAO cleantable = new CleanTableDAO();
        cleantable.delete();

        FileInputStream fis;
        fis = new FileInputStream(pathname);
        // 将输入流转换为工作簿对象
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        // 获取第一个工作表  这个按照表名来的
        //XSSFSheet sheet = workbook.getSheet("sheet1");
        // 使用索引获取工作表 按照索引表1就是第0表

       // 判断字符是空字符 有可能用的上 && !"".equals(vaule)
        if(GlobalVar.BoxOnePlat){
            ReadPlatInfOne(workbook);
        }
        if(GlobalVar.BoxTwoPhy){
            ReadPsychzInfTwo(workbook);
        }
        if(GlobalVar.BoxThrNet){
            ReadNetDeviceThree(workbook);
        }
        if(GlobalVar.BoxFourSec){
            ReadSecurityDevFour(workbook);
        }
        if(GlobalVar.BoxSixHost){
            ReadHostInfSix(workbook);
        }
        if(GlobalVar.BoxSevTerm){
            ReadTerminalSeven(workbook);
        }
        if(GlobalVar.BoxNineApp){
            ReadAppInfNine(workbook);
        }
        if(GlobalVar.BoxElePer){
            ReadJobEleven(workbook);
        }
        if(GlobalVar.BoxTweDoc){
            ReadDocumentTwelve(workbook);
        }
        if(GlobalVar.BoxThirTopology){
            ReadTopologyThirteen(workbook);
        }
        if(GlobalVar.BoxFoteCloud){
            ReadCloudinFourteen(workbook);
        }
    }
    public void ReadPlatInfOne(XSSFWorkbook workbook){
        PlatInfOneDAO dao = new PlatInfOneDAO();
        XSSFSheet sheet = workbook.getSheetAt(1);
        List<String> list = new ArrayList<>();

        int lastRowNum = sheet.getLastRowNum();
        for (int i=0; i<=lastRowNum; i++){
            XSSFRow row = sheet.getRow(i);
            if (row != null && isRowNotEmpty(row)){
                String vaule = getCellStringValue(row.getCell(2));
                if(vaule!=null){
                    list.add(vaule);
                }
            }
        }
        PlatInfOne platinfone = new PlatInfOne(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7),list.get(8),list.get(9),list.get(10),list.get(11),list.get(12));
        dao.add(platinfone);
    }


    public void ReadHostInfSix(XSSFWorkbook workbook){
        HostInfSixDAO dao = new HostInfSixDAO();
        XSSFSheet sheet = workbook.getSheetAt(6);
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
                // 1 遍历每一行 按索引取出单元格 填充 实例类。
                HostInfSix hostinfsix = new HostInfSix(Integer.parseInt(list.get(0)),PlatInfOne.platName,list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7),list.get(8),list.get(9),list.get(10),list.get(11));
                // 2 每个实例类调取dao层存入数据库
                dao.add(hostinfsix);

            }
        }

    }

    public void ReadPsychzInfTwo(XSSFWorkbook workbook){
        PsychzInfTwoDAO dao = new PsychzInfTwoDAO();
        XSSFSheet sheet = workbook.getSheetAt(2);
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
                // 1 遍历每一行 按索引取出单元格 填充 实例类。
                PsychzInfTwo psychzInfTwo = new PsychzInfTwo(PlatInfOne.platName,list.get(1),list.get(2),list.get(3),list.get(4));
                // 2 每个实例类调取dao层存入数据库
                dao.add(psychzInfTwo);
            }
        }

    }

    public void ReadNetDeviceThree(XSSFWorkbook workbook){
        NetDeviceThreeDAO dao = new NetDeviceThreeDAO();
        XSSFSheet sheet = workbook.getSheetAt(3);
        int lastRowNum = sheet.getLastRowNum();
        for (int i=1; i<=lastRowNum; i++){
            XSSFRow row = sheet.getRow(i);
            if (row != null && isRowNotEmpty(row)){
                List<String> list = new ArrayList<>();
                for (Cell cell : row){
                    if (cell != null){
                        String vaule = getCellStringValue(cell);
                        if(vaule!=null){
                            list.add(vaule);
                        }
                    }
                }

                // 1 遍历每一行 按索引取出单元格 填充 实例类。
                NetDeviceThree netdevicethree = new NetDeviceThree(PlatInfOne.platName,list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7),list.get(8),list.get(9));
                // 2 每个实例类调取dao层存入数据库
                dao.add(netdevicethree);
            }
        }

    }


    public void ReadSecurityDevFour(XSSFWorkbook workbook){
        SecurityDevFourDAO dao = new SecurityDevFourDAO();
        XSSFSheet sheet = workbook.getSheetAt(4);
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
                // 1 遍历每一行 按索引取出单元格 填充 实例类。
                SecurityDevFour secdevicefour = new SecurityDevFour(PlatInfOne.platName,list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7),list.get(8),list.get(9));
                // 2 每个实例类调取dao层存入数据库
                dao.add(secdevicefour);

            }
        }

    }

    public void ReadTerminalSeven(XSSFWorkbook workbook){
        TerminalSevenDAO dao = new TerminalSevenDAO();
        XSSFSheet sheet = workbook.getSheetAt(7);
        int lastRowNum = sheet.getLastRowNum();

        for (int i=1; i<=lastRowNum; i++){
            XSSFRow row = sheet.getRow(i);
            // 表中有异常的非空的行，所以无奈只能判断第1列如果是空的话 就判定不正常的列，这个也可以作为其他的方法来使用
            if (row != null && isRowNotEmpty(row)){
                List<String> list = new ArrayList<>();
                for (Cell cell : row){
                    if (cell != null){
                        String vaule = getCellStringValue(cell);
                        if(vaule!=null){
                            list.add(vaule);
                        }
                    }
                }
                TerminalSeven terminalseven = new TerminalSeven(PlatInfOne.platName,list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7),list.get(8),list.get(9));
                dao.add(terminalseven);

            }
        }

    }

    public void ReadAppInfNine(XSSFWorkbook workbook){
        AppInfNineDAO dao = new AppInfNineDAO();
        XSSFSheet sheet = workbook.getSheetAt(9);
        int lastRowNum = sheet.getLastRowNum();

        for (int i=1; i<=lastRowNum; i++){
            XSSFRow row = sheet.getRow(i);
            if (row != null && isRowNotEmpty(row)){
                List<String> list = new ArrayList<>();
                for (Cell cell : row){
                    if (cell != null){
                        String vaule = getCellStringValue(cell);
                        if(vaule!=null){
                            list.add(vaule);
                        }
                    }
                }
                // 判断是否是空列 非空才添加

                // 1 遍历每一行 按索引取出单元格 填充 实例类。
                AppInfNine appInfNine = new AppInfNine(PlatInfOne.platName,list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7),list.get(8));
                // 2 每个实例类调取dao层存入数据库
                dao.add(appInfNine);


            }
        }
    }

    public void ReadJobEleven(XSSFWorkbook workbook){
        JobElevenDAO dao = new JobElevenDAO();
        XSSFSheet sheet = workbook.getSheetAt(11);
        int lastRowNum = sheet.getLastRowNum();

        for (int i=1; i<=lastRowNum; i++){
            XSSFRow row = sheet.getRow(i);
            if (row != null && isRowNotEmpty(row)){
                List<String> list = new ArrayList<>();
                for (Cell cell : row){
                    if (cell != null){
                       // System.out.println(cell.getCellType());
                        String vaule = getCellStringValue(cell);
                        if(vaule!=null){
                            list.add(vaule);
                        }
                    }
                }

                // 1 遍历每一行 按索引取出单元格 填充 实例类。
                JobEleven jobeleven = new JobEleven(PlatInfOne.platName,list.get(1),list.get(2),list.get(3));
                // 2 每个实例类调取dao层存入数据库
                dao.add(jobeleven);
            }
        }
    }

    public void ReadDocumentTwelve(XSSFWorkbook workbook){
        DocumentTwelveDAO dao = new DocumentTwelveDAO();
        XSSFSheet sheet = workbook.getSheetAt(12);
        int lastRowNum = sheet.getLastRowNum();

        for (int i=1; i<=lastRowNum; i++){
            XSSFRow row = sheet.getRow(i);
            if (row != null && isRowNotEmpty(row)){
                List<String> list = new ArrayList<>();
                for (Cell cell : row){
                    if (cell != null){
                        String vaule = getCellStringValue(cell);
                        if(vaule!=null){
                            list.add(vaule);
                        }
                    }
                }
                // 1 遍历每一行 按索引取出单元格 填充 实例类。
                DocumentTwelve documentTwelve = new DocumentTwelve(PlatInfOne.platName,list.get(1),list.get(2));
                // 2 每个实例类调取dao层存入数据库
                dao.add(documentTwelve);
            }
        }
    }

    // 读取网络拓扑表13 TopologyThirteenDAO
    public void ReadTopologyThirteen(XSSFWorkbook workbook){
        TopologyThirteenDAO dao = new TopologyThirteenDAO();
        Map<String, PictureData>  maplist=null;
        TopologyThirteen topology = null;
        XSSFSheet sheet = workbook.getSheetAt(13);
        try {
            maplist = getPictures2(sheet);
            topology = new TopologyThirteen(PlatInfOne.platName,saveImg(maplist),sheet.getRow(1).getCell(2).getStringCellValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
        dao.add(topology);
    }



    // 读取云平台表14
    public static void ReadCloudinFourteen(XSSFWorkbook workbook){
        CloudinFourteenDAO dao = new CloudinFourteenDAO();
        XSSFSheet sheet = workbook.getSheetAt(14);
        int lastRowNum = sheet.getLastRowNum();

        for (int i=1; i<=lastRowNum; i++){
            XSSFRow row = sheet.getRow(i);
            if (row != null && isRowNotEmpty(row)){
                List<String> list = new ArrayList<>();
                for (Cell cell : row){
                    if (cell != null){
                        String vaule = getCellStringValue(cell);
                        if(vaule!=null){
                            list.add(vaule);
                        }
                    }
                }
                // 1 遍历每一行 按索引取出单元格 填充 实例类。
                System.out.println(list);
                CloudinFourteen cloudinFourteen = new CloudinFourteen(PlatInfOne.platName,list.get(1),list.get(2),list.get(3));
                // 2 每个实例类调取dao层存入数据库
                dao.add(cloudinFourteen);
            }
        }
    }



    /**
     * 获取图片和坐标 (xlsx)
     * @param sheet
     * @return
     * @throws IOException
     */
    public static Map<String, PictureData> getPictures2 (XSSFSheet sheet) throws IOException {
        Map<String, PictureData> map = new HashMap<String, PictureData>();
        List<POIXMLDocumentPart> list = sheet.getRelations();
        for (POIXMLDocumentPart part : list) {
            if (part instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) part;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    XSSFPicture picture = (XSSFPicture) shape;
                    XSSFClientAnchor anchor = picture.getPreferredSize();
                    CTMarker marker = anchor.getFrom();
                    String key = marker.getRow() + "-" + marker.getCol();
                    map.put(key, picture.getPictureData());
                }
            }
        }
        return map;
    }
    //图片保存并返回路径
    public static String saveImg(Map<String, PictureData> sheetList) throws IOException {
        //for (Map<String, PictureData> map : sheetList) {
        String savepath = "";
        Object key[] = sheetList.keySet().toArray();
        for (int i = 0; i < sheetList.size(); i++) {
            // 获取图片流
            PictureData pic = sheetList.get(key[i]);
            // 获取图片索引
            String picName = key[i].toString();
            // 获取图片格式
            String ext = pic.suggestFileExtension().toLowerCase();
            byte[] data = pic.getData();
            //图片保存路径
            savepath = GlobalVar.TemplatePath+"临时网络拓扑图"+ "." + ext;
            FileOutputStream out = new FileOutputStream(savepath);
            out.write(data);
            out.close();
        }
        return savepath;

    }

    public static void main(String[] args) throws FileNotFoundException {

    }
}
