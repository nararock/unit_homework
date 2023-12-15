package homework3.task3;

import homework3.task3.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        user.isAuthenticate = true;
        data.add(user);
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logOutUsers(){
        for (int i = 0; i < data.size();){
            User user = data.get(i);
            if (!user.isAdmin){
                user.isAuthenticate = false;
                data.remove(user);
            } else{
                i++;
            }
        }
    }

}