package com.convergys.custom.geneva.j2ee.util;

/**
 * 
 * @author tkon2950
 * @author sgad2315 (Sreekanth Gade)
 * @author sjoshi1
 */
public interface SQLStatements {

    //public static final String READ_NEXT_DUNNING_REQ_SEQ_SQL = "SELECT RBM_CUSTOM.DBT_DUNNING_REQ_SEQ.nextval FROM DUAL";

    public static final String INSERT_REQUEST_SQL = "INSERT INTO TMOBILE_CUSTOM.TMO_TRANSACTIONDETAILS"
            + "(CREATED_DTM,WHOLESALE_TRANSACTION_ID,SERVICE_NAME,CUSTOMER_REF,STATUS,"
            + "EVENTSOURCE,REQUEST_DETAIL,RESPONSE_DETAIL)"
            + " VALUES(?,?,?,?,?,?,?,?)";
    public static final String INSERT_REQUEST_SQL_PROC = "{call tmobile_custom.insertToErrorLog(?,?,?,?,?,?,?,?,?,?)}";
    public static final String UPDATE_REQUEST_SQL = "UPDATE tmobile_custom.TMO_TRANSACTIONDETAILS "
            + "SET STATUS = ?, completed_dtm = sysdate "
            + "WHERE WHOLESALE_TRANSACTION_ID = ? AND status = ?,REQUEST_DETAIL=?,RESPONSE_DETAIL=? ";
    public static final String GET_PROD_SEQ = "{call TMO_BILLINGPROFILE.getPrdSeqForModify(?,?,?,?,?,?)}";
    
    public static final String GET_PROD_SEQ_1 = "{call TMO_BILLINGPROFILE.getPrdSeqForModify_1(?,?,?,?,?,?,?)}";
    
    public static final String GET_BASE_PROD_SEQ_MOD_CES  = "SELECT DISTINCT(PRODUCT_SEQ) FROM CUSTEVENTSOURCE WHERE CUSTOMER_REF = ? AND EVENT_SOURCE = ? AND END_DTM IS NULL";
    public static final String GET_BASE_PROD_SEQ  = "SELECT DISTINCT(CES.PRODUCT_SEQ) FROM CUSTEVENTSOURCE CES, CUSTPRODUCTATTRDETAILS CPAD WHERE "
            + "CES.CUSTOMER_REF = CPAD.CUSTOMER_REF AND "
            + "CES.PRODUCT_SEQ = CPAD.PRODUCT_SEQ AND   "
            + "CES.CUSTOMER_REF = ? AND "
            + "CES.EVENT_SOURCE = ? AND "
            + "CES.END_DTM IS NULL AND  "
            + "CPAD.PRODUCT_ID = ? AND  "
            + "CPAD.PRODUCT_ATTRIBUTE_SUBID = 1 AND "
            + "CPAD.ATTRIBUTE_VALUE = ?";
    
    public static final String GET_SUB_ID  = "SELECT PRODUCT_ATTRIBUTE_SUBID FROM PRODUCTATTRIBUTE WHERE PRODUCT_ID =? AND ATTRIBUTE_UA_NAME =?";
    
    //Query  for queryLastRatedUsageDtmByType
    public static final String GET_LASTRATEDUSAGE = "{call TMO_BILLINGPROFILE.getLastRatedUsage(?,?,?,?)}";
    
    public static final String UPDATE_ACCT_PAY_ATTRIBUTES = "UPDATE ACCOUNTPAYATTRIBUTES SET CANCELLED_DTM = sysdate , WEB_PORTAL_USER = ? WHERE"
            + " ACCOUNT_NUM = ? AND ACCOUNT_PAYMENT_SEQ = ? ";
            
    //public static final String CALL_CANCEL_PHYSICAL_PAY = "{call GNVPAY.cancelPhysicalPay1NC(?,?,?,?)}";
    //public static final String CALL_CANCEL_PHYSICAL_PAYMENT = "{call gnvj2eepayments.cancelphysicalpayment_1(?,?,?,?,?,?)}";
    //public static final String CALL_CREATE_ACCOUNT_PAYMENT = "{call gnvj2eepayments.createaccountpay_5(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    //public static final String CALL_CREATE_PHYSICAL_PAY2NC = "{call GNVPAY.createPhysicalPay2NC(?,?,?,?,?,?,?,?,?,?,?,?)}";;
    
    public static final String QUERY_VIEW  = "SELECT * FROM ALL_TAB_COLUMNS T WHERE T.TABLE_NAME = ?";
    
    
/*  public static final String QUERY_RESULT  = "SELECT ACCOUNT_NUM, TO_CHAR(NVL(ADJUSTMENT_DEBT_MNY,'')) ADJUSTMENT_DEBT_MNY ,TO_CHAR(NVL(ADJUSTMENT_NET_MNY,'')) ADJUSTMENT_NET_MNY,OUTCOME_DESC  "
            + " FROM PVADJUSTMENT7 WHERE ADJUSTMENT_NET_MNY <0 ORDER BY ACCOUNT_NUM OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY" ;*/
    
       public static final String QUERY_RESULT  = "SELECT * "
                + " FROM PVADJUSTMENT6 WHERE ADJUSTMENT_NET_MNY <0 ORDER BY ACCOUNT_NUM OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY" ;
       
    public static final String CREATE_BULK_REQUEST_SQL = "{call TMOBILE_CUSTOM.createBulkRequest(?,?,?,?,?,?,?,?)}";
    
    

    public static final String GET_BULK_REQUEST_SQL = "SELECT * FROM TMOBILE_CUSTOM.BULKREQUEST WHERE  TIBCO_PARTNER_ID = ? ";
    public static final String QUERY_GPARAMS = "SELECT STRING_VALUE FROM GPARAMS WHERE NAME LIKE ?";
    
 
    public static final String INVOICE_SECTION_DETAILS_USAGE_SQL = "SELECT * FROM TMOBILE_CUSTOM.INVOICESECTIONDETAILSUSAGEVIEW  WHERE ACCOUNT_NUM = ?  AND BILL_SEQ = ? AND EVENT_SUMMARY_ID in (%s)";
   
    public static final String INVOICE_SECTION_DETAILS_MRC_SQL =  "SELECT * FROM  TMOBILE_CUSTOM.INVOICESECTIONDETAILSMRCVIEW WHERE ACCOUNT_NUM = ? AND BILL_SEQ = ? AND EVENT_SUMMARY_ID in (%s)";
    
    public static final String INVOICE_SECTION_DETAILS_ADJ_SQL = "SELECT * FROM TMOBILE_CUSTOM.INVOICESECTIONDETAILSADJVIEW WHERE ACCOUNT_NUM = ? AND BILL_SEQ = ? AND EVENT_SUMMARY_ID in (%s) ";
    public static final String INVOICE_SECTION_DETAILS_TAX_SQL = "SELECT * FROM TMOBILE_CUSTOM.INVOICESECTIONDETAILSTAXVIEW WHERE ACCOUNT_NUM = ? AND BILL_SEQ = ? ";
    
    public static final String INVOICE_SECTION_DETAILS_OTF_TAX_SQL = "SELECT * FROM TMOBILE_CUSTOM.INVOICESECTIONDETAILSTAXVIEW WHERE ACCOUNT_NUM = ? AND BILL_SEQ = ? AND TYPE = 'OTF'";
    
    public static final String INVOICE_SECTION_DETAILS_GTF_TAX_SQL = "SELECT * FROM TMOBILE_CUSTOM.INVOICESECTIONDETAILSTAXVIEW WHERE ACCOUNT_NUM = ? AND BILL_SEQ = ? AND TYPE = 'GTF'";
    
    
    
    //public static final String GET_DUFFILE_NAME  = "select DUF_FILENAME from TMOBILE_CUSTOM.TMO_DUF_CDR_DETAILS where event_type= 'VOICE' AND ACCOUNT_NUM='ACC000086' OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY ";
    //public static final String GET_CUSTOMER_REF_SQL = "select RATING_CUST_REF from TMO_ACCT_MAPPING t where t.TIBCO_PARTNER_ID = ?";
    
    public static final String GET_CUSTOMER_REF_SQL  = "SELECT DISTINCT(CUSTOMER_REF) FROM (SELECT RATING_CUST_REF CUSTOMER_REF FROM TMO_ACCT_MAPPING TAM  "
                                                        + "WHERE TAM.TIBCO_PARTNER_ID = ?  "
                                                        + "UNION   SELECT CUSTOMER_REF  "
                                                        + "FROM TMO_CUST_SUBCLIENT SUB WHERE SUB.TIBCO_CLIENT_ID = ?)";

    
    public static final String GET_INVOICE_SUMMARY_SQL = " SELECT CUS.CUSTOMER_REF AS CUSTOMER_REF,CUS.COMPANY_NAME AS COMPANY_NAME, "
            //+ " --ATTN: Account Payable "
            + " A.ADDRESS_1 AS ADDRESSLN1, A.ADDRESS_2 AS ADDRESSLN2, A.ADDRESS_3 AS CITY_NAME, A.ADDRESS_4 AS STATE_NAME, A.ZIPCODE AS ZIP_CODE, CO.COUNTRY_NAME AS COUNTRY_NAME, " 
            + " INVOICING_CO_NAME, REG_ADDR_1  , REG_ADDR_2, REG_ADDR_3,  "
            + " BS.INVOICE_NUM AS INVOICE_NUM, BS.BILL_DTM as INVOICE_DTM,  "
            + " CONCAT(CONCAT(TO_CHAR(BS.START_OF_BILL_DTM,'MM/DD/YYYY') , '-') , TO_CHAR((BS.BILL_DTM-1),'MM/DD/YYYY')) AS INVOICE_PERIOD, "
            + " ROUND((BS.INVOICE_NET_MNY+BS.INVOICE_TAX_MNY)/10000,2) AS CURRENT_INVOICE_TOTAL, BS.PAYMENT_DUE_DAT AS PAYMENT_DUE_DATE, "
            + " (BS.PAYMENT_DUE_DAT - BS.BILL_DTM) AS PAYMENT_TERM, "
            + " ROUND(BS.BALANCE_FWD_MNY/10000,2) AS PREVIOUS_BALANCE, "
            + " ROUND((BS.PAYMENTS_MNY-BS.FAILED_PAYMENTS_MNY)/10000,2) AS PAYMENT_RECEIVED, "
            + " ROUND((BS.BALANCE_FWD_MNY-(BS.PAYMENTS_MNY-BS.FAILED_PAYMENTS_MNY))/10000,2) AS OUTSTANDING_BALANCE,  "
            + " CASE WHEN CON.ADDRESS_NAME IS NOT NULL THEN 'ATTN: ' || CON.ADDRESS_NAME  ELSE NULL END AS ADDRESS_NAME, "
            + " ROUND((BS.BALANCE_OUT_MNY)/10000,2) AS TOTAL_DUE"
            + " FROM CUSTOMER CUS, "
            + " ADDRESS   A, COUNTRY CO, "
            + " INVOICINGCOMPANY INV,BILLSUMMARY BS,ACCOUNT ACC, CONTACT CON "
            + " WHERE CUS.CUSTOMER_REF = A.CUSTOMER_REF "
            + " AND A.COUNTRY_ID = CO.COUNTRY_ID "
            + " AND INV.INVOICING_CO_ID = CUS.INVOICING_CO_ID "
            + " AND BS.ACCOUNT_NUM = ACC.ACCOUNT_NUM "
            + " AND CUS.CUSTOMER_REF = ACC.CUSTOMER_REF "
            + " AND BS.INVOICE_NUM = ?  AND BS.BILL_STATUS IN (1,7,8) "
            + " AND CON.CUSTOMER_REF = CUS.CUSTOMER_REF "
            + " AND A.ADDRESS_SEQ =(select max(address_seq) from address "
            + " where CUSTOMER_REF = (SELECT CUSTOMER_REF "
            + " FROM ACCOUNT WHERE ACCOUNT_NUM = (SELECT DISTINCT ACCOUNT_NUM FROM BILLSUMMARY WHERE INVOICE_NUM = ? ))) "
            + " AND CON.CONTACT_SEQ = (select max(CONTACT_SEQ) from CONTACT where CUSTOMER_REF = "
            + " (SELECT CUSTOMER_REF  FROM ACCOUNT WHERE ACCOUNT_NUM = (SELECT DISTINCT ACCOUNT_NUM FROM BILLSUMMARY WHERE INVOICE_NUM = ? ))) ";
    
    public static final String GET_INVOICE_SUMMARY_USAGE_SQL = "SELECT ROUND(SUM(TOTAL_AMOUNT),2) AS TOTAL_AMOUNT FROM  TMOBILE_CUSTOM.INVOICESECTIONDETAILSUSAGEVIEW "
            + " WHERE ACCOUNT_NUM =? AND BILL_SEQ = ?  " ;
    
    public static final String GET_INVOICE_SUMMARY_MRC_SQL = "SELECT CEIL(SUM(TOTAL_AMOUNT)*100)/100 AS TOTAL_AMOUNT  FROM  TMOBILE_CUSTOM.INVOICESECTIONDETAILSMRCVIEW "
            + " WHERE ACCOUNT_NUM =? AND BILL_SEQ = ?   " ;
    
    public static final String GET_INVOICE_SUMMARY_ADJ_SQL = "SELECT CEIL(SUM(TOTAL_AMOUNT)*100)/100 AS TOTAL_AMOUNT FROM  TMOBILE_CUSTOM.INVOICESECTIONDETAILSADJVIEW "
            + " WHERE ACCOUNT_NUM =? AND BILL_SEQ = ?  " ;
    
    public static final String GET_INVOICE_SUMMARY_TAXES_SQL = "SELECT ROUND(SUM(TOTAL_AMOUNT),2) AS TOTAL_AMOUNT FROM TMOBILE_CUSTOM.INVOICESECTIONDETAILSTAXVIEW "
            + "WHERE ACCOUNT_NUM = ? AND BILL_SEQ = ? " ;
    public static final String GET_INVOICE_SUMMARY_TAXES_OTF_SQL = "SELECT ROUND(SUM(TOTAL_AMOUNT),2) AS TOTAL_AMOUNT FROM TMOBILE_CUSTOM.INVOICESECTIONDETAILSTAXVIEW "
            + "WHERE ACCOUNT_NUM = ? AND BILL_SEQ = ? AND TYPE = 'OTF' " ;
    public static final String GET_INVOICE_SUMMARY_TAXES_GTF_SQL = "SELECT ROUND(SUM(TOTAL_AMOUNT),2) AS TOTAL_AMOUNT FROM TMOBILE_CUSTOM.INVOICESECTIONDETAILSTAXVIEW "
            + "WHERE ACCOUNT_NUM = ? AND BILL_SEQ = ? AND TYPE = 'GTF' " ;
    
    
    public static final String GET_INVOICE_TOTAL_USAGE = "{call TMO_BILLINGPROFILE.getInvoiceUsage(?,?,?,?,?,?,?,?)}";
    
    public static final String QUERY_FIND_INVOICE = "SELECT count(*),max(bill_version) FROM Billsummary WHERE INVOICE_NUM = ?";
    
    public static final String GET_PARTNERS="SELECT CUSTOMER_NAME AS PARTNER_NAME FROM TMOBILE_CUSTOM.TMO_ACCT_MAPPING WHERE REFACTORED_FLAG = 'T' AND BILLING_ACCT_NBR = ?";
        
    public static final String CREATE_DUF_CDR_OUTPUT = "{call TMOBILE_CUSTOM.TMO_INVDRILLDOWN.load_duf(?,?,?,?)}";
    
    //public static final String CREATE_DUF_CDR_OUTPUT_BILLED = "select max(event_seq) from billsummary where account_num= ? and bill_status in (1,6)";
    
    public static final String CREATE_DUF_CDR_OUTPUT_BILLED = "select event_seq from (select distinct event_seq,bill_seq from billsummary where account_num = ? and bill_status in (1, 7,8) order by bill_seq desc) where rownum <= 2";
   
    public static final String CREATE_DUF_CDR_OUTPUT_UN_BILLED="select max(BILL_EVENT_SEQ) from account a, tmobile_custom.tmo_acct_mapping tam where a.account_num = tam.rating_acct_nbr and tam.billing_acct_nbr = ?";
    
    public static final String GNV_DATE="SELECT GNVGEN.SYSTEMDATE FROM DUAL";
    
    public static final String GET_BILL_DATE="SELECT TO_CHAR(BILL_DTM) AS BILL_DATE FROM BILLSUMMARY where ACCOUNT_NUM = 'ACC000143' AND BILL_STATUS in (1,7,8) AND BILL_SEQ = ? ";
    public static final String GET_BILL_DATE_WITH_ACCOUNT_NUM="SELECT TO_CHAR(BILL_DTM) AS BILL_DATE FROM BILLSUMMARY where ACCOUNT_NUM = ? AND BILL_STATUS in (1,7,8) AND BILL_SEQ = ? ";
    public static final String GET_PARTNER_CONTACT_DETAILS = "SELECT * FROM TMOBILE_CUSTOM.TMO_CONTACT_VIEW WHERE CUSTOMER_REF = ? ";
	
    public static final String CREATE_PAYMENT_CHANNEL_SQL ="INSERT INTO GENEVA_ADMIN.PAYMENTMETHOD (PAYMENT_METHOD_ID,PAYMENT_METHOD_NAME,REQUEST_NEEDED_BOO,MI_REQUEST_BOO,REFUND_REQUEST_BOO,SEPARATE_PRFILE_BOO,ACCOUNT_PICKLIST_BOO,PAYMENT_PICKLIST_BOO,MANDATE_REQUIRED_BOO,BANK_ACCOUNT_HOLDER_OPT_BOO,BANK_ACCOUNT_NUMBER_OPT_BOO,BANK_CODE_OPT_BOO,BANK_BRANCH_NUMBER_OPT_BOO,CARD_NUMBER_OPT_BOO,CARD_EXPIRY_DAT_OPT_BOO,CARD_ISSUE_DAT_OPT_BOO,CARD_ISSUE_NUM_OPT_BOO,MANDATE_ATTR_1_OPT_BOO,MANDATE_ATTR_2_OPT_BOO,MANDATE_ATTR_3_OPT_BOO,MANDATE_ATTR_4_OPT_BOO,MANDATE_ATTR_5_OPT_BOO,MANDATE_ATTR_6_OPT_BOO,LATE_FEE_EXEMPT_BOO,IBAN_OPT_BOO,BIC_OPT_BOO) VALUES (?,?,'F','F','F','F','T','T','F','T','T','T','T','T','T','T','T','T','T','T','T','T','T','F','T','T')";    
    public static final String CREATE_PAYMENT_CHANNEL_SQL2 = "INSERT INTO GENEVA_ADMIN.ICOHASPAYMENTMETHOD (INVOICING_CO_ID,PAYMENT_METHOD_ID) VALUES(?,?)";
    public static final String UPDATE_PAYMENT_CHANNEL_SQL = "UPDATE GENEVA_ADMIN.PAYMENTMETHOD SET PAYMENT_METHOD_NAME = ? WHERE PAYMENT_METHOD_ID = ?";
    public static final String CREATE_ADJUSTMENT_ATTRS_SQL = "INSERT INTO TMOBILE_CUSTOM.TMO_ADJUSTMENT_ATTRIBUTES (ACCOUNT_NUM,ADJUSTMENT_SEQ,ATTRIBUTE_VALUE) VALUES(?,?,?)";
    public static final String CREATE_ACCT_TAX_EXEMPTION_SQL = "INSERT INTO TMOBILE_CUSTOM.TMO_ACCT_EXEMPTION(CUSTOMER_REF,EXEMPTION_TYPE,EXEMPTION_START_DATE,EXEMPTION_END_DATE,STATUS,LAST_MODIFIED_DATE,CREATEDBYUSER) VALUES(?,?,TO_DATE(?,'MM/DD/YYYY'),TO_DATE(?,'MM/DD/YYYY'),?,sysdate,?)";
    public static final String GET_ACCT_EXMP_DETAILS ="SELECT * FROM TMOBILE_CUSTOM.TMO_ACCT_EXEMPTION WHERE CUSTOMER_REF=?";
    public static final String UPDATE_ACCOUNT_EXEMP="UPDATE TMOBILE_CUSTOM.TMO_ACCT_EXEMPTION SET EXEMPTION_TYPE=?,EXEMPTION_START_DATE=TO_DATE(?,'MM/DD/YYYY'),EXEMPTION_END_DATE=TO_DATE(?,'MM/DD/YYYY'),STATUS=?,LAST_MODIFIED_DATE=sysdate,CREATEDBYUSER=? where CUSTOMER_REF=?";
    public static final String DELETE_EXEMPTION_PROC="{call TMOBILE_CUSTOM.TMO_TAX_EXEMPTION_PKG.delete_tax_exemption(?,?,?,?)}";
    public static final String ADD_EXEMPTION_PROC="{call TMOBILE_CUSTOM.TMO_TAX_EXEMPTION_PKG.load_tax_exemption(?,?,?,?,?,?,?)}";
    public static final String GET_MAX_BILL_SEQ="SELECT MAX(BILL_SEQ) AS MAX_BILL_SEQ  FROM BILLSUMMARY where ACCOUNT_NUM = ? AND BILL_STATUS in (1,7,8) ";
	
	//Partner On boarding wizard
    public static final String ACCOUNT_ATTRIBUTES_VIEW = "SELECT * FROM TMOBILE_CUSTOM.TMO_ACCOUNT_ATTRIBUTES_VIEW ";
    public static final String CUSTOM_DATA_VIEW = "SELECT * FROM TMOBILE_CUSTOM.TMO_CUSTOM_TABLE_VIEW ";
    public static final String GET_CUSTOMRREF_ACCOUNNUM = "{call TMOBILE_CUSTOM.TMO_PARTNER_ONBOARDING_PKG.getAutoCustomerRefAndAccount(?,?,?,?,?,?)}";
    public static final String INSERT_CUSTOM_DATA = "{call TMOBILE_CUSTOM.TMO_PARTNER_ONBOARDING_PKG.customTablesUpdate(?,?,?)}";
    
}
