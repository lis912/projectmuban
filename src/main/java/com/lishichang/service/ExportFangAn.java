package com.lishichang.service;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.data.PictureRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import com.lishichang.dao.*;
import com.lishichang.entity.PlatInfOne;
import com.lishichang.entity.PsychzInfTwo;
import com.lishichang.entity.SecurityDevFour;
import com.lishichang.gui.frame.MainFrame;
import com.lishichang.gui.panel.MainPanel;
import com.lishichang.mubanentity.ListHost;
import com.lishichang.mubanentity.SAGlevel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * 导出测评方案类 ExportFangAn
 * 读取GlobalVar全局类的配置值 选择模板 来导出需要的测评方案
 * @tempath 模板变量
 *
 */
public class ExportFangAn {
    public static void ExportFangAn() throws IOException {
        String ExportPathFangAn = GlobalVar.ExportPath+PlatInfOne.platName+"-等级测评方案.docx";

        PsychzInfTwoDAO psychzInfTwoDAO = new PsychzInfTwoDAO();
        PlatInfOneDAO platInfOneDAO = new PlatInfOneDAO();
        HostInfSixDAO hostInfSixDAO = new HostInfSixDAO();
        NetDeviceThreeDAO netDeviceThreeDAO = new NetDeviceThreeDAO();
        SecurityDevFourDAO securityDevFourDAO = new SecurityDevFourDAO();
        TerminalSevenDAO terminalSevenDAO = new TerminalSevenDAO();
        AppInfNineDAO appInfNineDAO = new AppInfNineDAO();
        JobElevenDAO jobElevenDAO = new JobElevenDAO();
        DocumentTwelveDAO documentTwelveDAO = new DocumentTwelveDAO();
        TopologyThirteenDAO topologyThirteenDAO = new TopologyThirteenDAO();
        CloudinFourteenDAO cloudinFourteenDAO = new CloudinFourteenDAO();
        SAGlevel sag = new SAGlevel(platInfOneDAO.get().getProtectClass());

        String tempath;
        if(GlobalVar.GENERAL){
           tempath = "template/等级测评方案模板1.2-通用A.docx";
        }else {
            tempath = "template/等级测评方案模板1.2-无网络B.docx";
        }
       // String tempath = "D:\\winshare\\javacode\\projectmuban\\src\\template\\等级测评方案模板1.2-通用A.docx";
        HackLoopTableRenderPolicy Policy = new HackLoopTableRenderPolicy();
        Configure config = Configure.newBuilder().bind("psychz", Policy).bind("psychzb", Policy).bind("netdevice", Policy).bind("netdeviceb", Policy).bind("secdevice", Policy).bind("secdeviceb", Policy).bind("hosts", Policy).bind("hostsb", Policy).bind("terminal", Policy).bind("terminalb", Policy).bind("app", Policy).bind("appb", Policy).bind("job", Policy).bind("doc", Policy).bind("ScanHost", Policy).bind("PenetraApp", Policy).build();
        XWPFTemplate template = XWPFTemplate.compile(tempath, config).render(
                new HashMap<String, Object>(){{
                    put("varPlatName", platInfOneDAO.get().getPlatName());
                    put("varorganName", platInfOneDAO.get().getOrganName());
                    put("varDescribe", platInfOneDAO.get().getDescribe());
                    put("S", sag.getS());
                    put("A", sag.getA());
                    put("G", sag.getG());
                    if(GlobalVar.BoxThirTopology){
                        put("netopology", new PictureRenderData(500, 350, topologyThirteenDAO.get().gettPathName()));
                        put("tNetworkDescription", topologyThirteenDAO.get().gettNetworkDescription());
                    }
                    if(GlobalVar.BoxFoteCloud){
                        put("cloudPlatName", cloudinFourteenDAO.GetCloudPlat().getCloudPlatName());
                    }
                    if(GlobalVar.BoxTwoPhy){
                        put("psychz", psychzInfTwoDAO.listAllPsychz());
                        put("psychzb", psychzInfTwoDAO.listAllPsychzIssample());
                    }
                    if(GlobalVar.BoxThrNet){
                        put("netdevice", netDeviceThreeDAO.listallnetDev());
                        put("netdeviceb", netDeviceThreeDAO.listallnetDev());
                    }
                    if(GlobalVar.BoxFourSec){
                        put("secdevice", securityDevFourDAO.listallSecDev());
                        put("secdeviceb", securityDevFourDAO.listAllSecDevFromIssample());
                    }
                    if(GlobalVar.BoxSixHost){
                        put("hosts", hostInfSixDAO.listallhost());
                        put("hostsb", hostInfSixDAO.listallhostFromIssample());
                        put("ScanHost", hostInfSixDAO.ScanlistallhostFromIssample());
                    }
                    if(GlobalVar.BoxSevTerm){
                        put("terminal", terminalSevenDAO.listallTerminalDev());
                        put("terminalb", terminalSevenDAO.listAllSecDevFromIssample());
                    }
                    if(GlobalVar.BoxNineApp){
                        put("app", appInfNineDAO.listallApp());
                        put("appb", appInfNineDAO.listAllAppFromIssample());
                        put("PenetraApp", appInfNineDAO.PenetralistAllAppFromIssample());
                    }
                    if(GlobalVar.BoxElePer){
                        put("job", jobElevenDAO.listjobPerson());
                    }
                    if(GlobalVar.BoxTweDoc){
                        put("doc", documentTwelveDAO.listDocument());
                    }
                }});

        FileOutputStream out = new FileOutputStream(ExportPathFangAn);
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }
}
