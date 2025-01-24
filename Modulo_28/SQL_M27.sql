create table tb_produto (
	id bigint not null,
	nome varchar(50) not null,
	qtd_estoque integer not null,
	constraint pk_id_produto primary key (id)
);

create table tb_cliente (
	id bigint,
	cpf integer,
	nome varchar(50),
	constraint pk_id_cliente primary key (id),
	constraint uq_cpf_cliente unique (cpf)
);

create table tb_notaFiscal (
	codigoNota integer not null,
	idCliente bigint not null,
	constraint pk_codigoNota_notaFiscal primary key (codigoNota),
	constraint fk_idCliente_cliente foreign key (idCliente) references tb_cliente(id)
);

create table tb_nota_to_produto (
	idNota integer not null,
	idProduto bigint not null,
	quantidade integer not null,
	constraint pk_nota_produto primary key (idNota, idProduto),
	constraint fk_idNota_notaFiscal foreign key (idNota) references tb_notaFiscal(codigoNota),
    constraint fk_idProduto_produto foreign key (idProduto) references tb_produto(id)
)

create sequence sq_produto
start 1
increment 1
owned by tb_produto.id;

create sequence sq_cliente
start 1
increment 1
owned by tb_cliente.id;

create sequence sq_notaFiscal
start 1
increment 1
owned by tb_notaFiscal.codigoNota;

INSERT INTO tb_produto (id, nome, qtd_estoque)
VALUES 
(nextval('sq_produto'), 'Produto A', 100),
(nextval('sq_produto'), 'Produto B', 50),
(nextval('sq_produto'), 'Produto C', 30);

INSERT INTO tb_cliente (id, cpf, nome)
VALUES 
(nextval('sq_cliente'), 123456789, 'Cliente 1'),
(nextval('sq_cliente'), 987654321, 'Cliente 2');

INSERT INTO tb_notaFiscal (codigoNota, idCliente)
VALUES 
(nextval('sq_notaFiscal'), 1),
(nextval('sq_notaFiscal'), 2);

INSERT INTO tb_nota_to_produto (idNota, idProduto, quantidade)
VALUES 
(1, 1, 2),
(1, 2, 1),
(2, 3, 5);

--Listar todas as notas fiscais com os produtos associados
SELECT 
    nf.codigoNota AS nota,
    p.nome AS produto,
    np.quantidade
FROM 
    tb_notaFiscal nf
JOIN 
    tb_nota_to_produto np ON nf.codigoNota = np.idNota
JOIN 
    tb_produto p ON np.idProduto = p.id;

--Consultar as notas fiscais de um cliente específico
SELECT 
    nf.codigoNota AS nota,
    p.nome AS produto,
    np.quantidade
FROM 
    tb_notaFiscal nf
JOIN 
    tb_nota_to_produto np ON nf.codigoNota = np.idNota
JOIN 
    tb_produto p ON np.idProduto = p.id
WHERE 
    nf.idCliente = 1;

--Listar todos os clientes e suas notas fiscais
SELECT 
    c.nome AS cliente, 
    nf.codigoNota AS nota
FROM 
    tb_cliente c
LEFT JOIN 
    tb_notaFiscal nf ON c.id = nf.idCliente;
