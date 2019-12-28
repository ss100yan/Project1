package com.revature.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursements;
import com.revature.util.ConnectionUtil;

public class ReimbursementsDaoImpl implements ReimbursementsDao {

	@Override
	public int createReimbursement(Reimbursements reimbursement) {
		int reimbursementsCreated = 0;
		// TODO: Create SQL trigger for increment erb_id
		String sql = "INSERT INTO REIMBURSEMENTS (Reimbursement_ID, Reimbursement_AMOUNT, Reimbursement_STATUS, MANAGER_ID, Employe_ID, PHOTO) VALUES (?,?,?,?,?,?)";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, reimbursement.getReimbursementId());
			ps.setFloat(2, reimbursement.getReimbursementAmount());
			ps.setString(3, "PENDING");
			ps.setInt(4, reimbursement.getManagerId());
			ps.setInt(5, reimbursement.getEmployeeId());
			ps.setBinaryStream(6, reimbursement.getFis(), reimbursement.getLength());
//			
			reimbursementsCreated = ps.executeUpdate();

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		if (reimbursementsCreated > 0) {
			System.out.println("Congratulations, your request has been successfully submitted!");
		}

		return reimbursementsCreated;
	}

	@Override
	public int approveReimbursementByErbId(int id) {
		int approvedReimbursements = 0;
		String sql = "UPDATE REIMBURSEMENTS SET Reimbursement_STATUS = 'APPROVED' WHERE Reimbursement_ID = ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			approvedReimbursements = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return approvedReimbursements;
	}

	@Override
	// deny reimbursement by id
	public int denyReimbursementByErbId(int id) {
		int deniedReimbursements = 0;
		String sql = "UPDATE REIMBURSEMENTS SET Reimbursement_STATUS = 'DENIED' WHERE Reimbursement_ID = ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			deniedReimbursements = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deniedReimbursements;
	}

	@Override
	public Reimbursements getReimbursementById(int id) {
		Reimbursements r = new Reimbursements();
		ResultSet rs = null;
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE Reimbursement_ID = ?";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				r.setReimbursementId(rs.getInt("Reimbursement_ID"));
				r.setReimbursementAmount(rs.getFloat("Reimbursement_AMOUNT"));
				r.setReimbursementStatus(rs.getString("Reimbursement_STATUS"));
				r.setManagerId(rs.getInt("MANAGER_ID"));
				r.setEmployeeId(rs.getInt("Employe_ID"));
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return r;
	}

	@Override
	public List<Reimbursements> getAllPendingReimbursementsByEmployeeId(int id) {

		List<Reimbursements> r = new ArrayList<Reimbursements>();
		ResultSet rs = null;
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE Reimbursement_STATUS = 'PENDING' AND Employe_ID = ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, id);
			rs = ps.executeQuery(sql);

			while (rs.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setReimbursementId(rs.getInt("Reimbursement_ID"));
				reimbursement.setReimbursementAmount(rs.getFloat("Reimbursement_AMOUNT"));
				reimbursement.setReimbursementStatus(rs.getString("Reimbursement_STATUS"));
				reimbursement.setManagerId(rs.getInt("MANAGER_ID"));
				reimbursement.setEmployeeId(rs.getInt("Employe_ID"));
				r.add(reimbursement);
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return r;
	}

	@Override
	public List<Reimbursements> getAllResolvedReimbursementsEmployeeId(int id) {
		List<Reimbursements> r = new ArrayList<Reimbursements>();
		ResultSet rs = null;
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE Reimbursement_STATUS = 'APPROVED' OR Reimbursement_STATUS = 'DENIED' AND Employe_ID = ?";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, id);
			rs = ps.executeQuery(sql);

			while (rs.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setReimbursementId(rs.getInt("Reimbursement_ID"));
				reimbursement.setReimbursementAmount(rs.getFloat("Reimbursement_AMOUNT"));
				reimbursement.setReimbursementStatus(rs.getString("Reimbursement_STATUS"));
				reimbursement.setManagerId(rs.getInt("MANAGER_ID"));
				reimbursement.setEmployeeId(rs.getInt("Employe_ID"));
				r.add(reimbursement);
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return r;
	}

	@Override
	public List<Reimbursements> getReimbursementsByEmployeeId(int id) {
		List<Reimbursements> r = new ArrayList<Reimbursements>();

		ResultSet rs = null;
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE Employe_ID = ?";

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setReimbursementId(rs.getInt("Reimbursement_ID"));
				reimbursement.setReimbursementAmount(rs.getFloat("Reimbursement_AMOUNT"));
				reimbursement.setReimbursementStatus(rs.getString("Reimbursement_STATUS"));
				reimbursement.setManagerId(rs.getInt("MANAGER_ID"));
				reimbursement.setEmployeeId(rs.getInt("Employe_ID"));
				r.add(reimbursement);
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return r;
	}

	@Override
	public List<Reimbursements> getAllPendingReimbursements() {
		List<Reimbursements> r = new ArrayList<Reimbursements>();

		ResultSet rs = null;
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE Reimbursement_STATUS = 'PENDING'";

		try (Connection con = ConnectionUtil.getConnection(); Statement s = con.createStatement();) {
			rs = s.executeQuery(sql);

			while (rs.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setReimbursementId(rs.getInt("Reimbursement_ID"));
				reimbursement.setReimbursementAmount(rs.getFloat("Reimbursement_AMOUNT"));
				reimbursement.setReimbursementStatus(rs.getString("Reimbursement_STATUS"));
				reimbursement.setManagerId(rs.getInt("MANAGER_ID"));
				reimbursement.setEmployeeId(rs.getInt("Employe_ID"));
				r.add(reimbursement);

			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return r;
	}

	@Override
	public List<Reimbursements> getAllResolvedReimbursements() {
		List<Reimbursements> r = new ArrayList<Reimbursements>();

		ResultSet rs = null;
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE Reimbursement_STATUS = 'APPROVED' OR Reimbursement_STATUS = 'DENIED'";
		try (Connection con = ConnectionUtil.getConnection(); Statement s = con.createStatement();) {
			rs = s.executeQuery(sql);

			while (rs.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setReimbursementId(rs.getInt("Reimbursement_ID"));
				reimbursement.setReimbursementAmount(rs.getFloat("Reimbursement_AMOUNT"));
				reimbursement.setReimbursementStatus(rs.getString("Reimbursement_STATUS"));
				reimbursement.setManagerId(rs.getInt("MANAGER_ID"));
				reimbursement.setEmployeeId(rs.getInt("Employe_ID"));
				r.add(reimbursement);

			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return r;
	}

	@Override
	public List<Reimbursements> getAllReimbursements() {
		List<Reimbursements> reimbursementsList = new ArrayList<Reimbursements>();

		String sql = "SELECT * FROM REIMBURSEMENTS";

		ResultSet rs = null;

		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();) {

			rs = s.executeQuery(sql);

			while (rs.next()) {
				Reimbursements r = new Reimbursements();

				int reimbursementId = rs.getInt("Reimbursement_ID");
				r.setReimbursementId(reimbursementId);

				float reimbursementAmount = rs.getFloat("Reimbursement_AMOUNT");
				r.setReimbursementAmount(reimbursementAmount);

				String reimbursementStatus = rs.getString("Reimbursement_STATUS");
				r.setReimbursementStatus(reimbursementStatus);

				int reimbursementManagerId = rs.getInt("MANAGER_ID");
				r.setManagerId(reimbursementManagerId);

				int reimbursementEmployeeId = rs.getInt("Employe_ID");
				r.setEmployeeId(reimbursementEmployeeId);
				
				byte[] reimbursementPhoto = rs.getBytes("PHOTO");
				r.setPhoto(reimbursementPhoto);

				reimbursementsList.add(r);

			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return reimbursementsList;
	}

	@Override
	public List<Reimbursements> getAllDeniedReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	@Override
	public List<Reimbursements> getReimbursementsByEmployeeUsername(String username) {
		List<Reimbursements> r = new ArrayList<Reimbursements>();

		ResultSet rs = null;
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE EMP_USERNAME = ?";

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, username);
			rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setReimbursementId(rs.getInt("Reimbursement_ID"));
				reimbursement.setReimbursementAmount(rs.getFloat("Reimbursement_AMOUNT"));
				reimbursement.setReimbursementStatus(rs.getString("Reimbursement_STATUS"));
				reimbursement.setManagerId(rs.getInt("MANAGER_ID"));
				reimbursement.setEmployeeId(rs.getInt("Employe_ID"));
				r.add(reimbursement);
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return r;
	}
	
	@Override
	public byte[] getReceipts(int ID) {
		byte[] receipt = null;
		ResultSet rs = null;
		String sql = "SELECT PHOTO FROM REIMBURSEMENTS WHERE Reimbursement_ID = ?";

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, ID);
			rs = ps.executeQuery();

			while (rs.next()) {
				receipt = rs.getBytes(1);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return receipt;
	}







}
