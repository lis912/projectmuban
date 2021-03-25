package com.lishichang.service;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import com.lishichang.dao.HostInfSixDAO;
import com.lishichang.dao.PlatInfOneDAO;
import com.lishichang.dao.ProblemDAO;
import com.lishichang.entity.PlatInfOne;
import com.lishichang.gui.util.ColorUtil;
import com.lishichang.gui.util.GUIUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;


/**
 * 导出问题汇总 ExportSummaryProblem
 */
public class ExportSummaryProblem {
    public static void ExportSummaryProblem() throws IOException {
        PlatInfOneDAO platInfOneDAO = new PlatInfOneDAO();
        ProblemDAO problemDAO = new ProblemDAO();
        String ExportFilePath = GlobalVar.ExportPath + PlatInfOne.platName +"-问题汇总.docx";

        String WordChangeTemp = "";
        if(GlobalVar.PROBLEMGENERAL){
            WordChangeTemp = "template/问题汇总-通用模板.docx";
        }else{
            WordChangeTemp = "template/问题汇总-无网络模板.docx";
        }

        HackLoopTableRenderPolicy Policy = new HackLoopTableRenderPolicy();
        Configure config = Configure.newBuilder().bind("SummaryProblem", Policy).bind("SafeBoundary", Policy).build();
        XWPFTemplate template = XWPFTemplate.compile(WordChangeTemp, config).render(
                new HashMap<String, Object>(){{
                    // 获取表一的单位信息，后期通过界面获取
                    if(platInfOneDAO.get() != null){
                        put("organName", platInfOneDAO.get().getOrganName());
                        put("aplatName", platInfOneDAO.get().getPlatName());
                        put("protectClass", platInfOneDAO.get().getProtectClass());
                    }
                    put("SummaryProblem", problemDAO.OutSafeSummaryProblem("安全计算环境"));
                    put("SafeManageCenter", problemDAO.OutSafeSummaryProblemNoAssoc("安全管理中心"));
                    put("SafeNet", problemDAO.OutSafeSummaryProblemNoAssoc("安全通信网络"));
                    put("SafeBoundary", problemDAO.OutSafeSummaryProblemNoAssoc("安全区域边界"));
                }});

        FileOutputStream out = new FileOutputStream(ExportFilePath);
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }
}
