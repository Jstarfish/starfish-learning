package priv.starfish.repository;

import org.springframework.data.repository.CrudRepository;
import priv.starfish.entity.SubwayStation;

import java.util.List;

/**
 * Created by 瓦力.
 */
public interface SubwayStationRepository extends CrudRepository<SubwayStation, Long> {
    List<SubwayStation> findAllBySubwayId(Long subwayId);
}
