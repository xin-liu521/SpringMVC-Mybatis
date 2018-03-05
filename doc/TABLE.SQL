drop table if exists BY_APPROVE_BASE;

/*==============================================================*/
/* Table: BY_APPROVE_BASE                                       */
/*==============================================================*/
create table BY_APPROVE_BASE 
(
   ID                   NUMBER                         not null,
   COMPANY_CODE         NVARCHAR2(200)                 null,
   COMPANY_FULL_NAME    NVARCHAR2(200)                 null,
   COMPANY_FULL_EG      NVARCHAR2(200)                 null,
   COMPANY_SHORT_NAME   NVARCHAR2(200)                 null,
   COMPANY_SHORT_EG     NVARCHAR2(200)                 null,
   LEGAL_PERSON         NVARCHAR2(200)                 null,
   FUND                 NUMBER                         null,
   IS_UNITY             NUMBER                         null,
   ECONOMICS_TYPE_NAME  NVARCHAR2(200)                 null,
   SOCIAL_CREDIT_CODE   NVARCHAR2(200)                 null,
   LICENSE_NUMBER       NVARCHAR2(200)                 null,
   ORGANIZATION_CODE_NUMBER NVARCHAR2(200)                 null,
   TAX_NUMBER           NVARCHAR2(200)                 null,
   ECONOMICS_TYPE       NUMBER                         null,
   CREATE_REG_TIME      DATE                           null,
   ADDRESS              NVARCHAR2(300)                 null,
   POSTCODE             NUMBER                         null,
   PHONE                NVARCHAR2(100)                 null,
   EMAIL                NVARCHAR2(200)                 null,
   WEB_ADDRESS          NVARCHAR2(200)                 null,
   FAX                  NVARCHAR2(200)                 null,
   COMPANY_TYPE         NUMBER                         null,
   STATUS               NUMBER                         null,
   CREATE_TIME          DATE                           null,
   CREATE_USER_ID       NUMBER                         null,
   UPDATE_TIME          DATE                           null,
   UPDATE_USER_ID       NUMBER                         null,
   AREA_NAME            NVARCHAR2(200)                 null,
   AREA                 NUMBER                         null,
   APPROVE_BACK_CAUSE   NVARCHAR2(300)                 null,
   COMPANY_SUPPLIER_TYPE NUMBER                         null,
   SUPPLIER_STATUS      NUMBER                         null,
   CONTACT              NVARCHAR2(200)                 null,
   CONTACT_PHONE        NVARCHAR2(200)                 null,
   IS_CHEMICAL          NUMBER                         null,
   constraint PK_BY_APPROVE_BASE primary key (ID)
);

comment on table BY_APPROVE_BASE is 
'��֤������Ϣ��';

comment on column BY_APPROVE_BASE.COMPANY_CODE is 
'��λ����';

comment on column BY_APPROVE_BASE.COMPANY_FULL_NAME is 
'��λȫ��';

comment on column BY_APPROVE_BASE.COMPANY_FULL_EG is 
'Ӣ��ȫ��';

comment on column BY_APPROVE_BASE.COMPANY_SHORT_NAME is 
'��λ���';

comment on column BY_APPROVE_BASE.COMPANY_SHORT_EG is 
'Ӣ�ļ��';

comment on column BY_APPROVE_BASE.LEGAL_PERSON is 
'����';

comment on column BY_APPROVE_BASE.FUND is 
'ע���ʽ�';

comment on column BY_APPROVE_BASE.IS_UNITY is 
'�Ƿ���֤��һ';

comment on column BY_APPROVE_BASE.ECONOMICS_TYPE_NAME is 
'������������';

comment on column BY_APPROVE_BASE.SOCIAL_CREDIT_CODE is 
'������ô���';

comment on column BY_APPROVE_BASE.LICENSE_NUMBER is 
'Ӫҵִ�պ�';

comment on column BY_APPROVE_BASE.ORGANIZATION_CODE_NUMBER is 
'��֯��������֤��';

comment on column BY_APPROVE_BASE.TAX_NUMBER is 
'˰��Ǽ�֤��';

comment on column BY_APPROVE_BASE.ECONOMICS_TYPE is 
'��������';

comment on column BY_APPROVE_BASE.CREATE_REG_TIME is 
'��������';

comment on column BY_APPROVE_BASE.ADDRESS is 
'ͨѶ��ַ';

comment on column BY_APPROVE_BASE.POSTCODE is 
'�ʱ�';

comment on column BY_APPROVE_BASE.PHONE is 
'��˾�绰';

comment on column BY_APPROVE_BASE.EMAIL is 
'����';

comment on column BY_APPROVE_BASE.WEB_ADDRESS is 
'WEB��ַ';

comment on column BY_APPROVE_BASE.FAX is 
'����';

comment on column BY_APPROVE_BASE.COMPANY_TYPE is 
'�ͻ���λ����(0: �ͻ�)';

comment on column BY_APPROVE_BASE.STATUS is 
'�ͻ����״̬( 0δ�ύ   1����   2���ͨ��    3���ʧ��)';

comment on column BY_APPROVE_BASE.CREATE_TIME is 
'����ʱ��';

comment on column BY_APPROVE_BASE.CREATE_USER_ID is 
'�����û�';

comment on column BY_APPROVE_BASE.UPDATE_TIME is 
'�޸�ʱ��';

comment on column BY_APPROVE_BASE.UPDATE_USER_ID is 
'�޸��û�';

comment on column BY_APPROVE_BASE.AREA_NAME is 
'������������';

comment on column BY_APPROVE_BASE.AREA is 
'��������';

comment on column BY_APPROVE_BASE.APPROVE_BACK_CAUSE is 
'���ʧ��ԭ��';

comment on column BY_APPROVE_BASE.COMPANY_SUPPLIER_TYPE is 
'��Ӧ�̵�λ����(1: ��Ӧ��)';

comment on column BY_APPROVE_BASE.SUPPLIER_STATUS is 
'��Ӧ�����״̬( 0δ�ύ   1����   2���ͨ��    3���ʧ��)';

comment on column BY_APPROVE_BASE.CONTACT is 
'��ϵ��';

comment on column BY_APPROVE_BASE.CONTACT_PHONE is 
'��ϵ���ֻ���';

comment on column BY_APPROVE_BASE.IS_CHEMICAL is 
'�Ƿ�Σ��Ʒ��0��   1��';


drop table if exists BY_USERS;

/*==============================================================*/
/* Table: BY_USERS                                              */
/*==============================================================*/
create table BY_USERS 
(
   USER_ID              NUMBER                         not null,
   USER_ACCOUNT         nvarchar2(100)                 null,
   USER_PASSWORD        nvarchar2(200)                 null,
   PHONE                nvarchar2(100)                 null,
   EMAIL                nvarchar2(200)                 null,
   CREATE_TIME          DATE                           null,
   IS_ACTIVE            NUMBER                         null,
   EMAIL_SEND_TIME      DATE                           null,
   SALT                 NVARCHAR2(200)                 null,
   PICTURE_URL          NVARCHAR2(500)                 null,
   STATUS               NUMBER                         null,
   constraint PK_BY_USERS primary key (USER_ID)
);

comment on table BY_USERS is 
'�û���';

comment on column BY_USERS.USER_ACCOUNT is 
'�˺�';

comment on column BY_USERS.USER_PASSWORD is 
'����';

comment on column BY_USERS.PHONE is 
'��ϵ�绰';

comment on column BY_USERS.EMAIL is 
'��������';

comment on column BY_USERS.CREATE_TIME is 
'����ʱ��';

comment on column BY_USERS.IS_ACTIVE is 
'�Ƿ񼤻�(0 �ǣ�1 ��)';

comment on column BY_USERS.EMAIL_SEND_TIME is 
'�ʼ�����ʱ��';

comment on column BY_USERS.SALT is 
'����';

comment on column BY_USERS.PICTURE_URL is 
'ͼƬ';

comment on column BY_USERS.STATUS is 
'״̬';

drop table if exists BY_BANK;

/*==============================================================*/
/* Table: BY_BANK                                               */
/*==============================================================*/
create table BY_BANK 
(
   ID                   NUMBER                         not null,
   BASE_ID              NUMBER                         null,
   BANK_ACCOUNT         NVARCHAR2(50)                  null,
   BANK_TYPE            NVARCHAR2(50)                  null,
   BANK_ACCOUNT_NAME    NVARCHAR2(200)                 null,
   DEPOSIT_BANK         NUMBER                         null,
   BANK_COUNTRY         NVARCHAR2(200)                 null,
   ASSOCIATED_NUMBER    NVARCHAR2(200)                 null,
   CURRENCY_TYPE        NVARCHAR2(20)                  null,
   OTHER_BANK           NVARCHAR2(200)                 null,
   BANK_TYPE_NAME       NVARCHAR2(200)                 null,
   DEPOSIT_BANK_NAME    NVARCHAR2(200)                 null,
   CREATE_TIME          DATE                           null,
   CREATE_USER_ID       NUMBER                         null,
   COMPANY_TYPE         NUMBER                         null,
   IS_ELECTRON_ACCOUNT  NUMBER                         null,
   ACCOUNT_PROPERTIES   NUMBER                         null,
   constraint PK_BY_BANK primary key (ID)
);

comment on table BY_BANK is 
'������Ϣ';

comment on column BY_BANK.BASE_ID is 
'������ϢID';

comment on column BY_BANK.BANK_ACCOUNT is 
'�����˺�';

comment on column BY_BANK.BANK_TYPE is 
'�������';

comment on column BY_BANK.BANK_ACCOUNT_NAME is 
'�˻�����';

comment on column BY_BANK.DEPOSIT_BANK is 
'��������';

comment on column BY_BANK.BANK_COUNTRY is 
'���й���';

comment on column BY_BANK.ASSOCIATED_NUMBER is 
'���к�';

comment on column BY_BANK.CURRENCY_TYPE is 
'����';

comment on column BY_BANK.OTHER_BANK is 
'����������';

comment on column BY_BANK.BANK_TYPE_NAME is 
'�����������';

comment on column BY_BANK.DEPOSIT_BANK_NAME is 
'������������';

comment on column BY_BANK.CREATE_TIME is 
'����ʱ��';

comment on column BY_BANK.CREATE_USER_ID is 
'�����û�';

comment on column BY_BANK.COMPANY_TYPE is 
'��λ���ͣ�0�ͻ�  1 ��Ӧ�̣�';

comment on column BY_BANK.IS_ELECTRON_ACCOUNT is 
'�Ƿ���ӳж��˻�';

comment on column BY_BANK.ACCOUNT_PROPERTIES is 
'�˺����ʣ�0�����˺�   1��λ�˺ţ�';

drop table if exists BY_PRODUCT;

/*==============================================================*/
/* Table: BY_PRODUCT                                            */
/*==============================================================*/
create table BY_PRODUCT 
(
   ID                   NUMBER                         not null,
   PRODUCT_TYPE         NUMBER                         null,
   PRODUCT_TYPE_NAME    NVARCHAR2(200)                 null,
   REMARK               NVARCHAR2(200)                 null,
   BASE_ID              NUMBER                         null,
   CREATE_TIME          DATE                           null,
   CREATE_USER_ID       NUMBER                         null,
   COMPANY_TYPE         NUMBER                         null,
   constraint PK_BY_PRODUCT primary key (ID)
);

comment on table BY_PRODUCT is 
'��Ʒ����';

comment on column BY_PRODUCT.PRODUCT_TYPE is 
'����';

comment on column BY_PRODUCT.PRODUCT_TYPE_NAME is 
'������';

comment on column BY_PRODUCT.REMARK is 
'��ע';

comment on column BY_PRODUCT.BASE_ID is 
'������Ϣid';

comment on column BY_PRODUCT.CREATE_TIME is 
'����ʱ��';

comment on column BY_PRODUCT.CREATE_USER_ID is 
'�����û�';

comment on column BY_PRODUCT.COMPANY_TYPE is 
'��λ���ͣ�0�ͻ�   1��Ӧ�̣�';

drop table if exists BY_DOC;

/*==============================================================*/
/* Table: BY_DOC                                                */
/*==============================================================*/
create table BY_DOC 
(
   ID                   NUMBER                         not null,
   DOC_NAME             NVARCHAR2(200)                 null,
   DOC_URL              NVARCHAR2(200)                 null,
   BASE_ID              NUMBER                         null,
   IS_DELETE            NUMBER                         null,
   CREATE_TIME          DATE                           null,
   CREATE_USER_ID       NUMBER                         null,
   COMPANY_TYPE         NUMBER                         null,
   constraint PK_BY_DOC primary key (ID)
);

comment on table BY_DOC is 
'������';

comment on column BY_DOC.DOC_NAME is 
'������';

comment on column BY_DOC.DOC_URL is 
'����url';

comment on column BY_DOC.BASE_ID is 
'������ϢID';

comment on column BY_DOC.IS_DELETE is 
'0:δɾ  1:��ɾ';

comment on column BY_DOC.CREATE_TIME is 
'����ʱ��';

comment on column BY_DOC.CREATE_USER_ID is 
'�����û�';

comment on column BY_DOC.COMPANY_TYPE is 
'��λ���ͣ�0�ͻ�   1��Ӧ�̣�';

drop table if exists BY_APPROVE_BASE_RECORD;

/*==============================================================*/
/* Table: BY_APPROVE_BASE_RECORD                                */
/*==============================================================*/
create table BY_APPROVE_BASE_RECORD 
(
   ID                   NUMBER                         not null,
   BY_APPROVE_BASE_ID   NUMBER                         null,
   COMPANY_CODE         NVARCHAR2(200)                 null,
   COMPANY_FULL_NAME    NVARCHAR2(200)                 null,
   COMPANY_FULL_EG      NVARCHAR2(200)                 null,
   COMPANY_SHORT_NAME   NVARCHAR2(200)                 null,
   COMPANY_SHORT_EG     NVARCHAR2(200)                 null,
   LEGAL_PERSON         NVARCHAR2(200)                 null,
   FUND                 NUMBER                         null,
   IS_UNITY             NUMBER                         null,
   ECONOMICS_TYPE_NAME  NVARCHAR2(200)                 null,
   SOCIAL_CREDIT_CODE   NVARCHAR2(200)                 null,
   LICENSE_NUMBER       NVARCHAR2(200)                 null,
   ORGANIZATION_CODE_NUMBER NVARCHAR2(200)                 null,
   TAX_NUMBER           NVARCHAR2(200)                 null,
   ECONOMICS_TYPE       NUMBER                         null,
   CREATE_REG_TIME      DATE                           null,
   ADDRESS              NVARCHAR2(300)                 null,
   POSTCODE             NUMBER                         null,
   PHONE                NVARCHAR2(100)                 null,
   EMAIL                NVARCHAR2(200)                 null,
   WEB_ADDRESS          NVARCHAR2(200)                 null,
   FAX                  NVARCHAR2(200)                 null,
   COMPANY_TYPE         NUMBER                         null,
   STATUS               NUMBER                         null,
   CREATE_TIME          DATE                           null,
   CREATE_USER_ID       NUMBER                         null,
   UPDATE_TIME          DATE                           null,
   UPDATE_USER_ID       NUMBER                         null,
   AREA_NAME            NVARCHAR2(200)                 null,
   AREA                 NUMBER                         null,
   APPROVE_BACK_CAUSE   NVARCHAR2(300)                 null,
   COMPANY_SUPPLIER_TYPE NUMBER                         null,
   SUPPLIER_STATUS      NUMBER                         null,
   CONTACT              NVARCHAR2(200)                 null,
   CONTACT_PHONE        NVARCHAR2(200)                 null,
   IS_CHEMICAL          NUMBER                         null,
   constraint PK_BY_APPROVE_BASE_RECORD primary key (ID)
);

comment on table BY_APPROVE_BASE_RECORD is 
'��֤������Ϣ��¼��';

comment on column BY_APPROVE_BASE_RECORD.ID is 
'����';

comment on column BY_APPROVE_BASE_RECORD.BY_APPROVE_BASE_ID is 
'��֤����������';

comment on column BY_APPROVE_BASE_RECORD.COMPANY_CODE is 
'��λ����';

comment on column BY_APPROVE_BASE_RECORD.COMPANY_FULL_NAME is 
'��λȫ��';

comment on column BY_APPROVE_BASE_RECORD.COMPANY_FULL_EG is 
'Ӣ��ȫ��';

comment on column BY_APPROVE_BASE_RECORD.COMPANY_SHORT_NAME is 
'��λ���';

comment on column BY_APPROVE_BASE_RECORD.COMPANY_SHORT_EG is 
'Ӣ�ļ��';

comment on column BY_APPROVE_BASE_RECORD.LEGAL_PERSON is 
'����';

comment on column BY_APPROVE_BASE_RECORD.FUND is 
'ע���ʽ�';

comment on column BY_APPROVE_BASE_RECORD.IS_UNITY is 
'�Ƿ���֤��һ';

comment on column BY_APPROVE_BASE_RECORD.ECONOMICS_TYPE_NAME is 
'������������';

comment on column BY_APPROVE_BASE_RECORD.SOCIAL_CREDIT_CODE is 
'������ô���';

comment on column BY_APPROVE_BASE_RECORD.LICENSE_NUMBER is 
'Ӫҵִ�պ�';

comment on column BY_APPROVE_BASE_RECORD.ORGANIZATION_CODE_NUMBER is 
'��֯��������֤��';

comment on column BY_APPROVE_BASE_RECORD.TAX_NUMBER is 
'˰��Ǽ�֤��';

comment on column BY_APPROVE_BASE_RECORD.ECONOMICS_TYPE is 
'��������';

comment on column BY_APPROVE_BASE_RECORD.CREATE_REG_TIME is 
'��������';

comment on column BY_APPROVE_BASE_RECORD.ADDRESS is 
'ͨѶ��ַ';

comment on column BY_APPROVE_BASE_RECORD.POSTCODE is 
'�ʱ�';

comment on column BY_APPROVE_BASE_RECORD.PHONE is 
'��˾�绰';

comment on column BY_APPROVE_BASE_RECORD.EMAIL is 
'����';

comment on column BY_APPROVE_BASE_RECORD.WEB_ADDRESS is 
'WEB��ַ';

comment on column BY_APPROVE_BASE_RECORD.FAX is 
'����';

comment on column BY_APPROVE_BASE_RECORD.COMPANY_TYPE is 
'�ͻ���λ����(0: �ͻ�)';

comment on column BY_APPROVE_BASE_RECORD.STATUS is 
'�ͻ����״̬( 0δ�ύ   1����   2���ͨ��    3���ʧ��)';

comment on column BY_APPROVE_BASE_RECORD.CREATE_TIME is 
'����ʱ��';

comment on column BY_APPROVE_BASE_RECORD.CREATE_USER_ID is 
'�����û�';

comment on column BY_APPROVE_BASE_RECORD.UPDATE_TIME is 
'�޸�ʱ��';

comment on column BY_APPROVE_BASE_RECORD.UPDATE_USER_ID is 
'�޸��û�';

comment on column BY_APPROVE_BASE_RECORD.AREA_NAME is 
'������������';

comment on column BY_APPROVE_BASE_RECORD.AREA is 
'��������';

comment on column BY_APPROVE_BASE_RECORD.APPROVE_BACK_CAUSE is 
'���ʧ��ԭ��';

comment on column BY_APPROVE_BASE_RECORD.COMPANY_SUPPLIER_TYPE is 
'��Ӧ�̵�λ����(1: ��Ӧ��)';

comment on column BY_APPROVE_BASE_RECORD.SUPPLIER_STATUS is 
'��Ӧ�����״̬( 0δ�ύ   1����   2���ͨ��    3���ʧ��)';

comment on column BY_APPROVE_BASE_RECORD.CONTACT is 
'��ϵ��';

comment on column BY_APPROVE_BASE_RECORD.CONTACT_PHONE is 
'��ϵ���ֻ���';

comment on column BY_APPROVE_BASE_RECORD.IS_CHEMICAL is 
'�Ƿ�Σ��Ʒ��0��   1��';


drop table if exists BY_BANK_RECORD;

/*==============================================================*/
/* Table: BY_BANK_RECORD                                        */
/*==============================================================*/
create table BY_BANK_RECORD 
(
   ID                   NUMBER                         not null,
   BY_BANK_ID           NUMBER                         null,
   BASE_ID              NUMBER                         null,
   BANK_ACCOUNT         NVARCHAR2(50)                  null,
   BANK_TYPE            NVARCHAR2(50)                  null,
   BANK_ACCOUNT_NAME    NVARCHAR2(200)                 null,
   DEPOSIT_BANK         NUMBER                         null,
   BANK_COUNTRY         NVARCHAR2(200)                 null,
   ASSOCIATED_NUMBER    NVARCHAR2(200)                 null,
   CURRENCY_TYPE        NVARCHAR2(20)                  null,
   OTHER_BANK           NVARCHAR2(200)                 null,
   BANK_TYPE_NAME       NVARCHAR2(200)                 null,
   DEPOSIT_BANK_NAME    NVARCHAR2(200)                 null,
   CREATE_TIME          DATE                           null,
   CREATE_USER_ID       NUMBER                         null,
   COMPANY_TYPE         NUMBER                         null,
   IS_ELECTRON_ACCOUNT  NUMBER                         null,
   ACCOUNT_PROPERTIES   NUMBER                         null,
   constraint PK_BY_BANK_RECORD primary key (ID)
);

comment on table BY_BANK_RECORD is 
'������Ϣ��¼��';

comment on column BY_BANK_RECORD.ID is 
'����';

comment on column BY_BANK_RECORD.BY_BANK_ID is 
'��������id';

comment on column BY_BANK_RECORD.BASE_ID is 
'������ϢID';

comment on column BY_BANK_RECORD.BANK_ACCOUNT is 
'�����˺�';

comment on column BY_BANK_RECORD.BANK_TYPE is 
'�������';

comment on column BY_BANK_RECORD.BANK_ACCOUNT_NAME is 
'�˻�����';

comment on column BY_BANK_RECORD.DEPOSIT_BANK is 
'��������';

comment on column BY_BANK_RECORD.BANK_COUNTRY is 
'���й���';

comment on column BY_BANK_RECORD.ASSOCIATED_NUMBER is 
'���к�';

comment on column BY_BANK_RECORD.CURRENCY_TYPE is 
'����';

comment on column BY_BANK_RECORD.OTHER_BANK is 
'����������';

comment on column BY_BANK_RECORD.BANK_TYPE_NAME is 
'�����������';

comment on column BY_BANK_RECORD.DEPOSIT_BANK_NAME is 
'������������';

comment on column BY_BANK_RECORD.CREATE_TIME is 
'����ʱ��';

comment on column BY_BANK_RECORD.CREATE_USER_ID is 
'�����û�';

comment on column BY_BANK_RECORD.COMPANY_TYPE is 
'��λ���ͣ�0�ͻ�  1 ��Ӧ�̣�';

comment on column BY_BANK_RECORD.IS_ELECTRON_ACCOUNT is 
'�Ƿ���ӳж��˻�';

comment on column BY_BANK_RECORD.ACCOUNT_PROPERTIES is 
'�˺����ʣ�0�����˺�   1��λ�˺ţ�';

drop table if exists BY_PRODUCT_RECORD;

/*==============================================================*/
/* Table: BY_PRODUCT_RECORD                                     */
/*==============================================================*/
create table BY_PRODUCT_RECORD 
(
   ID                   NUMBER                         not null,
   BY_PRODUCT_ID        NUMBER                         null,
   PRODUCT_TYPE         NUMBER                         null,
   PRODUCT_TYPE_NAME    NVARCHAR2(200)                 null,
   REMARK               NVARCHAR2(200)                 null,
   BASE_ID              NUMBER                         null,
   CREATE_TIME          DATE                           null,
   CREATE_USER_ID       NUMBER                         null,
   COMPANY_TYPE         NUMBER                         null,
   constraint PK_BY_PRODUCT_RECORD primary key (ID)
);

comment on table BY_PRODUCT_RECORD is 
'��Ʒ�����¼��';

comment on column BY_PRODUCT_RECORD.BY_PRODUCT_ID is 
'��Ʒ����id';

comment on column BY_PRODUCT_RECORD.PRODUCT_TYPE is 
'����';

comment on column BY_PRODUCT_RECORD.PRODUCT_TYPE_NAME is 
'������';

comment on column BY_PRODUCT_RECORD.REMARK is 
'��ע';

comment on column BY_PRODUCT_RECORD.BASE_ID is 
'������Ϣid';

comment on column BY_PRODUCT_RECORD.CREATE_TIME is 
'����ʱ��';

comment on column BY_PRODUCT_RECORD.CREATE_USER_ID is 
'�����û�';

comment on column BY_PRODUCT_RECORD.COMPANY_TYPE is 
'��λ���ͣ�0�ͻ�   1��Ӧ�̣�';

drop table if exists BY_DOC_RECORD;

/*==============================================================*/
/* Table: BY_DOC_RECORD                                         */
/*==============================================================*/
create table BY_DOC_RECORD 
(
   ID                   NUMBER                         not null,
   BY_DOC_ID            NUMBER                         null,
   DOC_NAME             NVARCHAR2(200)                 null,
   DOC_URL              NVARCHAR2(200)                 null,
   BASE_ID              NUMBER                         null,
   IS_DELETE            NUMBER                         null,
   CREATE_TIME          DATE                           null,
   CREATE_USER_ID       NUMBER                         null,
   COMPANY_TYPE         NUMBER                         null,
   constraint PK_BY_DOC_RECORD primary key (ID)
);

comment on table BY_DOC_RECORD is 
'��������¼��';

comment on column BY_DOC_RECORD.DOC_NAME is 
'������';

comment on column BY_DOC_RECORD.DOC_URL is 
'����url';

comment on column BY_DOC_RECORD.BASE_ID is 
'������ϢID';

comment on column BY_DOC_RECORD.IS_DELETE is 
'0:δɾ  1:��ɾ';

comment on column BY_DOC_RECORD.CREATE_TIME is 
'����ʱ��';

comment on column BY_DOC_RECORD.CREATE_USER_ID is 
'�����û�';

comment on column BY_DOC_RECORD.COMPANY_TYPE is 
'��λ���ͣ�0�ͻ�   1��Ӧ�̣�';