desc book;
desc cart;
desc category;
desc member;
desc bookmall.order;
desc order_book;


SELECT a.title AS 제목, 
       a.price AS 가격, 
	   b.name  AS 카테고리
FROM   book a
INNER  JOIN category b ON a.category_no = b.no
;

SELECT a.count    AS 수량,  
       b.title    AS 책제목, 
       b.price    AS 책가격,
       c.name     AS 책카테고리, 
       d.name     AS 주문자이름, 
       d.tel      AS 주문자연락처, 
       d.email    AS 주문자이메일 
FROM   cart a
INNER  JOIN book     b ON a.book_no     = b.no
INNER  JOIN category c ON b.category_no = c.no
INNER  JOIN member   d ON a.member_no   = d.no
;

commit;

select * From member;
select * from category;
select * From book;
select * from cart;

delete from cart; 
delete from member where no > 0;
delete from book where no > 0;
delete from category where no > 0;

ALTER TABLE member AUTO_INCREMENT = 0;
ALTER TABLE book AUTO_INCREMENT = 0;
ALTER TABLE category AUTO_INCREMENT = 0;
