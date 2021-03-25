package com.lishichang.service;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import com.lishichang.dao.DocumentTwelveDAO;
import com.lishichang.dao.PlatInfOneDAO;
import com.lishichang.entity.PlatInfOne;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;


/**
 * 导出文档交接单 ExportWordChange
 */
public class ExportWordChange {
    public static void ExportWordChange() throws IOException{
        PlatInfOneDAO platInfOneDAO = new PlatInfOneDAO();
        DocumentTwelveDAO documentTwelveDAO = new DocumentTwelveDAO();
        String ExportFilePath = GlobalVar.ExportPath+ PlatInfOne.platName+"-文档交接单.docx";
        String WordChangeTemp = "template/文档交接单模板v1.docx";

        HackLoopTableRenderPolicy Policy = new HackLoopTableRenderPolicy();
        Configure config = Configure.newBuilder().bind("doc", Policy).build();
        XWPFTemplate template = XWPFTemplate.compile(WordChangeTemp, config).render(
                new HashMap<String, Object>(){{
                    put("organName", platInfOneDAO.get().getOrganName());
                    put("doc", documentTwelveDAO.listdocumenName());
                }});

        FileOutputStream out = new FileOutputStream(ExportFilePath);
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }
}
