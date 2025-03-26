package utils;

import dao.UserDAO;
import dto.UserDTO;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mah
 */
public class AuthUtils {

    public static final String ADMIN_ROLE = "AD";
    public static final String USER_ROLE = "US";

    // PT kiểm tra người dùng đăng nhập hay ch
    public static boolean isLoggedIn(HttpSession session){
        return session.getAttribute("user") != null;
    }
    
    // PT kiểm tra admin
    public static boolean isAdmin(HttpSession session){
        if(isLoggedIn(session) == false){
            return false;
        }
        UserDTO user = (UserDTO)session.getAttribute("user");
        return user.getRoleID().equals(ADMIN_ROLE);
    }
    
     // PT kiểm tra user
    public static boolean isUser(HttpSession session){
        if(isLoggedIn(session) == false){
            return false;
        }
        UserDTO user = (UserDTO)session.getAttribute("user");
        return user.getRoleID().equals(USER_ROLE);
    }
    
    
// Phương thức trong MainController:
    public static UserDTO getUser(String strUserID) {
        UserDAO udao = new UserDAO();
        UserDTO user = udao.readById(strUserID);
        return user;
    }
    
    public static boolean isValidLogin(String strUsername, String strPassword) {
        UserDTO user = getUser(strUsername);
        System.out.println(user);
        return user != null && user.getPassword().equals(strPassword);
    }
    
    public static UserDTO getUser(HttpSession session){
        Object obj = session.getAttribute("user");
        return (obj != null)?(UserDTO)obj:null;
    }
    
}
