package com.lishichang.dao;

import com.lishichang.gui.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *  CleanTableDAO  ： 每次 点击导入调研表 执行清除数据操作，并重置ID。数据库中不固化系统设备数据
 *
 */
public class CleanTableDAO {
    /**
     *  delete() ： 清除表1 - 表14 的数据库表
     */
    public int delete() {
        List<String> sqlist = new ArrayList<>();
        sqlist.add("DELETE FROM platinfone");
        sqlist.add("update sqlite_sequence set seq=0 where name='platinfone'");

        sqlist.add("DELETE FROM psychzinftwo");
        sqlist.add("update sqlite_sequence set seq=0 where name='psychzinftwo'");

        sqlist.add("DELETE FROM netinfthree");
        sqlist.add("update sqlite_sequence set seq=0 where name='netinfthree'");

        sqlist.add("DELETE FROM securitydevfour");
        sqlist.add("update sqlite_sequence set seq=0 where name='securitydevfour'");

        sqlist.add("DELETE FROM hostinfsix");
        sqlist.add("update sqlite_sequence set seq=0 where name='hostinfsix'");

        sqlist.add("DELETE FROM terminalseven");
        sqlist.add("update sqlite_sequence set seq=0 where name='terminalseven'");

        sqlist.add("DELETE FROM appinfnine");
        sqlist.add("update sqlite_sequence set seq=0 where name='appinfnine'");

        sqlist.add("DELETE FROM jobeleven");
        sqlist.add("update sqlite_sequence set seq=0 where name='jobeleven'");

        sqlist.add("DELETE FROM documenttwelve");
        sqlist.add("update sqlite_sequence set seq=0 where name='documenttwelve'");

        sqlist.add("DELETE FROM topologythirteen");
        sqlist.add("update sqlite_sequence set seq=0 where name='topologythirteen'");

        sqlist.add("DELETE FROM cloudinfofourteen");
        sqlist.add("update sqlite_sequence set seq=0 where name='cloudinfofourteen'");

        return delTable(sqlist);

    }
    /**
     *  deleteProblem() ： 清除主机问题汇总源数据
     */
    public int deleteProblem() {
        List<String> sqlist = new ArrayList<>();
        sqlist.add("DELETE FROM Problem");
        sqlist.add("update sqlite_sequence set seq=0 where name='Problem'");
        return delTable(sqlist);
    }

    /**
     *  deleteProblem() ： 清除网络问题汇总源数据
     */
//    public int deleteProblemForNet() {
//        List<String> sqlist = new ArrayList<>();
//        sqlist.add("DELETE FROM ProblemforNet");
//        sqlist.add("update sqlite_sequence set seq=0 where name='ProblemforNet'");
//        return delTable(sqlist);
//    }



    /**
     *  deleteTmpProblem() ： 清理测评能手导入问题数据
     */
    public int deleteTmpProblem() {
        List<String> sqlist = new ArrayList<>();
        sqlist.add("DELETE FROM TmpProblem");
        sqlist.add("update sqlite_sequence set seq=0 where name='TmpProblem'");
        return delTable(sqlist);
    }
    /**
     *  delTable() ： 执行SQL语句
     *  @param  List<String> sqlist  : sql语句列表
     *
     */
    private int delTable(List<String> sqlist){
        int result = 0;
        for (String sqlvaule: sqlist){
            String sql = sqlvaule;
            try (Connection c = DBUtil.getConnection();
                 PreparedStatement ps = c.prepareStatement(sqlvaule)) {
                result = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
