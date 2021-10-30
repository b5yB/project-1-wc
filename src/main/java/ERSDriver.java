import java.sql.SQLException;
import java.sql.Timestamp;

import com.project1.dao.ReimbursementDao;
import com.project1.dao.ReimbursementDaoDB;
import com.project1.dao.UserDao;
import com.project1.dao.UserDaoDB;
import com.project1.models.Reimbursement;
import com.project1.models.User;
import com.project1.services.ReimbursementService;
import com.project1.services.UserService;

public class ERSDriver {

	public static void main(String[] args) throws SQLException {
		
		UserDao uDao = new UserDaoDB();
		ReimbursementDao rDao = new ReimbursementDaoDB();
		UserService uServ = new UserService(uDao);
		ReimbursementService rServ = new ReimbursementService(rDao);
		
		
		
	}

}
