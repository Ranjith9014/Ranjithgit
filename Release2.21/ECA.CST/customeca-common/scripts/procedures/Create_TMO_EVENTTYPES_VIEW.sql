DROP VIEW TMOBILE_CUSTOM.TMO_EVENTTYPES_VIEW;

CREATE OR REPLACE FORCE VIEW TMOBILE_CUSTOM.TMO_EVENTTYPES_VIEW
(
    EVENT_TYPE_ID, 
    EVENT_TYPE_NAME
)
AS
   SELECT EVENT_TYPE_ID, EVENT_TYPE_NAME
   FROM GENEVA_ADMIN.EVENTTYPE
   WHERE EVENT_TYPE_ID IN (20,21,28,1234)
WITH READ ONLY;


CREATE OR REPLACE PUBLIC SYNONYM TMO_EVENTTYPES_VIEW FOR TMOBILE_CUSTOM.TMO_EVENTTYPES_VIEW;

CREATE OR REPLACE SYNONYM UNIF_ADMIN.TMO_EVENTTYPES_VIEW FOR TMOBILE_CUSTOM.TMO_EVENTTYPES_VIEW;

GRANT SELECT ON TMOBILE_CUSTOM.TMO_EVENTTYPES_VIEW TO UNIF_ADMIN;
