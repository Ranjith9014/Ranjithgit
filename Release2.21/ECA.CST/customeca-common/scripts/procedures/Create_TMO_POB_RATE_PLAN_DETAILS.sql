BEGIN
  EXECUTE IMMEDIATE 'CREATE TABLE TMOBILE_CUSTOM.TMO_POB_RATE_PLAN_DETAILS
(
    TRANSACTION_ID        VARCHAR2(40),
    RATING_ACCT_NUM       VARCHAR2(40),
	CATALOGUE_CHANGE_ID   NUMBER,
    PRICE_PLAN_ID         NUMBER,
    PRICE_PLAN_NAME       VARCHAR2(40),
    PRODUCT_ID            NUMBER,
    WPS_VALID_FROM        DATE,
    WPS_END_DATE          DATE,
	RATING_CATALOGUE_ID   NUMBER,
	RATE_PLAN_ID          NUMBER,
    RATE_PLAN_NAME        VARCHAR2(40),
    EVENT_TYPE_ID         NUMBER
)';
EXCEPTION
  WHEN OTHERS THEN
    NULL;
END;
/
BEGIN
  EXECUTE IMMEDIATE 'ALTER TABLE TMOBILE_CUSTOM.TMO_POB_RATE_PLAN_DETAILS
ADD CONSTRAINT  TMO_RATE_PLAN_DETAILS_PK PRIMARY KEY (TRANSACTION_ID,RATING_ACCT_NUM,PRICE_PLAN_ID,RATE_PLAN_ID)';
EXCEPTION
  WHEN OTHERS THEN
    NULL;
END;
/
GRANT ALL ON TMOBILE_CUSTOM.TMO_POB_RATE_PLAN_DETAILS TO GENEVA_ADMIN,UNIF_ADMIN,GENEVABATCHUSER;




