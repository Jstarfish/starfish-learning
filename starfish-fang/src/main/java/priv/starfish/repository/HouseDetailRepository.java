package priv.starfish.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import priv.starfish.entity.HouseDetail;


public interface HouseDetailRepository extends CrudRepository<HouseDetail, Long>{
    HouseDetail findByHouseId(Long houseId);

    List<HouseDetail> findAllByHouseIdIn(List<Long> houseIds);
}
