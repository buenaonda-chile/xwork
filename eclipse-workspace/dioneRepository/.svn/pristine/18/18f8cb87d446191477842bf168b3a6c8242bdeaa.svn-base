package com.globaldenso.dnkr.business.service.db2;

import java.util.HashMap;
import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.db2.AccountSituationDomain;
import com.globaldenso.dnkr.domain.db2.AccountingJournalDomain;
import com.globaldenso.dnkr.domain.db2.BusinessShippingDomain;
import com.globaldenso.dnkr.domain.db2.BusinessShippingMaterialDomain;
import com.globaldenso.dnkr.domain.db2.CalculationMaterialDomain;
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
import com.globaldenso.dnkr.presentation.form.dwh.WAO001QrPartListForm;

/**
 * [KR] 부품입고 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface ManagementInfomationService {

    /**
     * [EN] Search DWHDomain information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'DWHDomain' class
     * @return List of 'DWHDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<CommonDb2Domain> searchByVennam(CommonDb2Domain domain) throws ApplicationException;
    
  
    /**
     * [EN] Search DataWareHouse information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'DWHDomain' class
     * @return List of 'DWHDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<MaterialReceivingDomain> searchByConditionBm008pr(MaterialReceivingDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search MatrerialReceiving information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'DWHDomain' class
     * @return List of 'DWHDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<MaterialReceivingDomain> searchByMaterialReceiving(MaterialReceivingDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'PurchasePirceDomain' class
     * @return List of 'PurchasePirceDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<PurchasePriceDomain> searchByPurchasePrice(PurchasePriceDomain domain) throws ApplicationException;


	public List<SalesPlanMaterialCostDomain> searchBySalesPlanMaterialCost(SalesPlanMaterialCostDomain form) throws ApplicationException;


	public List<MaterialCostByPeriodDomain> searchByMaterialCostByPeriodList_1(MaterialCostByPeriodDomain form) throws ApplicationException;
	
	public List<MaterialCostByPeriodDomain> searchByMaterialCostByPeriodList_2(MaterialCostByPeriodDomain form) throws ApplicationException;
    

	public List<MaterialCostByPeriodDomain> standardCostHistoryList(StandardCostHistoryDomain form) throws ApplicationException;	

	public List<CalculationMaterialDomain> searchByCalculationMaterial(CalculationMaterialDomain form) throws ApplicationException;
	
	 /**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'ProductStockShippingReceivingDomain' class
     * @return List of 'ProductStockShippingReceivingDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<ProductStockShippingReceivingDomain> searchByProductStockShippingReceiving(ProductStockShippingReceivingDomain domain) throws ApplicationException;

	 /**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'ProductInventoryDomain' class
     * @return List of 'ProductInventoryDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<ProductInventoryDomain> searchByProductInventory(ProductInventoryDomain domain) throws ApplicationException;
	
	 /**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'ProductInventoryDomain' class
     * @return List of 'ProductInventoryDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<ImportInventoryDomain> searchByImportInventory(ImportInventoryDomain domain) throws ApplicationException;
	 /**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'ImportInventoryPopDomain' class
     * @return List of 'ImportInventoryPopDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public ImportInventoryPopDomain searchByImportInventoryPop1(ImportInventoryPopDomain domain) throws ApplicationException;
	public List<ImportInventoryPopDomain> searchByImportInventoryPop2(ImportInventoryPopDomain domain) throws ApplicationException;
	
	
	
	 /**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'ProductInventoryDomain' class
     * @return List of 'ProductInventoryDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<MaterialInventoryDomain> searchByMaterialInventoryHouse(MaterialInventoryDomain domain) throws ApplicationException;	
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'DataWarehouseFileDomain' class
     * @return List of 'DataWarehouseFileDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	
	public DataWarehouseFileDomain searchByDwhCount(DataWarehouseFileDomain domain) throws ApplicationException;
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'ProductInventoryDomain' class
     * @return List of 'ProductInventoryDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<MaterialInventoryDomain> searchByMaterialInventory(MaterialInventoryDomain domain) throws ApplicationException;

	
	 /**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'ProductInventoryDomain' class
     * @return List of 'ProductInventoryDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<ProductInventoryDomain> searchByProductInventoryCost(ProductInventoryDomain domain) throws ApplicationException;
	
	 /**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'MaterialWasteDomain' class
     * @return List of 'MaterialWasteDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<MaterialWasteDomain> searchByMaterialWaste(MaterialWasteDomain domain) throws ApplicationException;
	
	 /**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'MaterialWasteDomain' class
     * @return List of 'MaterialWasteDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<MaterialWasteDomain> searchByMaterialScrapTicket(MaterialWasteDomain domain) throws ApplicationException;
	
	
	 /**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'SupplyShippingDomain' class
     * @return List of 'SupplyShippingDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<SupplyShippingDomain> searchBySupplyShipping(SupplyShippingDomain domain) throws ApplicationException;
	
	 /**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'WipReportDomain' class
     * @return List of 'WipReportDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<WipReportDomain> searchByWipReport(WipReportDomain domain) throws ApplicationException;
	
	 /**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'MaterialWasteDomain' class
     * @return List of 'MaterialWasteDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<ProductionRecordDomain> searchByProductionRecord(ProductionRecordDomain domain) throws ApplicationException;
	
	 /**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'MaterialWasteDomain' class
     * @return List of 'MaterialWasteDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<ProductShippingReceivingDomain> searchByProductShippingReceiving(ProductShippingReceivingDomain domain) throws ApplicationException;
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'YearlyProductShippingDomain' class
     * @return List of 'YearlyProductShippingDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<HashMap<String, String>> searchByYearlyProductShipping(YearlyProductShippingDomain domain) throws ApplicationException;
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'ShippingSalesDomain' class
     * @return List of 'ShippingSalesDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<ShippingSalesDomain> searchByShippingSales(ShippingSalesDomain domain) throws ApplicationException;
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'BusinessShippingMaterialDomain' class
     * @return List of 'BusinessShippingMaterialDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<BusinessShippingMaterialDomain> searchByBusinessShippingMaterial(BusinessShippingMaterialDomain domain) throws ApplicationException;
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'BusinessShippingDomain' class
     * @return List of 'BusinessShippingDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<BusinessShippingDomain> searchByBusinessShipping(BusinessShippingDomain domain) throws ApplicationException;
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'MonthlyShippingListDomain' class
     * @return List of 'MonthlyShippingListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<MonthlyShippingListDomain> searchByMonthlyShippingList(MonthlyShippingListDomain domain) throws ApplicationException;
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'MonthlySalesPlanDomain' class
     * @return List of 'MonthlySalesPlanDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<MonthlySalesPlanDomain> searchByMonthlySalesPlan(MonthlySalesPlanDomain domain) throws ApplicationException;
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'AccountSituationDomain' class
     * @return List of 'AccountSituationDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<AccountSituationDomain> searchByAccountSituation(AccountSituationDomain domain) throws ApplicationException;
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'FakeSalesCheckListDomain' class
     * @return List of 'FakeSalesCheckListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<FakeSalesCheckListDomain> searchByFakeSalesCheckList(FakeSalesCheckListDomain domain) throws ApplicationException;

	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'OceanListDomain' class
     * @return List of 'OceanListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */	
	public List<OceanListDomain> searchByOceansList(OceanListDomain domain) throws ApplicationException;

	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'OceanListSalesRevenueDomain' class
     * @return List of 'OceanListSalesRevenueDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<OceanListSalesRevenueDomain> searchByOceanListSalesRevenue(OceanListSalesRevenueDomain domain) throws ApplicationException;
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'MonthlyShipmentCheckDomain' class
     * @return List of 'MonthlyShipmentCheckDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<MonthlyShipmentCheckDomain> searchByMonthlyShipmentCheckList(MonthlyShipmentCheckDomain domain) throws ApplicationException;
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'DomesticPurchasePriceListDomain' class
     * @return List of 'DomesticPurchasePriceListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<DomesticPurchasePriceListDomain> searchByDomesticPurchasePriceList(DomesticPurchasePriceListDomain domain) throws ApplicationException;
	
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'ImportsTradeDomain' class
     * @return List of 'ImportsTradeDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */	
	public List<ImportsTradeDomain> searchByImportsTrade(ImportsTradeDomain domain) throws ApplicationException;

	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'ImportDressingHistoryDomain' class
     * @return List of 'ImportDressingHistoryDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */	
	public List<ImportDressingHistoryDomain> searchByImportDressingHistory(ImportDressingHistoryDomain domain) throws ApplicationException;
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'ImportDressingHistoryDomain' class
     * @return List of 'ImportDressingHistoryDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */	
	public List<MonthlyImportsProductDomain> searchByMonthlyImportsProduct(MonthlyImportsProductDomain domain) throws ApplicationException;
	
	public List<MonthlyDivisionRatioDomain> searchByMonthlyDivisionRatio(MonthlyDivisionRatioDomain domain) throws ApplicationException;
	
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'DailyDepartmentCostDomain' class
     * @return List of 'DailyDepartmentCostDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */	
	public List<DailyDepartmentCostDomain> searchByDailyDepartmentCost(DailyDepartmentCostDomain domain) throws ApplicationException;
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'ShippingSalesDomain' class
     * @return List of 'ShippingSalesDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<DuplicationPartDomain> searchByDupPartCheck(DuplicationPartDomain domain) throws ApplicationException;


	public List<HvacSpoolDomain> searchByHvacSpool(HvacSpoolDomain domain) throws ApplicationException;
	
	public QrPartListDomain searchByPartName(QrPartListDomain domain) throws ApplicationException;

	public List<QrPartListDomain> searchByQrPartList(WAO001QrPartListForm form) throws ApplicationException;

	
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'AccountingJournalDomain' class
     * @return List of 'AccountingJournalDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */	
	public List<AccountingJournalDomain> searchByAccountingJournal(AccountingJournalDomain domain) throws ApplicationException;
	
	public int searchByAccountingJournalCnt(AccountingJournalDomain domain) throws ApplicationException;
	
	
	/**
     * [EN] Search Purchase Price information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'JdeBudgetDomain' class
     * @return List of 'JdeBudgetDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */	
	public List<JdeBudgetDomain> searchByJdeBudget(JdeBudgetDomain domain) throws ApplicationException;
}
