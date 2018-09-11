DECLARE 

v_emp int:=0; 

BEGIN 

  SELECT 1 into v_emp FROM dba_tables where table_name = 'TMO_ADJUSTMENT_ATTRIBUTES';  

 --dbms_output.put_line(v_emp);
 

EXCEPTION WHEN NO_DATA_FOUND then
BEGIN 

EXECUTE IMMEDIATE 'CREATE TABLE TMOBILE_CUSTOM.TMO_ADJUSTMENT_ATTRIBUTES 
(
  ACCOUNT_NUM             VARCHAR2(20) NOT NULL,
  ADJUSTMENT_SEQ          NUMBER(9) NOT NULL,
  ATTRIBUTE_VALUE         VARCHAR2(20) NOT NULL,
  CONSTRAINT "TMO_ADJUSTMENT_ATTR_PK" PRIMARY KEY ("ACCOUNT_NUM","ADJUSTMENT_SEQ")
)';

 EXECUTE IMMEDIATE 
'GRANT ALL ON TMOBILE_CUSTOM.TMO_ADJUSTMENT_ATTRIBUTES TO UNIF_ADMIN';
 EXECUTE IMMEDIATE 
 'Grant ALL ON TMOBILE_CUSTOM.TMO_ADJUSTMENT_ATTRIBUTES TO geneva_admin';
 COMMIT;
END; 

END;
/