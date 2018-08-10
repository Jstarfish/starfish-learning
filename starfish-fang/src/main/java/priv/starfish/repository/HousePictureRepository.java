package priv.starfish.repository;

import org.springframework.data.repository.CrudRepository;
import priv.starfish.entity.HousePicture;

import java.util.List;

/**
 * Created by 瓦力.
 */
public interface HousePictureRepository extends CrudRepository<HousePicture, Long> {
    List<HousePicture> findAllByHouseId(Long id);
}
