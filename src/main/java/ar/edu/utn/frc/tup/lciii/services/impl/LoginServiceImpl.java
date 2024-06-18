package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.login.Credential;
import ar.edu.utn.frc.tup.lciii.dtos.login.CredentialV2;
import ar.edu.utn.frc.tup.lciii.dtos.login.EmailIdentity;
import ar.edu.utn.frc.tup.lciii.dtos.login.UserNameIdentity;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.services.LoginService;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private PlayerService playerService;

    @Override
    public Player login(Credential credential) {
        if (credential.getIdentity() instanceof UserNameIdentity) {
            return loginWithIdentity((UserNameIdentity) credential.getIdentity(), credential.getPassword());
        }
        else {
            return loginWithIdentity((EmailIdentity) credential.getIdentity(), credential.getPassword());
        }
    }

    @Override
    public Player login(CredentialV2 credential) {
        return playerService.getPlayerByUserNameOrEmailAndPassword(credential.getIdentity(), credential.getPassword());
    }

    private Player loginWithIdentity(UserNameIdentity userNameIdentity, String password) {
        return playerService.getPlayerByUserNameAndPassword(userNameIdentity.getUserName(), password);
    }

    private Player loginWithIdentity(EmailIdentity emailIdentity, String password) {
        return playerService.getPlayerByEmailAndPassword(emailIdentity.getEmail(), password);
    }
}
