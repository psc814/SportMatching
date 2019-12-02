--(일정 등록관리자)--
INSERT INTO SCHEDULE(SCHEDULE_ID, STADIUM_CODE, GAME_DATE)
VALUES(SCHEDULE_SEQ.NEXTVAL,'SC0001', '20191128');

SELECT * FROM SCHEDULE;
SELECT * FROM TEAM;

--(관리자가 점수 입력)--
UPDATE SCHEDULE 
SET HOME_SCORE = '2', AWAY_SCORE = '0'
WHERE SCHEDULE_ID = '1';

--(사용자가 일정 조회)--
SELECT NVL(HOME_TEAM,'홈팀 없음'), NVL(AWAY_TEAM, '어웨이팀 없음')
FROM SCHEDULE
WHERE GAME_DATE = '20191128';

--(홈팀이 예약 신청했을 때 (아직 미승인))--
UPDATE SCHEDULE
SET HOME_RESERVATION = 'N'
WHERE SCHEDULE_ID = '5';

--(홈팀이 예약 신청했을 때 관리자가 확인하고 최종 승인)--
UPDATE SCHEDULE
SET HOME_RESERVATION = 'Y', HOME_TEAM = '피닉스'
WHERE SCHEDULE_ID = '5';

-- (어웨이팀이 예약 신청했을 때(아직 미승인))--
UPDATE SCHEDULE
SET AWAY_RESERVATION = 'N'
WHERE SCHEDULE_ID = '5';

--(어웨이팀이 예약 신청했을 때 관리자가 확인하고 최종 승인)--
UPDATE SCHEDULE
SET AWAY_RESERVATION = 'Y', AWAY_TEAM = '가나다'
WHERE SCHEDULE_ID = '5';

--(홈팀이 취소 신청을 했을 때 (아직 미승인))
UPDATE SCHEDULE
SET HOME_CANCEL = 'N'
WHERE SCHEDULE_ID = '5';

--(홈팀이 취소 신청을 했을 때 관리자가 확인하고 최종 승인)
UPDATE SCHEDULE
SET HOME_CANCEL = '', HOME_RESERVATION = '', HOME_TEAM = ''
WHERE SCHEDULE_ID = '5';

--(어웨이팀이 취소 신청을 했을 때 (아직 미승인))
UPDATE SCHEDULE
SET AWAY_CANCEL = 'N'
WHERE SCHEDULE_ID = '5';

--(어웨이팀이 취소 신청을 했을 때 관리자가 확인하고 최종 승인)
UPDATE SCHEDULE
SET AWAY_CANCEL = '', AWAY_RESERVATION = '', AWAY_TEAM= ''
WHERE SCHEDULE_ID = '5';
--일정 삭제
DELETE FROM SCHEDULE 
WHERE SCHEDULE_ID = '5';
--------------관리자 페이지에서-----------------
-- 예약 요청된 일정 출력--
SELECT GAME_DATE, HOME_TEAM, AWAY_TEAM 
FROM SCHEDULE
WHERE HOME_RESERVATION = 'N' OR AWAY_RESERVATION = 'N';
-- 취소 요청된 일정 출력--
SELECT GAME_DATE, HOME_TEAM, AWAY_TEAM
FROM SCHEDULE
WHERE HOME_CANCEL = 'N' OR AWAY_CANCEL = 'N';
