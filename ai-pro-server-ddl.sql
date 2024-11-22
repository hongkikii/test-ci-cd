-- chat_catalog_seq 테이블 생성
CREATE TABLE chat_catalog_seq (
    next_val BIGINT
) ENGINE=InnoDB;

-- chat_catalog_seq 값 삽입
INSERT INTO chat_catalog_seq VALUES (1);

-- chat_catalog 테이블 생성
CREATE TABLE chat_catalog (
    id BIGINT NOT NULL,
    chat_summary TEXT NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

-- chat_history 테이블 생성
CREATE TABLE chat_history (
    chat_catalog_id BIGINT,
    id BIGINT NOT NULL AUTO_INCREMENT,
    question TEXT NOT NULL,
    response TEXT,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

-- member 테이블 생성
CREATE TABLE member (
    id BIGINT NOT NULL AUTO_INCREMENT,
    password VARCHAR(255) NOT NULL,
    userid VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

-- member 테이블에 유니크 제약 조건 추가
ALTER TABLE member
    ADD CONSTRAINT UK6yhxjegychh1rq9jfynisnhro UNIQUE (userid);

-- chat_history 테이블에 외래 키 제약 조건 추가
ALTER TABLE chat_history
    ADD CONSTRAINT FKjmt1cqkq9fbkbs5liicg181kt
    FOREIGN KEY (chat_catalog_id)
    REFERENCES chat_catalog (id);
