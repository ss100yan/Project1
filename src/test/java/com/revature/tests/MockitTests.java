  
package com.revature.tests;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.revature.service.*;

import static org.junit.Assert.assertEquals;

import com.revature.dao.ReimbursementsDaoImpl;
import com.revature.models.Reimbursements;
import com.revature.util.ConnectionUtil;



//import junit.framework.Assert;

public class MockitTests {
	
	@Test
	public void canCreateReimbursement() {
		try (Connection con = ConnectionUtil.getConnection()) {
			Reimbursements r = new Reimbursements();
			r.setReimbursementId(1);
			r.setReimbursementAmount(300);
			r.setReimbursementStatus("DENIED");
			r.setManagerId(2);
			r.setEmployeeId(4);
			
			ReimbursementsDaoImpl rdi = new ReimbursementsDaoImpl();
			assertEquals(1, rdi.createReimbursement(r));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
	@Mock
	public ReimbursementsDaoImpl repositoryImpl;
	

	@InjectMocks
	public static service service;
	
	@BeforeClass
	public static void setUp() {
		service = new service();
	}
	
	@Before
	public void beforeEach() {
	
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllBankAccounts() {
		
	
		
		Mockito.when(repositoryImpl.getAllReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
		
		Assert.assertNotNull(MockitTests.service.getAllReimbursements());
	}
	
//	Assert.assertEquals(BankServiceTests.service.getAllAccounts().get(0).getName(), "Name");
//	Assert.assertSame(BankServiceTests.service.getAllAccounts().get(0).getName(), "Name");
	
	
	@Test
	public void testGetAllBankAccounts2() {
		
	
		
		Mockito.when(repositoryImpl.getAllReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
		
//         Assert.assertEquals(MockitTests.service.getAllReimbursements().get(0).getManagerId(), 4);
         Assert.assertNotNull(MockitTests.service.getAllReimbursements());
	}
	
	
//	@Test
//	public void testgetAllResolvedReimbursements() {
//		
//	
//		
//		Mockito.when(repositoryImpl.getAllResolvedReimbursements()).thenReturn(
//				Arrays.asList(
//						new Reimbursements(4, 4, "test",4, 4),
//						new Reimbursements(4, 4, "test",4, 4),
//						new Reimbursements(4, 4, "test",4, 4)
//						)
//				);
////		 Assert.assertNotNull(MockitTests.service.getAllReimbursements());
//         Assert.assertEquals(4,MockitTests.service.getAllResolvedReimbursements().get(0).getEmployeeId());
//
//	}	

	
	
	@Test
	public void testgetReimbursementsByEmployeeUsername() {
		
	
		
		Mockito.when(repositoryImpl.getReimbursementsByEmployeeUsername(null)).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
		 Assert.assertNotNull(MockitTests.service.getReimbursementsByEmployeeUsername(null));
//         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 4);

	}
	
	
	@Test
	public void testgetAllResolvedReimbursements1() {
		
	
		
		Mockito.when(repositoryImpl.getAllResolvedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
		 Assert.assertNotNull(MockitTests.service.getReimbursementsByEmployeeUsername(null));
//         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 4);

	}
	
	
	@Test
	public void testgetAllResolvedReimbursements21() {
		
	
		
		Mockito.when(repositoryImpl.getAllResolvedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
		 Assert.assertNotNull(MockitTests.service.getReimbursementsByEmployeeUsername(null));
//         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 4);

	}
	
	@Test
	public void testgetAllPendingReimbursements() {
		
	
		
		Mockito.when(repositoryImpl.getAllPendingReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
		 Assert.assertNotNull(MockitTests.service.getAllPendingReimbursements());
//         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 4);

	}
	
	@Test
	public void testgetAllPendingReimbursements2() {
		
	
		
		Mockito.when(repositoryImpl.getAllPendingReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
		 Assert.assertNotNull(MockitTests.service.getAllPendingReimbursements());
//         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 4);

	}
	
	
	@Test
	public void testgetReimbursementsByEmployeeId() {
		
	
		
		Mockito.when(repositoryImpl.getReimbursementsByEmployeeId(0)).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
		 Assert.assertNotNull(MockitTests.service.getReimbursementsByEmployeeId(0));
//         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 4);

	}
	
	@Test
	public void testgetAllResolvedReimbursementsEmployeeId() {
		
	
		
		Mockito.when(repositoryImpl.getAllResolvedReimbursementsEmployeeId(0)).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
		 Assert.assertNotNull(MockitTests.service.getAllResolvedReimbursementsEmployeeId(0));
//         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 4);

	}
	
	@Test
	public void getAllPendingReimbursementsByEmployeeId() {
		
	
		
		Mockito.when(repositoryImpl.getAllPendingReimbursementsByEmployeeId(0)).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
		 Assert.assertNotNull(MockitTests.service.getAllPendingReimbursementsByEmployeeId(0));
//         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 4);

	}
	
	
	
	@Test
	public void getAllDeniedReimbursements() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
//         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 4);

	}
	

	@Test
	public void getAllDeniedReimbursements2() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
//		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 4);

	}

	@Test
	public void getAllDeniedReimbursements3() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
//		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getManagerId(), 4);

	}
	@Test
	public void getAllDeniedReimbursements4() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
//		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getEmployeeId(), 4);

	}
	@Test
	public void getAllDeniedReimbursements5() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4),
						new Reimbursements(4, 4, "test",4, 4)
						)
				);
//		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 4);

	}
	

	@Test
	public void getAllDeniedReimbursements6() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(5, 5, "Photo",5, 5),
						new Reimbursements(5, 5, "Photo",5, 5),
						new Reimbursements(5, 5, "Photo",5, 5)
						)
				);
//		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 5);

	}
	@Test
	public void getAllDeniedReimbursements7() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(5, 5, "Photo",5, 5),
						new Reimbursements(5, 5, "Photo",5, 5),
						new Reimbursements(5, 5, "Photo",5, 5)
						)
				);
//		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getEmployeeId(), 5);

	}
	@Test
	public void getAllDeniedReimbursements8() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(5, 5, "Photo",5, 5),
						new Reimbursements(5, 5, "Photo",5, 5),
						new Reimbursements(5, 5, "Photo",5, 5)
						)
				);
//		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 5);

	}
	@Test
	public void getAllDeniedReimbursements10() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(5, 5, "Photo",5, 5),
						new Reimbursements(5, 5, "Photo",5, 5),
						new Reimbursements(5, 5, "Photo",5, 5)
						)
				);
//		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getManagerId(), 5);

	}
	@Test
	public void getAllDeniedReimbursement11() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(6, 6, "Photo",6,6 ),
						new Reimbursements(6, 6, "Photo",6,6 ),
						new Reimbursements(6, 6, "Photo",6,6 )
						)
				);
//		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getEmployeeId(), 6);

	}
	@Test
	public void getAllDeniedReimbursement12() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(6, 6, "Photo",6,6 ),
						new Reimbursements(6, 6, "Photo",6,6 ),
						new Reimbursements(6, 6, "Photo",6,6 )
						)
				);
//		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 6);

	}
	@Test
	public void getAllDeniedReimbursements13() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(6, 6, "Photo",6,6 ),
						new Reimbursements(6, 6, "Photo",6,6 ),
						new Reimbursements(6, 6, "Photo",6,6 )
						)
				);
//		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getManagerId(), 6);

	}
	public void getAllDeniedReimbursement55() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(7, 7, "Photo",7,7 ),
						new Reimbursements(7, 7, "Photo",7,7 ),
						new Reimbursements(7, 7, "Photo",7,7 )
						)
				);
//		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getEmployeeId(), 7);

	}
	@Test
	public void getAllDeniedReimbursement56() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(7, 7, "Photo",7,7 ),
						new Reimbursements(7, 7, "Photo",7,7 ),
						new Reimbursements(7, 7, "Photo",7,7 )
						)
				);
//		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getReimbursementId(), 7);

	}
	@Test
	public void getAllDeniedReimbursements57() {
		
	
		
		Mockito.when(repositoryImpl.getAllDeniedReimbursements()).thenReturn(
				Arrays.asList(
						new Reimbursements(7, 7, "Photo",7,7 ),
						new Reimbursements(7, 7, "Photo",7,7 ),
						new Reimbursements(7, 7, "Photo",7,7 )
						)
				);
//		 Assert.assertNotNull(MockitTests.service.getAllDeniedReimbursements());
         Assert.assertEquals(MockitTests.service.getAllResolvedReimbursements().get(0).getManagerId(), 7);

	}
	
}