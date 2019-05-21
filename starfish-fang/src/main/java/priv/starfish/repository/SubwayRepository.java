package priv.starfish.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import priv.starfish.entity.Subway;


public interface SubwayRepository extends CrudRepository<Subway, Long>{
    List<Subway> findAllByCityEnName(String cityEnName);
}
