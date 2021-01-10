
CREATE TABLE "user" (
    "user_id" VARCHAR(20)   NOT NULL,
    "first_name" CHAR(20),
    "last_name" CHAR(20),
    "drivers_license" CHAR(8),
    "ssn" INT,
    "email" CHAR(20),
    "billing_address" CHAR(20),
    "dob" DATE,
    "gender" CHAR(1),
    "password" char(20),
    CONSTRAINT "pk_user" PRIMARY KEY (
        "user_id"
     )
);


CREATE TABLE "accounts" (
    "account_id" INT   NOT NULL,
    "account_type" CHAR(15)   NOT NULL,
    "balance" NUMERIC   NOT NULL,
    "low_balance_alert" INT   NOT NULL,
    "expense_alert" INT   NOT NULL,
    "user_id" VARCHAR(20)   NOT NULL,
    CONSTRAINT "pk_accounts" PRIMARY KEY (
        "account_id"
     )
);


CREATE TABLE "transactions" (
	"transaction_id" INT not null,
	"account_id" INT not null,
	"transaction" CHAR(15) not null,
	"amount" NUMERIC not null,
	"date" DATE not null,
	"status" VARCHAR(10),
	CONSTRAINT "pk_transaction" PRIMARY KEY(
		"transaction_id"
	)
	
);

-- In case I need to get rid of my current sequences and tables

--DROP TABLE user, accounts, transactions;

--DROP SEQUENCE "account_sequence";

--DROP SEQUENCE "customer_sequence";

--DROP SEQUENCE "transaction_sequence";

CREATE SEQUENCE "account_sequence" START 99999
INCREMENT 1;

CREATE SEQUENCE "transaction_sequence" START 999999
INCREMENT 1;