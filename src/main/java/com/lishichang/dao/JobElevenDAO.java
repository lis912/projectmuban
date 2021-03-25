package com.lishichang.dao;

import com.lishichang.entity.AppInfNine;
import com.lishichang.entity.JobEleven;
import com.lishichang.gui.util.DBUtil;
import com.lishichang.mubanentity.App;
import com.lishichang.mubanentity.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobElevenDAO {
    public void add(JobEleven job) {
        String sql = "insert into jobeleven (`jpaltName`,`jName`,`jobName`,`jphone`) values (?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, job.getJpaltName());
            ps.setString(2, job.getjName());
            ps.setString(3, job.getJobName());
            ps.setString(4, job.getJphone());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                job.setjId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Job> listjobPerson() {
        String sql = "select jName, jobName, jphone from jobeleven";
        List<Job> jobs = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int i =0;
            while (rs.next()) {
                Job job = new Job(++i,
                        rs.getString("jName"),
                        rs.getString("jobName"),
                        rs.getString("jphone"));
                jobs.add(job);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }
}
