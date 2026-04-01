package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info("Login method was called. Params login ={}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.error("User or password are incorrect. Params login ={}", login);
        }
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, "1234");
        logger.info("FindByLogin method was called. Params login ={}", login);
        user.setUserId(2L);
        return user;
    }
}
