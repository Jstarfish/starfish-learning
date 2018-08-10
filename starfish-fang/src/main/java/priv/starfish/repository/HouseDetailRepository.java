package priv.starfish.repository;

import org.springframework.data.repository.CrudRepository;
import priv.starfish.entity.HouseDetail;

import java.util.List;

/**
 * Created by 瓦力.
 */
public interface HouseDetailRepository extends CrudRepository<HouseDetail, Long> {
    HouseDetail findByHouseId(Long houseId);

    List<HouseDetail> findAllByHouseIdIn(List<Long> houseIds);
}
