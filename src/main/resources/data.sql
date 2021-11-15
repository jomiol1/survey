insert into question (id,question) values(1,'Question 1');
insert into question (id,question) values(2,'Question 2');
insert into question (id,question) values(3,'Question 3');

insert into answer (id,answer) values(1,'Answer 1');
insert into answer (id,answer) values(2,'Answer 2');

insert into question_answer (id,question_id,answer_id) values(1,1,1);
insert into question_answer (id,question_id,answer_id) values(2,1,2);
insert into question_answer (id,question_id,answer_id) values(3,2,1);
insert into question_answer (id,question_id,answer_id) values(4,2,2);
insert into question_answer (id,question_id,answer_id) values(5,3,1);
insert into question_answer (id,question_id,answer_id) values(6,3,2);