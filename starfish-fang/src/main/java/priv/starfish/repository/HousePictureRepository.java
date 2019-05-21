package priv.starfish.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import priv.starfish.entity.HousePicture;


public interface HousePictureRepository extends CrudRepository<HousePicture, Long> {
    List<HousePicture> findAllByHouseId(Long id);
}
