insert into auth_user(id,username,password)
values (nextval('hibernate_sequence'), 'admin','root'),
       (nextval('hibernate_sequence'), 'user','pass');


insert into chat (id,name)
values (nextval('hibernate_sequence'),'admin-chat'),
       (nextval('hibernate_sequence'),'user_chat');

insert into user_chat(chat_id, user_id)
values  (3,1), (4,2);

insert into message(id,text,user_id,chat_id)
values  (nextval('hibernate_sequence'), 'qalaysan?',1,3),
        (nextval('hibernate_sequence'),'zo`rmisan?',2,4);
