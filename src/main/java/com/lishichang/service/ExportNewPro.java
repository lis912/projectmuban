package com.lishichang.service;

import com.deepoove.poi.XWPFTemplate;
import com.lishichang.dao.HostInfSixDAO;
import com.lishichang.entity.PlatInfOne;
import com.lishichang.mubanentity.NewPro;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExportNewPro {
    public static void ExportNewPro(String oraName, String proName) throws IOException {
        String ExportFilePath = GlobalVar.ExportPath+ oraName+"-项目启动资料.docx";
        String WordChangeTemp = "template/项目启动资料模板.docx";

        XWPFTemplate template = XWPFTemplate.compile(WordChangeTemp).render(
                new HashMap<String, Object>(){{
                    put("experiences", lisNewPro(oraName, proName));
                }});
        FileOutputStream out = new FileOutputStream(ExportFilePath);
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }

    private static List<NewPro> lisNewPro(String oraName, String proName){
        List<NewPro> NewPros = new ArrayList<>();
        String[] lines = proName.split("\\r?\\n");
        for (String line : lines) {
            NewPro newPro = new NewPro(oraName, line);
            NewPros.add(newPro);
        }
        return NewPros;
    }
}
