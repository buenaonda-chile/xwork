package com.globaldenso.dnkr.business.service.db2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.db2.AccountSituationDomain;
import com.globaldenso.dnkr.domain.db2.AccountingJournalDomain;
import com.globaldenso.dnkr.domain.db2.BusinessShippingDomain;
import com.globaldenso.dnkr.domain.db2.BusinessShippingMaterialDomain;
import com.globaldenso.dnkr.domain.db2.CalculationMaterialDomain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.domain.db2.DailyDepartmentCostDomain;
import com.globaldenso.dnkr.domain.db2.DataWarehouseFileDomain;
import com.globaldenso.dnkr.domain.db2.DomesticPurchasePriceListDomain;
import com.globaldenso.dnkr.domain.db2.DuplicationPartDomain;
import com.globaldenso.dnkr.domain.db2.FakeSalesCheckListDomain;
import com.globaldenso.dnkr.domain.db2.HvacSpoolDomain;
import com.globaldenso.dnkr.domain.db2.ImportDressingHistoryDomain;
import com.globaldenso.dnkr.domain.db2.ImportInventoryDomain;
import com.globaldenso.dnkr.domain.db2.ImportInventoryPopDomain;
import com.globaldenso.dnkr.domain.db2.ImportProgressDomain;
import com.globaldenso.dnkr.domain.db2.ImportsTradeDomain;
import com.globaldenso.dnkr.domain.db2.JdeBudgetDomain;
import com.globaldenso.dnkr.domain.db2.MaterialCostByPeriodDomain;
import com.globaldenso.dnkr.domain.db2.MaterialInventoryDomain;
import com.globaldenso.dnkr.domain.db2.MaterialReceivingDomain;
import com.globaldenso.dnkr.domain.db2.MaterialWasteDomain;
import com.globaldenso.dnkr.domain.db2.MonthlyDivisionRatioDomain;
import com.globaldenso.dnkr.domain.db2.MonthlyImportsProductDomain;
import com.globaldenso.dnkr.domain.db2.MonthlySalesPlanDomain;
import com.globaldenso.dnkr.domain.db2.MonthlyShipmentCheckDomain;
import com.globaldenso.dnkr.domain.db2.MonthlyShippingListDomain;
import com.globaldenso.dnkr.domain.db2.OceanListDomain;
import com.globaldenso.dnkr.domain.db2.OceanListSalesRevenueDomain;
import com.globaldenso.dnkr.domain.db2.ProductInventoryDomain;
import com.globaldenso.dnkr.domain.db2.ProductShippingReceivingDomain;
import com.globaldenso.dnkr.domain.db2.ProductStockShippingReceivingDomain;
import com.globaldenso.dnkr.domain.db2.ProductionRecordDomain;
import com.globaldenso.dnkr.domain.db2.PurchasePriceDomain;
import com.globaldenso.dnkr.domain.db2.QrPartListDomain;
import com.globaldenso.dnkr.domain.db2.SalesPlanMaterialCostDomain;
import com.globaldenso.dnkr.domain.db2.ShippingSalesDomain;
import com.globaldenso.dnkr.domain.db2.StandardCostHistoryDomain;
import com.globaldenso.dnkr.domain.db2.SupplyShippingDomain;
import com.globaldenso.dnkr.domain.db2.WipReportDomain;
import com.globaldenso.dnkr.domain.db2.YearlyProductShippingDomain;
import com.globaldenso.dnkr.integration.dao.db2.ManagementInformationDao;
import com.globaldenso.dnkr.presentation.form.dwh.WAO001QrPartListForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 로그관리 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("dwhService")
public class ManagementInformationServiceImpl implements ManagementInfomationService {
    /**
     * [KR] 부품입고 관리 Dao <br>
     */
    @Autowired
    private ManagementInformationDao mifDao;
   
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public ManagementInformationServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set DAO of DWH information.<br>
     * [JP] <br>
     * 
     * @param mifDao Dao
     */
    public void setmifDao(ManagementInformationDao mifDao) {
        this.mifDao = mifDao;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByCondition(MaterialReceivingDomain)
     */
    public List<CommonDb2Domain> searchByVennam(CommonDb2Domain domain) throws ApplicationException {
        return mifDao.searchByVennam(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByConditionBm008pr(MaterialReceivingDomain)
     */
    public List<MaterialReceivingDomain> searchByConditionBm008pr(MaterialReceivingDomain domain) throws ApplicationException {
        return mifDao.searchByConditionBm008pr(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#tblBaseSqldwhz001q(MaterialReceivingDomain)
     */
    public List<MaterialReceivingDomain> searchByMaterialReceiving(MaterialReceivingDomain domain) throws ApplicationException {
        return mifDao.searchByMaterialReceiving(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#tblBaseSqldwhz001q(MaterialReceivingDomain)
     */
    public List<PurchasePriceDomain> searchByPurchasePrice(PurchasePriceDomain domain) throws ApplicationException {
    	
    	List<PurchasePriceDomain> purchasePriceList = mifDao.searchByPurchasePrice(domain);
    	List<CommonDb2Domain> vnameList = mifDao.searchByVennam(domain);
    	
    	// VNAME 셋팅
    	for (PurchasePriceDomain purchasePriceDomain : purchasePriceList) {
    		for (CommonDb2Domain commonDb2Domain : vnameList) {
    			if(purchasePriceDomain.getSpcod().trim().equals(commonDb2Domain.getVndnr())) {
    				purchasePriceDomain.setVname(commonDb2Domain.getVname());
    				continue;
    			}
			}
		}

        return purchasePriceList;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#tblBaseSqldwhz001q(MaterialReceivingDomain)
     */
    public List<SalesPlanMaterialCostDomain> searchBySalesPlanMaterialCost(SalesPlanMaterialCostDomain domain) throws ApplicationException {
    	// 4월 분기별로 데이터 셋팅
    	List<String> yearAprilBaseList = UxisCmmUtil.yearAprilBase(Integer.parseInt(domain.getYear()));
    	domain.setYearList(yearAprilBaseList);
    	
    	//조회시작/마지막 년월을 셋팅
    	domain.setStartDate(yearAprilBaseList.get(0));
    	domain.setEndDate(yearAprilBaseList.get((yearAprilBaseList.size()-1)));
    	    	
        return mifDao.searchBySalesPlanMaterialCost(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#tblBaseSqldwhz001q(MaterialReceivingDomain)
     */
    public List<MaterialCostByPeriodDomain> searchByMaterialCostByPeriodList_1(MaterialCostByPeriodDomain domain) throws ApplicationException {
    	
        return mifDao.searchByMaterialCostByPeriodList_1(domain);
    }
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByProductStockShippingReceiving(ProductStockShippingReceivingDomain)
     */
	public List<ProductStockShippingReceivingDomain> searchByProductStockShippingReceiving(ProductStockShippingReceivingDomain domain) throws ApplicationException {
        return mifDao.searchByProductStockShippingReceiving(domain);
    }
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByProductInventory(ProductInventoryDomain)
     */
	public List<ProductInventoryDomain> searchByProductInventory(ProductInventoryDomain domain) throws ApplicationException {
        return mifDao.searchByProductInventory(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#tblBaseSqldwhz001q(MaterialReceivingDomain)
     */
    public List<MaterialCostByPeriodDomain> searchByMaterialCostByPeriodList_2(MaterialCostByPeriodDomain domain) throws ApplicationException {
    	
        return mifDao.searchByMaterialCostByPeriodList_2(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#tblBaseSqldwhz001q(MaterialReceivingDomain)
     */
    public List<MaterialCostByPeriodDomain> standardCostHistoryList(StandardCostHistoryDomain domain) throws ApplicationException {
    	
        return mifDao.searchStandardCostHistoryList(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#tblBaseSqldwhz001q(MaterialReceivingDomain)
     */
    public List<CalculationMaterialDomain> searchByCalculationMaterial(CalculationMaterialDomain domain) throws ApplicationException {
    	// 4월 분기별로 데이터 셋팅
    	List<String> yearAprilBaseList = UxisCmmUtil.yearAprilBase(Integer.parseInt(domain.getYear()));
    	domain.setYearList(yearAprilBaseList);
    	    	
        return mifDao.searchByCalculationMaterial(domain);
    }
    
	 /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByProductInventory(ProductInventoryDomain)
     */
	public List<ImportInventoryDomain> searchByImportInventory(ImportInventoryDomain domain) throws ApplicationException{
        return mifDao.searchByImportInventory(domain);
    }
	public ImportInventoryPopDomain searchByImportInventoryPop1(ImportInventoryPopDomain domain) throws ApplicationException{
        return mifDao.searchByImportInventoryPop1(domain);
    }
	public List<ImportInventoryPopDomain> searchByImportInventoryPop2(ImportInventoryPopDomain domain) throws ApplicationException{
        return mifDao.searchByImportInventoryPop2(domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByImportInventoryHouse(MaterialInventoryDomain)
     */
	public List<MaterialInventoryDomain> searchByMaterialInventoryHouse(MaterialInventoryDomain domain) throws ApplicationException{
        return mifDao.searchByMaterialInventoryHouse(domain);
    }	
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByDwhCount(DataWarehouseFileDomain)
     */
	public DataWarehouseFileDomain searchByDwhCount(DataWarehouseFileDomain domain) throws ApplicationException{
        return mifDao.searchByDwhCount(domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByProductInventory(MaterialInventoryDomain)
     */
	public List<MaterialInventoryDomain> searchByMaterialInventory(MaterialInventoryDomain domain) throws ApplicationException{
        return mifDao.searchByMaterialInventory(domain);
    }

	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByProductInventoryCost(ProductInventoryDomain)
     */
	public List<ProductInventoryDomain> searchByProductInventoryCost(ProductInventoryDomain domain) throws ApplicationException{
        return mifDao.searchByProductInventoryCost(domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByMaterialWaste(MaterialWasteDomain)
     */
	public List<MaterialWasteDomain> searchByMaterialWaste(MaterialWasteDomain domain) throws ApplicationException{
        return mifDao.searchByMaterialWaste(domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByMaterialScrapTicket(MaterialWasteDomain)
     */
	public List<MaterialWasteDomain> searchByMaterialScrapTicket(MaterialWasteDomain domain) throws ApplicationException{
        return mifDao.searchByMaterialScrapTicket(domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchBySupplyShipping(SupplyShippingDomain)
     */
	public List<SupplyShippingDomain> searchBySupplyShipping(SupplyShippingDomain domain) throws ApplicationException{
        return mifDao.searchBySupplyShipping(domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByWipReport(WipReportDomain)
     */
	public List<WipReportDomain> searchByWipReport(WipReportDomain domain) throws ApplicationException{
        return mifDao.searchByWipReport(domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByProductionRecord(ProductionRecordDomain)
     */
	public List<ProductionRecordDomain> searchByProductionRecord(ProductionRecordDomain domain) throws ApplicationException{
        return mifDao.searchByProductionRecord(domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByProductShippingReceiving(MaterialWasteDomain)
     */
	public List<ProductShippingReceivingDomain> searchByProductShippingReceiving(ProductShippingReceivingDomain domain) throws ApplicationException{
        return mifDao.searchByProductShippingReceiving(domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByYearlyProductShipping(YearlyProductShippingDomain)
     */	
	public List<HashMap<String, String>> searchByYearlyProductShipping(YearlyProductShippingDomain domain) throws ApplicationException{
        return mifDao.searchByYearlyProductShipping(domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByShippingSales(ShippingSalesDomain)
     */
	public List<ShippingSalesDomain> searchByShippingSales(ShippingSalesDomain domain) throws ApplicationException{
        return mifDao.searchByShippingSales(domain);
	}
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByBusinessShippingMaterial(BusinessShippingMaterialDomain)
     */
	public List<BusinessShippingMaterialDomain> searchByBusinessShippingMaterial(BusinessShippingMaterialDomain domain) throws ApplicationException{
        return mifDao.searchByBusinessShippingMaterial(domain);
	}
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByBusinessShipping(BusinessShippingDomain)
     */
	public List<BusinessShippingDomain> searchByBusinessShipping(BusinessShippingDomain domain) throws ApplicationException{
        return mifDao.searchByBusinessShipping(domain);
	}
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByMonthlyShippingList(MonthlyShippingListDomain)
     */
	public List<MonthlyShippingListDomain> searchByMonthlyShippingList(MonthlyShippingListDomain domain) throws ApplicationException{
        return mifDao.searchByMonthlyShippingList(domain);
	}
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByMonthlySalesPlan(MonthlySalesPlanDomain)
     */
	public List<MonthlySalesPlanDomain> searchByMonthlySalesPlan(MonthlySalesPlanDomain domain) throws ApplicationException{
        return mifDao.searchByMonthlySalesPlan(domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByAccountSituation(AccountSituationDomain)
     */
	public List<AccountSituationDomain> searchByAccountSituation(AccountSituationDomain domain) throws ApplicationException{
        return mifDao.searchByAccountSituation(domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByFakeSalesCheckList(FakeSalesCheckListDomain)
     */
	public List<FakeSalesCheckListDomain> searchByFakeSalesCheckList(FakeSalesCheckListDomain domain) throws ApplicationException{
        return mifDao.searchByFakeSalesCheckList(domain);
    }
	
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByOceansList(OceanListDomain)
     */
	public List<OceanListDomain> searchByOceansList(OceanListDomain domain)throws ApplicationException{
	     return mifDao.searchByOceansList(domain);
    }
	
	private void getJobYear(OceanListDomain domain) {
		DataWarehouseFileDomain dwhDomain = new DataWarehouseFileDomain();
		dwhDomain.setLib2(domain.getLib2());
		dwhDomain.setJobFileName(domain.getJobFileName());
		String year = "";
		
		try {
			year = mifDao.searchByDwhCount(dwhDomain).getJyymm();
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
	}
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByOceanListSalesRevenue(searchByOceanListSalesRevenue)
     */
	public List<OceanListSalesRevenueDomain> searchByOceanListSalesRevenue(OceanListSalesRevenueDomain domain) throws ApplicationException{
        return mifDao.searchByOceanListSalesRevenue(domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByMonthlyShipmentCheckList(MonthlyShipmentCheckDomain)
     */
	public List<MonthlyShipmentCheckDomain> searchByMonthlyShipmentCheckList(MonthlyShipmentCheckDomain domain) throws ApplicationException{
        return mifDao.searchByMonthlyShipmentCheckList(domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByDomesticPurchasePriceList(DomesticPurchasePriceListDomain)
     */
	public List<DomesticPurchasePriceListDomain> searchByDomesticPurchasePriceList(DomesticPurchasePriceListDomain domain) throws ApplicationException{
        return mifDao.searchByDomesticPurchasePriceList(domain);
    }

	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByImportsTrade(ImportsTradeDomain)
     */
	public List<ImportsTradeDomain> searchByImportsTrade(ImportsTradeDomain domain) throws ApplicationException{
        return mifDao.searchByImportsTrade(domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByImportsTrade(ImportsTradeDomain)
     */
	public List<ImportDressingHistoryDomain> searchByImportDressingHistory(ImportDressingHistoryDomain domain) throws ApplicationException{
        return mifDao.searchByImportDressingHistory(domain);
        /*
    	List<ImportDressingHistoryDomain> importDressingHistoryList = mifDao.searchByImportDressingHistory(domain);
    	List<CommonDb2Domain> vnameList = mifDao.searchByVennam(domain);
    	
    	// VNAME 셋팅
    	for (ImportDressingHistoryDomain importDressingHistoryDomain : importDressingHistoryList) {
    		for (CommonDb2Domain commonDb2Domain : vnameList) {
    			if(importDressingHistoryDomain.getVndnr().trim().equals(commonDb2Domain.getVndnr())) {
    				importDressingHistoryDomain.setVname(commonDb2Domain.getVname());
    				continue;
    			}
			}
		}

        return importDressingHistoryList;
        */
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByMonthlyImportsProduct(MonthlyImportsProductDomain)
     */
	public List<MonthlyImportsProductDomain> searchByMonthlyImportsProduct(MonthlyImportsProductDomain domain) throws ApplicationException{
        return mifDao.searchByMonthlyImportsProduct(domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByMonthlyDivisionRatio(MonthlyDivisionRatioDomain)
     */
	public List<MonthlyDivisionRatioDomain> searchByMonthlyDivisionRatio(MonthlyDivisionRatioDomain domain) throws ApplicationException{
        return mifDao.searchByMonthlyDivisionRatio(domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByDailyDepartmentCost(DailyDepartmentCostDomain)
     */
	public List<DailyDepartmentCostDomain> searchByDailyDepartmentCost(DailyDepartmentCostDomain domain) throws ApplicationException{
        return mifDao.searchByDailyDepartmentCost(domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByDailyDepartmentCost(DailyDepartmentCostDomain)
     */
	public List<DuplicationPartDomain> searchByDupPartCheck(DuplicationPartDomain domain) throws ApplicationException{
        return mifDao.searchByDupPartCheck(domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByDailyDepartmentCost(DailyDepartmentCostDomain)
     */
	public List<HvacSpoolDomain> searchByHvacSpool(HvacSpoolDomain domain) throws ApplicationException{
        return mifDao.searchByHvacSpool(domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByDailyDepartmentCost(DailyDepartmentCostDomain)
     */
	public QrPartListDomain searchByPartName(QrPartListDomain domain) throws ApplicationException{
        return mifDao.searchByPartName(domain);
    }
	
	public List<QrPartListDomain> searchByQrPartList(WAO001QrPartListForm form) throws ApplicationException{
		// 결과 리스트 
		List<QrPartListDomain> resultList = new ArrayList<QrPartListDomain>();
		
		// 중복 제거
		String[] conditionPartArray = form.getConditionPart();
		Integer[] quantityArray = form.getConditionQuantity();
		
		//conditionPartArray = new HashSet<String>(Arrays.asList(conditionPartArray)).toArray(new String[0]);
		
		for(int x=0; x< conditionPartArray.length; x++) {
			
			List<QrPartListDomain> tempList = mifDao.searchByQrPartList(conditionPartArray[x]);
			
			for (int i=0; i< tempList.size(); i++) {
				QrPartListDomain tempDomain = (QrPartListDomain) tempList.get(i);
				
				if("0".equals(tempDomain.getIttyp())) {
					
					// 가상 팬텀의 리스트 하위 품번 리스트로 교체 
					List<QrPartListDomain> FantomPartList = mifDao.searchByQrPartList(tempDomain.getCinbr());
					
					for (QrPartListDomain fantomPartListDomain : FantomPartList) {
						// 가상 팬텀의 수량 * 하위 품번 수량
						fantomPartListDomain.setQtypr(tempDomain.getQtypr() * fantomPartListDomain.getQtypr());
					}

					//tempList.remove(i);
					tempList.addAll(FantomPartList);		
				}
				
				// 소요량 계산
				tempDomain.setCalculateQtypr((tempDomain.getQtypr() * quantityArray[x]));
				
				// 같은 리스트가 존재하면 제외시키고 추가로 계산하여 ADD
				for(int y=0; y<resultList.size(); y++) {
					QrPartListDomain resultDomain = (QrPartListDomain)resultList.get(y);
					if(resultDomain.getCinbr().equals(tempDomain.getCinbr())){	
						tempDomain.setCalculateQtypr(resultDomain.getCalculateQtypr() + tempDomain.getCalculateQtypr());
						resultList.remove(y);
					}
				}
				
				// 팬텀이 아닐때만 등록
				if(!"0".equals(tempDomain.getIttyp())) {
					resultList.add(tempDomain);
				}
				
			}
			// 최초는 조회
			/* if( x==0 ) {
				resultList = mifDao.searchByQrPartList(conditionPartArray[x]);
				
				for (int i=0; i< resultList.size(); i++) {
					QrPartListDomain resultDomain = (QrPartListDomain) resultList.get(i);
					if("0".equals(resultDomain.getIttyp())) {
						List<QrPartListDomain> changePartList = mifDao.searchByQrPartList(resultDomain.getCinbr());
						resultList.remove(i);
						resultList.addAll(changePartList);						
					}
				}
			} else {
				resultList = mifDao.searchByQrPartList(conditionPartArray[x]);
			} */ 
		}
		resultList.sort(Comparator.comparing(QrPartListDomain::getWhslcdesc).thenComparing(QrPartListDomain::getCinbr));
		return resultList;
	}
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByAccountingJournal(AccountingJournalDomain)
     */
	public List<AccountingJournalDomain> searchByAccountingJournal(AccountingJournalDomain domain) throws ApplicationException{
        return mifDao.searchByAccountingJournal(domain);
	}
	
	public int searchByAccountingJournalCnt(AccountingJournalDomain domain) throws ApplicationException{
        return mifDao.searchByAccountingJournalCnt(domain);
	}
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.ManagementInfomationService#searchByJdeBudget(JdeBudgetDomain)
     */
	public List<JdeBudgetDomain> searchByJdeBudget(JdeBudgetDomain domain) throws ApplicationException{
        //return mifDao.searchByJdeBudget(domain);

		/*
		List<JdeBudgetDomain> tempList = mifDao.searchByJdeBudget(domain);
		List<JdeBudgetDomain> returnList = new ArrayList<JdeBudgetDomain>();
		
		
    	List<CommonDb2Domain> vnameList = mifDao.searchByVennam(domain);
    	
    	// VNAME 셋팅
    	for (JdeBudgetDomain JdeBudgetDomain : tempList) {
    		for (CommonDb2Domain commonDb2Domain : vnameList) {
    			if(JdeBudgetDomain.getVndnr().trim().equals(commonDb2Domain.getVndnr())) {
    				JdeBudgetDomain.setVname(commonDb2Domain.getVname());
    				continue;
    			}
			}
    		
    	}
    	*/

		List<JdeBudgetDomain> tempList = mifDao.searchByJdeBudget(domain);
		JdeBudgetDomain criteria = new JdeBudgetDomain();
		double totBudgetPlt = 0; //회계년도 합계(계획)
		double totBudgetRlt= 0; //회계년도 합계(실적)
		double totBudgetDif= 0; //회계년도 합계(차이)
		String totBucdSPlt; //BU코드 합계(계획)
		String totBucdSRlt; //BU코드 합계(실적)
		String totBucdSDif; //BU코드 합계(차이)
		String totDptcdPlt; //부서코드 합계(계획)
		String totDptcdRlt;//부서코드 합계(실적)
		String totDptcdDif;//부서코드 합계(차이)
		String totAccPlt;//계정코드 합계(계획)
		String totAccRlt;//계정코드 합계(실적)
		String totAccDif;//계정코드 합계(차이)
		
		for (JdeBudgetDomain JdeBudgetDomain : tempList) {
/*			 System.out.println(JdeBudgetDomain.getBudYear()+"||"+JdeBudgetDomain.getGbmcu()+"||"+JdeBudgetDomain.getMcdc()+"||"+JdeBudgetDomain.getGbsbl()+"||"+
					 JdeBudgetDomain.getGbobj()+"||"+ JdeBudgetDomain.getGbsub()+"||"+JdeBudgetDomain.getGblt());
*/
			 System.out.println(JdeBudgetDomain.getBudYear()+"||"+JdeBudgetDomain.getGbmcu()+"||"+JdeBudgetDomain.getGbsbl()+"||"+
					 JdeBudgetDomain.getGbobj()+"||"+ JdeBudgetDomain.getGbsub()+"||"+JdeBudgetDomain.getGblt()+"||"+
					 JdeBudgetDomain.getSortSeq()+"||"+JdeBudgetDomain.getTotGban());
			 if("A".equals(JdeBudgetDomain.getSortSeq())) {
				 totBudgetPlt += Double.parseDouble(JdeBudgetDomain.getTotGban());
			 }
			 if("B".equals(JdeBudgetDomain.getSortSeq())) {
				 totBudgetRlt += Double.parseDouble(JdeBudgetDomain.getTotGban());
			 }
			 if("C".equals(JdeBudgetDomain.getSortSeq())) {
				 totBudgetDif += Double.parseDouble(JdeBudgetDomain.getTotGban());
			 }
			 System.out.println(totBudgetPlt+"||"+totBudgetRlt+"||"+totBudgetDif);
		}
        return tempList;
	}

	public List<ImportProgressDomain> searchByImportProgress(ImportProgressDomain domain) throws ApplicationException{
        return mifDao.searchByImportProgress(domain);
	}

}
