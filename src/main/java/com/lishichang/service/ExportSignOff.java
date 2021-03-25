package com.lishichang.service;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import com.lishichang.dao.DocumentTwelveDAO;
import com.lishichang.dao.HostInfSixDAO;
import com.lishichang.dao.PlatInfOneDAO;
import com.lishichang.entity.PlatInfOne;
import com.lishichang.mubanentity.ListSignDevIP;
import com.lishichang.mubanentity.SignDevIP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 导出每日签退清单 ExportSignOff
 */
public class ExportSignOff {
    public static void ExportSignOff() throws IOException {
        String ExportFilePath = GlobalVar.ExportPath+ PlatInfOne.platName+"-入场离场确认.docx";
        String WordChangeTemp = "template/入场离场确认v1纸张纵向模板.docx";

        XWPFTemplate template = XWPFTemplate.compile(WordChangeTemp).render(
                new HashMap<String, Object>(){{
                    put("experiences", ArrayDev(new HostInfSixDAO().SignOffFromIssample(),12));
                }});
        FileOutputStream out = new FileOutputStream(ExportFilePath);
        template.write(out);
        out.flush();
        out.close();
        template.close();

    }

    /**
     * 分组组合函数 ArrayDev
     * @param  list : 字符串列表
     * @param  arraynum ： 每天测评数量，后期通过界面传参实现
     */
    private static List<SignDevIP> ArrayDev (List<String> list, int arraynum){
        List<SignDevIP> experiences = new ArrayList<SignDevIP>();
        int count = list.size();
        String devip = "";
        for (int i=0; i<count; i++) {
            // 依次叠加换行
            devip = devip + list.get(i) + "\n";
            // 由于inedx i是0起步的，当inedx+1是arraynum的整数倍时候，add到experiences
            if((i+1)%arraynum==0){
                experiences.add(new SignDevIP(devip));
                devip = "";
                continue;
            }
            // 当遍历到最后一个，并且arraynum不是总数的整倍数的时候，add到experiences，完成最后几个的添加
            if((i+1) == count && (i+1)%10!=arraynum){
                experiences.add(new SignDevIP(devip));
            }
        }
        return experiences;
    }
}
