package com.agnasarp.user.service;

import com.agnasarp.user.entity.User;
import com.agnasarp.user.repository.UserRepository;
import com.agnasarp.user.vo.Department;
import com.agnasarp.user.vo.ResponseTemplateVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVo getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService");
        ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
        User user = userRepository.getUserByUserId(userId);
        Department department = restTemplate.getForObject("http://localhost:8280/departments/" + userId, Department.class);
        responseTemplateVo.setUser(user);
        responseTemplateVo.setDepartment(department);
        return responseTemplateVo;
    }

}
