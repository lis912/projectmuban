package com.lishichang.dao;

import com.lishichang.entity.HostInfSix;
import com.lishichang.entity.Problem;
import com.lishichang.gui.util.DBUtil;
import com.lishichang.mubanentity.Document;
import com.lishichang.mubanentity.SafeManageCenter;
import com.lishichang.mubanentity.SummaryProblem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProblemDAO {
    public void add(Problem problem) {
        String sql = "insert into Problem (`Proid`,`proBigLay`,`proMinLay`,`proPoint`,`proItem`, `proItemDegree`,`proDescribe`,`proAnalyse`,`proaThret`,`proaThretDegree`,`proaThretAnalyse`,`proaRecommendations`, `proDev`, `proComment`) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, problem.getProid());
            ps.setString(2, problem.getProBigLay());
            ps.setString(3, problem.getProMinLay());
            ps.setString(4, problem.getProPoint());
            ps.setString(5, problem.getProItem());
            ps.setString(6, problem.getProItemDegree());
            ps.setString(7, problem.getProDescribe());
            ps.setString(8, problem.getProAnalyse());
            ps.setString(9, problem.getProaThret());
            ps.setString(10, problem.getProaThretDegree());
            ps.setString(11, problem.getProaThretAnalyse());
            ps.setString(12, problem.getProaRecommendations());
            ps.setString(13, problem.getProDev());
            ps.setString(14, problem.getProComment());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 输出 问题描述 和 关联设备
    public List<SummaryProblem> OutSafeSummaryProblem(String minlay) {
        String sql = "SELECT src.proDescribe, tmp.tmpAssociateDev, src.proComment " +
                "FROM Problem src INNER JOIN TmpProblem tmp ON src.proItem = tmp.tmpItem and src.proMinLay = tmp.tmpBigLay " +
                "where src.proDescribe != \"无\" and src.proMinLay == ?";
        List<SummaryProblem> summaryproblems = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, minlay);
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                SummaryProblem summaryproblem = new SummaryProblem(++i,
                        rs.getString("proDescribe"),
                        rs.getString("tmpAssociateDev"),
                        rs.getString("proComment"));
                summaryproblems.add(summaryproblem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return summaryproblems;
    }

    //  输出 问题描述 不输出关联设备
    public List<SafeManageCenter> OutSafeSummaryProblemNoAssoc(String minlay) {
        String sql = "SELECT src.proDescribe " +
                "FROM Problem src INNER JOIN TmpProblem tmp ON src.proItem = tmp.tmpItem and src.proMinLay = tmp.tmpBigLay " +
                "where src.proDescribe != \"无\" and src.proMinLay == ?";
        List<SafeManageCenter> safeManageCenters = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, minlay);
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                SafeManageCenter safe = new SafeManageCenter(rs.getString("proDescribe"));
                safeManageCenters.add(safe);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return safeManageCenters;
    }



    // SummaryProblem 输出 安全计算环境 问题描述
//    public List<SummaryProblem> OutSummaryProblem() {
//        String sql = "SELECT src.proDescribe, tmp.tmpAssociateDev, src.proComment " +
//                "FROM Problem src INNER JOIN TmpProblem tmp ON src.proItem = tmp.tmpItem and src.proMinLay = tmp.tmpBigLay " +
//                "where src.proDescribe != \"无\" and src.proMinLay == \"安全计算环境\"";
//        List<SummaryProblem> summaryproblems = new ArrayList<>();
//        try (Connection c = DBUtil.getConnection();
//             PreparedStatement ps = c.prepareStatement(sql)) {
//            ResultSet rs = ps.executeQuery();
//            int i =0;
//            while (rs.next()) {
//                SummaryProblem summaryproblem = new SummaryProblem(++i,
//                        rs.getString("proDescribe"),
//                        rs.getString("tmpAssociateDev"),
//                        rs.getString("proComment"));
//                summaryproblems.add(summaryproblem);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return summaryproblems;
//    }

    //  SafeManageCenter输出 安全管理中心 问题描述
//    public List<SafeManageCenter> OutSafeManageCenterSummaryProblem() {
//        String sql = "SELECT src.proDescribe " +
//                "FROM Problem src INNER JOIN TmpProblem tmp ON src.proItem = tmp.tmpItem and src.proMinLay = tmp.tmpBigLay " +
//                "where src.proDescribe != \"无\" and src.proMinLay == \"安全管理中心\"";
//        List<SafeManageCenter> safeManageCenters = new ArrayList<>();
//        try (Connection c = DBUtil.getConnection();
//             PreparedStatement ps = c.prepareStatement(sql)) {
//            ResultSet rs = ps.executeQuery();
//            int i =0;
//            while (rs.next()) {
//                SafeManageCenter safe = new SafeManageCenter(rs.getString("proDescribe"));
//                safeManageCenters.add(safe);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return safeManageCenters;
//    }

}
