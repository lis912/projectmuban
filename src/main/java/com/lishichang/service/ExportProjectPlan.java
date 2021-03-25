package com.lishichang.service;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import com.lishichang.dao.AppInfNineDAO;
import com.lishichang.dao.JobElevenDAO;
import com.lishichang.dao.PlatInfOneDAO;
import com.lishichang.entity.PlatInfOne;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * 导出项目计划书 ExportProjectPlan
 */
public class ExportProjectPlan {
    public static void ExportProjectPlan() throws IOException {
        PlatInfOneDAO platInfOneDAO = new PlatInfOneDAO();
        JobElevenDAO jobElevenDAO = new JobElevenDAO();

        String ExportFilePath = GlobalVar.ExportPath + PlatInfOne.platName +"-项目计划书.docx";
        String WordChangeTemp = "template/项目计划书模板v1.docx";

        HackLoopTableRenderPolicy Policy = new HackLoopTableRenderPolicy();
        Configure config = Configure.newBuilder().bind("job", Policy).build();
        XWPFTemplate template = XWPFTemplate.compile(WordChangeTemp, config).render(
                new HashMap<String, Object>(){{
                    put("organName", platInfOneDAO.get().getOrganName());
                    put("aplatName", platInfOneDAO.get().getPlatName());
                    put("job", jobElevenDAO.listjobPerson());
                }});

        FileOutputStream out = new FileOutputStream(ExportFilePath);
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }
}
