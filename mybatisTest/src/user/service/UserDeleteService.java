package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {

	@Override
	public void execute() {
		//데이터
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 아이디 입력 : ");
		String id = scan.next();
		
		//DB
		UserDAO userDAO = UserDAO.getInstance(); //싱글톤
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
			return; //함수를 나가라
		}
		
		userDAO.delete(id);
		
		//응답
		System.out.println("데이터를 삭제하였습니다.");
	}

}
