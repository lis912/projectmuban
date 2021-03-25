package com.lishichang.dao;

import com.lishichang.entity.SecurityDevFour;
import com.lishichang.entity.TerminalSeven;
import com.lishichang.gui.util.DBUtil;
import com.lishichang.mubanentity.SecurityDevice;
import com.lishichang.mubanentity.Terminal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TerminalSevenDAO {
    public void add(TerminalSeven terminal) {
        String sql = "insert into terminalseven (`tplatName`,`tdeviceName`,`tisVMhost`,`tosName`, `tmodel`,`tdescribe`,`tamount`,`tipAddr`,`tDegree`,`tisSample`) values (?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, terminal.getTplatName());
            ps.setString(2, terminal.getTdeviceName());
            ps.setString(3, terminal.getTisVMhost());
            ps.setString(4, terminal.getTosName());
            ps.setString(5, terminal.getTmodel());
            ps.setString(6, terminal.getTdescribe());
            ps.setString(7, terminal.getTamount());
            ps.setString(8, terminal.getTipAddr());
            ps.setString(9, terminal.gettDegree());
            ps.setString(10, terminal.getTisSample());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Terminal> listallTerminalDev() {
        String sql = "select tplatName,tdeviceName,tisVMhost,tosName,tmodel,tdescribe,tamount,tipAddr,tDegree from terminalseven";
        List<Terminal> terminals = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                Terminal terminal = new Terminal(++i,
                        rs.getString("tplatName"),
                        rs.getString("tdeviceName"),
                        rs.getString("tisVMhost"),
                        rs.getString("tosName"),
                        rs.getString("tmodel"),
                        rs.getString("tdescribe"),
                        rs.getString("tamount"),
                        rs.getString("tipAddr"),
                        rs.getString("tDegree"));
                terminals.add(terminal);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return terminals;
    }


    //
    public List<Terminal> listAllSecDevFromIssample() {
        String sql = "select tplatName,tdeviceName,tisVMhost,tosName,tmodel,tdescribe,tamount,tipAddr,tDegree from terminalseven where tisSample=\"是\"";
        List<Terminal> terminals = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                Terminal terminal = new Terminal(++i,
                        rs.getString("tplatName"),
                        rs.getString("tdeviceName"),
                        rs.getString("tisVMhost"),
                        rs.getString("tosName"),
                        rs.getString("tmodel"),
                        rs.getString("tdescribe"),
                        rs.getString("tamount"),
                        rs.getString("tipAddr"),
                        rs.getString("tDegree"));
                terminals.add(terminal);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return terminals;
    }
}
