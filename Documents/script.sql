CREATE TABLE dpb.vendedor 
( 
  id            INT NOT NULL auto_increment, 
  nome          VARCHAR(100) NOT NULL, 
  cpf           VARCHAR(11) NOT NULL, 
  email         VARCHAR(100) NOT NULL, 
  senha         VARCHAR(45) NOT NULL, 
  endereco      VARCHAR(255), 
  data_cadastro DATETIME, 
  ativo         CHAR(1), 
  PRIMARY KEY (id), 
  UNIQUE INDEX cpf_unique (cpf asc), 
  UNIQUE INDEX email_unique (email ASC), 
  UNIQUE INDEX senha_unique (senha ASC) 
);

CREATE TABLE dpb.cliente 
( 
  id            INT NOT NULL auto_increment, 
  razao_social  VARCHAR(40), 
  nome_fantasia VARCHAR(45), 
  cnpj          VARCHAR(14) NOT NULL, 
  endereco      VARCHAR(255), 
  PRIMARY KEY (id), 
  UNIQUE INDEX cnpj_unique (cnpj asc) 
);

CREATE TABLE dpb.status_pedido 
( 
  id        INT NOT NULL auto_increment, 
  descricao VARCHAR(25), 
  PRIMARY KEY (id) 
);

CREATE TABLE dpb.categoria 
( 
  id        INT NOT NULL auto_increment, 
  descricao VARCHAR(25), 
  PRIMARY KEY (id) 
);

CREATE TABLE dpb.produto 
( 
  id             INT NOT NULL auto_increment, 
  id_categoria   INT NOT NULL, 
  descricao      VARCHAR(100), 
  preco_unitario NUMERIC(10,2), 
  ativo          CHAR(1), 
  PRIMARY KEY (id), 
  INDEX id_categoria_idx (id_categoria asc), 
  CONSTRAINT id_categoria FOREIGN KEY (id_categoria) REFERENCES dpb.categoria (id) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE dpb.pedido 
( 
  id               INT NOT NULL auto_increment, 
  id_cliente       INT NOT NULL, 
  id_vendedor      INT NOT NULL, 
  id_status_pedido INT NOT NULL, 
  data_pedido      DATETIME, 
  data_envio       DATETIME, 
  PRIMARY KEY (id), 
  INDEX id_cliente_idx (id_cliente asc), 
  INDEX id_vendedor_idx (id_vendedor ASC), 
  INDEX id_status_pedido_idx (id_status_pedido ASC), 
  CONSTRAINT id_cliente FOREIGN KEY (id_cliente) REFERENCES dpb.cliente (id) ON DELETE CASCADE ON UPDATE CASCADE, 
  CONSTRAINT id_vendedor FOREIGN KEY (id_vendedor) REFERENCES dpb.vendedor (id) ON DELETE CASCADE ON UPDATE CASCADE, 
  CONSTRAINT id_status_pedido FOREIGN KEY (id_status_pedido) REFERENCES dpb.status_pedido (id) ON DELETE CASCADE ON UPDATE CASCADE 
);
 
CREATE TABLE dpb.pedido_itens 
( 
  id         INT NOT NULL auto_increment, 
  id_pedido  INT NOT NULL, 
  id_produto INT NOT NULL, 
  quantidade INT, 
  PRIMARY KEY (id), 
  INDEX id_pedido_idx (id_pedido asc), 
  INDEX id_produto_idx (id_produto ASC), 
  CONSTRAINT id_pedido FOREIGN KEY (id_pedido) REFERENCES dpb.pedido (id) ON DELETE CASCADE ON UPDATE CASCADE, 
  CONSTRAINT id_produto FOREIGN KEY (id_produto) REFERENCES dpb.produto (id) ON DELETE CASCADE ON UPDATE CASCADE 
);




