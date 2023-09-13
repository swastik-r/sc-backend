package user.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import user.model.User;
import user.repository.UserRepository;
import user.vo.ResponseTemplateVo;
import java.util.List;

@Service
public class UserServices {
    private static final Logger log = LoggerFactory.getLogger(UserServices.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of User-Services");
        return userRepository.save(user);
    }

    public ResponseTemplateVo getUser(Long userId) {
        log.info("Inside getUserWithDepartment method of User-Services");
        ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
        User user = userRepository.getUserByUserId(userId);
        responseTemplateVo.setUser(user);
        return responseTemplateVo;
    }

    public List<User> getAllUsers() {
        log.info("Inside getAllUsers method of User-Services");
        return userRepository.findAll();
    }
}