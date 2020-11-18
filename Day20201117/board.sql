CREATE TABLE board(
	no int AUTO_INCREMENT,
	title varchar(100),
	content varchar(500),
	author varchar(100),
	nal varchar(10),
	readCount int(3),
	primary key(no)
)

insert into BOARD(title,content,author,nal,readCount) values('제목1','내용1','kh','2020.11.12',0)
select no,title,content,author,nal,readCount from board

drop table board