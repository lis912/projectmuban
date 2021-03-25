package com.lishichang.dao;

import com.lishichang.entity.HostInfSix;
import com.lishichang.entity.PsychzInfTwo;
import com.lishichang.gui.util.DBUtil;
import com.lishichang.mubanentity.Host;
import com.lishichang.mubanentity.Psychz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PsychzInfTwoDAO {
    public void add(PsychzInfTwo Psychz) {
        String sql = "insert into psychzinftwo (`pplatname`,`PsychzName`,`PsychzAddr`,`PsychzDegree`, `PisSample`) values (?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, Psychz.getPpaltName());
            ps.setString(2, Psychz.getPsychzName());
            ps.setString(3, Psychz.getPsychzAddr());
            ps.setString(4, Psychz.getPsychzDegree());
            ps.setString(5, Psychz.getPisSample());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                Psychz.setPsychzId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Psychz> listAllPsychz() {
        String sql = "select PsychzName, PsychzAddr, PsychzDegree from psychzinftwo";
        List<Psychz> Psychzs = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                Psychz psychz = new Psychz(++i,
                        rs.getString("PsychzName"),
                        rs.getString("PsychzAddr"),
                        rs.getString("PsychzDegree"));
                Psychzs.add(psychz);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Psychzs;
    }

    public List<Psychz> listAllPsychzIssample() {
        String sql = "select PsychzName, PsychzAddr, PsychzDegree from psychzinftwo where PisSample=\"是\"";
        List<Psychz> Psychzs = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                Psychz psychz = new Psychz(++i,
                        rs.getString("PsychzName"),
                        rs.getString("PsychzAddr"),
                        rs.getString("PsychzDegree"));
                Psychzs.add(psychz);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Psychzs;
    }

}
