-- ★ Member.xml(회원가입, id중복체크, id로 memberDto로 가져오기, 정보수정) ★

-- Member.xml id=idConfirm (해당id가 몇개인지)
SELECT COUNT(*) FROM MEMBER WHERE MID='bbb';

-- Member.xml id = joinMember (회원가입)
INSERT INTO MEMBER VALUES
    ('bbb','1','신길동','shin@gmail.com', '01234', '서울시 어떤구 xx동');

-- Member.xml id = getDetailMember (mid로 dto가져오기)
SELECT * FROM MEMBER WHERE MID='bbb';

-- Member.xml id = modifyMember (회원정보수정)
UPDATE MEMBER SET MPW='1',
                MNAME='선길동',
                MMAIL = 'shin@gmail.com',
                MADDR='서울시 용산구',
                MPOST = '01234'
    WHERE MID='bbb';

-- ★ Book.xml (페이징없이신규순list, 페이지징포함된도서list(책이름순), 책갯수, 상세보기, 도서등록, 도서수정) ★
-- mainList
-- bookList
-- totCntBook
-- getDetailBook
-- registerBook
-- modifyBook
