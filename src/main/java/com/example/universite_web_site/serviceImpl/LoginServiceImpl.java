package com.example.universite_web_site.serviceImpl;


import com.example.universite_web_site.model.Manager;
import com.example.universite_web_site.model.ResponseModel;
import com.example.universite_web_site.repository.LoginRepository;
import com.example.universite_web_site.service.LoginService;
import com.example.universite_web_site.session.ManagerSession;

public class LoginServiceImpl implements LoginService {

    private LoginRepository loginRepository = new LoginRepository();

    @Override
    public ResponseModel<Manager> login(Long id, String password) {
        ResponseModel responsemodel = new ResponseModel();
        Manager user = loginRepository.login(id, password);
        if (user != null) {
            responsemodel.setIsSuccess(true);
            responsemodel.setMessage("Login successful!");
            responsemodel.setResponseObject(user);

        } else {
            responsemodel.setIsSuccess(false);
            responsemodel.setMessage("Login failed!");
            responsemodel.setResponseObject(user);
        }
        ManagerSession.setUser(user);
        return responsemodel;
    }

    @Override
    public ResponseModel<Boolean> logout() {
        ResponseModel responsemodel = new ResponseModel();
        
        ManagerSession.clear();
        responsemodel.setIsSuccess(true);
        responsemodel.setMessage("Oturumunuz kapatılmıştır!");
        responsemodel.setResponseObject(true);
        
        return responsemodel;
    }

}
