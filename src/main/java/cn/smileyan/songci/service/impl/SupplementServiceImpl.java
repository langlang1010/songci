package cn.smileyan.songci.service.impl;

import cn.smileyan.songci.dao.SupplementDao;
import cn.smileyan.songci.entity.Supplement;
import cn.smileyan.songci.service.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplementServiceImpl implements SupplementService {
    @Autowired
    private SupplementDao supplementDao;
    @Override
    public Supplement getSupplementById(Long id) {
        Supplement supplementById = supplementDao.getSupplementById(id);
        String explanation = supplementById.getExplanation();
        supplementById.setExplanation(explanation.replace(" ",""));
        String note = supplementById.getNote();
        supplementById.setNote(note.replace(" ",""));
        return supplementById;
    }
}
