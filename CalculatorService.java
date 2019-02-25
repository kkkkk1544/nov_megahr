package bvehr.megahr.pay.calculator;

import bvehr.megahr.pay.cmm.PayCmmService;


import bvehr.megahr.pay.cmm.dto.Py33Dto;
import bvehr.megahr.pay.fixallowdedcrt.PayFixAllowDedCrtDto;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.TransactionStatus;

import bvehr.megahr.cmm.CmmCodeDto;
import bvehr.megahr.cmm.util.BeanUtil;
import bvehr.megahr.cmm.util.StringUtil;




public class CalculatorService extends PayCmmService {
	private String sqlMapNs = "CalculatorCode";
	protected String getSqlMapNs() {
		return sqlMapNs;
	}

	/**
	 * 수당항목 List 조회
	 * @param dto
	 * @return
	 */
	public Map<String,Object> selectList(CalculatorDto dto) {
		Map<String,Object> modelMap = new HashMap<String,Object>();
		
		//권한사업장 체크
		//Map<String, String> compycdMap = getCmmSsnOrgidCompycdMap(dto);
		Map<String, String> compycdMap	= getAuthCompycdMap(dto);
		
		if(StringUtil.isEmpty(dto.getSrch_compycd())){
			if(compycdMap != null && compycdMap.size() > 0) {
				dto.setSrch_compycd(compycdMap.keySet().iterator().next());
			}
		}
		
		Map<String, CmmCodeDto> cdG101Map = getCmmCodeMap("G101");
//		if(StringUtil.isEmpty(dto.getSrch_pay_class())){
//			//if(cdG101Map != null && cdG101Map.size() > 0){
//			//	dto.setSrch_pay_class(cdG101Map.keySet().iterator().next());
//			//}
//			dto.setSrch_pay_class("10");
//		}
		
		List<CalculatorDto> retList = queryForList("selectList", dto, CalculatorDto.class);
		BeanUtil.copyPagingInfo(retList, dto);
		
		//modelMap.put("cdG101Map", 	getCmmCodeMap("G101"));	// 지급시기
		modelMap.put("cdG101Map", 	cdG101Map);				// 지급시기
		//modelMap.put("paycdMap", 	getPaycdAllMap());		// 지급시기
		modelMap.put("cdG201Map", 	getCmmCodeMap("G201"));	// 계산방법
		modelMap.put("asMap", 		getCmmCodeMap("S701"));	// 수당맵
		modelMap.put("compycdMap", 	compycdMap);
		modelMap.put("compycdCnt", 	compycdMap.size());
		modelMap.put("retList", 	retList);
		return modelMap;
	}

	/**
	 * 저장
	 * @param dto
	 * @return
	 * @throws SQLException
	 */
	public int saveList(CalculatorDto dto) throws SQLException {
		int ret = 0;

		TransactionStatus status = getTransaction(txManager);
		try {
			
			int idxNum = 0;
			for(int i=0; dto.getArr_num()!=null && i<dto.getArr_num().length; i++) {
				idxNum = dto.getArr_num()[i];
				CalculatorDto dto1 = BeanUtil.copyArrIndex(dto, idxNum, CalculatorDto.class);
				if(dto1 == null) continue;
				dto1.setOrg_id(dto.getSsn_org_id());
				
				if (StringUtil.isNotEmpty(dto1.getRow_id())) {
					update("update", dto1);
				} else {
					insert("insert", dto1);
				}
			}
			
			txManager.commit(status);
		} catch (Exception e) {
			txManager.rollback(status);
			logger.error(e.getMessage(), e);

			dto.setRetCode(1);
			if(e instanceof DuplicateKeyException) {
				dto.setRetMsg(MSG_ERR_DUPEKEY);
			} else {
				dto.setRetMsg(MSG_ERR_DEFAULT);
			}
		} finally {
			if(!status.isCompleted()) txManager.rollback(status);
		}

		return 0;
	}

	/**
	 * 삭제[List]
	 * @param dto
	 * @return
	 * @throws SQLException
	 */
	public int deleteList(CalculatorDto dto) throws SQLException {
		
		TransactionStatus status = getTransaction(txManager);
		try {
			
			int idxNum = 0;
			for(int i=0; dto.getArr_num()!=null && i<dto.getArr_num().length; i++) {
				idxNum = dto.getArr_num()[i];
				CalculatorDto dto1 = BeanUtil.copyArrIndex(dto, idxNum, CalculatorDto.class);
				if(dto1 == null) continue;
				dto1.setOrg_id(dto.getSsn_org_id());
				
				delete("delete", dto1);
			}
			
			txManager.commit(status);
		} catch (Exception e) {
			txManager.rollback(status);
			logger.error(e.getMessage(), e);

			dto.setRetCode(1);
			if(e instanceof DuplicateKeyException) {
				dto.setRetMsg(MSG_ERR_DUPEKEY);
			} else {
				dto.setRetMsg(MSG_ERR_DEFAULT);
			}
		} finally {
			if(!status.isCompleted()) txManager.rollback(status);
		}
		
		return 0;
	}
	
	/**
	 * 수당대상자 및 계산설정 추출
	 * @param dto
	 * @return
	 */
	public Map<String,Object> selectListDetail(CalculatorDto dto) {
		Map<String,Object> modelMap = new HashMap<String,Object>();
		
		List<CalculatorDto> retList = queryForList("selectDetail", dto, CalculatorDto.class);
		BeanUtil.copyPagingInfo(retList, dto);
		
		CalculatorDto calcDto = queryForObject("selectDetailCalc", dto);
		
		modelMap.put("retList", 	retList);
		modelMap.put("calcDto",		calcDto);
		modelMap.put("typeMap",		queryForLinkedMap("typeMap", dto, "description", "codeid"));
		modelMap.put("payMap",		queryForLinkedMap("payMap", dto, "codeid", "description"));
		modelMap.put("dutyMap",		queryForLinkedMap("dutyMap", dto, "codeid", "description"));
		modelMap.put("allowMap",	queryForLinkedMap("allowMap", dto, "codeid", "description"));
		modelMap.put("calcMap",		queryForLinkedMap("calcMap", dto, "codeid", "description"));
		return modelMap;
	}
	
	/**
	 * 수당대상자 고정수당/공제 설정에 의한 Dynamic 조회조건 Popup
	 * @param dto
	 * @return
	 */
	public Map<String,Object> selectWhereList(CalculatorDto dto) {
		Map<String,Object> modelMap = new HashMap<String,Object>();
		
		dto.setAs_class("ALLOW");
		
		HashMap<String, Object> callMap = new HashMap<String, Object>();
		callMap.put("p_org_id",			dto.getSsn_org_id());
		callMap.put("p_precede_num", 	dto.getSrch_precede_num());
		callMap.put("p_sql", 			"");
		queryForObject("getRecordSql",	callMap);
		
		dto.setQuery(callMap.get("p_sql").toString());
		
		List<PayFixAllowDedCrtDto> retList = queryForList("selectWhereList", dto, PayFixAllowDedCrtDto.class);
		BeanUtil.copyPagingInfo(retList, dto);
		
		modelMap.put("colspanCnt",		queryForObject("colspanCnt", dto, java.lang.String.class));				// colspan용 카운트
		modelMap.put("optionContent", 	queryForObject("selectOptionContent", dto, Py33Dto.class));				// 설정구성요소
		modelMap.put("retList", 		retList);
		return modelMap;
	}
	
	/**
	 * 수당대상자 저장[List]
	 * @param dto
	 * @return
	 * @throws SQLException
	 */
	public int saveListDetail(CalculatorDto dto) throws SQLException {
		int ret = 0;

		TransactionStatus status = getTransaction(txManager);
		try {
			
			int idxNum = 0;
			for(int i=0; dto.getArr_num()!=null && i<dto.getArr_num().length; i++) {
				idxNum = dto.getArr_num()[i];
				CalculatorDto dto1 = BeanUtil.copyArrIndex(dto, idxNum, CalculatorDto.class);
				if(dto1 == null) continue;
				dto1.setOrg_id(dto.getSsn_org_id());
				dto1.setCompycd(dto.getCompycd());
				dto1.setAs_cd(dto.getAllowcd());
				
				if (StringUtil.isNotEmpty(dto1.getRow_id())) {
					update("updateDetail", dto1);
				} else {
					insert("insertDetail", dto1);
				}
				
			}
			
			//계산수식/수당로직 저장
			update("updateFormula", dto);
			
			//수당로직 오브젝트 생성
			HashMap<String, Object> comMap = new HashMap<String, Object>();
			comMap.put("p_org_id",			dto.getSsn_org_id());
			comMap.put("p_compycd",			dto.getCompycd());
			comMap.put("p_as_class", 		"ALLOW");
			comMap.put("p_as_cd", 			dto.getAllowcd());
			//comMap.put("p_formula", 		dto.getFormula_long());
			comMap.put("x_err_msg", 		null);
			queryForObject("formulaCompile",	comMap);
			
			if (StringUtil.isNotEmpty(comMap.get("x_err_msg"))) {
				dto.setRetCode(1);
				dto.setRetMsg(comMap.get("x_err_msg").toString());
			}
			
			txManager.commit(status);
		} catch (Exception e) {
			txManager.rollback(status);
			logger.error(e.getMessage(), e);

			dto.setRetCode(1);
			if(e instanceof DuplicateKeyException) {
				dto.setRetMsg(MSG_ERR_DUPEKEY);
			} else {
				dto.setRetMsg(MSG_ERR_DEFAULT);
			}
		} finally {
			if(!status.isCompleted()) txManager.rollback(status);
		}

		return 0;
	}

	/**
	 * 수당대상자 삭제[List]
	 * @param dto
	 * @return
	 * @throws SQLException
	 */
	public int deleteListDetail(CalculatorDto dto) throws SQLException {
		
		TransactionStatus status = getTransaction(txManager);
		try {
			
			int idxNum = 0;
			for(int i=0; dto.getArr_num()!=null && i<dto.getArr_num().length; i++) {
				idxNum = dto.getArr_num()[i];
				CalculatorDto dto1 = BeanUtil.copyArrIndex(dto, idxNum, CalculatorDto.class);
				if(dto1 == null) continue;
				dto1.setOrg_id(dto.getSsn_org_id());
				
				delete("deleteDetail", dto1);
			}
			
			txManager.commit(status);
		} catch (Exception e) {
			txManager.rollback(status);
			logger.error(e.getMessage(), e);

			dto.setRetCode(1);
			if(e instanceof DuplicateKeyException) {
				dto.setRetMsg(MSG_ERR_DUPEKEY);
			} else {
				dto.setRetMsg(MSG_ERR_DEFAULT);
			}
		} finally {
			if(!status.isCompleted()) txManager.rollback(status);
		}
		
		return 0;
	}
	
	/**
	 * 수당대상자 및 계산설정 추출
	 * @param dto
	 * @return
	 */
	public Map<String,Object> formulaValid(CalculatorDto dto) {
		Map<String,Object> modelMap = new HashMap<String,Object>();
		
		HashMap<String, Object> valMap = new HashMap<String, Object>();
		valMap.put("p_org_id",			dto.getSsn_org_id());
		valMap.put("p_formula", 		dto.getFormula_hidden());
		valMap.put("x_err_msg", 		null);
		queryForObject("formulaValid",	valMap);
		
		if (StringUtil.isNotEmpty(valMap.get("x_err_msg"))) {
			dto.setRetCode(1);
			dto.setRetMsg(valMap.get("x_err_msg").toString());
		}
		
		return modelMap;
	}
	
    /**
     * 로직 내용 조회
     * @param dto
     * @return
     */
    public Map<String, Object> selectLogicList(CalculatorDto dto) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        List<CalculatorDto> retList = queryForList("selectLogicList", dto);
        
        modelMap.put("retList", retList);
        return modelMap;
    }

}