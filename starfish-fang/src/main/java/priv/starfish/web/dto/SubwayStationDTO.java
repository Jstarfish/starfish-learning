package priv.starfish.web.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubwayStationDTO {
    private Long id;
    private Long subwayId;
    private String name;

}
