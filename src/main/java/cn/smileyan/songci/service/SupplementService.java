package cn.smileyan.songci.service;

import cn.smileyan.songci.entity.Supplement;

/**
 * @author Smileyan
 */
public interface SupplementService {
    /**
     * 根据id获得注释
     * @param id 编号
     * @return 注释
     */
    Supplement getSupplementById(Long id);
}
