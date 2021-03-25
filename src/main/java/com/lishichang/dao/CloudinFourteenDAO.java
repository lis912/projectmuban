package com.lishichang.dao;

import com.lishichang.entity.CloudinFourteen;
import com.lishichang.entity.DocumentTwelve;
import com.lishichang.gui.util.DBUtil;
import com.lishichang.mubanentity.Cloudinf;
import com.lishichang.mubanentity.WordChange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *  CloudinFourteenDAO  ：  表14 云平台信息 DAO 操作类
 */
public class CloudinFourteenDAO {
    public void add(CloudinFourteen cloudinfo) {
        String sql = "insert into cloudinfofourteen (`cpaltName`,`cloudPlatName`,`cloudLesseeName`,`cloudServerDetail`) values (?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, cloudinfo.getCpaltName());
            ps.setString(2, cloudinfo.getCloudPlatName());
            ps.setString(3, cloudinfo.getCloudLesseeName());
            ps.setString(4, cloudinfo.getCloudServerDetail());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                cloudinfo.setCid(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *  Cloudinf GetCloudPlat() ： 返回 Cloudinf 仅过去第一行，毕竟不大可能在多个云平台
     */
    public Cloudinf GetCloudPlat() {
        String sql = "select * from cloudinfofourteen limit 1";
       Cloudinf cloudinf = new Cloudinf();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            cloudinf.setCloudPlatName(rs.getString("cloudPlatName"));
            cloudinf.setCloudLesseeName(rs.getString("cloudLesseeName"));
            cloudinf.setCloudServerDetail(rs.getString("cloudServerDetail"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cloudinf;
    }

}
