package com.lishichang.dao;

import com.lishichang.entity.HostInfSix;
import com.lishichang.entity.NetDeviceThree;
import com.lishichang.gui.util.DBUtil;
import com.lishichang.mubanentity.Host;
import com.lishichang.mubanentity.ListNetDevice;
import com.lishichang.mubanentity.NetDevice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NetDeviceThreeDAO {
    public void add(NetDeviceThree netDev) {
        String sql = "insert into netinfthree (`NplatName`,`NdeviceName`,`NisVMhost`,`NosName`, `Nmodel`,`Ndescribe`,`NipAddr`,`Namount`,`NDegree`,`NisSample`) values (?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, netDev.getNplatName());
            ps.setString(2, netDev.getNdeviceName());
            ps.setString(3, netDev.getNisVMhost());
            ps.setString(4, netDev.getNosName());
            ps.setString(5, netDev.getNmodel());
            ps.setString(6, netDev.getNdescribe());
            ps.setString(7, netDev.getNipAddr());
            ps.setString(8, netDev.getNamount());
            ps.setString(9, netDev.getNDegree());
            ps.setString(10, netDev.getNisSample());


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



    public List<NetDevice> listallnetDev() {
        String sql = "select NplatName,NdeviceName,NisVMhost,NosName,Nmodel,Ndescribe,NipAddr,Namount,NDegree from netinfthree";
        List<NetDevice> netdevices = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                NetDevice netdev = new NetDevice(++i,
                        rs.getString("NplatName"),
                        rs.getString("NdeviceName"),
                        rs.getString("NisVMhost"),
                        rs.getString("NosName"),
                        rs.getString("Nmodel"),
                        rs.getString("Ndescribe"),
                        rs.getString("NipAddr"),
                        rs.getString("Namount"),
                        rs.getString("NDegree"));
                netdevices.add(netdev);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return netdevices;
    }


    //
    public List<NetDevice> listAllNetDevFromIssample() {
        String sql = "select NplatName, NdeviceName, NisVMhost, NosName,Nmodel,Ndescribe,NipAddr,Namount,NDegree from netinfthree where NisSample=\"是\"";
        List<NetDevice> netdevices = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                NetDevice netdev = new NetDevice(++i,
                        rs.getString("NplatName"),
                        rs.getString("NdeviceName"),
                        rs.getString("NisVMhost"),
                        rs.getString("NosName"),
                        rs.getString("Nmodel"),
                        rs.getString("Ndescribe"),
                        rs.getString("NipAddr"),
                        rs.getString("Namount"),
                        rs.getString("NDegree"));
                netdevices.add(netdev);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return netdevices;
    }


}
