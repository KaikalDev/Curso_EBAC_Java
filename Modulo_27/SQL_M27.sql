create table tb_produto (
  IdProduto bigint,
  nome varchar(205)
);

alter table tb_produto
add column qtd_estoque integer;

insert into tb_produto (IdProduto, nome, qtd_estoque) values (1, 'Biscoito', 24);
insert into tb_produto (IdProduto, nome, qtd_estoque) values (2, 'Bolacha', 32);
insert into tb_produto (IdProduto, nome, qtd_estoque) values (3, 'Coca Cola', 27);

update tb_Produto 
set qtd_estoque = 29 
where IdProduto = 2;

delete from tb_Produto
where IdProduto = 3;

select * from tb_produto;

drop table tb_produto;
