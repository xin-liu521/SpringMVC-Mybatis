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
'认证基本信息表';

comment on column BY_APPROVE_BASE.COMPANY_CODE is 
'单位代码';

comment on column BY_APPROVE_BASE.COMPANY_FULL_NAME is 
'单位全称';

comment on column BY_APPROVE_BASE.COMPANY_FULL_EG is 
'英文全称';

comment on column BY_APPROVE_BASE.COMPANY_SHORT_NAME is 
'单位简称';

comment on column BY_APPROVE_BASE.COMPANY_SHORT_EG is 
'英文简称';

comment on column BY_APPROVE_BASE.LEGAL_PERSON is 
'法人';

comment on column BY_APPROVE_BASE.FUND is 
'注册资金';

comment on column BY_APPROVE_BASE.IS_UNITY is 
'是否三证合一';

comment on column BY_APPROVE_BASE.ECONOMICS_TYPE_NAME is 
'经济类型名称';

comment on column BY_APPROVE_BASE.SOCIAL_CREDIT_CODE is 
'社会信用代码';

comment on column BY_APPROVE_BASE.LICENSE_NUMBER is 
'营业执照号';

comment on column BY_APPROVE_BASE.ORGANIZATION_CODE_NUMBER is 
'组织机构代码证号';

comment on column BY_APPROVE_BASE.TAX_NUMBER is 
'税务登记证号';

comment on column BY_APPROVE_BASE.ECONOMICS_TYPE is 
'经济类型';

comment on column BY_APPROVE_BASE.CREATE_REG_TIME is 
'成立日期';

comment on column BY_APPROVE_BASE.ADDRESS is 
'通讯地址';

comment on column BY_APPROVE_BASE.POSTCODE is 
'邮编';

comment on column BY_APPROVE_BASE.PHONE is 
'公司电话';

comment on column BY_APPROVE_BASE.EMAIL is 
'邮箱';

comment on column BY_APPROVE_BASE.WEB_ADDRESS is 
'WEB地址';

comment on column BY_APPROVE_BASE.FAX is 
'传真';

comment on column BY_APPROVE_BASE.COMPANY_TYPE is 
'客户单位类型(0: 客户)';

comment on column BY_APPROVE_BASE.STATUS is 
'客户审核状态( 0未提交   1待审   2审核通过    3审核失败)';

comment on column BY_APPROVE_BASE.CREATE_TIME is 
'创建时间';

comment on column BY_APPROVE_BASE.CREATE_USER_ID is 
'创建用户';

comment on column BY_APPROVE_BASE.UPDATE_TIME is 
'修改时间';

comment on column BY_APPROVE_BASE.UPDATE_USER_ID is 
'修改用户';

comment on column BY_APPROVE_BASE.AREA_NAME is 
'所属地区名称';

comment on column BY_APPROVE_BASE.AREA is 
'所属地区';

comment on column BY_APPROVE_BASE.APPROVE_BACK_CAUSE is 
'审核失败原因';

comment on column BY_APPROVE_BASE.COMPANY_SUPPLIER_TYPE is 
'供应商单位类型(1: 供应商)';

comment on column BY_APPROVE_BASE.SUPPLIER_STATUS is 
'供应商审核状态( 0未提交   1待审   2审核通过    3审核失败)';

comment on column BY_APPROVE_BASE.CONTACT is 
'联系人';

comment on column BY_APPROVE_BASE.CONTACT_PHONE is 
'联系人手机号';

comment on column BY_APPROVE_BASE.IS_CHEMICAL is 
'是否危化品（0是   1否）';


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
'用户表';

comment on column BY_USERS.USER_ACCOUNT is 
'账号';

comment on column BY_USERS.USER_PASSWORD is 
'密码';

comment on column BY_USERS.PHONE is 
'联系电话';

comment on column BY_USERS.EMAIL is 
'电子邮箱';

comment on column BY_USERS.CREATE_TIME is 
'创建时间';

comment on column BY_USERS.IS_ACTIVE is 
'是否激活(0 是，1 否)';

comment on column BY_USERS.EMAIL_SEND_TIME is 
'邮件发送时间';

comment on column BY_USERS.SALT is 
'加密';

comment on column BY_USERS.PICTURE_URL is 
'图片';

comment on column BY_USERS.STATUS is 
'状态';

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
'银行信息';

comment on column BY_BANK.BASE_ID is 
'基础信息ID';

comment on column BY_BANK.BANK_ACCOUNT is 
'银行账号';

comment on column BY_BANK.BANK_TYPE is 
'银行类别';

comment on column BY_BANK.BANK_ACCOUNT_NAME is 
'账户名称';

comment on column BY_BANK.DEPOSIT_BANK is 
'开户银行';

comment on column BY_BANK.BANK_COUNTRY is 
'银行国家';

comment on column BY_BANK.ASSOCIATED_NUMBER is 
'联行号';

comment on column BY_BANK.CURRENCY_TYPE is 
'币种';

comment on column BY_BANK.OTHER_BANK is 
'其他开户行';

comment on column BY_BANK.BANK_TYPE_NAME is 
'银行类别名称';

comment on column BY_BANK.DEPOSIT_BANK_NAME is 
'开户银行名称';

comment on column BY_BANK.CREATE_TIME is 
'创建时间';

comment on column BY_BANK.CREATE_USER_ID is 
'创建用户';

comment on column BY_BANK.COMPANY_TYPE is 
'单位类型（0客户  1 供应商）';

comment on column BY_BANK.IS_ELECTRON_ACCOUNT is 
'是否电子承兑账户';

comment on column BY_BANK.ACCOUNT_PROPERTIES is 
'账号性质（0个人账号   1单位账号）';

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
'产品分类';

comment on column BY_PRODUCT.PRODUCT_TYPE is 
'分类';

comment on column BY_PRODUCT.PRODUCT_TYPE_NAME is 
'分类名';

comment on column BY_PRODUCT.REMARK is 
'备注';

comment on column BY_PRODUCT.BASE_ID is 
'基本信息id';

comment on column BY_PRODUCT.CREATE_TIME is 
'创建时间';

comment on column BY_PRODUCT.CREATE_USER_ID is 
'创建用户';

comment on column BY_PRODUCT.COMPANY_TYPE is 
'单位类型（0客户   1供应商）';

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
'附件表';

comment on column BY_DOC.DOC_NAME is 
'附件名';

comment on column BY_DOC.DOC_URL is 
'附件url';

comment on column BY_DOC.BASE_ID is 
'基本信息ID';

comment on column BY_DOC.IS_DELETE is 
'0:未删  1:已删';

comment on column BY_DOC.CREATE_TIME is 
'创建时间';

comment on column BY_DOC.CREATE_USER_ID is 
'创建用户';

comment on column BY_DOC.COMPANY_TYPE is 
'单位类型（0客户   1供应商）';

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
'认证基本信息记录表';

comment on column BY_APPROVE_BASE_RECORD.ID is 
'主键';

comment on column BY_APPROVE_BASE_RECORD.BY_APPROVE_BASE_ID is 
'认证基础表主键';

comment on column BY_APPROVE_BASE_RECORD.COMPANY_CODE is 
'单位代码';

comment on column BY_APPROVE_BASE_RECORD.COMPANY_FULL_NAME is 
'单位全称';

comment on column BY_APPROVE_BASE_RECORD.COMPANY_FULL_EG is 
'英文全称';

comment on column BY_APPROVE_BASE_RECORD.COMPANY_SHORT_NAME is 
'单位简称';

comment on column BY_APPROVE_BASE_RECORD.COMPANY_SHORT_EG is 
'英文简称';

comment on column BY_APPROVE_BASE_RECORD.LEGAL_PERSON is 
'法人';

comment on column BY_APPROVE_BASE_RECORD.FUND is 
'注册资金';

comment on column BY_APPROVE_BASE_RECORD.IS_UNITY is 
'是否三证合一';

comment on column BY_APPROVE_BASE_RECORD.ECONOMICS_TYPE_NAME is 
'经济类型名称';

comment on column BY_APPROVE_BASE_RECORD.SOCIAL_CREDIT_CODE is 
'社会信用代码';

comment on column BY_APPROVE_BASE_RECORD.LICENSE_NUMBER is 
'营业执照号';

comment on column BY_APPROVE_BASE_RECORD.ORGANIZATION_CODE_NUMBER is 
'组织机构代码证号';

comment on column BY_APPROVE_BASE_RECORD.TAX_NUMBER is 
'税务登记证号';

comment on column BY_APPROVE_BASE_RECORD.ECONOMICS_TYPE is 
'经济类型';

comment on column BY_APPROVE_BASE_RECORD.CREATE_REG_TIME is 
'成立日期';

comment on column BY_APPROVE_BASE_RECORD.ADDRESS is 
'通讯地址';

comment on column BY_APPROVE_BASE_RECORD.POSTCODE is 
'邮编';

comment on column BY_APPROVE_BASE_RECORD.PHONE is 
'公司电话';

comment on column BY_APPROVE_BASE_RECORD.EMAIL is 
'邮箱';

comment on column BY_APPROVE_BASE_RECORD.WEB_ADDRESS is 
'WEB地址';

comment on column BY_APPROVE_BASE_RECORD.FAX is 
'传真';

comment on column BY_APPROVE_BASE_RECORD.COMPANY_TYPE is 
'客户单位类型(0: 客户)';

comment on column BY_APPROVE_BASE_RECORD.STATUS is 
'客户审核状态( 0未提交   1待审   2审核通过    3审核失败)';

comment on column BY_APPROVE_BASE_RECORD.CREATE_TIME is 
'创建时间';

comment on column BY_APPROVE_BASE_RECORD.CREATE_USER_ID is 
'创建用户';

comment on column BY_APPROVE_BASE_RECORD.UPDATE_TIME is 
'修改时间';

comment on column BY_APPROVE_BASE_RECORD.UPDATE_USER_ID is 
'修改用户';

comment on column BY_APPROVE_BASE_RECORD.AREA_NAME is 
'所属地区名称';

comment on column BY_APPROVE_BASE_RECORD.AREA is 
'所属地区';

comment on column BY_APPROVE_BASE_RECORD.APPROVE_BACK_CAUSE is 
'审核失败原因';

comment on column BY_APPROVE_BASE_RECORD.COMPANY_SUPPLIER_TYPE is 
'供应商单位类型(1: 供应商)';

comment on column BY_APPROVE_BASE_RECORD.SUPPLIER_STATUS is 
'供应商审核状态( 0未提交   1待审   2审核通过    3审核失败)';

comment on column BY_APPROVE_BASE_RECORD.CONTACT is 
'联系人';

comment on column BY_APPROVE_BASE_RECORD.CONTACT_PHONE is 
'联系人手机号';

comment on column BY_APPROVE_BASE_RECORD.IS_CHEMICAL is 
'是否危化品（0是   1否）';


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
'银行信息记录表';

comment on column BY_BANK_RECORD.ID is 
'主键';

comment on column BY_BANK_RECORD.BY_BANK_ID is 
'银行主键id';

comment on column BY_BANK_RECORD.BASE_ID is 
'基础信息ID';

comment on column BY_BANK_RECORD.BANK_ACCOUNT is 
'银行账号';

comment on column BY_BANK_RECORD.BANK_TYPE is 
'银行类别';

comment on column BY_BANK_RECORD.BANK_ACCOUNT_NAME is 
'账户名称';

comment on column BY_BANK_RECORD.DEPOSIT_BANK is 
'开户银行';

comment on column BY_BANK_RECORD.BANK_COUNTRY is 
'银行国家';

comment on column BY_BANK_RECORD.ASSOCIATED_NUMBER is 
'联行号';

comment on column BY_BANK_RECORD.CURRENCY_TYPE is 
'币种';

comment on column BY_BANK_RECORD.OTHER_BANK is 
'其他开户行';

comment on column BY_BANK_RECORD.BANK_TYPE_NAME is 
'银行类别名称';

comment on column BY_BANK_RECORD.DEPOSIT_BANK_NAME is 
'开户银行名称';

comment on column BY_BANK_RECORD.CREATE_TIME is 
'创建时间';

comment on column BY_BANK_RECORD.CREATE_USER_ID is 
'创建用户';

comment on column BY_BANK_RECORD.COMPANY_TYPE is 
'单位类型（0客户  1 供应商）';

comment on column BY_BANK_RECORD.IS_ELECTRON_ACCOUNT is 
'是否电子承兑账户';

comment on column BY_BANK_RECORD.ACCOUNT_PROPERTIES is 
'账号性质（0个人账号   1单位账号）';

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
'产品分类记录表';

comment on column BY_PRODUCT_RECORD.BY_PRODUCT_ID is 
'产品主键id';

comment on column BY_PRODUCT_RECORD.PRODUCT_TYPE is 
'分类';

comment on column BY_PRODUCT_RECORD.PRODUCT_TYPE_NAME is 
'分类名';

comment on column BY_PRODUCT_RECORD.REMARK is 
'备注';

comment on column BY_PRODUCT_RECORD.BASE_ID is 
'基本信息id';

comment on column BY_PRODUCT_RECORD.CREATE_TIME is 
'创建时间';

comment on column BY_PRODUCT_RECORD.CREATE_USER_ID is 
'创建用户';

comment on column BY_PRODUCT_RECORD.COMPANY_TYPE is 
'单位类型（0客户   1供应商）';

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
'附件表记录表';

comment on column BY_DOC_RECORD.DOC_NAME is 
'附件名';

comment on column BY_DOC_RECORD.DOC_URL is 
'附件url';

comment on column BY_DOC_RECORD.BASE_ID is 
'基本信息ID';

comment on column BY_DOC_RECORD.IS_DELETE is 
'0:未删  1:已删';

comment on column BY_DOC_RECORD.CREATE_TIME is 
'创建时间';

comment on column BY_DOC_RECORD.CREATE_USER_ID is 
'创建用户';

comment on column BY_DOC_RECORD.COMPANY_TYPE is 
'单位类型（0客户   1供应商）';
