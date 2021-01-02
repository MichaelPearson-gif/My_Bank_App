
CREATE TABLE "customer" (
    "customer_id" INT   NOT NULL,
    "first_name" CHAR   NOT NULL,
    "last_name" CHAR   NOT NULL,
    "drivers_license" CHAR   NOT NULL,
    "ssn" INT   NOT NULL,
    "email" CHAR   NOT NULL,
    "physical_address" CHAR   NOT NULL,
    "mailing_address" CHAR   NOT NULL,
    "dob" DATE   NOT NULL,
    "gender" CHAR   NOT NULL,
    CONSTRAINT "pk_customer" PRIMARY KEY (
        "customer_id"
     )
);

CREATE TABLE "employee" (
    "employee_id" INT   NOT NULL,
    CONSTRAINT "pk_employee" PRIMARY KEY (
        "employee_id"
     )
);

CREATE TABLE "accounts" (
    "account_id" BIGINT   NOT NULL,
    "account_type" CHAR   NOT NULL,
    "routing_id" BIGINT   NOT NULL,
    "balance" NUMERIC   NOT NULL,
    "low_balance_alert" INT   NOT NULL,
    "expense_alert" INT   NOT NULL,
    "customer_id" INT   NOT NULL,
    CONSTRAINT "pk_accounts" PRIMARY KEY (
        "account_id"
     )
);

CREATE TABLE "login" (
    "username" CHAR   NOT NULL,
    "password" CHAR   NOT NULL,
    "customer_id" INT   NOT NULL,
    CONSTRAINT "pk_login" PRIMARY KEY (
        "username","password"
     )
);

CREATE TABLE "transactions" (
	"transaction_id" INT not null,
	"account_id" INT not null,
	"customer_id" INT not null,
	"transaction" CHAR(15) not null,
	"amount" NUMERIC not null,
	"balance" NUMERIC not null,
	"date" DATE not null,
	CONSTRAINT "pk_transaction" PRIMARY KEY(
		"transaction_id"
	)
	
);

ALTER TABLE "employee" ADD CONSTRAINT "fk_employee_account_id" FOREIGN KEY("account_id")
REFERENCES "accounts" ("account_id");

ALTER TABLE "accounts" ADD CONSTRAINT "fk_accounts_customer_id" FOREIGN KEY("customer_id")
REFERENCES "customer" ("customer_id");

ALTER TABLE "login" ADD CONSTRAINT "fk_login_customer_id" FOREIGN KEY("customer_id")
REFERENCES "customer" ("customer_id");

ALTER TABLE "transactions" ADD CONSTRAINT "fk_transaction_account_id" FOREIGN KEY("account_id")
REFERENCES "accounts" ("account_id");

ALTER TABLE "transactions" ADD CONSTRAINT "fk_transaction_customer_id" FOREIGN KEY("customer_id")
REFERENCES "customer" ("customer_id");

ALTER TABLE "accounts" DROP CONSTRAINT "fk_accounts_emp_id";

ALTER TABLE "accounts" DROP COLUMN "employee_id";

ALTER TABLE "employee" DROP CONSTRAINT "pk_employee";

ALTER TABLE "employee" ADD COLUMN "account_id" int;

ALTER TABLE "employee" ADD CONSTRAINT "pk_employee_accounts" PRIMARY KEY("account_id");