package com.lishichang.dao;

import com.lishichang.entity.PlatInfOne;
import com.lishichang.entity.TopologyThirteen;
import com.lishichang.gui.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class TopologyThirteenDAO {
    public void add(TopologyThirteen topology) {
        String sql = "insert into topologythirteen (`tpaltName`,`tPathName`,`tNetworkDescription`) values (?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, topology.getTpaltName());
            ps.setString(2, topology.gettPathName());
            ps.setString(3, topology.gettNetworkDescription());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                topology.setTpid(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TopologyThirteen get() {
        TopologyThirteen topology = null;
        String sql = "select * from topologythirteen";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                topology = new TopologyThirteen(result.getString("tpaltName"),
                        result.getString("tPathName"),
                        result.getString("tNetworkDescription"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topology;
    }}
