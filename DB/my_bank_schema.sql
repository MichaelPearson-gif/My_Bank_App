
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

ALTER TABLE "employee" ADD CONSTRAINT "fk_employee_account_id" FOREIGN KEY("account_id")
REFERENCES "accounts" ("account_id");

ALTER TABLE "accounts" ADD CONSTRAINT "fk_accounts_customer_id" FOREIGN KEY("customer_id")
REFERENCES "customer" ("customer_id");

ALTER TABLE "login" ADD CONSTRAINT "fk_login_customer_id" FOREIGN KEY("customer_id")
REFERENCES "customer" ("customer_id");

ALTER TABLE "accounts" ADD CONSTRAINT "fk_accounts_emp_id" FOREIGN KEY("emp_id")
REFERENCES "employee" ("employee_id");