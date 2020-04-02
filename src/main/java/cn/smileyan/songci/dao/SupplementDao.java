package cn.smileyan.songci.dao;

import cn.smileyan.songci.entity.Supplement;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Smileyan
 */
public interface SupplementDao extends CrudRepository<Supplement,Long> {
    /**
     * 根据id获得注释
     * @return 注释
     */
    Supplement getSupplementById(Long id);
}

