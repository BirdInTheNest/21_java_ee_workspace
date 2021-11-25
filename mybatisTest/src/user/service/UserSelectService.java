package user.service;

import java.util.List;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSelectService implements UserService {

	@Override
	public void execute() {
		//DB
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.getUserList(); //startNum, endNum으로 페이징 처리도 가능함

		//응답
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
		}
	}

}
