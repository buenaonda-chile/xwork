package com.globaldenso.dnkr.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.BatchDomain;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.MaEmpDomain;
import com.globaldenso.dnkr.domain.db2.SsoAccountDb2Domain;
import com.globaldenso.dnkr.integration.dao.BatchCheckDao;
import com.globaldenso.dnkr.integration.dao.EmpDao;
import com.globaldenso.dnkr.uxis.ShaEncryptUtils;

/**
 * [KR] 사원관리 서비스 구현 <br>
 * [EN] Service implementation of Employee information.<br>
 * [JP] 社員情報のService実装クラス。<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("empService")
public class EmpServiceImpl implements EmpService {

	/**
	 * [KR] 사원 관리 Dao <br>
	 */
	@Autowired
	private EmpDao empDao;

	/**
	 * [KR] Batch정보조회 Dao <br>
	 */
	@Autowired
	private BatchCheckDao batchDao;

	/**
	 * [EN] Default constructor.<br>
	 * [JP] デフォルトコンストラクタ。<br>
	 */
	public EmpServiceImpl() {
		// no process
	}

	/**
	 * [EN] Set DAO of Employee information.<br>
	 * [JP] 社員情報のDAOを設定します。<br>
	 * 
	 * @param empDao Dao of 'EMP_INFO'
	 */
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#searchById(EmpDomain)
	 */
	public EmpDomain searchById(EmpDomain domain) throws ApplicationException {
		return empDao.searchById(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#searchById(EmpDomain)
	 */
	public EmpDomain getTeamName(EmpDomain domain) throws ApplicationException {
		return empDao.getTeamName(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#searchByKey(EmpDomain)
	 */
	public EmpDomain searchByKey(EmpDomain domain) throws ApplicationException {
		return empDao.searchByKey(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#searchByCondition(EmpDomain)
	 */
	public List<EmpDomain> searchByCondition(EmpDomain domain) throws ApplicationException {
		return empDao.searchByCondition(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#searchByConditionForPaging(EmpDomain)
	 */
	public List<EmpDomain> searchByConditionForPaging(EmpDomain domain) throws ApplicationException {
		return empDao.searchByConditionForPaging(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.ai.sample.business.service.EmpService#searchByCondition(EmpDomain)
	 */
	public List<EmpDomain> searchByConditionForTeam(EmpDomain domain) throws ApplicationException {
		return empDao.searchByConditionForTeam(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.ai.sample.business.service.EmpService#searchMaxEmpNumber(EmpDomain)
	 * @see com.globaldenso.dnkr.business.service.EmpService#searchMaxEmpNumber(EmpDomain)
	 */
	public String searchMaxEmpNumber(EmpDomain domain) throws ApplicationException {
		return empDao.searchMaxEmpNumber(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#searchCount(EmpDomain)
	 */
	public int searchCount(EmpDomain domain) throws ApplicationException {
		return empDao.searchCount(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#create(EmpDomain)
	 */
	public void create(EmpDomain domain) throws ApplicationException {
		try {
			domain.setEmpPwd(ShaEncryptUtils.encrypt(domain.getEmpPwd()));

			empDao.create(domain);
		} catch (ApplicationException e) {
			if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
				throw new ApplicationException("SMPL-E8-0004", MessageSources.getInstance().value("info.employee"));
			} else {
				throw e;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#update(EmpDomain)
	 */
	public int update(EmpDomain domain) throws ApplicationException {
		try {
			domain.setEmpPwd(ShaEncryptUtils.encrypt(domain.getEmpPwd()));
			return empDao.update(domain);
		} catch (ApplicationException e) {
			if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
				throw new ApplicationException("SMPL-E8-0004", MessageSources.getInstance().value("info.board"));
			} else {
				throw e;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#delete(EmpDomain)
	 */
	public int delete(EmpDomain domain) throws ApplicationException {
		return empDao.delete(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#delete(List)
	 */
	public int delete(List<EmpDomain> domainList) throws ApplicationException {
		int deleteCount = 0;
		for (EmpDomain delDomain : domainList) {
			deleteCount += delete(delDomain);
		}
		return deleteCount;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public List<MaEmpDomain> searchMaEmpList(MaEmpDomain domain) throws ApplicationException {
		// System.out.println("MaEmpList Get---------------------------");
		return empDao.searchMaEmpList(domain);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public int insertMaEmpToDnkrEmpTmp(MaEmpDomain maEmpDomain) throws ApplicationException {
		return empDao.insertMaEmpToDnkrEmpTmp(maEmpDomain);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public int deleteDnkrEmpTmp() throws ApplicationException {
		return empDao.deleteDnkrEmpTmp();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#searchByDb2Id(EmpDb2Domain)
	 */
	public EmpDb2Domain searchByDb2Id(EmpDb2Domain domain) throws ApplicationException {
		return empDao.searchByDb2Id(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#ssoAccounts(SsoAccountDb2Domain)
	 */
	public SsoAccountDb2Domain ssoAccounts(SsoAccountDb2Domain domain) throws ApplicationException {
		return empDao.ssoAccounts(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#ssoAccounts_OrderProd(SsoAccountDb2Domain)
	 */
	public SsoAccountDb2Domain ssoAccounts_OrderProd(SsoAccountDb2Domain domain) throws ApplicationException {
		return empDao.ssoAccounts_OrderProd(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#"selectOgm200_hmd020pf"(EmpDb2Domain)
	 */
	public EmpDb2Domain selectOgm200_hmd020pf(EmpDb2Domain domain) throws ApplicationException {
		return empDao.selectOgm200_hmd020pf(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#selectOGMUserID(EmpDb2Domain)
	 */
	public List<EmpDb2Domain> selectOGMUserID(EmpDb2Domain domain) throws ApplicationException {
		return empDao.selectOGMUserID(domain);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Scheduled(cron = " 0 0 1 * * * ")
	public void procDnkrEmpTmpToMaEmp() throws ApplicationException {
		// 더존 회사코드변경시 수정필요
		// System.out.println("------인사정보 스케쥴------");
		/// 더존 인사정보를 사용자정보에 입력
		HashMap map = new HashMap();
		List<MaEmpDomain> maEmpList = searchMaEmpList(null);
		int insertMaEmpCnt = 0;
		int deleteMaEmpCnt = 0;
		if (maEmpList != null && maEmpList.size() > 0) {
			try {
				deleteMaEmpCnt = deleteDnkrEmpTmp();
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("deleteMaEmpCnt >>>>> " + deleteMaEmpCnt);

			for (int i = 0; i < maEmpList.size(); i++) {
				MaEmpDomain maEmpDomain = maEmpList.get(i);
				insertMaEmpCnt += insertMaEmpToDnkrEmpTmp(maEmpDomain);
			}

			System.out.println("inertMaEmpCnt >>>>> " + insertMaEmpCnt);
			empDao.procMergeEmp(map); // 인사정보갱신
			empDao.procDisableEmp(map); // 퇴사자 사용여부 변경
			System.out.println("------------------------------------------------");
			System.out.println(map.get("rtnCnt"));
			System.out.println(map.get("rtnMsg"));
			System.out.println("------------------------------------------------");
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */

	// 실서버적용 → 테스트 서버 적용시  @Scheduled 주석처리 할것!
	@Scheduled(cron = " 0 0/10 01,02,03,04,05 * * *")
	public void batchCheckIsSendSms() throws ApplicationException {

		System.out.println("----------DNKE BATCH CHECK 로직 START------------");
		SimpleDateFormat format2 = new SimpleDateFormat("HHmmss");
		Integer hhmmss = Integer.parseInt(format2.format(new Date()));
		// 더존 회사코드변경시 수정필요
		try {

			List<BatchDomain> resultMap = batchDao.selectBatchInfo("");
			String message = "";

			for (BatchDomain domain : resultMap) {
				// DNKE BATCH CHECK
				if (domain.getComps().equals("PE")) {
					message = dnkeBatchCheck(message, domain, hhmmss);
					message = sendSMSmessage(message);
				}
				// DNKA BATCH CHECK
				if (domain.getComps().equals("PS")) {
					message = dnkaBatchCheck(message, domain, hhmmss);
					message = sendSMSmessage(message);
				}
				
			}
			int cnt = batchDao.searchBatchCheckMassage();
			// MSGQ check
			if(cnt > 0) {
				message = "야간배치중 ERROR 로 인한 JOBQ에 MESSAGE 상태입니다.";
				message = sendSMSmessage(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("----------DNKE BATCH CHECK 로직 END------------");
	}

	
	private String dnkeBatchCheck(String message, BatchDomain domain,Integer hhmmss) throws ApplicationException {

		BatchDomain paraDomain = new BatchDomain();
		if (domain.getBchst().equals("S")) {
			// 체크 시간 01시부터 01시10분까지 check
			
			// CASE C :사전,사후 작업시 ERROR 발생되었을 경우
			if (domain.getCheckError().equals("ERROR")) {
				message = "DNKE 야간배치가 사전, 사후 작업시 ERROR 발생되었습니다.";
			}
			
			// CASE D :DNKE 야간배치가 CIGMA에서 ERROR 발생되었습니다.
			paraDomain.setLib("PERESLIB");
			if (batchDao.searchBatchCheckError(paraDomain) > 0) {
				
				message = "DNKE 야간배치가 CIGMA에서 ERROR 발생되었습니다.";
			}
			//message = "DNKE 야간배치가 CIGMA에서 ERROR 발생되었습니다.";
		}
		
		return message;
	}
	
	private String dnkaBatchCheck(String message, BatchDomain domain,Integer hhmmss) throws ApplicationException {

		BatchDomain paraDomain = new BatchDomain();
		
		if (domain.getBchst().equals("S")) {
			// 체크 시간 01시부터 01시10분까지 check
		
			// CASE C : 04:00 ~ 05:30
			if (domain.getCheckError().equals("ERROR")) {
				message = "DNKA 야간배치가 사전, 사후 작업시 ERROR 발생되었습니다.";
			}
			paraDomain.setLib("PSRESLIB");
			if (batchDao.searchBatchCheckError(paraDomain) > 0) {
				message = "DNKA 야간배치가 CIGMA에서 ERROR 발생되었습니다.";
			}
		}
		
		return message;
	}
	
	private String sendSMSmessage(String message) throws ApplicationException {
		
		// message가 없으면 전송하지 않음
		if(message != "") {
			List<BatchDomain> list = batchDao.searchSMSuserList();

			for (BatchDomain batchDomain : list) {
				HashMap<String, String> smsMap = new HashMap<String, String>();
				smsMap.put("receiver", batchDomain.getPhone());
				smsMap.put("sender", "055-220-9096");
				smsMap.put("content", message);
				batchDao.insertSmsSendData(smsMap);
			}
		}
   	    
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#searchById(EmpDomain)
	 */
	// 2018.06.05 추가 IT.T 제혼복
	public MaEmpDomain searchEmpMaAccount(MaEmpDomain domain) throws ApplicationException {
		// System.out.println("MaEmpList Get---------------------------");
		return empDao.searchEmpMaAccount(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#ssoAccounts(SsoAccountDb2Domain)
	 */
	public int searchSsoDspSessionAccount(SsoAccountDb2Domain domain) throws ApplicationException {
		return empDao.searchSsoDspSessionAccount(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.globaldenso.dnkr.business.service.EmpService#ssoAccounts(SsoAccountDb2Domain)
	 */
	public SsoAccountDb2Domain searchSsoPrtSessionAccount(SsoAccountDb2Domain domain) throws ApplicationException {
		return empDao.searchSsoPrtSessionAccount(domain);
	}

	/**
	 * [EN] Search SSO information from DB table by the LOGIN EMP_ID, and return the
	 * search results.<br>
	 * [JP] 主キーを条件にDBテーブルから社員情報を検索し、検索結果を返却します。<br>
	 * 
	 * @param domain 'SsoAccountDb2Domain' class
	 * @return 'EmpDb2Domain' class
	 * @throws ApplicationException Application exception of 'Application
	 *                              Infrastructure'
	 */
	public List<SsoAccountDb2Domain> searchDioneAccountCnt(SsoAccountDb2Domain domain) throws ApplicationException {
		return empDao.searchDioneAccountCnt(domain);
	}

	// 2018.12.18 추가 IT.T 제혼복(사업부이동자를 위한 Ldap체크)
	public EmpDomain searchByIdLdap(EmpDomain domain) throws ApplicationException {
		return empDao.searchByIdLdap(domain);
	}

}
