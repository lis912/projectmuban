package com.lishichang.dao;

import com.lishichang.entity.HostInfSix;
import com.lishichang.gui.util.DBUtil;
import com.lishichang.mubanentity.Host;
import com.lishichang.mubanentity.ListHost;
import com.lishichang.mubanentity.ScanHost;
import com.lishichang.mubanentity.ScanHostIP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *  HostInfSixDAO  ： 表6 主机信息 DAO 操作类
 */
public class HostInfSixDAO {
    public void add(HostInfSix host) {
        String sql = "insert into hostinfsix (`fplatname`,`hostname`,`appsystemname`,`isvmhost`, `area`,`osname`,`dataosname`,`bitname`,`amount`,`ipsddr`,`hostdegree`, `issample`) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, host.getFplatName());
            ps.setString(2, host.getHostName());
            ps.setString(3, host.getAppSystemName());
            ps.setString(4, host.getIsVMhost());
            ps.setString(5, host.getArea());
            ps.setString(6, host.geOsName());
            ps.setString(7, host.getDataOSname());
            ps.setString(8, host.getBitName());
            ps.setString(9, host.getAmount());
            ps.setString(10, host.getIpAddr());
            ps.setString(11, host.getHostDegree());
            ps.setString(12, host.getIsSample());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                host.setHostid(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *  listallhost  ： 获取填充方案所有资产主机
     */
    public List<Host> listallhost() {
        String sql = "select platname, hostname,appsystemname,isvmhost,area,osname,dataosname,bitname,amount,ipsddr,hostdegree from hostinfsix,platinfone";
        List<Host> hostinfsixs = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                Host host = new Host(++i,
                        rs.getString("platname"),
                        rs.getString("hostname"),
                        rs.getString("appsystemname"),
                        rs.getString("isvmhost"),
                        rs.getString("area"),
                        rs.getString("osname"),
                        rs.getString("dataosname"),
                        rs.getString("bitname"),
                        rs.getString("amount"),
                        rs.getString("ipsddr"),
                        rs.getString("hostdegree"));
                hostinfsixs.add(host);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hostinfsixs;
    }

    /**
     *  ScanlistallhostFromIssample  ： 获取填充方案所有漏扫主机
     */
    public List<ScanHost> ScanlistallhostFromIssample() {
        String sql = "select hostname,osname from hostinfsix where issample=\"是\"";
        List<ScanHost> scanhosts = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                ScanHost scanhost = new ScanHost(++i,
                        rs.getString("hostname"),
                        rs.getString("osname"));
                scanhosts.add(scanhost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scanhosts;
    }

    /**
     *  ScanlistallhostFromIssample  ： 获取工具指导书中的主机漏扫清单 多个IP地址
     */
    public List<ScanHostIP> ScanHostIpFromIssample() {
        String sql = "select hostname,osname, ipsddr from hostinfsix where issample=\"是\"";
        List<ScanHostIP> scanHostips = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                ScanHostIP scanhostip = new ScanHostIP(++i,
                        rs.getString("hostname"),
                        rs.getString("osname"),
                        rs.getString("ipsddr"));
                scanHostips.add(scanhostip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scanHostips;
    }

    /**
     *  ScanlistallhostFromIssample  ： 测评退场签名设备清单 包含 hostinfsix netinfthree 两个表，采用内连接查询
     */
    public List<String> SignOffFromIssample() {
        String sql = "select hostname, ipsddr from hostinfsix where issample=\"是\" " +
                "union select NdeviceName, NipAddr from netinfthree where NisSample=\"是\" " +
                "union select sdeviceName, sipAddr from securitydevfour where sisSample=\"是\"";
        List<String> scanHostips = new ArrayList<String>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                scanHostips.add(rs.getString("hostname")+"    "+rs.getString("ipsddr"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scanHostips;
    }

    /**
     *  listallhostFromIssample  ：  获取填充方案所有被测主机
     */
    public List<Host> listallhostFromIssample() {
        String sql = "select platname, hostname,appsystemname,isvmhost,area,osname,dataosname,bitname,amount,ipsddr,hostdegree from hostinfsix,platinfone where issample=\"是\"";
        List<Host> hostinfsixs = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                Host host = new Host(++i,
                        rs.getString("platname"),
                        rs.getString("hostname"),
                        rs.getString("appsystemname"),
                        rs.getString("isvmhost"),
                        rs.getString("area"),
                        rs.getString("osname"),
                        rs.getString("dataosname"),
                        rs.getString("bitname"),
                        rs.getString("amount"),
                        rs.getString("ipsddr"),
                        rs.getString("hostdegree"));
                hostinfsixs.add(host);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hostinfsixs;
    }
}





