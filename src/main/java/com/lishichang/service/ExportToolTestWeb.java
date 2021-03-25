package com.lishichang.service;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import com.lishichang.dao.AppInfNineDAO;
import com.lishichang.dao.HostInfSixDAO;
import com.lishichang.dao.PlatInfOneDAO;
import com.lishichang.entity.PlatInfOne;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * 导出WEB工具测试指导书 ExportToolTestWeb
 */

public class ExportToolTestWeb {
    public static void ExportToolTestWeb() throws IOException {
        PlatInfOneDAO platInfOneDAO = new PlatInfOneDAO();
        AppInfNineDAO appInfNineDAO = new AppInfNineDAO();

        String ExportFilePath = GlobalVar.ExportPath + PlatInfOne.platName +"-WEB工具测试指导书.docx";
        String WordChangeTemp = "template/WEB工具测试指导书v1.docx";

        HackLoopTableRenderPolicy Policy = new HackLoopTableRenderPolicy();
        Configure config = Configure.newBuilder().bind("ScanApp", Policy).build();
        XWPFTemplate template = XWPFTemplate.compile(WordChangeTemp, config).render(
                new HashMap<String, Object>(){{
                    put("organName", platInfOneDAO.get().getOrganName());
                    put("aplatName", platInfOneDAO.get().getPlatName());
                    put("ScanApp", appInfNineDAO.ScanAppUrlFromIssample());
                }});

        FileOutputStream out = new FileOutputStream(ExportFilePath);
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }
}
