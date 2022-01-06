CREATE TABLE bet (
  idt_bet                                 BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  idt_parent                              BIGINT NULL,
  idt_evict                               BIGINT NULL,
  is_priority                             TINYINT(1) NULL,
  name                                    VARCHAR(50) NOT NULL,
  type                                    VARCHAR(50) NOT NULL,
  name_simple                             VARCHAR(50) NULL,
  value_green                             BIGINT NULL,
  score                                   BIGINT NOT NULL,
  unit                                    DECIMAL(4,2) NOT NULL,
  minimum_score                           BIGINT NOT NULL,
  minimum_unity                           DECIMAL(4,2) NOT NULL,
  minimum_alert_minute                    BIGINT NULL,
  maximum_alert_minute                    BIGINT NULL,
  maximum_entry_minute                    BIGINT NOT NULL,
  minimum_green_minute                    BIGINT NULL,
  maximum_green_minute                    BIGINT NULL,
  quantity_to_green                       BIGINT NULL,
  minimum_odd                             DECIMAL(4,2) NOT NULL,
  is_equal                                TINYINT(1) NOT NULL,
  is_first_half                           TINYINT(1) NOT NULL,
  is_able_to_close                        TINYINT(1) NOT NULL,
  maximum_check_close_minute              BIGINT NULL,
  maximum_check_close_neutral_minute      BIGINT NULL,
  is_push                                 TINYINT(1) NOT NULL,
  UNIQUE                                  (is_first_half, name)
);

CREATE TABLE rule (
  idt_rule                      BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  idt_parent                    BIGINT NULL,
  idt_bet                       BIGINT NULL,
  type                          VARCHAR(50) NOT NULL,
  name                          VARCHAR(50) NOT NULL,
  value                         BIGINT NULL,
  score                         BIGINT NULL,
  is_mandatory                  TINYINT(1) NULL,
  is_mandatory_after_red_card   TINYINT(1) NULL,
  is_underdog_team              TINYINT(1) NULL,
  is_equal                      TINYINT(1) NULL,
  FOREIGN KEY (idt_bet) REFERENCES bet (idt_bet),
  UNIQUE                    (name, value, idt_bet, is_equal)
);

CREATE TABLE bet_rule_dependency (
  idt_bet_rule_dependency   BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  idt_bet                   BIGINT NULL,
  idt_rule                  BIGINT NULL,
  FOREIGN KEY (idt_bet) REFERENCES bet (idt_bet),
  FOREIGN KEY (idt_rule) REFERENCES rule (idt_rule)
)