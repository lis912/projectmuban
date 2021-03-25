package com.lishichang.dao;

import com.lishichang.entity.DocumentTwelve;
import com.lishichang.entity.TmpProblem;
import com.lishichang.gui.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TmpProblemDAO {
    public void add(TmpProblem tmproblem) {
        String sql = "insert into TmpProblem (`tmpid`,`tmpAssociateDev`,`tmpBigLay`,`tmpItem`) values (?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, tmproblem.getTmpid());
            ps.setString(2, tmproblem.getTmpAssociateDev());
            ps.setString(3, tmproblem.getTmpBigLay());
            ps.setString(4, tmproblem.getTmpItem());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
