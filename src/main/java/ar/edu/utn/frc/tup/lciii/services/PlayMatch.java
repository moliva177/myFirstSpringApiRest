package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.models.Match;
import ar.edu.utn.frc.tup.lciii.models.Play;
import org.springframework.stereotype.Service;

@Service
public interface PlayMatch<P extends Play, M extends Match>{

    P play(P play, M match);
}
