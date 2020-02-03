package com.kh.searchfree.admin.model.dao;

import static com.kh.searchfree.common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.searchfree.admin.model.vo.Project;
import com.kh.searchfree.admin.model.vo.ReportAll;

public class ReportDao {
	private Properties prop = null;
	
	public ReportDao() throws Exception{
		String fileName = NoticeDao.class.getResource("/com/kh/searchfree/sql/report/adminReport-query.properties")
				.getPath();
		prop = new Properties();
		prop.load(new FileReader(fileName));
	}
	
	public List<ReportAll> selectReportList(Connection conn)throws Exception{
		
		Statement stmt = null;
				ResultSet rset = null;
				
				List<ReportAll> list = null;
				
				String query = prop.getProperty("selectReportList");
				
				try {
					stmt = conn.createStatement();
					rset = stmt.executeQuery(query);
					
					list = new ArrayList<ReportAll>();
					
					ReportAll report = null;
					
					while(rset.next()) {
						
						report = new ReportAll();
						report.setReportListNo(rset.getInt("REPLY_NO"));
						report.setReportCode(rset.getInt("REPORT_CODE"));
						report.setMemberId(rset.getString("MEMBER_ID"));
						report.setReportCreateDT(rset.getDate("REPORT_CREATE_DT"));
						report.setReportStatus((rset.getString("REPLY_DELETE_YN")).charAt(0));		
						report.setReportTitle(rset.getString("REPORT_TITLE"));
						list.add(report);
						System.out.println("신고전체 리스트 :  "+report);
					}
				}finally {
					close(rset);
					close(stmt);
				}
				return list;
			}


}
