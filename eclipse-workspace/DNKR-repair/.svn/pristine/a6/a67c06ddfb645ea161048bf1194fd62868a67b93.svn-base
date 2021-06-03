package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.AtchmnflDomain;
import com.globaldenso.dicas.business.dto.AtchmnflDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] AtchmnflDao class of Menu information.<br>
 * [JP] AtchmnflDao class of Menu information.<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("atchmnflDao")
public interface AtchmnflDao {

  AtchmnflDto searchByKey(AtchmnflDomain domain) throws SystemException;
  AtchmnflDto searchUseFileByKey(Long atchmnflId) throws SystemException;

  List<AtchmnflDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(AtchmnflDomain atchmnflDomain) throws SystemException;

  void update(AtchmnflDomain atchmnflDomain) throws SystemException;
}
