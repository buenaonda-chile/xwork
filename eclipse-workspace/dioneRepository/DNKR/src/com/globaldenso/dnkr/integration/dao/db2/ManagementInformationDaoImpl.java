package com.globaldenso.dnkr.integration.dao.db2;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

/**
 * [KO] DataWareHouse 정보 클래스의 DAO 구현클래스이다. <br>
 * [EN] It is DAO implementation class of DataWareHouse information.<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("ManagementInformationDao")
public class ManagementInformationDaoImpl implements ManagementInformationDao {


    /**
     * [EN] Namespace of SQLMap.<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.db2.ManagementInformationDao";
    
    /**
     * 
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate4")
    private SqlSessionTemplate sqlSessionTemplate4 = null;
    
    
    /**
     * [EN] Default constructor.<br>
     */
    public ManagementInformationDaoImpl() {
        // no process
    }
    
    
    /**
     * [EN] It is a setter method of sqlSessionTemplate4.<br>
     * 
     * @param sqlSessionTemplate sqlSessionTemplate に設定する
     */
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate4 = sqlSessionTemplate;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByCondition(MaterialReceivingDomain)
     */
    public List<CommonDb2Domain> searchByVennam(CommonDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByVennam", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByConditionBm008pr(MaterialReceivingDomain)
     */
    public List<MaterialReceivingDomain> searchByConditionBm008pr(MaterialReceivingDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionBm008pr", domain);
    }
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#tblBaseSqldwhz001q(MaterialReceivingDomain)
     */
    public List<MaterialReceivingDomain> searchByMaterialReceiving(MaterialReceivingDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMaterialReceiving", domain);
    }
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#tblBaseSqldwhz001q(MaterialReceivingDomain)
     */
    public List<PurchasePriceDomain> searchByPurchasePrice(PurchasePriceDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByPurchasePrice", domain);
    }
    public List<MaterialCostByPeriodDomain> searchStandardCostHistoryList(StandardCostHistoryDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByStandardCostHistoryList", domain);
    }
    
    public List<CalculationMaterialDomain> searchByCalculationMaterial(CalculationMaterialDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCalculationMaterial", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#tblBaseSqldwhz001q(MaterialReceivingDomain)
     */
    public List<SalesPlanMaterialCostDomain> searchBySalesPlanMaterialCost(SalesPlanMaterialCostDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchBySalesPlanMaterialCost", domain);
    }
    
    public List<MaterialCostByPeriodDomain> searchByMaterialCostByPeriodList_1(MaterialCostByPeriodDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMaterialCostByPeriod_1", domain);
    }
    
    public List<MaterialCostByPeriodDomain> searchByMaterialCostByPeriodList_2(MaterialCostByPeriodDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMaterialCostByPeriod_2", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByProductStockShippingReceiving(ProductStockShippingReceivingDomain)
     */
	public List<ProductStockShippingReceivingDomain> searchByProductStockShippingReceiving(ProductStockShippingReceivingDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByProductStockShippingReceiving", domain);
    }
 
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByProductInventory(ProductInventoryDomain)
     */	
	public List<ProductInventoryDomain> searchByProductInventory(ProductInventoryDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByProductInventory", domain);
    }
	
	 /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByImportInventory(ImportInventoryDomain)
     */	
	public List<ImportInventoryDomain> searchByImportInventory(ImportInventoryDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByImportInventory", domain);
    }
	public ImportInventoryPopDomain searchByImportInventoryPop1(ImportInventoryPopDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByImportInventoryPop1", domain);
    }
	public List<ImportInventoryPopDomain> searchByImportInventoryPop2(ImportInventoryPopDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByImportInventoryPop2", domain);
    }
	
	 /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByImportInventoryHouse(MaterialInventoryDomain)
     */
	public List<MaterialInventoryDomain> searchByMaterialInventoryHouse(MaterialInventoryDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMaterialInventoryHouse", domain);
    }
	 /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByDwhCount(DataWarehouseFileDomain)
     */
	public DataWarehouseFileDomain searchByDwhCount(DataWarehouseFileDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByDwhCount", domain);
    }
	
	 /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByMaterialInventory(MaterialInventoryDomain)
     */
	public List<MaterialInventoryDomain> searchByMaterialInventory(MaterialInventoryDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMaterialInventory", domain);
    }   
 
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByProductInventoryCost(ProductInventoryDomain)
     */
	public List<ProductInventoryDomain> searchByProductInventoryCost(ProductInventoryDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByProductInventoryCost", domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByMaterialWaste(MaterialWasteDomain)
     */
	public List<MaterialWasteDomain> searchByMaterialWaste(MaterialWasteDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMaterialWaste", domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByMaterialScrapTicket(MaterialWasteDomain)
     */
	public List<MaterialWasteDomain> searchByMaterialScrapTicket(MaterialWasteDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMaterialScrapTicket", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchBySupplyShipping(SupplyShippingDomain)
     */
	public List<SupplyShippingDomain> searchBySupplyShipping(SupplyShippingDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchBySupplyShipping", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByWipReport(WipReportDomain)
     */
	public List<WipReportDomain> searchByWipReport(WipReportDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByWipReport", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByProductionRecord(ProductionRecordDomain)
     */
	public List<ProductionRecordDomain> searchByProductionRecord(ProductionRecordDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByProductionRecord", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByProductShippingReceiving(ProductShippingReceivingDomain)
     */
	public List<ProductShippingReceivingDomain> searchByProductShippingReceiving(ProductShippingReceivingDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByProductShippingReceiving", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByYearlyProductShipping(YearlyProductShippingDomain)
     */
	public List<HashMap<String, String>> searchByYearlyProductShipping(YearlyProductShippingDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByYearlyProductShipping", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByShippingSales(ShippingSalesDomain)
     */
	public List<ShippingSalesDomain> searchByShippingSales(ShippingSalesDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByShippingSales", domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByBusinessShippingMaterial(BusinessShippingMaterialDomain)
     */
	public List<BusinessShippingMaterialDomain> searchByBusinessShippingMaterial(BusinessShippingMaterialDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByBusinessShippingMaterial", domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByBusinessShipping(BusinessShippingDomain)
     */
	public List<BusinessShippingDomain> searchByBusinessShipping(BusinessShippingDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByBusinessShipping", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByMonthlyShippingList(MonthlyShippingListDomain)
     */
	public List<MonthlyShippingListDomain> searchByMonthlyShippingList(MonthlyShippingListDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMonthlyShippingList", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByMonthlySalesPlan(MonthlySalesPlanDomain)
     */
	public List<MonthlySalesPlanDomain> searchByMonthlySalesPlan(MonthlySalesPlanDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMonthlySalesPlan", domain);
    }
	
	/**
    * {@inheritDoc}
    * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByAccountSituation(AccountSituationDomain)
    */
	public List<AccountSituationDomain> searchByAccountSituation(AccountSituationDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByAccountSituation", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByFakeSalesCheckList(FakeSalesCheckListDomain)
     */
	public List<FakeSalesCheckListDomain> searchByFakeSalesCheckList(FakeSalesCheckListDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByFakeSalesCheckList", domain);
    }
	

	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByOceansList(OceanListDomain)
     */
	public List<OceanListDomain> searchByOceansList(OceanListDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByOceansList", domain);
		
	}
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByOceanListSalesRevenue(OceanListSalesRevenueDomain)
     */
	public List<OceanListSalesRevenueDomain> searchByOceanListSalesRevenue(OceanListSalesRevenueDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByOceanListSalesRevenue", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByMonthlyShipmentCheckList(MonthlyShipmentCheckDomain)
     */
	public List<MonthlyShipmentCheckDomain> searchByMonthlyShipmentCheckList(MonthlyShipmentCheckDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMonthlyShipmentCheckList", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByDomesticPurchasePriceList(DomesticPurchasePriceListDomain)
     */
	public List<DomesticPurchasePriceListDomain> searchByDomesticPurchasePriceList(DomesticPurchasePriceListDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByDomesticPurchasePriceList", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByImportsTrade(ImportsTradeDomain)
     */
	public List<ImportsTradeDomain> searchByImportsTrade(ImportsTradeDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByImportsTrade", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByImportDressingHistory(ImportDressingHistoryDomain)
     */
	public List<ImportDressingHistoryDomain> searchByImportDressingHistory(ImportDressingHistoryDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByImportDressingHistory", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByImportDressingHistory(ImportDressingHistoryDomain)
     */
	public List<MonthlyImportsProductDomain> searchByMonthlyImportsProduct(MonthlyImportsProductDomain domain) throws ApplicationException{
	    return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMonthlyImportsProduct", domain);
	}
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByImportDressingHistory(ImportDressingHistoryDomain)
     */
	public List<MonthlyDivisionRatioDomain> searchByMonthlyDivisionRatio(MonthlyDivisionRatioDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMonthlyDivisionRatio", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByMonthlyDepartmentCost(DailyDepartmentCostDomain)
     */
	public List<DailyDepartmentCostDomain> searchByDailyDepartmentCost(DailyDepartmentCostDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByDailyDepartmentCost", domain);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByMonthlyDepartmentCost(DailyDepartmentCostDomain)
     */
	public List<DuplicationPartDomain> searchByDupPartCheck(DuplicationPartDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByDupPartCheck", domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByMonthlyDepartmentCost(DailyDepartmentCostDomain)
     */
	public List<HvacSpoolDomain> searchByHvacSpool(HvacSpoolDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByHvacSpool", domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByMonthlyDepartmentCost(DailyDepartmentCostDomain)
     */
	public QrPartListDomain searchByPartName(QrPartListDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByPartName", domain);
    }
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByMonthlyDepartmentCost(DailyDepartmentCostDomain)
     */
	public List<QrPartListDomain> searchByQrPartList(String partNum) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByQrPartList", partNum);
    }
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByAccountingJournal(AccountingJournalDomain)
     */
	public List<AccountingJournalDomain> searchByAccountingJournal(AccountingJournalDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByAccountingJournal", domain);
    }

	public int searchByAccountingJournalCnt(AccountingJournalDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByAccountingJournalCnt", domain);
    }
	
	
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DWHManagementDao#searchByJdeBudget(JdeBudgetDomain)
     */
	public List<JdeBudgetDomain> searchByJdeBudget(JdeBudgetDomain domain) throws ApplicationException{
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByJdeBudget", domain);
    }
}
