select*from names;
delete from names ;
select*from buyer;
delete from buyer;-- 응급시 복구가능
truncate buyer;-- 복구 불가능 id값도 없앰
select count(*)from buyer;
select count(*) from buyer where bucode>5000;-- 문자숫자안가림
select bucode from buyer where bucode>5000;
--2000부터  
select bucode from buyer where bucode>2000 and bucode <5000;
select bucode from buyer where bucode>=2000 and bucode =<5000;
select bucode from buyer where  bucode between 2000 and 5000 ;
-- 포인트의 총합
select sum(bupint) from buyer;
-- 중간  문자열 검색, DB성능저하 34시작하는 사람들 검색 텍스트검사
select * from buyer where bucode like"34%";
-- 34가 코드에 포함된 사람들
select * from buyer where bucode like"%34%";
-- bucode로 묶어서 보여달라
-- 같은 코드가 있으면 1개로 보여준다
select bucode from buyer group by bucode;
select count(*) from buyer group by bucode ; 
select count(*) from buyer group by bucode having count(*)>1;
select bucode from buyer group by bucode having count(*)>1;
select * from buyer where bucode="6272";

select bucode,buname from buyer group by bucode;-- 오류
select bucode,buname from buyer group by bucode,buname;
--전체 중에 10개의 데이터만 list
select * from buyer limit 10;
--전제 충에 10번째 부터 30번째 까지만 List
select * from buyer limit 10,30;
-- bucode를 기준을 오름차순정렬
select * from buyer order by bucode limit 10;
--  bucode를 내림차순
select*from buyer order by bucode desc limit 10;
-- buname 순으로 내림차순 정렬한후 bucode로 오름차순 정렬
select*from buyer order by buname desc ,bucode limit 10;
select*from buyer order by buname desc ,bucode limit 11,20;
select*from buyer order by buname desc ,bucode limit 21,30;
select*from buyer order by buname desc ,bucode limit 31,40;
select*from buyer order by buname desc ,bucode limit 41,50;

select count(*) from buyer;



