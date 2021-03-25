package com.lishichang.service;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import com.lishichang.dao.DocumentTwelveDAO;
import com.lishichang.dao.HostInfSixDAO;
import com.lishichang.dao.PlatInfOneDAO;
import com.lishichang.entity.PlatInfOne;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * 导出工具测试指导书 ExportToolTestHost
 */
public class ExportToolTestHost {
    public static void ExportToolTestHost() throws IOException {
        PlatInfOneDAO platInfOneDAO = new PlatInfOneDAO();
        HostInfSixDAO hostInfSixDAO = new HostInfSixDAO();

        String ExportFilePath = GlobalVar.ExportPath + PlatInfOne.platName +"-工具测试指导书.docx";
        String WordChangeTemp = "template/工具测试指导书模板v1.docx";

        HackLoopTableRenderPolicy Policy = new HackLoopTableRenderPolicy();
        Configure config = Configure.newBuilder().bind("ScanHost", Policy).build();
        XWPFTemplate template = XWPFTemplate.compile(WordChangeTemp, config).render(
                new HashMap<String, Object>(){{
                    put("organName", platInfOneDAO.get().getOrganName());
                    put("aplatName", platInfOneDAO.get().getPlatName());
                    put("ScanHost", hostInfSixDAO.ScanHostIpFromIssample());
                }});

        FileOutputStream out = new FileOutputStream(ExportFilePath);
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }
}
