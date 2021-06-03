package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderDomain;
import com.globaldenso.dnkr.domain.OrderQtyDomain;
import com.globaldenso.dnkr.domain.db2.OrderDb2Domain;
import com.globaldenso.dnkr.integration.dao.OrderDao;
import com.globaldenso.dnkr.uxis.UxisStringUtil;

/**
 * [KR] 수주업로드 서비스 구현 <br>
 * [EN] Service implementation of contract information.
 * [JP] 
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    /**
     * [KR] 수주업로드 Dao <br>
     * [EN] A field of ContractDao.<br>
     * [JP] ContractDaoのフィールド。<br>
     */
    @Autowired
    private OrderDao orderDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public OrderServiceImpl() {
        // no process
    }
    
    /**
     * [KO] 수주업로드 Dao 의 setter 메소드
     * [EN] Set DAO of contract information.<br>
     * [JP] 。<br>
     *
     * @param orderDao 'OrderDao' class 
     */
    public void setContractDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ContractService#searchByCondition(OrderDomain)
     */
    @Override
    public List<OrderDomain> searchByCondition(OrderDomain domain) throws ApplicationException {
        return orderDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ContractService#searchByCondition(OrderDomain)
     */
    @Override
    public List<OrderQtyDomain> searchByQtyCondition(OrderQtyDomain domain) throws ApplicationException {
        return orderDao.searchByConditionQty(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ContractService#searchByCondition(OrderDomain)
     */
    @Override
    public List<OrderDomain> searchByTotalCondition(OrderDomain domain) throws ApplicationException {
        
        List<OrderDomain> orderList = orderDao.searchByCondition(domain);
        
        for(int i = 0; i < orderList.size(); i++){
            OrderDomain tempDomain = orderList.get(i);
            OrderQtyDomain qtyDomain = new OrderQtyDomain();
            qtyDomain.setOrderKey(tempDomain.getOrderKey());
            tempDomain.setQtyList(orderDao.searchByConditionQty(qtyDomain));
        }
        
        return orderDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ContractService#searchByCondition(OrderDomain)
     */
    @Override
    public List<OrderDomain> getReleaseDate(OrderDomain domain) throws ApplicationException {
        return orderDao.getReleaseDate(domain);
    }
    
    /**
     * {@inheritDoc}
     * @throws ParseException 
     * @throws java.text.ParseException 
     * 
     * @see com.globaldenso.dnkr.business.service.ContractService#create(OrderDomain)
     */
    public void orderCreateAll(List<OrderDomain> domainList, String stockQry, String stockDailyQry) throws ApplicationException, ParseException, java.text.ParseException {
        
        OrderDomain chkDomain = new OrderDomain();
        //chkDomain.setMeterialNumber(domain.getMeterialNumber());;
        chkDomain.setReleaseDate(domainList.get(0).getReleaseDate());
        //System.out.println("meterail : " + domainList.get(0).getMeterialNumber() + "  releaseDate : " + domainList.get(0).getReleaseDate());
        
        int orderCnt = orderDao.searchCount(chkDomain);
        
        if(orderCnt > 0){
            
            List<OrderDomain> orderList = orderDao.searchByCondition(chkDomain);
            
            for(int i = 0; i < orderList.size() ; i++){
                OrderDomain tempDomain = orderList.get(i);
                OrderQtyDomain qtyDomain = new OrderQtyDomain();
                
                qtyDomain.setOrderKey(tempDomain.getOrderKey());
                
                orderDao.qtyDelete(qtyDomain);
            }
            
            orderDao.orderDelete(chkDomain);
            
        }
        
        JSONObject jsonObj = new JSONObject();
        JSONParser jsonParser = new JSONParser();
        
        jsonObj = (JSONObject) jsonParser.parse(stockQry);
        JSONArray dataArray = (JSONArray) jsonObj.get("DATA");
        
        String errcode1 = "";
        if(jsonObj.get("ERRCODE") != null){
            errcode1 = jsonObj.get("ERRCODE").toString();
        }
        
        System.out.println("stockDailyQry : " + stockDailyQry);
        jsonObj = (JSONObject) jsonParser.parse(stockDailyQry);
        JSONArray dataArray2 = (JSONArray) jsonObj.get("DATA");
        String errcode2 = "";
        if(jsonObj.get("ERRCODE") != null){
            errcode2 = jsonObj.get("ERRCODE").toString();
        }
        
        for(int k = 0; k < domainList.size() ; k++){
            OrderDomain domain = domainList.get(k);
            
            String orderKey = orderDao.OrderNextIdx(domain);
            String densoNumber = domain.getDensoNumber();
                
            domain.setOrderKey(orderKey);
            
            if("".equals(errcode1)){
                for(int i = 0; i < dataArray.size() ; i++){
                    JSONObject tempObj = (JSONObject) dataArray.get(i);
                    String ritemCd = UxisStringUtil.isNullToString(tempObj.get("ritem_cd"));
                    String totalStockQty = UxisStringUtil.isNullToString(tempObj.get("stock_qty"));
                    
                    if(densoNumber != null && densoNumber.equals(ritemCd)){
                        System.out.println(" update totalStockQty : " + totalStockQty);
                        domain.setTotalStockQty(totalStockQty);
                    } 
                }
            }
            System.out.println("orderDao.create(domain)  : " + domain.getReleaseDate());
            orderDao.create(domain);
            
            List<OrderQtyDomain> qtyList = domain.getQtyList();
            
            for(int i = 0; i < qtyList.size(); i++){
                if(qtyList.get(i).getOrderDate() != null && !"".equals(qtyList.get(i).getOrderDate())){
                    OrderQtyDomain qtyDomain = qtyList.get(i);
                    qtyDomain.setOrderKey(orderKey);
                    
                    String orderDateOrg = qtyDomain.getOrderDate();
                    //String weekOfYear = UxisStringUtil.getWeekOfYear(orderDate);
                    
                    if("".equals(errcode2)){
                        
                        for(int l = 0; l < dataArray2.size() ; l++){
                            JSONObject tempObj = (JSONObject) dataArray2.get(l);
                            String ritemCd = UxisStringUtil.isNullToString(tempObj.get("ritem_cd"));
                            String stockQty = UxisStringUtil.isNullToString(tempObj.get("stock_qty"));
                            String startDt = UxisStringUtil.isNullToString(tempObj.get("start_dt"));
                            
                            
                            /*String weekOfYearIso = UxisStringUtil.isNullToString(tempObj.get("week_of_year_iso"));
                            if(weekOfYear.equals(weekOfYearIso)){
                                System.out.println("update stockQty : " + stockQty + "  ritemCd : " + ritemCd + "  weekofYear + " + weekOfYear);
                                qtyDomain.setStockQty(stockQty);
                            }*/
                            
                            if(domain.getDensoNumber().equals(ritemCd) && orderDateOrg.equals(startDt)) {
                                System.out.println("update stockQty : " + stockQty + "  ritemCd : " + ritemCd + "  weekofYear + " + startDt);
                                qtyDomain.setStockQty(stockQty);
                            }
                        }
                    }
                    
                    orderDao.createQty(qtyDomain);
                    //System.out.println("createQty Complete" + " i : " + i);
                }
                
            }
                
            //winus를 기준으로 등록할 수주데이터를 비교하여 ritemCd 와 densonumber 가 같은 항목중 densoDate와 startDt가 같은것이 없을경우 
            //startDt로 orderQtydomain 을 생성하여 추가로 insert 한다.
            for(int l = 0; l < dataArray2.size(); l++){
                JSONObject tempObj = (JSONObject) dataArray2.get(l);
                String ritemCd = UxisStringUtil.isNullToString(tempObj.get("ritem_cd"));
                String stockQty = UxisStringUtil.isNullToString(tempObj.get("stock_qty"));
                String startDt = UxisStringUtil.isNullToString(tempObj.get("start_dt"));
                boolean dateflag = true;    //해당날짜 체크 플레그
                boolean itemflag = false;   //아이템 플래그
                
                for(int i = 0; i < qtyList.size(); i++){
                    OrderQtyDomain qtyDomain = qtyList.get(i);
                    
                    String orderDateOrg = qtyDomain.getOrderDate();
                    
                    if(orderDateOrg.equals(startDt)){   //같은 날짜의 데이터가 있는경우 false;
                        dateflag = false;
                    }
                    
                    if(ritemCd.equals(densoNumber)){    //ritemCd와 densoNumber가 같은경우 true;
                        itemflag = true;
                    }
                }
                
                if(dateflag && itemflag){   //조건에 맞을경우 qtyDomain 데이터 생성해서 tmpList에 담는다.
                    OrderQtyDomain tmpDomain = new OrderQtyDomain();
                    System.out.println("ritemCd : " + ritemCd + "startDt : " + startDt);
                    tmpDomain.setOrderKey(orderKey);
                    tmpDomain.setOrderDate(startDt);
                    tmpDomain.setOrderQty("0");
                    tmpDomain.setStockQty(stockQty);
                    
                    orderDao.createQty(tmpDomain);
                }
                
            }

            
        }
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ContractService#create(OrderDomain)
     */
    public void orderCreate(OrderDomain domain) throws ApplicationException {
        
        System.out.println("create start : " + domain.getMeterialNumber());
        String orderKey = orderDao.OrderNextIdx(domain);
            
        OrderDomain chkDomain = new OrderDomain();
        chkDomain.setMeterialNumber(domain.getMeterialNumber());;
        chkDomain.setReleaseDate(domain.getReleaseDate());
        System.out.println("meterail : " + domain.getMeterialNumber() + "  releaseDate : " + domain.getReleaseDate());
        
        int orderCnt = orderDao.searchCount(chkDomain);
        
        if(orderCnt > 0){
            
            OrderDomain orderResult = orderDao.searchById(chkDomain);
            
            System.out.println("delete : order key : " + orderResult.getOrderKey()) ;
            
            OrderQtyDomain qtyDomain = new OrderQtyDomain();
            qtyDomain.setOrderKey(orderResult.getOrderKey());
            
            System.out.println("int qtyCnt = orderDao.searchQtyCount(qtyDomain)" + qtyDomain.getOrderKey());
            int qtyCnt = orderDao.searchQtyCount(qtyDomain);
            
            if(qtyCnt > 0){
                System.out.println("111  orderDao.qtyDelete(qtyDomain)  " + qtyDomain.getOrderKey());
                orderDao.qtyDelete(qtyDomain);
            }
            System.out.println("222 orderDao.orderDelete(orderResult) " + orderResult.getOrderKey() + "  , " + orderResult.getReleaseDate());
            orderDao.orderDelete(chkDomain);
        }
            
        System.out.println("delete Compltetetetet");
        domain.setOrderKey(orderKey);
        orderDao.create(domain);
        List<OrderQtyDomain> qtyList = domain.getQtyList();
        for(int i = 0; i < qtyList.size(); i++){
            System.out.println(" i : " + i + " start");
            if(qtyList.get(i).getOrderDate() != null && !"".equals(qtyList.get(i).getOrderDate())){
                OrderQtyDomain qtyDomain = qtyList.get(i);
                qtyDomain.setOrderKey(orderKey);
                System.out.println(" qtyData > orderKey " + qtyDomain.getOrderKey() + " , orderDAte : " + qtyDomain.getOrderDate() + "  orderQty : " + qtyDomain.getOrderQty() + " i : " + i);
                orderDao.createQty(qtyDomain);
                System.out.println("createQty Complete" + " i : " + i);
            }
            /*OrderQtyDomain qtyDomain = qtyList.get(i);
            qtyDomain.setOrderKey(orderKey);
            if(qtyDomain.getOrderDate() != null && !"".equals(qtyDomain.getOrderDate())){
                System.out.println(" qtyData > orderKey " + qtyDomain.getOrderKey() + " , orderDAte : " + qtyDomain.getOrderDate() + "  orderQty : " + qtyDomain.getOrderQty() + " i : " + i);
                orderDao.createQty(qtyDomain);
                System.out.println("createQty Complete" + " i : " + i);
            }*/
            
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ContractService#delete(OrderDomain)
     */
    public int update(OrderDomain domain) throws ApplicationException {
        
        
        return orderDao.orderUpdate(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ContractService#delete(OrderDomain)
     */
    public int updateQty(OrderQtyDomain domain) throws ApplicationException {
        
        
        return orderDao.orderQtyUpdate(domain);
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ContractService#delete(OrderDomain)
     */
    public int delete(OrderDomain domain) throws ApplicationException {
        
        
        return orderDao.orderDelete(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ContractService#delete(OrderDomain)
     */
    public int allDelete(OrderDomain domain) throws ApplicationException {
        
        OrderQtyDomain qtyDomain = new OrderQtyDomain();
        
        int result = orderDao.qtyDelete(qtyDomain);
        
        result += orderDao.orderDelete(domain);
        
        return result;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ContractService#delete(OrderDomain)
     */
    public OrderDb2Domain getDensoNumber(OrderDb2Domain domain) throws ApplicationException {
        
        
        return orderDao.getDensoNumber(domain);
    }
    
}
