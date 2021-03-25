package com.lishichang.dao;

import com.lishichang.entity.HostInfSix;
import com.lishichang.entity.PlatInfOne;
import com.lishichang.gui.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlatInfOneDAO {
    public void add(PlatInfOne plat) {
        String sql = "insert into platinfone (`platname`,`protectclass`,`number`,`describe`, `organname`,`organaddr`,`postnum`,`principal`,`department`,`job`,`telnum`, `phonenum`, `mail`) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, plat.getPlatName());
            ps.setString(2, plat.getProtectClass());
            ps.setString(3, plat.getNumber());
            ps.setString(4, plat.getDescribe());

            ps.setString(5, plat.getOrganName());
            ps.setString(6, plat.getOrganAddr());
            ps.setString(7, plat.getPostNum());
            ps.setString(8, plat.getPrincipal());

            ps.setString(9, plat.getDepartment());
            ps.setString(10, plat.getJob());
            ps.setString(11, plat.getTelNum());
            ps.setString(12, plat.getPhoneNum());
            ps.setString(13, plat.getMail());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                plat.setPid(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PlatInfOne get() {
        PlatInfOne category = null;
        String sql = "select * from platinfone";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            //ps.setString(1, platname);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                category = new PlatInfOne(result.getString("platname"),
                        result.getString("protectclass"),
                        result.getString("number"),
                        result.getString("describe"),
                        result.getString("organname"),
                        result.getString("organaddr"),
                        result.getString("postnum"),
                        result.getString("principal"),
                        result.getString("department"),
                        result.getString("job"),
                        result.getString("telnum"),
                        result.getString("phonenum"),
                        result.getString("mail"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

}
