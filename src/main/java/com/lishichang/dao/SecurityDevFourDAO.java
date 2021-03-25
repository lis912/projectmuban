package com.lishichang.dao;

import com.lishichang.entity.NetDeviceThree;
import com.lishichang.entity.SecurityDevFour;
import com.lishichang.gui.util.DBUtil;
import com.lishichang.mubanentity.NetDevice;
import com.lishichang.mubanentity.SecurityDevice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SecurityDevFourDAO {
    public void add(SecurityDevFour secDev) {
        String sql = "insert into securitydevfour (`splatName`,`sdeviceName`,`sisVMhost`,`sosName`, `smodel`,`sdescribe`,`sipAddr`,`samount`,`sDegree`,`sisSample`) values (?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, secDev.getSplatName());
            ps.setString(2, secDev.getSdeviceName());
            ps.setString(3, secDev.getSisVMhost());
            ps.setString(4, secDev.getSosName());
            ps.setString(5, secDev.getSmodel());
            ps.setString(6, secDev.getSdescribe());
            ps.setString(7, secDev.getSipAddr());
            ps.setString(8, secDev.getSamount());
            ps.setString(9, secDev.getsDegree());
            ps.setString(10, secDev.getSisSample());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                int id = rs.getInt(1);
//                netDev.setNid(id);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SecurityDevice> listallSecDev() {
        String sql = "select splatName,sdeviceName,sisVMhost,sosName,smodel,sdescribe,sipAddr,samount,sDegree from securitydevfour";
        List<SecurityDevice> secdevices = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                SecurityDevice secdev = new SecurityDevice(++i,
                        rs.getString("splatName"),
                        rs.getString("sdeviceName"),
                        rs.getString("sisVMhost"),
                        rs.getString("sosName"),
                        rs.getString("smodel"),
                        rs.getString("sdescribe"),
                        rs.getString("sipAddr"),
                        rs.getString("samount"),
                        rs.getString("sDegree"));
                secdevices.add(secdev);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return secdevices;
    }


    //
    public List<SecurityDevice> listAllSecDevFromIssample() {
        String sql = "select splatName,sdeviceName,sisVMhost,sosName,smodel,sdescribe,sipAddr,samount,sDegree from securitydevfour where sisSample=\"是\"";
        List<SecurityDevice> secdevices = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                SecurityDevice secdev = new SecurityDevice(++i,
                        rs.getString("splatName"),
                        rs.getString("sdeviceName"),
                        rs.getString("sisVMhost"),
                        rs.getString("sosName"),
                        rs.getString("smodel"),
                        rs.getString("sdescribe"),
                        rs.getString("sipAddr"),
                        rs.getString("samount"),
                        rs.getString("sDegree"));
                secdevices.add(secdev);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return secdevices;
    }
}
