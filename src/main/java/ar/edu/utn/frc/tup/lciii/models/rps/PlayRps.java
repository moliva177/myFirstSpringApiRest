package ar.edu.utn.frc.tup.lciii.models.rps;

import ar.edu.utn.frc.tup.lciii.models.Play;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayRps implements Play {

    private Long id;
    private Long matchRpsId;
    private ShapeHand shapeHandPlayer1;
    private ShapeHand shapeHandPlayer2;
    private Long winnerId;
}
