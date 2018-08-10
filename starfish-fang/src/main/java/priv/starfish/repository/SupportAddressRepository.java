package priv.starfish.repository;

import org.springframework.data.repository.CrudRepository;
import priv.starfish.entity.SupportAddress;

import java.util.List;

/**
 * Created by 瓦力.
 */
public interface SupportAddressRepository extends CrudRepository<SupportAddress, Long> {
    /**
     * 获取所有对应行政级别的信息
     * @return
     */
    List<SupportAddress> findAllByLevel(String level);

    SupportAddress findByEnNameAndLevel(String enName, String level);

    SupportAddress findByEnNameAndBelongTo(String enName, String belongTo);

    List<SupportAddress> findAllByLevelAndBelongTo(String level, String belongTo);

}
