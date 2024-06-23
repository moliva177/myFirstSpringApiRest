package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.models.rps.ShapeHand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plays_rps")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaysRpsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_rps_id")
    private MatchRpsEntity matchRps;

    @Enumerated(EnumType.STRING)
    private ShapeHand shapeHandPlayer1;

    @Enumerated(EnumType.STRING)
    private ShapeHand shapeHandPlayer2;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private PlayerEntity winner;
}
