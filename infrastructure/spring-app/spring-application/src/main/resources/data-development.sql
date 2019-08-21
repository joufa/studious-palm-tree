insert into team (id, name, member_count, description, created_at, updated_at) VALUES ((select hibernate_sequence.nextval), 'Testitiimi', 3, 'Testi', SYSDATE, SYSDATE);
insert into team (id, name, member_count, description, created_at, updated_at) VALUES ((select hibernate_sequence.nextval), 'Toinen tiimi', 4, 'Testi', SYSDATE, SYSDATE);

insert into surveys values ((select hibernate_sequence.nextval), null, SYSDATE, 'Test Survey #1', null, SYSDATE);

insert into survey_teams values ((select id from surveys where name = 'Test Survey #1'), 1);