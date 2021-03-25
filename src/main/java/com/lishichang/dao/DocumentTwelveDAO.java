package com.lishichang.dao;

import com.lishichang.entity.DocumentTwelve;
import com.lishichang.entity.JobEleven;
import com.lishichang.gui.util.DBUtil;
import com.lishichang.mubanentity.Document;
import com.lishichang.mubanentity.Job;
import com.lishichang.mubanentity.WordChange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *  AppInfNineDAO  ： 表12 管理文档 DAO 操作类
 */
public class DocumentTwelveDAO {
    public void add(DocumentTwelve document) {
        String sql = "insert into documenttwelve (`dpaltName`,`documenName`,`details`) values (?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, document.getDpaltName());
            ps.setString(2, document.getDocumenName());
            ps.setString(3, document.getDetails());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                document.setdId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Document> listDocument() {
        String sql = "select documenName, details from documenttwelve";
        List<Document> Documents = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                Document document = new Document(++i,
                        rs.getString("documenName"),
                        rs.getString("details"));
                Documents.add(document);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Documents;
    }

    /**
     * listdocumenName() 返回文档交接单 已经写死了  13行  后期有时间改为单独传入参数
     */
    public List<WordChange> listdocumenName() {
        String sql = "select documenName from documenttwelve limit 13";
        List<WordChange> wordchanges = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                WordChange document = new WordChange(++i,
                        rs.getString("documenName"));
                wordchanges.add(document);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wordchanges;
    }

}
