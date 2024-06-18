package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.PlayerEntity;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.PlayerJpaRepository;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Player getPlayerById(Long id) {
        PlayerEntity playerEntity = playerJpaRepository.getReferenceById(id);
        if (Objects.isNull(playerEntity.getUserName())){
            throw new EntityNotFoundException();
        }
        return modelMapper.map(playerEntity, Player.class);
    }

    @Override
    public Player savePlayer(Player player) {
        Optional<PlayerEntity> playerEntityOptional = playerJpaRepository.findByUserNameOrEmail(
                player.getUserName(), player.getEmail()
        );
        if(playerEntityOptional.isEmpty()){
            //mapeo el player recibido a un playerEntity
            PlayerEntity playerEntity = modelMapper.map(player, PlayerEntity.class);
            //guardo el player que se inserto
            PlayerEntity playerEntitySaved = playerJpaRepository.save(playerEntity);
            return modelMapper.map(playerEntitySaved, Player.class);
        }
        else {
            return null;
        }
    }

    @Override
    public Player getPlayerByUserNameAndPassword(String username, String password) {
        Optional<PlayerEntity> playerEntityOptional = playerJpaRepository.findByUserNameAndPassword(username, password);
        if (playerEntityOptional.isPresent()){
            return modelMapper.map(playerEntityOptional.get(), Player.class);
        }
        else {
            throw new EntityNotFoundException("Username or password incorrect.");
        }
    }

    @Override
    public Player getPlayerByEmailAndPassword(String email, String password) {
        Optional<PlayerEntity> playerEntityOptional = playerJpaRepository.findByEmailAndPassword(email, password);
        if (playerEntityOptional.isPresent()){
            return modelMapper.map(playerEntityOptional.get(), Player.class);
        }
        else {
            throw new EntityNotFoundException("Email or password incorrect.");
        }
    }

    @Override
    public Player getPlayerByUserNameOrEmailAndPassword(String identity, String password) {
        Optional<PlayerEntity> playerEntityOptional = playerJpaRepository.findByUserNameOrEmailAndPassword(identity, password);
        if (playerEntityOptional.isPresent()){
            return modelMapper.map(playerEntityOptional.get(), Player.class);
        }
        else {
            throw new EntityNotFoundException("Some parameters are incorrect.");
        }
    }
}
