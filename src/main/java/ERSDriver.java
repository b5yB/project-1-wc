import java.sql.SQLException;

import com.project1.dao.ReimbursementDao;
import com.project1.dao.ReimbursementDaoDB;
import com.project1.dao.UserDao;
import com.project1.dao.UserDaoDB;
import com.project1.models.Reimbursement;
import com.project1.models.User;
import com.project1.services.UserService;

public class ERSDriver {

	public static void main(String[] args) throws SQLException {
		
		/*
		int reimb_id;
		int reimb_amount;
		String reimb_submitted;
		String reimb_resolved;
		String reimb_description;
		Blob reimb_receipt;
		int reimb_author;
		int reimb_resolver;
		int reimb_status_id;
		int reimb_type_id;
		*/
		
		UserDao uDao = new UserDaoDB();
		ReimbursementDao rDao = new ReimbursementDaoDB();
		UserService uServ = new UserService(uDao);
	
		uDao.getAllEmployees();
		
	}

}
