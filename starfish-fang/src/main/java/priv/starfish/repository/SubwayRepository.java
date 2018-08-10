package priv.starfish.repository;

import org.springframework.data.repository.CrudRepository;
import priv.starfish.entity.Subway;

import java.util.List;

/**
 * Created by 瓦力.
 */
public interface SubwayRepository extends CrudRepository<Subway, Long> {
    List<Subway> findAllByCityEnName(String cityEnName);
}
