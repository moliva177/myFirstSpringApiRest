package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.match.MatchDto;
import ar.edu.utn.frc.tup.lciii.dtos.play.PlayRequest;
import ar.edu.utn.frc.tup.lciii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.models.*;
import ar.edu.utn.frc.tup.lciii.models.rps.MatchRps;
import ar.edu.utn.frc.tup.lciii.repositories.MatchEntityFactory;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.MatchJpaRepository;
import ar.edu.utn.frc.tup.lciii.services.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchJpaRepository matchJpaRepository;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    GameService gameService;

    @Autowired
    PlayStrategyFactory playStrategyFactory;

    @Override
    public List<Match> getMatchesByPlayer(Long playerId) {
        List<Match> matches = new ArrayList<>();
        Optional<List<MatchEntity>> optionalMatchEntities = matchJpaRepository.getAllByPlayer1Id(playerId);
        if (optionalMatchEntities.isPresent()) {
            for (MatchEntity me : optionalMatchEntities.get()) {
                matches.add(modelMapper.map(me, MatchRps.class));
            }
        }
        return matches;
    }

    @Override
    public Match createMatch(MatchDto matchDto) {
        Player player = playerService.getPlayerById(matchDto.getPlayerId());
        Game game = gameService.getGame(matchDto.getGameId());
        Match match = MatchFactory.createMatch(player, game);
        MatchEntity matchEntity = matchJpaRepository.save(modelMapper.map(match, MatchEntityFactory.getTypeOfMatch(match)));
        return modelMapper.map(matchEntity, match.getClass());
    }

    @Transactional
    @Override
    public Play play(Long matchId, PlayRequest playRequest) {
        Match match = this.getMatchById(matchId);
        if (match == null) {
            throw new EntityNotFoundException();
        }
        if (match.getStatus() != MatchStatus.STARTED){
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("the match is %s", match.getStatus()));
        }
        Play play = PlayFactory.getPlayInstance(playRequest, match.getGame().getCode());
        PlayMatch playMatch = playStrategyFactory.getPlayStrategy(match.getGame().getCode());
        return playMatch.play(play, match);
    }

    @Override
    public Match getMatchById(Long id) {
        //INFO: https://www.baeldung.com/hibernate-proxy-to-real-entity-object
        MatchEntity me = (MatchEntity) Hibernate.unproxy(matchJpaRepository.getReferenceById(id));
        if (me != null){
            Match match = modelMapper.map(me, MatchFactory.getTypeOfMatch(me.getGame().getCode()));
            return match;
        }
        else {
            throw new EntityNotFoundException();
        }
    }
}
