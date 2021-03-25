package com.lishichang.dao;

import com.lishichang.entity.AppInfNine;
import com.lishichang.entity.SecurityDevFour;
import com.lishichang.gui.util.DBUtil;
import com.lishichang.mubanentity.App;
import com.lishichang.mubanentity.PenetraApp;
import com.lishichang.mubanentity.ScanApp;
import com.lishichang.mubanentity.SecurityDevice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *  AppInfNineDAO  ： 表9 应用程序信息 DAO 操作类
 *
 */
public class AppInfNineDAO {
    public void add(AppInfNine appinf) {
        String sql = "insert into appinfnine (`aplatName`,`appName`,`aFunction`,`aVersion`, `aDevelopName`,`architecture`,`aurl`,`aDegree`,`aisSample`) values (?,?,?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, appinf.getAplatName());
            ps.setString(2, appinf.getAppName());
            ps.setString(3, appinf.getaFunction());
            ps.setString(4, appinf.getaVersion());
            ps.setString(5, appinf.getaDevelopName());
            ps.setString(6, appinf.getArchitecture());
            ps.setString(7, appinf.getAurl());
            ps.setString(8, appinf.getaDegree());
            ps.setString(9, appinf.getAisSample());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                appinf.setAid(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *  List<App> listallApp()  ： 返回数据库 appinfnine 所有应用程序信息
     */
    public List<App> listallApp() {
        String sql = "select aplatName,appName,aFunction,aVersion,aDevelopName,aDegree from appinfnine";
        List<App> apps = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                App app = new App(++i,
                        rs.getString("aplatName"),
                        rs.getString("appName"),
                        rs.getString("aFunction"),
                        rs.getString("aVersion"),
                        rs.getString("aDevelopName"),
                        rs.getString("aDegree"));
                apps.add(app);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apps;
    }

    /**
     *  List<ScanApp> ScanAppUrlFromIssample()
     *  WEB工具测试指导书输出应用和地址
     */
    public List<ScanApp> ScanAppUrlFromIssample() {
        String sql = "select appName, aurl from appinfnine where aisSample=\"是\"";
        List<ScanApp> penetraapps = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                ScanApp app = new ScanApp(++i,
                        rs.getString("appName"),
                        rs.getString("aurl"));
                penetraapps.add(app);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return penetraapps;

    }

    /**
     *  List<ScanApp> ScanAppUrlFromIssample()
     *  测评方案中WEB渗透测试对象表
     */
    public List<PenetraApp> PenetralistAllAppFromIssample() {
        String sql = "select appName,architecture from appinfnine where aisSample=\"是\"";
        List<PenetraApp> penetraapps = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                PenetraApp app = new PenetraApp(++i,
                        rs.getString("appName"),
                        rs.getString("architecture"));
                penetraapps.add(app);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return penetraapps;

    }

    /**
     * List<App> listAllAppFromIssample()
     *  测评方案中所有抽测应用
     */
    public List<App> listAllAppFromIssample() {
        String sql = "select aplatName,appName,aFunction,aVersion,aDevelopName,aDegree from appinfnine where aisSample=\"是\"";
        List<App> apps = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                App app = new App(++i,
                        rs.getString("aplatName"),
                        rs.getString("appName"),
                        rs.getString("aFunction"),
                        rs.getString("aVersion"),
                        rs.getString("aDevelopName"),
                        rs.getString("aDegree"));
                apps.add(app);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apps;

    }
}
