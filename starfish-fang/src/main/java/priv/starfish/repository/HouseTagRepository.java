package priv.starfish.repository;

import org.springframework.data.repository.CrudRepository;
import priv.starfish.entity.HouseTag;

import java.util.List;

/**
 * Created by 瓦力.
 */
public interface HouseTagRepository extends CrudRepository<HouseTag, Long> {
    HouseTag findByNameAndHouseId(String name, Long houseId);

    List<HouseTag> findAllByHouseId(Long id);

    List<HouseTag> findAllByHouseIdIn(List<Long> houseIds);
}
